@echo off
setlocal EnableDelayedExpansion

:: ========= CONFIG =========
set "PROJECT_DIR=C:\ui-automation-testing\ui-automation-testing"
set "LOG_DIR=C:\ui-automation-testing\Batch File\Logs"
set "SMOKE_XML=testng-smoke.xml"
set "REGRESSION_XML=testng-regression.xml"
:: ==========================

if not exist "%LOG_DIR%" mkdir "%LOG_DIR%"

:: Init flags
set "RUN_ALL_SMOKE=false"
set "RUN_ALL_REGRESSION=false"
set "TEST_CLASS="
set "CHOSEN_SUITE="
set "LAST_MENU="

echo =========================================
echo   DAMS Automation Test Runner
echo =========================================
echo.

goto SELECT_SUITE

:: =====================================================================
:: ========================= SUITE SELECTION ===========================
:: =====================================================================
:SELECT_SUITE
echo.
echo Select Test Suite:
echo 1 - Smoke Suite
echo 2 - Regression Suite
echo 0 - Exit
echo.
set /p SUITE_CHOICE=Enter choice: 

if "%SUITE_CHOICE%"=="0" goto PAUSE_END

if "%SUITE_CHOICE%"=="1" (
    set "SUITE_XML=%SMOKE_XML%"
    set "CHOSEN_SUITE=SMOKE"
    goto SMOKE_MENU
)

if "%SUITE_CHOICE%"=="2" (
    set "SUITE_XML=%REGRESSION_XML%"
    set "CHOSEN_SUITE=REGRESSION"
    goto REGRESSION_CATEGORY_MENU
)

echo Invalid Choice
goto SELECT_SUITE


:: =====================================================================
:: ============================= SMOKE MENU =============================
:: =====================================================================

:SMOKE_MENU
set "RUN_ALL_SMOKE=false"
set "TEST_CLASS="
set "LAST_MENU=SMOKE"

echo.
echo Select Smoke Test Class:
echo 1  - TC001_Global_Smoke_TestSuite_E2E
echo 2  - TC002_ATG_Smoke_TestSuite_E2E
echo 3  - TC003_ServicePrincipal_TestSuite_E2E
echo 4  - TC004_SpecialAccess_TestSuite_E2E
echo 5  - TC01_Login_MFA
echo 6  - TC02_Requests_STD_GLOBAL
echo 7  - TC03_Requests_STD_ATG_FR
echo 8  - TC04_STD_ATG_FRrejected
echo 9  - TC05_STD_GLOBAL_FRrejected
echo 10 - TC06_STD_GLOBAL_FRapproved
echo 11 - TC07_STD_ATG_FRapproved
echo 12 - TC08_Diagnostic_Authority_GLOBAL
echo 13 - TC09_Diagnostic_Authority_GLOBAL_Rejected
echo 14 - TC10_Diagnostic_Authority_GLOBAL_Approved
echo 15 - TC11_EnhanceRightAuthority_GLOBAL
echo 16 - TC12_EnhanceRightAuthority_GLOBAL_Rejected
echo 17 - TC13_EnhanceRightAuthority_GLOBAL_Approved
echo 18 - TC14_NestT_CentralAuth_GLOBAL
echo 19 - TC15_NestT_CentralAuth_GLOBAL_Rejected
echo 20 - TC16_NestT_CentralAuth_GLOBAL_Approved
echo 21 - TC17_NestT_TestCOT_GLOBAL
echo 22 - TC18_NestT_TestCOT_GLOBAL_Rejected
echo 23 - TC19_NestT_TestCOT_GLOBAL_Approved
echo 24 - TC20_NestT_SeriesCOT_GLOBAL
echo 25 - TC21_NestT_SeriesCOT_GLOBAL_Rejected
echo 26 - TC22_NestT_SeriesCOT_GLOBAL_Approved
echo 27 - TC23_ReplacementPackage_RootLink_GLOBAL
echo 28 - TC24_ReplacementPackage_RootLink_GLOBAL_Rejected
echo 29 - TC25_ReplacementPackage_RootLink_GLOBAL_Approved
echo 30 - TC26_ReplacementPackage_BackendLink_GLOBAL
echo 31 - TC27_ReplacementPackage_BackendLink_GLOBAL_Rejected
echo 32 - TC28_ReplacementPackage_BackendLink_GLOBAL_Approved
echo 33 - TC29_ReplacementPackage_RootBackend_Swap_GLOBAL
echo 34 - TC30_ReplacementPackage_RootBackend_Swap_Swap_GLOBAL_Rejected
echo 35 - TC31_ReplacementPackage_RootBackend_Swap_Swap_GLOBAL_Approved
echo 36 - TC32_DiagnosticAuthority_ATG
echo 37 - TC33_DiagnosticAuthority_ATG_Rejected
echo 38 - TC34_DiagnosticAuthority_ATG_Approved
echo 39 - TC35_EnhanceRightAuthority_ATG
echo 40 - TC36_EnhanceRightAuthority_ATG_Rejected
echo 41 - TC37_EnhanceRightAuthority_ATG_Approved
echo 42 - TC38_NestT_CentralAuth_ATG
echo 43 - TC39_NestT_CentralAuth_ATG_Rejected
echo 44 - TC40_NestT_CentralAuth_ATG_Approved
echo 45 - TC41_NestT_TestCOT_ATG
echo 46 - TC42_NestT_TestCOT_ATG_Rejected
echo 47 - TC43_NestT_TestCOT_ATG_Approved
echo 48 - TC44_NestT_SeriesCOT_ATG
echo 49 - TC45_NestT_SeriesCOT_ATG_Rejected
echo 50 - TC46_NestT_SeriesCOT_ATG_Approved
echo 51 - TC47_ReplacementPackage_RootLink_ATG
echo 52 - TC48_ReplacementPackage_RootLink_ATG_Rejected
echo 53 - TC49_ReplacementPackage_RootLink_ATG_Approved
echo 54 - TC50_ReplacementPackage_BackendLink_ATG
echo 55 - TC51_ReplacementPackage_BackendLink_ATG_Rejected
echo 56 - TC52_ReplacementPackage_BackendLink_ATG_Approved
echo 57 - TC53_ReplacementPackage_RootBackend_Swap_ATG
echo 58 - TC54_ReplacementPackage_RootBackend_Swap_ATG_Rejected
echo 59 - TC55_ReplacementPackage_RootBackend_Swap_ATG_Approved
echo 60 - TC56_ServicePrinciple_Production_Pending
echo 61 - TC57_ServicePrinciple_Production_Reject
echo 62 - TC58_ServicePrinciple_Production_Approved
echo 63 - TC59_ServicePrincipal_xOTA_Pending
echo 64 - TC60_ServicePrincipal_xOTA_Rejected
echo 65 - TC61_ServicePrincipal_xOTA_Approved
echo 66 - TC62_ServicePrincipal_Production_DA_Pending
echo 67 - TC63_ServicePrincipal_Production_DA_Rejected
echo 68 - TC64_ServicePrincipal_Production_DA_Approved
echo 69 - TC65_ServicePrincipal_Production_EA_Pending
echo 70 - TC66_ServicePrincipal_Production_EA_Rejected
echo 71 - TC67_ServicePrincipal_Production_EA_Approved
echo 72 - TC68_xOTA_FOTA_Pending
echo 73 - TC69_xOTA_FOTA_Rejected
echo 74 - TC70_xOTA_FOTA_Approved
echo 75 - TC71_OnboardNewECU_Pending
echo 76 - TC72_OnboardNewECU_Rejected
echo 77 - TC73_OnboardNewECU_Approved
echo 78 - TC74_FunctionalRole_ViewPermission
echo 79 - TC75_ThirdParty_Publisher
echo 80 - TC76_ViewPublisher_Onboarding_Edit
echo 81 - TC77_ViewPublisher_Onboarding_Delete
echo 82 - TC78_ViewPublisher_Onboarding
echo 83 - TC79_ADD_UpdateFR_ECU_Pending
echo 84 - TC80_ADD_UpdateFR_ECU_Rejected
echo 85 - TC81_ADD_UpdateFR_ECU_Approved
echo 86 - TC82_REMOVE_UpdateFR_ECU_Pending
echo 87 - TC83_REMOVE_UpdateFR_ECU_Rejected
echo 88 - TC84_REMOVE_UpdateFR_ECU_Approved
echo 89 - TC85_SpecialEnhancedRight_Pending
echo 90 - TC86_SpecialEnhancedRight_Rejected
echo 91 - TC87_SpecialEnhancedRight_Approved
echo 92 - TC88_ADD_UpdateGlobalEnhance_Pending
echo 93 - TC89_ADD_UpdateGlobalEnhance_Rejected
echo 94 - TC90_ADD_UpdateGlobalEnhance_Approved
echo 95 - TC91_DELETE_UpdateGlobalEnhance_Approved
echo 96 - TC92_ECU_MetaData
echo 97 - TC93_MyDeputy
echo 98 - TC94_ReadView_Permission
echo 99 - TC95_ECU_Certificate_Request_Pending
echo 100 - TC96_ECU_Certificate_Request_Rejected
echo 101 - TC97_ECU_Certificate_Request_Approved
echo.
echo 999 - Run ALL Smoke Tests
echo 0   - Go Back
echo.

set /p CLASS_CHOICE=Enter choice: 

if "%CLASS_CHOICE%"=="0" goto SELECT_SUITE

if "%CLASS_CHOICE%"=="999" (
    set "RUN_ALL_SMOKE=true"
    set "LAST_MENU=SMOKE"
    goto ENV_SELECT
) else (
    set "RUN_ALL_SMOKE=false"
)

:: Smoke mapping
if "%CLASS_CHOICE%"=="1"  set TEST_CLASS=TC001_Global_Smoke_TestSuite_E2E
if "%CLASS_CHOICE%"=="2"  set TEST_CLASS=TC002_ATG_Smoke_TestSuite_E2E
if "%CLASS_CHOICE%"=="3"  set TEST_CLASS=TC003_ServicePrincipal_TestSuite_E2E
if "%CLASS_CHOICE%"=="4"  set TEST_CLASS=TC004_SpecialAccess_TestSuite_E2E
if "%CLASS_CHOICE%"=="5"  set TEST_CLASS=TC01_Login_MFA
if "%CLASS_CHOICE%"=="6"  set TEST_CLASS=TC02_Requests_STD_GLOBAL
if "%CLASS_CHOICE%"=="7"  set TEST_CLASS=TC03_Requests_STD_ATG_FR
if "%CLASS_CHOICE%"=="8"  set TEST_CLASS=TC04_STD_ATG_FRrejected
if "%CLASS_CHOICE%"=="9"  set TEST_CLASS=TC05_STD_GLOBAL_FRrejected
if "%CLASS_CHOICE%"=="10" set TEST_CLASS=TC06_STD_GLOBAL_FRapproved
if "%CLASS_CHOICE%"=="11" set TEST_CLASS=TC07_STD_ATG_FRapproved
if "%CLASS_CHOICE%"=="12" set TEST_CLASS=TC08_Diagnostic_Authority_GLOBAL
if "%CLASS_CHOICE%"=="13" set TEST_CLASS=TC09_Diagnostic_Authority_GLOBAL_Rejected
if "%CLASS_CHOICE%"=="14" set TEST_CLASS=TC10_Diagnostic_Authority_GLOBAL_Approved
if "%CLASS_CHOICE%"=="15" set TEST_CLASS=TC11_EnhanceRightAuthority_GLOBAL
if "%CLASS_CHOICE%"=="16" set TEST_CLASS=TC12_EnhanceRightAuthority_GLOBAL_Rejected
if "%CLASS_CHOICE%"=="17" set TEST_CLASS=TC13_EnhanceRightAuthority_GLOBAL_Approved
if "%CLASS_CHOICE%"=="18" set TEST_CLASS=TC14_NestT_CentralAuth_GLOBAL
if "%CLASS_CHOICE%"=="19" set TEST_CLASS=TC15_NestT_CentralAuth_GLOBAL_Rejected
if "%CLASS_CHOICE%"=="20" set TEST_CLASS=TC16_NestT_CentralAuth_GLOBAL_Approved
if "%CLASS_CHOICE%"=="21" set TEST_CLASS=TC17_NestT_TestCOT_GLOBAL
if "%CLASS_CHOICE%"=="22" set TEST_CLASS=TC18_NestT_TestCOT_GLOBAL_Rejected
if "%CLASS_CHOICE%"=="23" set TEST_CLASS=TC19_NestT_TestCOT_GLOBAL_Approved
if "%CLASS_CHOICE%"=="24" set TEST_CLASS=TC20_NestT_SeriesCOT_GLOBAL
if "%CLASS_CHOICE%"=="25" set TEST_CLASS=TC21_NestT_SeriesCOT_GLOBAL_Rejected
if "%CLASS_CHOICE%"=="26" set TEST_CLASS=TC22_NestT_SeriesCOT_GLOBAL_Approved
if "%CLASS_CHOICE%"=="27" set TEST_CLASS=TC23_ReplacementPackage_RootLink_GLOBAL
if "%CLASS_CHOICE%"=="28" set TEST_CLASS=TC24_ReplacementPackage_RootLink_GLOBAL_Rejected
if "%CLASS_CHOICE%"=="29" set TEST_CLASS=TC25_ReplacementPackage_RootLink_GLOBAL_Approved
if "%CLASS_CHOICE%"=="30" set TEST_CLASS=TC26_ReplacementPackage_BackendLink_GLOBAL
if "%CLASS_CHOICE%"=="31" set TEST_CLASS=TC27_ReplacementPackage_BackendLink_GLOBAL_Rejected
if "%CLASS_CHOICE%"=="32" set TEST_CLASS=TC28_ReplacementPackage_BackendLink_GLOBAL_Approved
if "%CLASS_CHOICE%"=="33" set TEST_CLASS=TC29_ReplacementPackage_RootBackend_Swap_GLOBAL
if "%CLASS_CHOICE%"=="34" set TEST_CLASS=TC30_ReplacementPackage_RootBackend_Swap_Swap_GLOBAL_Rejected
if "%CLASS_CHOICE%"=="35" set TEST_CLASS=TC31_ReplacementPackage_RootBackend_Swap_Swap_GLOBAL_Approved
if "%CLASS_CHOICE%"=="36" set TEST_CLASS=TC32_DiagnosticAuthority_ATG
if "%CLASS_CHOICE%"=="37" set TEST_CLASS=TC33_DiagnosticAuthority_ATG_Rejected
if "%CLASS_CHOICE%"=="38" set TEST_CLASS=TC34_DiagnosticAuthority_ATG_Approved
if "%CLASS_CHOICE%"=="39" set TEST_CLASS=TC35_EnhanceRightAuthority_ATG
if "%CLASS_CHOICE%"=="40" set TEST_CLASS=TC36_EnhanceRightAuthority_ATG_Rejected
if "%CLASS_CHOICE%"=="41" set TEST_CLASS=TC37_EnhanceRightAuthority_ATG_Approved
if "%CLASS_CHOICE%"=="42" set TEST_CLASS=TC38_NestT_CentralAuth_ATG
if "%CLASS_CHOICE%"=="43" set TEST_CLASS=TC39_NestT_CentralAuth_ATG_Rejected
if "%CLASS_CHOICE%"=="44" set TEST_CLASS=TC40_NestT_CentralAuth_ATG_Approved
if "%CLASS_CHOICE%"=="45" set TEST_CLASS=TC41_NestT_TestCOT_ATG
if "%CLASS_CHOICE%"=="46" set TEST_CLASS=TC42_NestT_TestCOT_ATG_Rejected
if "%CLASS_CHOICE%"=="47" set TEST_CLASS=TC43_NestT_TestCOT_ATG_Approved
if "%CLASS_CHOICE%"=="48" set TEST_CLASS=TC44_NestT_SeriesCOT_ATG
if "%CLASS_CHOICE%"=="49" set TEST_CLASS=TC45_NestT_SeriesCOT_ATG_Rejected
if "%CLASS_CHOICE%"=="50" set TEST_CLASS=TC46_NestT_SeriesCOT_ATG_Approved
if "%CLASS_CHOICE%"=="51" set TEST_CLASS=TC47_ReplacementPackage_RootLink_ATG
if "%CLASS_CHOICE%"=="52" set TEST_CLASS=TC48_ReplacementPackage_RootLink_ATG_Rejected
if "%CLASS_CHOICE%"=="53" set TEST_CLASS=TC49_ReplacementPackage_RootLink_ATG_Approved
if "%CLASS_CHOICE%"=="54" set TEST_CLASS=TC50_ReplacementPackage_BackendLink_ATG
if "%CLASS_CHOICE%"=="55" set TEST_CLASS=TC51_ReplacementPackage_BackendLink_ATG_Rejected
if "%CLASS_CHOICE%"=="56" set TEST_CLASS=TC52_ReplacementPackage_BackendLink_ATG_Approved
if "%CLASS_CHOICE%"=="57" set TEST_CLASS=TC53_ReplacementPackage_RootBackend_Swap_ATG
if "%CLASS_CHOICE%"=="58" set TEST_CLASS=TC54_ReplacementPackage_RootBackend_Swap_ATG_Rejected
if "%CLASS_CHOICE%"=="59" set TEST_CLASS=TC55_ReplacementPackage_RootBackend_Swap_ATG_Approved
if "%CLASS_CHOICE%"=="60" set TEST_CLASS=TC56_ServicePrinciple_Production_Pending
if "%CLASS_CHOICE%"=="61" set TEST_CLASS=TC57_ServicePrinciple_Production_Reject
if "%CLASS_CHOICE%"=="62" set TEST_CLASS=TC58_ServicePrinciple_Production_Approved
if "%CLASS_CHOICE%"=="63" set TEST_CLASS=TC59_ServicePrincipal_xOTA_Pending
if "%CLASS_CHOICE%"=="64" set TEST_CLASS=TC60_ServicePrincipal_xOTA_Rejected
if "%CLASS_CHOICE%"=="65" set TEST_CLASS=TC61_ServicePrincipal_xOTA_Approved
if "%CLASS_CHOICE%"=="66" set TEST_CLASS=TC62_ServicePrincipal_Production_DA_Pending
if "%CLASS_CHOICE%"=="67" set TEST_CLASS=TC63_ServicePrincipal_Production_DA_Rejected
if "%CLASS_CHOICE%"=="68" set TEST_CLASS=TC64_ServicePrincipal_Production_DA_Approved
if "%CLASS_CHOICE%"=="69" set TEST_CLASS=TC65_ServicePrincipal_Production_EA_Pending
if "%CLASS_CHOICE%"=="70" set TEST_CLASS=TC66_ServicePrincipal_Production_EA_Rejected
if "%CLASS_CHOICE%"=="71" set TEST_CLASS=TC67_ServicePrincipal_Production_EA_Approved
if "%CLASS_CHOICE%"=="72" set TEST_CLASS=TC68_xOTA_FOTA_Pending
if "%CLASS_CHOICE%"=="73" set TEST_CLASS=TC69_xOTA_FOTA_Rejected
if "%CLASS_CHOICE%"=="74" set TEST_CLASS=TC70_xOTA_FOTA_Approved
if "%CLASS_CHOICE%"=="75" set TEST_CLASS=TC71_OnboardNewECU_Pending
if "%CLASS_CHOICE%"=="76" set TEST_CLASS=TC72_OnboardNewECU_Rejected
if "%CLASS_CHOICE%"=="77" set TEST_CLASS=TC73_OnboardNewECU_Approved
if "%CLASS_CHOICE%"=="78" set TEST_CLASS=TC74_FunctionalRole_ViewPermission
if "%CLASS_CHOICE%"=="79" set TEST_CLASS=TC75_ThirdParty_Publisher
if "%CLASS_CHOICE%"=="80" set TEST_CLASS=TC76_ViewPublisher_Onboarding_Edit
if "%CLASS_CHOICE%"=="81" set TEST_CLASS=TC77_ViewPublisher_Onboarding_Delete
if "%CLASS_CHOICE%"=="82" set TEST_CLASS=TC78_ViewPublisher_Onboarding
if "%CLASS_CHOICE%"=="83" set TEST_CLASS=TC79_ADD_UpdateFR_ECU_Pending
if "%CLASS_CHOICE%"=="84" set TEST_CLASS=TC80_ADD_UpdateFR_ECU_Rejected
if "%CLASS_CHOICE%"=="85" set TEST_CLASS=TC81_ADD_UpdateFR_ECU_Approved
if "%CLASS_CHOICE%"=="86" set TEST_CLASS=TC82_REMOVE_UpdateFR_ECU_Pending
if "%CLASS_CHOICE%"=="87" set TEST_CLASS=TC83_REMOVE_UpdateFR_ECU_Rejected
if "%CLASS_CHOICE%"=="88" set TEST_CLASS=TC84_REMOVE_UpdateFR_ECU_Approved
if "%CLASS_CHOICE%"=="89" set TEST_CLASS=TC85_SpecialEnhancedRight_Pending
if "%CLASS_CHOICE%"=="90" set TEST_CLASS=TC86_SpecialEnhancedRight_Rejected
if "%CLASS_CHOICE%"=="91" set TEST_CLASS=TC87_SpecialEnhancedRight_Approved
if "%CLASS_CHOICE%"=="92" set TEST_CLASS=TC88_ADD_UpdateGlobalEnhance_Pending
if "%CLASS_CHOICE%"=="93" set TEST_CLASS=TC89_ADD_UpdateGlobalEnhance_Rejected
if "%CLASS_CHOICE%"=="94" set TEST_CLASS=TC90_ADD_UpdateGlobalEnhance_Approved
if "%CLASS_CHOICE%"=="95" set TEST_CLASS=TC91_DELETE_UpdateGlobalEnhance_Approved
if "%CLASS_CHOICE%"=="96" set TEST_CLASS=TC92_ECU_MetaData
if "%CLASS_CHOICE%"=="97" set TEST_CLASS=TC93_MyDeputy
if "%CLASS_CHOICE%"=="98" set TEST_CLASS=TC94_ReadView_Permission
if "%CLASS_CHOICE%"=="99" set TEST_CLASS=TC95_ECU_Certificate_Request_Pending
if "%CLASS_CHOICE%"=="100" set TEST_CLASS=TC96_ECU_Certificate_Request_Rejected
if "%CLASS_CHOICE%"=="101" set TEST_CLASS=TC97_ECU_Certificate_Request_Approved

if not defined TEST_CLASS (
    echo Invalid Class Selection
    goto SMOKE_MENU
)

set "LAST_MENU=SMOKE"
goto ENV_SELECT


:: =====================================================================
:: ========================= REGRESSION MENU ============================
:: =====================================================================

:REGRESSION_CATEGORY_MENU
set "RUN_ALL_REGRESSION=false"
set "TEST_CLASS="
set "PKG="
set "LAST_MENU=REG_CAT"

echo.
echo Select Regression Category:
echo 1 - Internal
echo 2 - External
echo 3 - Supplier
echo 999 - Run ALL Regression Tests
echo 0   - Go Back
echo.
set /p REG_CAT=Enter choice: 

if "%REG_CAT%"=="0" goto SELECT_SUITE

if "%REG_CAT%"=="999" (
    set "RUN_ALL_REGRESSION=true"
    set "LAST_MENU=REG_CAT"
    goto ENV_SELECT
)

if "%REG_CAT%"=="1" goto REG_INTERNAL
if "%REG_CAT%"=="2" goto REG_EXTERNAL
if "%REG_CAT%"=="3" goto REG_SUPPLIER

echo Invalid category selection
goto REGRESSION_CATEGORY_MENU


:: ============================ INTERNAL ================================
:REG_INTERNAL
set "PKG=DAMS.Testcases.Regression_Suite.Internal"
set "LAST_MENU=REG_INTERNAL"
echo.
echo INTERNAL Regression Classes:
echo 1  - TC001_Internal_Development_FR_Global
echo 2  - TC002_Internal_Production_FR_Global
echo 3  - TC003_Internal_VehicleValidation_FR_Global
echo 4  - TC004_Internal_BusProductionTool_FR_Global
echo 5  - TC005_Internal_QualityManagement_FR_Global
echo 6  - TC006_Internal_DiagnosticLinkTool_FR_Global
echo 7  - TC007_Internal_XentryTool_FR_Global
echo 8  - TC008_Internal_Development_FR_ATG
echo 9  - TC009_Internal_Production_FR_ATG
echo 10 - TC010_Internal_VehicleValidation_FR_ATG
echo 11 - TC011_Internal_ComponentVerification_FR_ATG
echo 12 - TC012_Reject_Approve_Internal_Global
echo 13 - TC013_Reject_Approve_Internal_ATG
echo 14 - TC014_Internal_OverAll_Run
echo 0  - Go Back
echo.
set /p REG_CLASS=Enter choice: 

if "%REG_CLASS%"=="0" goto REGRESSION_CATEGORY_MENU

if "%REG_CLASS%"=="1"  set TEST_CLASS=%PKG%.TC001_Internal_Development_FR_Global
if "%REG_CLASS%"=="2"  set TEST_CLASS=%PKG%.TC002_Internal_Production_FR_Global
if "%REG_CLASS%"=="3"  set TEST_CLASS=%PKG%.TC003_Internal_VehicleValidation_FR_Global
if "%REG_CLASS%"=="4"  set TEST_CLASS=%PKG%.TC004_Internal_BusProductionTool_FR_Global
if "%REG_CLASS%"=="5"  set TEST_CLASS=%PKG%.TC005_Internal_QualityManagement_FR_Global
if "%REG_CLASS%"=="6"  set TEST_CLASS=%PKG%.TC006_Internal_DiagnosticLinkTool_FR_Global
if "%REG_CLASS%"=="7"  set TEST_CLASS=%PKG%.TC007_Internal_XentryTool_FR_Global
if "%REG_CLASS%"=="8"  set TEST_CLASS=%PKG%.TC008_Internal_Development_FR_ATG
if "%REG_CLASS%"=="9"  set TEST_CLASS=%PKG%.TC009_Internal_Production_FR_ATG
if "%REG_CLASS%"=="10" set TEST_CLASS=%PKG%.TC010_Internal_VehicleValidation_FR_ATG
if "%REG_CLASS%"=="11" set TEST_CLASS=%PKG%.TC011_Internal_ComponentVerification_FR_ATG
if "%REG_CLASS%"=="12" set TEST_CLASS=%PKG%.TC012_Reject_Approve_Internal_Global
if "%REG_CLASS%"=="13" set TEST_CLASS=%PKG%.TC013_Reject_Approve_Internal_ATG
if "%REG_CLASS%"=="14" set TEST_CLASS=%PKG%.TC014_Internal_OverAll_Run

if not defined TEST_CLASS (
    echo Invalid Class Selection
    goto REG_INTERNAL
)
goto ENV_SELECT


:: ============================ EXTERNAL ===============================
:REG_EXTERNAL
set "PKG=DAMS.Testcases.Regression_Suite.External"
set "LAST_MENUAwesome — here’s your **full, fixed, ready-to-run** batch file with **Go Back** support in every menu, **same echo format**, **all Smoke classes (1–101 + 999)**, and **Regression (Internal / External / Supplier)**.

> Navigation:
> - **Suite** → **Smoke / Regression**
> - **Smoke** → `0 - Go Back` to **Suite**
> - **Regression Category** → `0 - Go Back` to **Suite**
> - **Internal / External / Supplier** → `0 - Go Back` to **Regression Category**
> - **Environment** → `0 - Go Back` returns to the **exact previous menu** (Smoke or the chosen Regression class menu, or Regression Category if “Run ALL” was used)

---

```bat
@echo off
setlocal EnableDelayedExpansion

:: ========= CONFIG =========
set "PROJECT_DIR=C:\ui-automation-testing\ui-automation-testing"
set "LOG_DIR=C:\ui-automation-testing\Batch File\Logs"
set "SMOKE_XML=testng-smoke.xml"
set "REGRESSION_XML=testng-regression.xml"
:: ==========================

if not exist "%LOG_DIR%" mkdir "%LOG_DIR%"

echo =========================================
echo   DAMS Automation Test Runner
echo =========================================
echo.

:: Jump to main menu (for Go Back support)
goto SELECT_SUITE


:: =====================================================================
:: ============================ MAIN (SUITE) ============================
:: =====================================================================
:SELECT_SUITE
set "CHOSEN_SUITE="
set "SUITE_XML="
set "RUN_ALL_SMOKE=false"
set "RUN_ALL_REGRESSION=false"
set "TEST_CLASS="
set "PKG="
set "PREV_MENU="

echo Select Test Suite:
echo 1 - Smoke Suite
echo 2 - Regression Suite
echo 0 - Exit
echo.
set /p SUITE_CHOICE=Enter choice: 

if "%SUITE_CHOICE%"=="0" goto PAUSE_END
if "%SUITE_CHOICE%"=="1" (
    set "SUITE_XML=%SMOKE_XML%"
    set "CHOSEN_SUITE=SMOKE"
    goto SMOKE_MENU
)
if "%SUITE_CHOICE%"=="2" (
    set "SUITE_XML=%REGRESSION_XML%"
    set "CHOSEN_SUITE=REGRESSION"
    goto REGRESSION_CATEGORY_MENU
)

echo Invalid choice.
echo.
goto SELECT_SUITE


:: =====================================================================
:: ============================= SMOKE MENU =============================
:: =====================================================================
:SMOKE_MENU
set "RUN_ALL_SMOKE=false"
set "TEST_CLASS="

echo.
echo Select Smoke Test Class:
echo 1  - TC001_Global_Smoke_TestSuite_E2E
echo 2  - TC002_ATG_Smoke_TestSuite_E2E
echo 3  - TC003_ServicePrincipal_TestSuite_E2E
echo 4  - TC004_SpecialAccess_TestSuite_E2E
echo 5  - TC01_Login_MFA
echo 6  - TC02_Requests_STD_GLOBAL
echo 7  - TC03_Requests_STD_ATG_FR
echo 8  - TC04_STD_ATG_FRrejected
echo 9  - TC05_STD_GLOBAL_FRrejected
echo 10 - TC06_STD_GLOBAL_FRapproved
echo 11 - TC07_STD_ATG_FRapproved
echo 12 - TC08_Diagnostic_Authority_GLOBAL
echo 13 - TC09_Diagnostic_Authority_GLOBAL_Rejected
echo 14 - TC10_Diagnostic_Authority_GLOBAL_Approved
echo 15 - TC11_EnhanceRightAuthority_GLOBAL
echo 16 - TC12_EnhanceRightAuthority_GLOBAL_Rejected
echo 17 - TC13_EnhanceRightAuthority_GLOBAL_Approved
echo 18 - TC14_NestT_CentralAuth_GLOBAL
echo 19 - TC15_NestT_CentralAuth_GLOBAL_Rejected
echo 20 - TC16_NestT_CentralAuth_GLOBAL_Approved
echo 21 - TC17_NestT_TestCOT_GLOBAL
echo 22 - TC18_NestT_TestCOT_GLOBAL_Rejected
echo 23 - TC19_NestT_TestCOT_GLOBAL_Approved
echo 24 - TC20_NestT_SeriesCOT_GLOBAL
echo 25 - TC21_NestT_SeriesCOT_GLOBAL_Rejected
echo 26 - TC22_NestT_SeriesCOT_GLOBAL_Approved
echo 27 - TC23_ReplacementPackage_RootLink_GLOBAL
echo 28 - TC24_ReplacementPackage_RootLink_GLOBAL_Rejected
echo 29 - TC25_ReplacementPackage_RootLink_GLOBAL_Approved
echo 30 - TC26_ReplacementPackage_BackendLink_GLOBAL
echo 31 - TC27_ReplacementPackage_BackendLink_GLOBAL_Rejected
echo 32 - TC28_ReplacementPackage_BackendLink_GLOBAL_Approved
echo 33 - TC29_ReplacementPackage_RootBackend_Swap_GLOBAL
echo 34 - TC30_ReplacementPackage_RootBackend_Swap_Swap_GLOBAL_Rejected
echo 35 - TC31_ReplacementPackage_RootBackend_Swap_Swap_GLOBAL_Approved
echo 36 - TC32_DiagnosticAuthority_ATG
echo 37 - TC33_DiagnosticAuthority_ATG_Rejected
echo 38 - TC34_DiagnosticAuthority_ATG_Approved
echo 39 - TC35_EnhanceRightAuthority_ATG
echo 40 - TC36_EnhanceRightAuthority_ATG_Rejected
echo 41 - TC37_EnhanceRightAuthority_ATG_Approved
echo 42 - TC38_NestT_CentralAuth_ATG
echo 43 - TC39_NestT_CentralAuth_ATG_Rejected
echo 44 - TC40_NestT_CentralAuth_ATG_Approved
echo 45 - TC41_NestT_TestCOT_ATG
echo 46 - TC42_NestT_TestCOT_ATG_Rejected
echo 47 - TC43_NestT_TestCOT_ATG_Approved
echo 48 - TC44_NestT_SeriesCOT_ATG
echo 49 - TC45_NestT_SeriesCOT_ATG_Rejected
echo 50 - TC46_NestT_SeriesCOT_ATG_Approved
echo 51 - TC47_ReplacementPackage_RootLink_ATG
echo 52 - TC48_ReplacementPackage_RootLink_ATG_Rejected
echo 53 - TC49_ReplacementPackage_RootLink_ATG_Approved
echo 54 - TC50_ReplacementPackage_BackendLink_ATG
echo 55 - TC51_ReplacementPackage_BackendLink_ATG_Rejected
echo 56 - TC52_ReplacementPackage_BackendLink_ATG_Approved
echo 57 - TC53_ReplacementPackage_RootBackend_Swap_ATG
echo 58 - TC54_ReplacementPackage_RootBackend_Swap_ATG_Rejected
echo 59 - TC55_ReplacementPackage_RootBackend_Swap_ATG_Approved
echo 60 - TC56_ServicePrinciple_Production_Pending
echo 61 - TC57_ServicePrinciple_Production_Reject
echo 62 - TC58_ServicePrinciple_Production_Approved
echo 63 - TC59_ServicePrincipal_xOTA_Pending
echo 64 - TC60_ServicePrincipal_xOTA_Rejected
echo 65 - TC61_ServicePrincipal_xOTA_Approved
echo 66 - TC62_ServicePrincipal_Production_DA_Pending
echo 67 - TC63_ServicePrincipal_Production_DA_Rejected
echo 68 - TC64_ServicePrincipal_Production_DA_Approved
echo 69 - TC65_ServicePrincipal_Production_EA_Pending
echo 70 - TC66_ServicePrincipal_Production_EA_Rejected
echo 71 - TC67_ServicePrincipal_Production_EA_Approved
echo 72 - TC68_xOTA_FOTA_Pending
echo 73 - TC69_xOTA_FOTA_Rejected
echo 74 - TC70_xOTA_FOTA_Approved
echo 75 - TC71_OnboardNewECU_Pending
echo 76 - TC72_OnboardNewECU_Rejected
echo 77 - TC73_OnboardNewECU_Approved
echo 78 - TC74_FunctionalRole_ViewPermission
echo 79 - TC75_ThirdParty_Publisher
echo 80 - TC76_ViewPublisher_Onboarding_Edit
echo 81 - TC77_ViewPublisher_Onboarding_Delete
echo 82 - TC78_ViewPublisher_Onboarding
echo 83 - TC79_ADD_UpdateFR_ECU_Pending
echo 84 - TC80_ADD_UpdateFR_ECU_Rejected
echo 85 - TC81_ADD_UpdateFR_ECU_Approved
echo 86 - TC82_REMOVE_UpdateFR_ECU_Pending
echo 87 - TC83_REMOVE_UpdateFR_ECU_Rejected
echo 88 - TC84_REMOVE_UpdateFR_ECU_Approved
echo 89 - TC85_SpecialEnhancedRight_Pending
echo 90 - TC86_SpecialEnhancedRight_Rejected
echo 91 - TC87_SpecialEnhancedRight_Approved
echo 92 - TC88_ADD_UpdateGlobalEnhance_Pending
echo 93 - TC89_ADD_UpdateGlobalEnhance_Rejected
echo 94 - TC90_ADD_UpdateGlobalEnhance_Approved
echo 95 - TC91_DELETE_UpdateGlobalEnhance_Approved
echo 96 - TC92_ECU_MetaData
echo 97 - TC93_MyDeputy
echo 98 - TC94_ReadView_Permission
echo 99 - TC95_ECU_Certificate_Request_Pending
echo 100 - TC96_ECU_Certificate_Request_Rejected
echo 101 - TC97_ECU_Certificate_Request_Approved
echo.
echo 999 - Run ALL Smoke Tests
echo 0   - Go Back
echo.
set /p CLASS_CHOICE=Enter choice: 

if "%CLASS_CHOICE%"=="0" goto SELECT_SUITE
if "%CLASS_CHOICE%"=="999" (
    set "RUN_ALL_SMOKE=true"
    set "PREV_MENU=SMOKE_MENU"
    goto ENV_SELECT
) else (
    set "RUN_ALL_SMOKE=false"
)

:: Smoke mapping
if "%CLASS_CHOICE%"=="1"  set TEST_CLASS=TC001_Global_Smoke_TestSuite_E2E
if "%CLASS_CHOICE%"=="2"  set TEST_CLASS=TC002_ATG_Smoke_TestSuite_E2E
if "%CLASS_CHOICE%"=="3"  set TEST_CLASS=TC003_ServicePrincipal_TestSuite_E2E
if "%CLASS_CHOICE%"=="4"  set TEST_CLASS=TC004_SpecialAccess_TestSuite_E2E
if "%CLASS_CHOICE%"=="5"  set TEST_CLASS=TC01_Login_MFA
if "%CLASS_CHOICE%"=="6"  set TEST_CLASS=TC02_Requests_STD_GLOBAL
if "%CLASS_CHOICE%"=="7"  set TEST_CLASS=TC03_Requests_STD_ATG_FR
if "%CLASS_CHOICE%"=="8"  set TEST_CLASS=TC04_STD_ATG_FRrejected
if "%CLASS_CHOICE%"=="9"  set TEST_CLASS=TC05_STD_GLOBAL_FRrejected
if "%CLASS_CHOICE%"=="10" set TEST_CLASS=TC06_STD_GLOBAL_FRapproved
if "%CLASS_CHOICE%"=="11" set TEST_CLASS=TC07_STD_ATG_FRapproved
if "%CLASS_CHOICE%"=="12" set TEST_CLASS=TC08_Diagnostic_Authority_GLOBAL
if "%CLASS_CHOICE%"=="13" set TEST_CLASS=TC09_Diagnostic_Authority_GLOBAL_Rejected
if "%CLASS_CHOICE%"=="14" set TEST_CLASS=TC10_Diagnostic_Authority_GLOBAL_Approved
if "%CLASS_CHOICE%"=="15" set TEST_CLASS=TC11_EnhanceRightAuthority_GLOBAL
if "%CLASS_CHOICE%"=="16" set TEST_CLASS=TC12_EnhanceRightAuthority_GLOBAL_Rejected
if "%CLASS_CHOICE%"=="17" set TEST_CLASS=TC13_EnhanceRightAuthority_GLOBAL_Approved
if "%CLASS_CHOICE%"=="18" set TEST_CLASS=TC14_NestT_CentralAuth_GLOBAL
if "%CLASS_CHOICE%"=="19" set TEST_CLASS=TC15_NestT_CentralAuth_GLOBAL_Rejected
if "%CLASS_CHOICE%"=="20" set TEST_CLASS=TC16_NestT_CentralAuth_GLOBAL_Approved
if "%CLASS_CHOICE%"=="21" set TEST_CLASS=TC17_NestT_TestCOT_GLOBAL
if "%CLASS_CHOICE%"=="22" set TEST_CLASS=TC18_NestT_TestCOT_GLOBAL_Rejected
if "%CLASS_CHOICE%"=="23" set TEST_CLASS=TC19_NestT_TestCOT_GLOBAL_Approved
if "%CLASS_CHOICE%"=="24" set TEST_CLASS=TC20_NestT_SeriesCOT_GLOBAL
if "%CLASS_CHOICE%"=="25" set TEST_CLASS=TC21_NestT_SeriesCOT_GLOBAL_Rejected
if "%CLASS_CHOICE%"=="26" set TEST_CLASS=TC22_NestT_SeriesCOT_GLOBAL_Approved
if "%CLASS_CHOICE%"=="27" set TEST_CLASS=TC23_ReplacementPackage_RootLink_GLOBAL
if "%CLASS_CHOICE%"=="28" set TEST_CLASS=TC24_ReplacementPackage_RootLink_GLOBAL_Rejected
if "%CLASS_CHOICE%"=="29" set TEST_CLASS=TC25_ReplacementPackage_RootLink_GLOBAL_Approved
if "%CLASS_CHOICE%"=="30" set TEST_CLASS=TC26_ReplacementPackage_BackendLink_GLOBAL
if "%CLASS_CHOICE%"=="31" set TEST_CLASS=TC27_ReplacementPackage_BackendLink_GLOBAL_Rejected
if "%CLASS_CHOICE%"=="32" set TEST_CLASS=TC28_ReplacementPackage_BackendLink_GLOBAL_Approved
if "%CLASS_CHOICE%"=="33" set TEST_CLASS=TC29_ReplacementPackage_RootBackend_Swap_GLOBAL
if "%CLASS_CHOICE%"=="34" set TEST_CLASS=TC30_ReplacementPackage_RootBackend_Swap_Swap_GLOBAL_Rejected
if "%CLASS_CHOICE%"=="35" set TEST_CLASS=TC31_ReplacementPackage_RootBackend_Swap_Swap_GLOBAL_Approved
if "%CLASS_CHOICE%"=="36" set TEST_CLASS=TC32_DiagnosticAuthority_ATG
if "%CLASS_CHOICE%"=="37" set TEST_CLASS=TC33_DiagnosticAuthority_ATG_Rejected
if "%CLASS_CHOICE%"=="38" set TEST_CLASS=TC34_DiagnosticAuthority_ATG_Approved
if "%CLASS_CHOICE%"=="39" set TEST_CLASS=TC35_EnhanceRightAuthority_ATG
if "%CLASS_CHOICE%"=="40" set TEST_CLASS=TC36_EnhanceRightAuthority_ATG_Rejected
if "%CLASS_CHOICE%"=="41" set TEST_CLASS=TC37_EnhanceRightAuthority_ATG_Approved
if "%CLASS_CHOICE%"=="42" set TEST_CLASS=TC38_NestT_CentralAuth_ATG
if "%CLASS_CHOICE%"=="43" set TEST_CLASS=TC39_NestT_CentralAuth_ATG_Rejected
if "%CLASS_CHOICE%"=="44" set TEST_CLASS=TC40_NestT_CentralAuth_ATG_Approved
if "%CLASS_CHOICE%"=="45" set TEST_CLASS=TC41_NestT_TestCOT_ATG
if "%CLASS_CHOICE%"=="46" set TEST_CLASS=TC42_NestT_TestCOT_ATG_Rejected
if "%CLASS_CHOICE%"=="47" set TEST_CLASS=TC43_NestT_TestCOT_ATG_Approved
if "%CLASS_CHOICE%"=="48" set TEST_CLASS=TC44_NestT_SeriesCOT_ATG
if "%CLASS_CHOICE%"=="49" set TEST_CLASS=TC45_NestT_SeriesCOT_ATG_Rejected
if "%CLASS_CHOICE%"=="50" set TEST_CLASS=TC46_NestT_SeriesCOT_ATG_Approved
if "%CLASS_CHOICE%"=="51" set TEST_CLASS=TC47_ReplacementPackage_RootLink_ATG
if "%CLASS_CHOICE%"=="52" set TEST_CLASS=TC48_ReplacementPackage_RootLink_ATG_Rejected
if "%CLASS_CHOICE%"=="53" set TEST_CLASS=TC49_ReplacementPackage_RootLink_ATG_Approved
if "%CLASS_CHOICE%"=="54" set TEST_CLASS=TC50_ReplacementPackage_BackendLink_ATG
if "%CLASS_CHOICE%"=="55" set TEST_CLASS=TC51_ReplacementPackage_BackendLink_ATG_Rejected
if "%CLASS_CHOICE%"=="56" set TEST_CLASS=TC52_ReplacementPackage_BackendLink_ATG_Approved
if "%CLASS_CHOICE%"=="57" set TEST_CLASS=TC53_ReplacementPackage_RootBackend_Swap_ATG
if "%CLASS_CHOICE%"=="58" set TEST_CLASS=TC54_ReplacementPackage_RootBackend_Swap_ATG_Rejected
if "%CLASS_CHOICE%"=="59" set TEST_CLASS=TC55_ReplacementPackage_RootBackend_Swap_ATG_Approved
if "%CLASS_CHOICE%"=="60" set TEST_CLASS=TC56_ServicePrinciple_Production_Pending
if "%CLASS_CHOICE%"=="61" set TEST_CLASS=TC57_ServicePrinciple_Production_Reject
if "%CLASS_CHOICE%"=="62" set TEST_CLASS=TC58_ServicePrinciple_Production_Approved
if "%CLASS_CHOICE%"=="63" set TEST_CLASS=TC59_ServicePrincipal_xOTA_Pending
if "%CLASS_CHOICE%"=="64" set TEST_CLASS=TC60_ServicePrincipal_xOTA_Rejected
if "%CLASS_CHOICE%"=="65" set TEST_CLASS=TC61_ServicePrincipal_xOTA_Approved
if "%CLASS_CHOICE%"=="66" set TEST_CLASS=TC62_ServicePrincipal_Production_DA_Pending
if "%CLASS_CHOICE%"=="67" set TEST_CLASS=TC63_ServicePrincipal_Production_DA_Rejected
if "%CLASS_CHOICE%"=="68" set TEST_CLASS=TC64_ServicePrincipal_Production_DA_Approved
if "%CLASS_CHOICE%"=="69" set TEST_CLASS=TC65_ServicePrincipal_Production_EA_Pending
if "%CLASS_CHOICE%"=="70" set TEST_CLASS=TC66_ServicePrincipal_Production_EA_Rejected
if "%CLASS_CHOICE%"=="71" set TEST_CLASS=TC67_ServicePrincipal_Production_EA_Approved
if "%CLASS_CHOICE%"=="72" set TEST_CLASS=TC68_xOTA_FOTA_Pending
if "%CLASS_CHOICE%"=="73" set TEST_CLASS=TC69_xOTA_FOTA_Rejected
if "%CLASS_CHOICE%"=="74" set TEST_CLASS=TC70_xOTA_FOTA_Approved
if "%CLASS_CHOICE%"=="75" set TEST_CLASS=TC71_OnboardNewECU_Pending
if "%CLASS_CHOICE%"=="76" set TEST_CLASS=TC72_OnboardNewECU_Rejected
if "%CLASS_CHOICE%"=="77" set TEST_CLASS=TC73_OnboardNewECU_Approved
if "%CLASS_CHOICE%"=="78" set TEST_CLASS=TC74_FunctionalRole_ViewPermission
if "%CLASS_CHOICE%"=="79" set TEST_CLASS=TC75_ThirdParty_Publisher
if "%CLASS_CHOICE%"=="80" set TEST_CLASS=TC76_ViewPublisher_Onboarding_Edit
if "%CLASS_CHOICE%"=="81" set TEST_CLASS=TC77_ViewPublisher_Onboarding_Delete
if "%CLASS_CHOICE%"=="82" set TEST_CLASS=TC78_ViewPublisher_Onboarding
if "%CLASS_CHOICE%"=="83" set TEST_CLASS=TC79_ADD_UpdateFR_ECU_Pending
if "%CLASS_CHOICE%"=="84" set TEST_CLASS=TC80_ADD_UpdateFR_ECU_Rejected
if "%CLASS_CHOICE%"=="85" set TEST_CLASS=TC81_ADD_UpdateFR_ECU_Approved
if "%CLASS_CHOICE%"=="86" set TEST_CLASS=TC82_REMOVE_UpdateFR_ECU_Pending
if "%CLASS_CHOICE%"=="87" set TEST_CLASS=TC83_REMOVE_UpdateFR_ECU_Rejected
if "%CLASS_CHOICE%"=="88" set TEST_CLASS=TC84_REMOVE_UpdateFR_ECU_Approved
if "%CLASS_CHOICE%"=="89" set TEST_CLASS=TC85_SpecialEnhancedRight_Pending
if "%CLASS_CHOICE%"=="90" set TEST_CLASS=TC86_SpecialEnhancedRight_Rejected
if "%CLASS_CHOICE%"=="91" set TEST_CLASS=TC87_SpecialEnhancedRight_Approved
if "%CLASS_CHOICE%"=="92" set TEST_CLASS=TC88_ADD_UpdateGlobalEnhance_Pending
if "%CLASS_CHOICE%"=="93" set TEST_CLASS=TC89_ADD_UpdateGlobalEnhance_Rejected
if "%CLASS_CHOICE%"=="94" set TEST_CLASS=TC90_ADD_UpdateGlobalEnhance_Approved
if "%CLASS_CHOICE%"=="95" set TEST_CLASS=TC91_DELETE_UpdateGlobalEnhance_Approved
if "%CLASS_CHOICE%"=="96" set TEST_CLASS=TC92_ECU_MetaData
if "%CLASS_CHOICE%"=="97" set TEST_CLASS=TC93_MyDeputy
if "%CLASS_CHOICE%"=="98" set TEST_CLASS=TC94_ReadView_Permission
if "%CLASS_CHOICE%"=="99" set TEST_CLASS=TC95_ECU_Certificate_Request_Pending
if "%CLASS_CHOICE%"=="100" set TEST_CLASS=TC96_ECU_Certificate_Request_Rejected
if "%CLASS_CHOICE%"=="101" set TEST_CLASS=TC97_ECU_Certificate_Request_Approved

if not defined TEST_CLASS (
    echo Invalid Class Selection
    echo.
    goto SMOKE_MENU
)

set "PREV_MENU=SMOKE_MENU"
goto ENV_SELECT


:: =====================================================================
:: ========================= REGRESSION MENUS ===========================
:: =====================================================================
:REGRESSION_CATEGORY_MENU
set "RUN_ALL_REGRESSION=false"
set "TEST_CLASS="
set "PKG="

echo.
echo Select Regression Category:
echo 1 - Internal
echo 2 - External
echo 3 - Supplier
echo 999 - Run ALL Regression Tests
echo 0   - Go Back
echo.
set /p REG_CAT=Enter choice: 

if "%REG_CAT%"=="0" goto SELECT_SUITE
if "%REG_CAT%"=="999" (
    set "RUN_ALL_REGRESSION=true"
    set "PREV_MENU=REGRESSION_CATEGORY_MENU"
    goto ENV_SELECT
)

if "%REG_CAT%"=="1" goto REG_INTERNAL
if "%REG_CAT%"=="2" goto REG_EXTERNAL
if "%REG_CAT%"=="3" goto REG_SUPPLIER

echo Invalid category selection
echo.
goto REGRESSION_CATEGORY_MENU


:: ============================ INTERNAL ================================
:REG_INTERNAL
set "PKG=DAMS.Testcases.Regression_Suite.Internal"
set "TEST_CLASS="

echo.
echo INTERNAL Regression Classes:
echo 1  - TC001_Internal_Development_FR_Global
echo 2  - TC002_Internal_Production_FR_Global
echo 3  - TC003_Internal_VehicleValidation_FR_Global
echo 4  - TC004_Internal_BusProductionTool_FR_Global
echo 5  - TC005_Internal_QualityManagement_FR_Global
echo 6  - TC006_Internal_DiagnosticLinkTool_FR_Global
echo 7  - TC007_Internal_XentryTool_FR_Global
echo 8  - TC008_Internal_Development_FR_ATG
echo 9  - TC009_Internal_Production_FR_ATG
echo 10 - TC010_Internal_VehicleValidation_FR_ATG
echo 11 - TC011_Internal_ComponentVerification_FR_ATG
echo 12 - TC012_Reject_Approve_Internal_Global
echo 13 - TC013_Reject_Approve_Internal_ATG
echo 14 - TC014_Internal_OverAll_Run
echo.
echo 0   - Go Back
echo.
set /p REG_CLASS=Enter choice: 

if "%REG_CLASS%"=="0" goto REGRESSION_CATEGORY_MENU

if "%REG_CLASS%"=="1"  set TEST_CLASS=%PKG%.TC001_Internal_Development_FR_Global
if "%REG_CLASS%"=="2"  set TEST_CLASS=%PKG%.TC002_Internal_Production_FR_Global
if "%REG_CLASS%"=="3"  set TEST_CLASS=%PKG%.TC003_Internal_VehicleValidation_FR_Global
if "%REG_CLASS%"=="4"  set TEST_CLASS=%PKG%.TC004_Internal_BusProductionTool_FR_Global
if "%REG_CLASS%"=="5"  set TEST_CLASS=%PKG%.TC005_Internal_QualityManagement_FR_Global
if "%REG_CLASS%"=="6"  set TEST_CLASS=%PKG%.TC006_Internal_DiagnosticLinkTool_FR_Global
if "%REG_CLASS%"=="7"  set TEST_CLASS=%PKG%.TC007_Internal_XentryTool_FR_Global
if "%REG_CLASS%"=="8"  set TEST_CLASS=%PKG%.TC008_Internal_Development_FR_ATG
if "%REG_CLASS%"=="9"  set TEST_CLASS=%PKG%.TC009_Internal_Production_FR_ATG
if "%REG_CLASS%"=="10" set TEST_CLASS=%PKG%.TC010_Internal_VehicleValidation_FR_ATG
if "%REG_CLASS%"=="11" set TEST_CLASS=%PKG%.TC011_Internal_ComponentVerification_FR_ATG
if "%REG_CLASS%"=="12" set TEST_CLASS=%PKG%.TC012_Reject_Approve_Internal_Global
if "%REG_CLASS%"=="13" set TEST_CLASS=%PKG%.TC013_Reject_Approve_Internal_ATG
if "%REG_CLASS%"=="14" set TEST_CLASS=%PKG%.TC014_Internal_OverAll_Run

if not defined TEST_CLASS (
    echo Invalid Class Selection
    echo.
    goto REG_INTERNAL
)

set "PREV_MENU=REG_INTERNAL"
goto ENV_SELECT


:: ============================ EXTERNAL ===============================
:REG_EXTERNAL
set "PKG=DAMS.Testcases.Regression_Suite.External"
set "TEST_CLASS="

echo.
echo EXTERNAL Regression Classes:
echo 1  - TC001_External_Development_FR_Global
echo 2  - TC002_External_Production_FR_Global
echo 3  - TC003_External_VehicleValidation_FR_Global
echo 4  - TC004_External_BusProductionTool_FR_Global
echo 5  - TC005_External_QualityManagement_FR_Global
echo 6  - TC006_External_DiagnosticLinkTool_FR_Global
echo 7  - TC007_External_XentryTool_FR_Global
echo 8  - TC008_External_Development_FR_ATG
echo 9  - TC009_External_Production_FR_ATG
echo 10 - TC010_External_VehicleValidation_FR_ATG
echo 11 - TC011_External_ComponentVerification_FR_ATG
echo 12 - TC012_Reject_Approve_External_Global
echo 13 - TC013_Reject_Approve_External_ATG
echo 14 - TC014_External_OverAll_Run
echo 15 - TC015_FUSO_External_Development_FR_Global
echo.
echo 0   - Go Back
echo.
set /p REG_CLASS=Enter choice: 

if "%REG_CLASS%"=="0" goto REGRESSION_CATEGORY_MENU

if "%REG_CLASS%"=="1"  set TEST_CLASS=%PKG%.TC001_External_Development_FR_Global
if "%REG_CLASS%"=="2"  set TEST_CLASS=%PKG%.TC002_External_Production_FR_Global
if "%REG_CLASS%"=="3"  set TEST_CLASS=%PKG%.TC003_External_VehicleValidation_FR_Global
if "%REG_CLASS%"=="4"  set TEST_CLASS=%PKG%.TC004_External_BusProductionTool_FR_Global
if "%REG_CLASS%"=="5"  set TEST_CLASS=%PKG%.TC005_External_QualityManagement_FR_Global
if "%REG_CLASS%"=="6"  set TEST_CLASS=%PKG%.TC006_External_DiagnosticLinkTool_FR_Global
if "%REG_CLASS%"=="7"  set TEST_CLASS=%PKG%.TC007_External_XentryTool_FR_Global
if "%REG_CLASS%"=="8"  set TEST_CLASS=%PKG%.TC008_External_Development_FR_ATG
if "%REG_CLASS%"=="9"  set TEST_CLASS=%PKG%.TC009_External_Production_FR_ATG
if "%REG_CLASS%"=="10" set TEST_CLASS=%PKG%.TC010_External_VehicleValidation_FR_ATG
if "%REG_CLASS%"=="11" set TEST_CLASS=%PKG%.TC011_External_ComponentVerification_FR_ATG
if "%REG_CLASS%"=="12" set TEST_CLASS=%PKG%.TC012_Reject_Approve_External_Global
if "%REG_CLASS%"=="13" set TEST_CLASS=%PKG%.TC013_Reject_Approve_External_ATG
if "%REG_CLASS%"=="14" set TEST_CLASS=%PKG%.TC014_External_OverAll_Run
if "%REG_CLASS%"=="15" set TEST_CLASS=%PKG%.TC015_FUSO_External_Development_FR_Global

if not defined TEST_CLASS (
    echo Invalid Class Selection
    echo.
    goto REG_EXTERNAL
)

set "PREV_MENU=REG_EXTERNAL"
goto ENV_SELECT


:: ============================ SUPPLIER ===============================
:REG_SUPPLIER
set "PKG=DAMS.Testcases.Regression_Suite.Supplier"
set "TEST_CLASS="

echo.
echo SUPPLIER Regression Classes:
echo 1 - TC001_Supplier_KeyManagement_FR_Global
echo 2 - TC002_Supplier_Development_FR_Global
echo 3 - TC003_Supplier_WarrantyReturn_FR_Global
echo 4 - TC004_Supplier_KeyManagement_FR_ATG
echo 5 - TC005_Supplier_Development_FR_ATG
echo 6 - TC006_Supplier_WarrantyReturn_FR_ATG
echo 7 - TC007_Reject_Approve_Supplier_Global
echo 8 - TC008_Reject_Approve_Supplier_ATG
echo 9 - TC009_FUSO_Supplier_All_FR_Global
echo.
echo 0   - Go Back
echo.
set /p REG_CLASS=Enter choice: 

if "%REG_CLASS%"=="0" goto REGRESSION_CATEGORY_MENU

if "%REG_CLASS%"=="1" set TEST_CLASS=%PKG%.TC001_Supplier_KeyManagement_FR_Global
if "%REG_CLASS%"=="2" set TEST_CLASS=%PKG%.TC002_Supplier_Development_FR_Global
if "%REG_CLASS%"=="3" set TEST_CLASS=%PKG%.TC003_Supplier_WarrantyReturn_FR_Global
if "%REG_CLASS%"=="4" set TEST_CLASS=%PKG%.TC004_Supplier_KeyManagement_FR_ATG
if "%REG_CLASS%"=="5" set TEST_CLASS=%PKG%.TC005_Supplier_Development_FR_ATG
if "%REG_CLASS%"=="6" set TEST_CLASS=%PKG%.TC006_Supplier_WarrantyReturn_FR_ATG
if "%REG_CLASS%"=="7" set TEST_CLASS=%PKG%.TC007_Reject_Approve_Supplier_Global
if "%REG_CLASS%"=="8" set TEST_CLASS=%PKG%.TC008_Reject_Approve_Supplier_ATG
if "%REG_CLASS%"=="9" set TEST_CLASS=%PKG%.TC009_FUSO_Supplier_All_FR_Global

if not defined TEST_CLASS (
    echo Invalid Class Selection
    echo.
    goto REG_SUPPLIER
)

set "PREV_MENU=REG_SUPPLIER"
goto ENV_SELECT


:: =====================================================================
:: ====================== ENVIRONMENT SELECTION ========================
:: =====================================================================
:ENV_SELECT
echo.
echo Select Environment:
echo 1 - DEV
echo 2 - STG
echo 3 - QA
echo 0 - Go Back
echo.
set /p ENV_CHOICE=Enter choice (1, 2, 3 or 0): 

if "%ENV_CHOICE%"=="0" goto %PREV_MENU%
if "%ENV_CHOICE%"=="1" (
    set "ENV=dev"
    set "BASE_URL=https://dams-dev.azurewebsites.net/dams/"
    goto EXEC_SUMMARY
)
if "%ENV_CHOICE%"=="2" (
    set "ENV=stg"
    set "BASE_URL=https://dams-stg.azurewebsites.net/dams/"
    goto EXEC_SUMMARY
)
if "%ENV_CHOICE%"=="3" (
    set "ENV=qa"
    set "BASE_URL=https://dams-qa.daimlertruck.com/dams/#/"
    goto EXEC_SUMMARY
)

echo Invalid Environment Selection
echo.
goto ENV_SELECT


:: =====================================================================
:: ========================= EXECUTION SUMMARY =========================
:: =====================================================================
:EXEC_SUMMARY
echo.
echo =====================================================
echo            DAMS AUTOMATION EXECUTION SUMMARY
echo =====================================================
echo.
echo Test Suite   : %SUITE_XML%

if "%CHOSEN_SUITE%"=="SMOKE" (
    if "%RUN_ALL_SMOKE%"=="true" (
        echo Execution    : Smoke Suite - ALL Classes
    ) else (
        echo Execution    : Smoke Suite - Single Class
        echo Test Class   : %TEST_CLASS%
    )
)

if "%CHOSEN_SUITE%"=="REGRESSION" (
    if "%RUN_ALL_REGRESSION%"=="true" (
        echo Execution    : Regression Suite - ALL Classes
    ) else (
        echo Execution    : Regression Suite - Single Class
        echo Test Class   : %TEST_CLASS%
    )
)

echo Environment  : %ENV%
echo Base URL     : %BASE_URL%
echo.

:: timestamp safe for file name
set "hh=%TIME:~0,2%"
if "%hh:~0,1%"==" " set "hh=0%hh:~1,1%"
set "mm=%TIME:~3,2%"
set "ss=%TIME:~6,2%"
set "TIMESTAMP=%DATE:~-4%%DATE:~4,2%%DATE:~7,2%_%hh%%mm%%ss%"

set "LOG_FILE=%LOG_DIR%\TestRun_%TIMESTAMP%.log"

echo Log file     : %LOG_FILE%
echo.

:: =====================================================================
:: ============================ RUN MAVEN ===============================
:: =====================================================================
echo Running Maven...

if "%CHOSEN_SUITE%"=="SMOKE" (
    if "%RUN_ALL_SMOKE%"=="true" (
        echo mvn -f "%PROJECT_DIR%\pom.xml" clean test -DsuiteXmlFile=%SMOKE_XML% -Denv=%ENV% -Dbase.url=%BASE_URL%
        mvn -f "%PROJECT_DIR%\pom.xml" clean test -DsuiteXmlFile=%SMOKE_XML% -Denv=%ENV% -Dbase.url=%BASE_URL% > "%LOG_FILE%" 2>&1
    ) else (
        echo mvn -f "%PROJECT_DIR%\pom.xml" clean test -Dtest=%TEST_CLASS% -Denv=%ENV% -Dbase.url=%BASE_URL%
        mvn -f "%PROJECT_DIR%\pom.xml" clean test -Dtest=%TEST_CLASS% -Denv=%ENV% -Dbase.url=%BASE_URL% > "%LOG_FILE%" 2>&1
    )
)

if "%CHOSEN_SUITE%"=="REGRESSION" (
    if "%RUN_ALL_REGRESSION%"=="true" (
        echo mvn -f "%PROJECT_DIR%\pom.xml" clean test -DsuiteXmlFile=%REGRESSION_XML% -Denv=%ENV% -Dbase.url=%BASE_URL%
        mvn -f "%PROJECT_DIR%\pom.xml" clean test -DsuiteXmlFile=%REGRESSION_XML% -Denv=%ENV% -Dbase.url=%BASE_URL% > "%LOG_FILE%" 2>&1
    ) else (
        echo mvn -f "%PROJECT_DIR%\pom.xml" clean test -Dtest=%TEST_CLASS% -Denv=%ENV% -Dbase.url=%BASE_URL%
        mvn -f "%PROJECT_DIR%\pom.xml" clean test -Dtest=%TEST_CLASS% -Denv=%ENV% -Dbase.url=%BASE_URL% > "%LOG_FILE%" 2>&1
    )
)

if %ERRORLEVEL% NEQ 0 (
    echo.
    echo ❌ Test Execution Failed. Check log:
    echo %LOG_FILE%
    goto PAUSE_END
)

echo.
echo ✅ Test Execution Completed Successfully!
echo Log saved at: %LOG_FILE%

:PAUSE_END
echo.
echo Press any key to exit...
pause >nul
endlocal