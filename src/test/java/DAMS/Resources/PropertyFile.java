package DAMS.Resources;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFile extends BaseClass {

    Properties pro;

    public PropertyFile() {
        File src = new File("./Configuration/config.properties");

        try {
            pro = new Properties();
            FileInputStream fis = new FileInputStream(src);
            pro.load(fis);
        } catch (Exception e) {
            logger.info("Exception is " + e.getMessage());
        }
    }

    public String getUsername() {
        String username = pro.getProperty("username");
        return username;
    }

    public String getProperty(String securityKeyMfa) {
        String security_key_mfa = pro.getProperty("security_key_MFA");
        return security_key_mfa;
    }

    public String getPassword() {
        String password = pro.getProperty("password");
        return password;
    }

    public String getpoolUsername() {
        String username = pro.getProperty("pool_username");
        return username;
    }

    public String getpoolPassword() {
        String password = pro.getProperty("pool_password");
        return password;
    }

    public String getUser_name() {
        String User_name = pro.getProperty("User_name");
        return User_name;
    }

    public String getUrl() {
        String url = pro.getProperty("URL");
        return url;
    }

    public String get_TechnicalUser_txt() {
        String msg1 = pro.getProperty("Technical_User");
        return msg1;
    }

    public String geterrormsg_userID() {
        String errormsg_UserID = pro.getProperty("errormessage_UserID");
        return errormsg_UserID;
    }

    public String getgtcmsg1() {
        String msg1 = pro.getProperty("gtc_message1");
        return msg1;
    }

    public String getgtcmsg2() {
        String msg1 = pro.getProperty("gtc_message2");
        return msg1;
    }

    public String getgtcmsg3() {
        String msg1 = pro.getProperty("gtc_message3");
        return msg1;
    }

    public String getgtcmsg4() {
        String msg1 = pro.getProperty("gtc_message4");
        return msg1;
    }

    public String get_new_FR_request_txt() {
        String msg1 = pro.getProperty("new_Functional_Role_Request_txt");
        return msg1;
    }

    public String get_for_whom_txt() {
        String msg1 = pro.getProperty("For_whom_txt");
        return msg1;
    }

    public String get_myself_txt() {
        String msg1 = pro.getProperty("myself_txt");
        return msg1;
    }

    public String get_All_txt() {
        String msg1 = pro.getProperty("All_txt");
        return msg1;
    }

    public String get_Functional_role_txt() {
        String msg1 = pro.getProperty("Functional_role_txt");
        return msg1;
    }

    public String get_vehicle_validation() {
        String msg1 = pro.getProperty("Vehicle_Validation");
        return msg1;
    }

//	 Development - AP4 


    public String get_Production() {
        String msg1 = pro.getProperty("Production");
        return msg1;
    }

    public String get_Xentry() {
        String msg1 = pro.getProperty("Xentry");
        return msg1;
    }

    public String get_QM() {
        String msg1 = pro.getProperty("QM");
        return msg1;
    }

    public String get_Development() {
        String msg1 = pro.getProperty("Development");
        return msg1;
    }

    public String get_Development_AP4() {
        String msg1 = pro.getProperty(" Development - AP4 ");
        return msg1;
    }

    public String get_Component_Verification_AP4() {
        String msg1 = pro.getProperty("ComponentVerificationAP4");
        return msg1;
    }

    public String get_DiagnosticLink() {
        String msg1 = pro.getProperty("DiagnosticLink");
        return msg1;
    }

    public String get_user_type_Internal() {
        String msg1 = pro.getProperty("User_type_Internal");
        return msg1;
    }


    public String get_user_type_external() {
        String msg1 = pro.getProperty("User_type_External");
        return msg1;
    }

    public String get_vehicle_validation_external() {
        String msg1 = pro.getProperty("Vehicle_Validation_external");
        return msg1;
    }

    public String get_Production_external() {
        String msg1 = pro.getProperty("Production_External");
        return msg1;
    }

    public String get_Xentry_external() {
        String msg1 = pro.getProperty("DiagnosticLink_External");
        return msg1;
    }

    public String get_DiagnosticLink_external() {
        String msg1 = pro.getProperty("DiagnosticLink_External");
        return msg1;
    }

    public String get_QM_external() {
        String msg1 = pro.getProperty("QM_External");
        return msg1;
    }

    public String get_Development_external() {
        String msg1 = pro.getProperty("Development_external");
        return msg1;
    }

    public String get_User_type_Supplier() {
        String msg1 = pro.getProperty("User_type_Supplier");
        return msg1;
    }

    public String get_Supplier_key_management() {
        String msg1 = pro.getProperty("Supplier_key_management");
        return msg1;
    }

    public String get_supplier_Develepment() {
        String msg1 = pro.getProperty("supplier_Develepment");
        return msg1;
    }

    public String get_supplier_warranty_return() {
        String msg1 = pro.getProperty("supplier_warranty_return");
        return msg1;
    }

    public String get_DTE() {
        String msg1 = pro.getProperty("DTE");
        return msg1;
    }

    public String get_dtna() {
        String msg1 = pro.getProperty("dtna");
        return msg1;
    }

    public String get_fuso() {
        String msg1 = pro.getProperty("fuso");
        return msg1;
    }

    public String get_bus() {
        String msg1 = pro.getProperty("bus");
        return msg1;
    }

    public String get_robert_company() {
        String msg1 = pro.getProperty("robert_company");
        return msg1;
    }

    public String get_Knorr_company() {
        String msg1 = pro.getProperty("Knorr_comapny");
        return msg1;
    }

    public String get_ask_Company() {
        String msg1 = pro.getProperty("ask_Company");
        return msg1;
    }

    public String get_marquart_Comapny() {
        String msg1 = pro.getProperty("marquart_Comapny");
        return msg1;
    }

    public String get_sensata_Company() {
        String msg1 = pro.getProperty("sensata_Company");
        return msg1;
    }

    public String get_contemporary_company() {
        String msg1 = pro.getProperty("contemporary_company");
        return msg1;
    }

    public String getApproverUsername() {
        String username = pro.getProperty("approver_username");
        return username;
    }

    public String getApproverPassword() {
        String password = pro.getProperty("approver_password");
        return password;
    }

    public String getcleanupUrl() {
        String cleanup_url = pro.getProperty("cleanup_url");
        return cleanup_url;
    }

    public String getBusiness_unit() {
        String username = pro.getProperty("Business_Unit_txt");
        return username;
    }

    public String getTechnical_user_id() {
        String username = pro.getProperty("Technical_user_id_txt");
        return username;
    }

    public String getStatus_pending() {
        String pending = pro.getProperty("Status_pending");
        return pending;
    }

    public String getStatus_Approved() {
        String approved = pro.getProperty("Status_Approved");
        return approved;
    }

    public String getStatus_rejected() {
        String rejected = pro.getProperty("Status_rejected");
        return rejected;
    }

    public String getUsername_MFA() {
        String username = pro.getProperty("username_MFA");
        return username;
    }

    public String getPassword_MFA() {
        String password = pro.getProperty("password_MFA");
        return password;
    }

    public String getsecurityKEY_MFA() {
        String password = pro.getProperty("security_key_MFA");
        return password;
    }

    public String Orgin_COT() {
        String origin = pro.getProperty("Orgin_COT");
        return origin;
    }

    public String Target_COT() {
        String target = pro.getProperty("Target_COT");
        return target;
    }
}