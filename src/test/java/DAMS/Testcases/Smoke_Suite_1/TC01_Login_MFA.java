package DAMS.Testcases.Smoke_Suite_1;

import DAMS.Resources.BaseClass;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

import static DAMS.Resources.Listeners.test;

public class TC01_Login_MFA extends BaseClass {
    // @Test
    // public static void login_with_addressing_MFA() throws Throwable {
    //
    // String username = prop.getUsername_MFA();
    //
    // if (username.equalsIgnoreCase("PU_S_PID1BD7")||
    // username.equalsIgnoreCase("IPATHAN")) {
    // login_with_addressing_MFA_Internal();
    //
    // } else if (username.equalsIgnoreCase("HARNAGA")) {
    // login_with_addressing_MFA_External();
    // login_with_addressing_MFA_Supplier();
    // }
    // BaseClass.getScreenshot("login", BaseClass.getDriver());
    // }

    @Test
    public static void login_with_addressing_MFA() throws Throwable {
        BaseClass.login_MFA_Incognito(prop.getUsername_MFA(), prop.getPassword_MFA(), prop.getUrl());
        login_with_mfa("External");
        BaseClass.getScreenshot("login", BaseClass.getDriver());
    }

    @Test
    public static void login_with_addressing_MFA_Internal() throws Throwable {
        BaseClass.login_MFA_Incognito_Internal();
        login_with_mfa("Internal");
        BaseClass.getScreenshot("login", BaseClass.getDriver());
    }

    @Test()
    public static void login_with_addressing_MFA_External() throws Throwable {
        BaseClass.login_MFA_Incognito_External();
        login_with_mfa("External");
        BaseClass.getScreenshot("login", BaseClass.getDriver());
    }

    @Test
    public static void login_with_addressing_MFA_Supplier() throws Throwable {
        BaseClass.login_MFA_Incognito_Supplier();
        login_with_mfa("Supplier");
        BaseClass.getScreenshot("login", BaseClass.getDriver());
    }

    @Test
    public static void login_with_addressing_MFA_normal() throws Exception {
        // BaseClass.getDriver() = getDriver();
        test.log(Status.INFO,
                "<span style=\"color: blue;\"><b><i><u>" + "Login with valid credentials:" + "</u></i></b>");
        BaseClass.login_MFA_Normal(prop.getUsername_MFA(), prop.getPassword_MFA(), prop.getUrl());
        // login_with_mfa();
    }

    public static void login_with_addressing_MFA_External_SP() throws Throwable {
        BaseClass.login_MFA_Incognito_External();
        login_with_mfa("External");
        BaseClass.getScreenshot("login", BaseClass.getDriver());
    }

    public static void login_with_mfa(String userType) throws Throwable {
        // test.pass("User is login to application");
        logger.info("User is login to application");

        String generate_OTP_for_MFA = BaseClass.generate_OTP_for_MFA(userType);
        // logger.info(generate_OTP_for_MFA);
        ctx().l.enter_verification_code(generate_OTP_for_MFA);
        // test.pass("User enters the verification code and click on verify button");
        logger.info("User enters the verification code and click on verify button");
        ctx().h = ctx().pageObjectManager.getHomePage();
        h = ctx().h;
        softAssertionALL();
    }
}
