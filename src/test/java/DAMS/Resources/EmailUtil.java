package DAMS.Resources;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailUtil {

    /**
     * Reads the latest email subject from local Outlook Desktop App via PowerShell
     * and extracts the 6-digit MFA verification code.
     * @return the 6 digit code as a String, or null if not found
     */
    public static String getVerificationCodeFromOutlook() throws InterruptedException {
        String code = null;
        int maxAttempts = 12; // Poll for up to 60 seconds (12 * 5s)
        int attempt = 0;
        
        System.out.println("Please ensure your Outlook Desktop App is open.");
        
        // Wait an initial 5 seconds for the email to arrive
        Thread.sleep(5000);
        
        while (attempt < maxAttempts) {
            try {
                System.out.println("Polling for MFA email in Outlook (Attempt " + (attempt + 1) + " of " + maxAttempts + ")...");
                // PowerShell script to get the latest email within the last 5 minutes matching subject
                String psScript = "$outlook = New-Object -ComObject Outlook.Application;" +
                                  "$namespace = $outlook.GetNameSpace('MAPI');" +
                                  "$inbox = $namespace.GetDefaultFolder(6);" + // 6 is Inbox
                                  "$timeFilter = (Get-Date).AddMinutes(-5);" +
                                  "$latest = $inbox.Items | Where-Object { $_.ReceivedTime -ge $timeFilter -and $_.Subject -match 'Business ID' } | Sort-Object ReceivedTime -Descending | Select-Object -First 1;" +
                                  "if ($latest) { Write-Output $latest.Subject }";

                ProcessBuilder pb = new ProcessBuilder("powershell.exe", "-NoProfile", "-Command", psScript);
                pb.redirectErrorStream(true);
                Process process = pb.start();
                
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                StringBuilder output = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    output.append(line).append("\n");
                }
                process.waitFor();
                
                String result = output.toString().trim();
                
                // If we get an output that looks like our subject
                if (!result.isEmpty() && (result.contains("Business ID") || result.contains("[QA]"))) {
                    // Extract 6-digit number using Regex
                    Pattern pattern = Pattern.compile("\\b(\\d{6})\\b");
                    Matcher matcher = pattern.matcher(result);
                    if (matcher.find()) {
                        code = matcher.group(1);
                        System.out.println("MFA Verification Code found: " + code);
                        return code;
                    }
                }
                
                // Wait 5 seconds before next poll
                Thread.sleep(5000);
            } catch (Exception e) {
                System.out.println("Error reading from Outlook: " + e.getMessage());
            }
            attempt++;
        }
        
        System.out.println("Failed to fetch Verification Code from Outlook within the time limit.");
        return code;
    }
}
