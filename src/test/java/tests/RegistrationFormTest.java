package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegistrationFormPage;

public class RegistrationFormTest {
    WebDriver driver;
    WebDriverWait wait;
    String URL = "https://etherscan.io/register";

    @BeforeMethod
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver98.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    // Test scenario 01
    @Test
    public void skipAllFields(){
        RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver, wait);
        registrationFormPage.clickOnAcceptCookiesButton();
        registrationFormPage.clickCreateAnAccountButton();
        registrationFormPage.verifyErrorMessageUsername();
        registrationFormPage.verifyErrorMessageEmail();
        registrationFormPage.verifyErrorMessageForPassword();
        registrationFormPage.verifyErrorMessageForConfirmPassword();
        registrationFormPage.verifyErrorMessageForTermsAndConditions();


    }
    // Test scenario 02
    @Test
    public void leaveUsernameFieldEmpty() {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver, wait);
        registrationFormPage.clickOnAcceptCookiesButton();
        registrationFormPage.clickOnReCaptcha();
        registrationFormPage.enterEmailAddress("vladadjurovic@gmail.com");
        registrationFormPage.enterPassword("vladadju87");
        registrationFormPage.enterConfirmPassword("vladadju87");
        registrationFormPage.checkBoxTermsAndConditions();
        registrationFormPage.checkBoxSubscribeNewsletter();
        registrationFormPage.clickCreateAnAccountButton();
        registrationFormPage.verifyErrorMessageUsername();

    }
    // Test scenario 03
    @Test
    public void usernameLessThan5Characters(){
        RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver, wait);
        registrationFormPage.clickOnAcceptCookiesButton();
        registrationFormPage.clickOnReCaptcha();
        registrationFormPage.enterUsername("vlad");
        registrationFormPage.enterEmailAddress("vladadjurovic@gmail.com");
        registrationFormPage.enterPassword("vladadju87");
        registrationFormPage.enterConfirmPassword("vladadju87");
        registrationFormPage.checkBoxTermsAndConditions();
        registrationFormPage.checkBoxSubscribeNewsletter();
        registrationFormPage.clickCreateAnAccountButton();
        registrationFormPage.verifyErrorMessageUsername();
    }
    // Test scenario 04
    @Test
    public void usernameNonAlphanumericCharacters(){
        RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver, wait);
        registrationFormPage.clickOnAcceptCookiesButton();
        registrationFormPage.clickOnReCaptcha();
        registrationFormPage.enterUsername("vladimirdju?");
        registrationFormPage.enterEmailAddress("vladadjurovic@gmail.com");
        registrationFormPage.enterPassword("vladadju87");
        registrationFormPage.enterConfirmPassword("vladadju87");
        registrationFormPage.checkBoxTermsAndConditions();
        registrationFormPage.checkBoxSubscribeNewsletter();
        registrationFormPage.clickCreateAnAccountButton();
        registrationFormPage.verifyErrorMessageUsername();
    }
    //Test scenario 05
    @Test
    public void leaveEmailAddressFieldEmpty(){
        RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver, wait);
        registrationFormPage.clickOnAcceptCookiesButton();
        registrationFormPage.clickOnReCaptcha();
        registrationFormPage.enterUsername("vladimirdju");
        registrationFormPage.enterPassword("vladadju87");
        registrationFormPage.enterConfirmPassword("vladadju87");
        registrationFormPage.checkBoxTermsAndConditions();
        registrationFormPage.checkBoxSubscribeNewsletter();
        registrationFormPage.clickCreateAnAccountButton();
        registrationFormPage.verifyErrorMessageEmail();
    }
    //Test scenario 06
    @Test
    public void invalidEmailAddress(){
        RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver, wait);
        registrationFormPage.clickOnAcceptCookiesButton();
        registrationFormPage.clickOnReCaptcha();
        registrationFormPage.enterUsername("vladimirdju");
        registrationFormPage.enterEmailAddress("vladadjurovicgmail.com");
        registrationFormPage.enterPassword("vladadju87");
        registrationFormPage.enterConfirmPassword("vladadju87");
        registrationFormPage.checkBoxTermsAndConditions();
        registrationFormPage.checkBoxSubscribeNewsletter();
        registrationFormPage.clickCreateAnAccountButton();
        registrationFormPage.verifyErrorMessageEmail();
    }
    //Test scenario 07
    @Test
    public void leavePasswordAndConfirmPasswordFieldEmpty(){
        RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver, wait);
        registrationFormPage.clickOnAcceptCookiesButton();
        registrationFormPage.clickOnReCaptcha();
        registrationFormPage.enterUsername("vladimirdju");
        registrationFormPage.enterEmailAddress("vladadjurovic@gmail.com");
        registrationFormPage.checkBoxTermsAndConditions();
        registrationFormPage.checkBoxSubscribeNewsletter();
        registrationFormPage.clickCreateAnAccountButton();
        registrationFormPage.verifyErrorMessageForPassword();
        registrationFormPage.verifyErrorMessageForConfirmPassword();
    }
    //Test scenario 08
    @Test
    public void enterLessThan5CharactersInPasswordAndConfirmPasswordField(){
        RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver, wait);
        registrationFormPage.clickOnAcceptCookiesButton();
        registrationFormPage.clickOnReCaptcha();
        registrationFormPage.enterUsername("vladimirdju");
        registrationFormPage.enterEmailAddress("vladadjurovic@gmail.com");
        registrationFormPage.enterPassword("vlad");
        registrationFormPage.enterConfirmPassword("vlad");
        registrationFormPage.checkBoxTermsAndConditions();
        registrationFormPage.checkBoxSubscribeNewsletter();
        registrationFormPage.clickCreateAnAccountButton();
        registrationFormPage.verifyErrorMessageForPassword();
        registrationFormPage.verifyErrorMessageForConfirmPassword();
    }


}
