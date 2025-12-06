package DAMS.Testcases.Smoke_Suite_1;

import DAMS.Resources.BaseClass;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

import static DAMS.Resources.Listeners.test;

public class TC01_Login_MFA extends BaseClass {
    @Test()
    public static void login_with_addressing_MFA() throws Throwable {
//		driver = getDriver();  
//        test.log(Status.INFO,
//                "<span style=\"color: blue;\"><b><i><u>" + "Login with valid credentials:" + "</u></i></b>");
        BaseClass.login_MFA_Incognito(prop.getUsername_MFA(), prop.getPassword_MFA(), prop.getUrl());
        login_with_mfa();
        BaseClass.getScreenshot("login", driver);
    }

    @Test(enabled = false)
    public static void login_with_addressing_MFA_normal() throws Exception {
        //	driver = getDriver();
        test.log(Status.INFO,
                "<span style=\"color: blue;\"><b><i><u>" + "Login with valid credentials:" + "</u></i></b>");
        BaseClass.login_MFA_Normal(prop.getUsername_MFA(), prop.getPassword_MFA(), prop.getUrl());
//		login_with_mfa();
    }

    public static void login_with_mfa() throws Throwable {
//        test.pass("User is login to application");
        logger.info("User is login to application");
        String generate_OTP_for_MFA = BaseClass.generate_OTP_for_MFA();
        l.enter_verification_code(generate_OTP_for_MFA);
//        test.pass("User enters the verification code and click on verify button");
        logger.info("User enters the verification code and click on verify button");
        h = pageObjectManager.getHomePage();

        softAssertionALL();
    }
}
