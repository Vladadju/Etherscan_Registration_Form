package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RegistrationFormPage extends BasePage{
    public RegistrationFormPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "input[id*='txtUserName']")
    WebElement username;
    @FindBy(css = "input[id*='txtEmail']")
    WebElement emailAddress;
    @FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtPassword']")
    WebElement password;
    @FindBy(css = "input[id*='txtPassword2']")
    WebElement confirmPassword;
    @FindBy(css = "input[name='ctl00$ContentPlaceHolder1$MyCheckBox']")
    WebElement termsAndConditions;
    @FindBy(css = "label[for='ContentPlaceHolder1_SubscribeNewsletter']")
    WebElement subscribeNewsletter;
    @FindBy(css = "input[id*='btnRegister']")
    WebElement createAnAccountButton;
    @FindBy(css = "#ContentPlaceHolder1_txtUserName-error")
    WebElement invalidMessageForUsername;
    @FindBy(css = "#ContentPlaceHolder1_txtEmail-error")
    WebElement invalidMessageForEmail;
    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_txtPassword-error']")
    WebElement invalidMessageForPassword;
    @FindBy(css = "div[id*='txtPassword2']")
    WebElement invalidMessageForConfirmPassword;
    @FindBy(css = "div[id='ContentPlaceHolder1_txtPassword2-error']")
    WebElement invalidMessageForDifferentConfirmPassword;
    @FindBy(css = "div[id='ctl00$ContentPlaceHolder1$MyCheckBox-error']")
    WebElement invalidMessageForTermsAndConditions;
    @FindBy(xpath = "//*[@id='btnCookie']")
    WebElement acceptCookies;
    @FindBy(css = "iframe[name='a-pmu4asq3bpy9")
    WebElement iFrame;
    @FindBy(xpath = "//*[@id='recaptcha-anchor']/div[4]")
    WebElement reCaptcha;
    @FindBy(xpath = "//*[@id='ctl00']/div[4]")
    WebElement errorReCaptcha;
    @FindBy(xpath = "//*[@id='ctl00']/div[4]")
    WebElement validRegistration;
    @FindBy(xpath = "//*[@id='ctl00']/div[4]")
    WebElement alreadyUsedUsername;
    String expectedErrorMessageForUsername = "Username is invalid.";
    String expectedErrorMessageForEmail = "Please enter a valid email address.";
    String expectedErrorMessageForPassword = "Your password must be at least 5 characters long.";
    String expectedErrorMessageForConfirmPassword = "Your password must be at least 5 characters long.";
    String expectedErrorMessageForTermsAndConditions = "Please accept our Terms and Conditions.";
    String expectedErrorMessageForDifferentConfirmPassword = "Password does not match, please check again.";
    String expectedErrorMessageForReCaptcha = "Error! Invalid captcha response.\nPlease Try Again";
    String expectedErrorMessageForAlreadyUsedUsername = "Sorry! The username you entered is already in use.";
    String expectedMessageForSuccessRegistration = "Your account registration has been submitted and is pending email verification ";

    public void enterUsername(String usernameText){
       username.sendKeys(usernameText);
    }
    public void enterEmailAddress(String emailText){
        emailAddress.sendKeys(emailText);
    }
    public void enterPassword(String passwordText){
        password.sendKeys(passwordText);
    }
    public void enterConfirmPassword(String confirmPasswordText){
        confirmPassword.sendKeys(confirmPasswordText);
    }
    public void checkBoxTermsAndConditions()  {

        Actions actions = new Actions(driver);
        actions.moveToElement(termsAndConditions).click().build().perform();
        boolean isSelected = termsAndConditions.isSelected();

        if(!isSelected) {
            termsAndConditions.click();
        }

        }
    public void checkBoxSubscribeNewsletter(){
        Actions actions = new Actions(driver);
        actions.moveToElement(subscribeNewsletter).click().build().perform();
        boolean isSelected = subscribeNewsletter.isSelected();

        if(!isSelected) {
            subscribeNewsletter.click();
        }else {
            subscribeNewsletter.click();
        }
//        subscribeNewsletter.click();
    }
    public void clickCreateAnAccountButton(){
       createAnAccountButton.click();
    }
    public void verifyErrorMessageUsername(){
        assertEquals(invalidMessageForUsername,expectedErrorMessageForUsername);
    }
    public void verifyErrorMessageEmail(){
        assertEquals(invalidMessageForEmail, expectedErrorMessageForEmail);
    }
    public void verifyErrorMessageForPassword(){
        assertEquals(invalidMessageForPassword, expectedErrorMessageForPassword);
    }
    public void verifyErrorMessageForConfirmPassword(){
        assertEquals(invalidMessageForConfirmPassword, expectedErrorMessageForConfirmPassword);
    }
    public void verifyErrorMessageForDifferentConfirmPassword(){
        assertEquals(invalidMessageForDifferentConfirmPassword, expectedErrorMessageForDifferentConfirmPassword);
    }
    public void verifyErrorMessageForTermsAndConditions(){
        assertEquals(invalidMessageForTermsAndConditions, expectedErrorMessageForTermsAndConditions);
    }
    public void clickOnAcceptCookiesButton(){
        click(acceptCookies);
    }
    public void clickOnReCaptcha() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-')]")));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[id='recaptcha-anchor']")));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click();
        driver.switchTo().defaultContent();

//        new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
//        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-checkmark"))).click();
    }
    public void fillRegistrationForm(String usernameText, String emailText, String passwordText, String confirmPasswordTex ) throws InterruptedException {
        enterUsername(usernameText);
        enterEmailAddress(emailText);
        enterPassword(passwordText);
        enterConfirmPassword(confirmPasswordTex);
        checkBoxTermsAndConditions();
        checkBoxSubscribeNewsletter();
        clickCreateAnAccountButton();

    }
    public void verifyErrorMessageForReCaptcha(){
        assertEquals(errorReCaptcha,expectedErrorMessageForReCaptcha);
    }
    public void verifySuccessRegistration(){
        assertEquals(validRegistration, expectedMessageForSuccessRegistration);
    }
    public void verifyAlreadyUsedUsernameErrorMessage(){
        assertEquals(alreadyUsedUsername,expectedErrorMessageForAlreadyUsedUsername);
    }



}
