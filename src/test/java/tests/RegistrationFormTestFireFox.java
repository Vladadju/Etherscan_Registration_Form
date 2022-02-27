package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegistrationFormPage;

import java.util.Random;

public class RegistrationFormTestFireFox {
    WebDriver driver;
    WebDriverWait wait;
    String URL = "https://etherscan.io/register";

    @BeforeMethod
    public void setUp(){

        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(URL);

    }
    @AfterMethod
    public void tearDown(){
       //driver.quit();
    }
    // Test scenario 02
    // TC01 Verify that user will not be able to register if he/she leave all fields empty
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
    // TC02 Verify that user will not be able to register ih he/she leave username field empty.
    @Test
    public void leaveUsernameFieldEmpty() throws InterruptedException {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver, wait);
        registrationFormPage.clickOnAcceptCookiesButton();
        registrationFormPage.enterEmailAddress("vladadjurovic@gmail.com");
        registrationFormPage.enterPassword("vladadju87");
        registrationFormPage.enterConfirmPassword("vladadju87");
        registrationFormPage.checkBoxTermsAndConditions();
        registrationFormPage.checkBoxSubscribeNewsletter();
        registrationFormPage.clickOnReCaptcha();
        registrationFormPage.clickCreateAnAccountButton();
        registrationFormPage.verifyErrorMessageUsername();

    }
    // Test scenario 02
    // TC03 Verify that user will not be able to register ih he/she enter less than 5 characters in username field.
    @Test
    public void usernameLessThan5Characters() throws InterruptedException {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver, wait);
        registrationFormPage.clickOnAcceptCookiesButton();
        registrationFormPage.enterUsername("vlad");
        registrationFormPage.enterEmailAddress("vladadjurovic@gmail.com");
        registrationFormPage.enterPassword("vladadju87");
        registrationFormPage.enterConfirmPassword("vladadju87");
        registrationFormPage.checkBoxTermsAndConditions();
        registrationFormPage.checkBoxSubscribeNewsletter();
        registrationFormPage.clickOnReCaptcha();
        registrationFormPage.clickCreateAnAccountButton();
        registrationFormPage.verifyErrorMessageUsername();
    }
    //Test scenario 02
    //TC05 Verify that user will not be able to register ih he/she enter already registered username.
    @Test
    public void alreadyUsedUsername(){
        RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver, wait);
        registrationFormPage.clickOnAcceptCookiesButton();
        registrationFormPage.enterUsername("vladimirdju");
        registrationFormPage.enterEmailAddress("vladadjurovic@gmail.com");
        registrationFormPage.enterPassword("vladadju87");
        registrationFormPage.enterConfirmPassword("vladadju87");
        registrationFormPage.checkBoxTermsAndConditions();
        registrationFormPage.checkBoxSubscribeNewsletter();
        registrationFormPage.clickOnReCaptcha();
        registrationFormPage.clickCreateAnAccountButton();
        registrationFormPage.verifyAlreadyUsedUsernameErrorMessage();

    }
    // Test scenario 02
    // TC06 Verify that user will not be able to register ih he/she enter
    //      non alphanumeric characters.
    @Test
    public void usernameNonAlphanumericCharacters() throws InterruptedException {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver, wait);
        registrationFormPage.clickOnAcceptCookiesButton();
        registrationFormPage.enterUsername("vladimirdju?");
        registrationFormPage.enterEmailAddress("vladadjurovic@gmail.com");
        registrationFormPage.enterPassword("vladadju87");
        registrationFormPage.enterConfirmPassword("vladadju87");
        registrationFormPage.checkBoxTermsAndConditions();
        registrationFormPage.checkBoxSubscribeNewsletter();
        registrationFormPage.clickOnReCaptcha();
        registrationFormPage.clickCreateAnAccountButton();
        registrationFormPage.verifyErrorMessageUsername();
    }
    //Test scenario 02
    //TC07 Verify that user will not be able to register ih he/she leave empty email address field.
    @Test
    public void leaveEmailAddressFieldEmpty() throws InterruptedException {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver, wait);
        registrationFormPage.clickOnAcceptCookiesButton();
        registrationFormPage.enterUsername("Vladadju");
        registrationFormPage.enterPassword("vladadju87");
        registrationFormPage.enterConfirmPassword("vladadju87");
        registrationFormPage.checkBoxTermsAndConditions();
        registrationFormPage.checkBoxSubscribeNewsletter();
        registrationFormPage.clickOnReCaptcha();
        registrationFormPage.clickCreateAnAccountButton();
        registrationFormPage.verifyErrorMessageEmail();
    }

    //Test scenario 02
    //TC08 Verify that user will not be able to register ih he/she enter email address in invalid format.
    @Test
    public void invalidEmailAddress()  {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver, wait);
        registrationFormPage.clickOnAcceptCookiesButton();
        registrationFormPage.enterUsername("Vladadju");
        registrationFormPage.enterEmailAddress("vladadjurovicgmail.com");
        registrationFormPage.enterPassword("vladadju87");
        registrationFormPage.enterConfirmPassword("vladadju87");
        registrationFormPage.checkBoxTermsAndConditions();
        registrationFormPage.checkBoxSubscribeNewsletter();
        registrationFormPage.clickOnReCaptcha();
        registrationFormPage.clickCreateAnAccountButton();
        registrationFormPage.verifyErrorMessageEmail();
    }
    //Test scenario 02
    //TC09 Verify that user will not be able to register ih he/she leave empty
    //     password and confirm password fields.
    @Test
    public void leavePasswordAndConfirmPasswordFieldEmpty() {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver, wait);
        registrationFormPage.clickOnAcceptCookiesButton();
        registrationFormPage.enterUsername("Vladadju");
        registrationFormPage.enterEmailAddress("vladadjurovic@gmail.com");
        registrationFormPage.checkBoxTermsAndConditions();
        registrationFormPage.checkBoxSubscribeNewsletter();
        registrationFormPage.clickOnReCaptcha();
        registrationFormPage.clickCreateAnAccountButton();
        registrationFormPage.verifyErrorMessageForPassword();
        registrationFormPage.verifyErrorMessageForConfirmPassword();
    }
    //Test scenario 02
    //TC10 Verify that user will not be able to register ih he/she leave password field empty.
    @Test
    public void emptyPasswordValidConfirmPassword() throws InterruptedException {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver, wait);
        registrationFormPage.clickOnAcceptCookiesButton();
        registrationFormPage.enterUsername("Vladadju");
        registrationFormPage.enterEmailAddress("vladadjurovic@gmail.com");
        registrationFormPage.enterConfirmPassword("vladadju87");
        registrationFormPage.checkBoxTermsAndConditions();
        Thread.sleep(2000);
        registrationFormPage.checkBoxSubscribeNewsletter();
        registrationFormPage.clickOnReCaptcha();
        registrationFormPage.clickCreateAnAccountButton();
        registrationFormPage.verifyErrorMessageForPassword();
        registrationFormPage.verifyErrorMessageForDifferentConfirmPassword();
    }
    //Test scenario 02
    //TC11 Verify that user will not be able to register ih he/she leave empty confirm password field.
    @Test
    public void emptyConfirmPassword() throws InterruptedException {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver, wait);
        registrationFormPage.clickOnAcceptCookiesButton();
        registrationFormPage.enterUsername("Vladadju");
        registrationFormPage.enterEmailAddress("vladadjurovic@gmail.com");
        registrationFormPage.enterPassword("vladadju87");
        registrationFormPage.checkBoxTermsAndConditions();
        Thread.sleep(2000);
        registrationFormPage.checkBoxSubscribeNewsletter();
        registrationFormPage.clickOnReCaptcha();
        registrationFormPage.clickCreateAnAccountButton();
        registrationFormPage.verifyErrorMessageForConfirmPassword();
    }
    //Test scenario 02
    //TC12 Verify that user will not be able to register if he/she enter les than 5
    //     characters in password and confirm password fields.
    @Test
    public void enterLessThan5CharactersInPasswordAndConfirmPasswordField() throws InterruptedException {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver, wait);
        registrationFormPage.clickOnAcceptCookiesButton();
        registrationFormPage.enterUsername("Vladadju");
        registrationFormPage.enterEmailAddress("vladadjurovic@gmail.com");
        registrationFormPage.enterPassword("vlad");
        registrationFormPage.enterConfirmPassword("vlad");
        registrationFormPage.checkBoxTermsAndConditions();
        registrationFormPage.checkBoxSubscribeNewsletter();
        registrationFormPage.clickOnReCaptcha();
        registrationFormPage.clickCreateAnAccountButton();
        registrationFormPage.verifyErrorMessageForPassword();
        registrationFormPage.verifyErrorMessageForConfirmPassword();
    }
    //Test scenario 02
    //TC13 Verify that user will not be able to register if he/she enter invalid data in confirm password field.
    @Test
    public void validPasswordInvalidDifferentConfirmPassword() throws InterruptedException {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver, wait);
        registrationFormPage.clickOnAcceptCookiesButton();
        registrationFormPage.enterUsername("Vladadju");
        registrationFormPage.enterEmailAddress("vladadjurovic@gmail.com");
        registrationFormPage.enterPassword("vladadju87");
        registrationFormPage.enterConfirmPassword("vladimir");
        registrationFormPage.checkBoxTermsAndConditions();
        registrationFormPage.checkBoxSubscribeNewsletter();
        registrationFormPage.clickOnReCaptcha();
        registrationFormPage.clickCreateAnAccountButton();
        registrationFormPage.verifyErrorMessageForDifferentConfirmPassword();
    }


    //Test scenario 02
    //TC14 Verify that user will not be able to register if he/she skip checkbox
    //     I agree to the Terms and Conditions.
    @Test
    public void skipCheckboxTermsAndConditions() throws InterruptedException {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver, wait);
        registrationFormPage.clickOnAcceptCookiesButton();
        registrationFormPage.enterUsername("Vladadju");
        registrationFormPage.enterEmailAddress("vladadjurovic@gmail.com");
        registrationFormPage.enterPassword("vladadju87");
        registrationFormPage.enterConfirmPassword("vladadju87");
        Thread.sleep(2000);
        registrationFormPage.checkBoxSubscribeNewsletter();
        registrationFormPage.clickOnReCaptcha();
        registrationFormPage.clickCreateAnAccountButton();
        registrationFormPage.verifyErrorMessageForTermsAndConditions();

    }
    //Test scenario 02
    //TC15 Verify that user will not be able to register if he/she skip checkbox
    //     I'm not a robot.
    @Test
    public void skipCheckboxReCaptcha() {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver, wait);
        registrationFormPage.clickOnAcceptCookiesButton();
        registrationFormPage.enterUsername("Vladadju");
        registrationFormPage.enterEmailAddress("vladadjurovic@gmail.com");
        registrationFormPage.enterPassword("vladadju87");
        registrationFormPage.enterConfirmPassword("vladadju87");
        registrationFormPage.checkBoxTermsAndConditions();
        registrationFormPage.checkBoxSubscribeNewsletter();
        registrationFormPage.clickCreateAnAccountButton();
        registrationFormPage.verifyErrorMessageForReCaptcha();
    }

    // Test scenario 03
    // TC01 Verify that user will register if he/she enter valid data in all required fields
    //      and check all checkboxes.
    @Test
    public void submitValidData(){
        RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver, wait);
        registrationFormPage.clickOnAcceptCookiesButton();
        registrationFormPage.enterUsername(generateRandomString(7));
        registrationFormPage.enterEmailAddress("testmail"+System.currentTimeMillis()+"@gmail.com");
        registrationFormPage.enterPassword("vladadju878");
        registrationFormPage.enterConfirmPassword("vladadju878");
        registrationFormPage.checkBoxTermsAndConditions();
        registrationFormPage.checkBoxSubscribeNewsletter();
        registrationFormPage.clickOnReCaptcha();
        registrationFormPage.clickCreateAnAccountButton();
        registrationFormPage.verifySuccessRegistration();


    }
    public String generateRandomString(int numOfChars){
        String[] letters = {"A","B","C","D","E"};
        String result = "";
        for(int i = 1; i <= numOfChars; i++){
            Random r = new Random();
            int randomNum = r.nextInt(letters.length-1);
            result = result + letters[randomNum];
        }
        return result;
    }


}
