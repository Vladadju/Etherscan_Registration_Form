package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    @FindBy(css = "label[for='ContentPlaceHolder1_MyCheckBox']")
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
    @FindBy(css = "div[id='ctl00$ContentPlaceHolder1$MyCheckBox-error']")
    WebElement invalidMessageForTermsAndConditions;
    @FindBy(xpath = "//*[@id='btnCookie']")
    WebElement acceptCookies;
    @FindBy(css = "iframe[name='a-pmu4asq3bpy9")
    WebElement iFrame;
    @FindBy(xpath = "//*[@id='recaptcha-anchor']/div[4]")
    WebElement reCaptcha;
    String expectedErrorMessageForUsername = "Username is invalid.";
    String expectedErrorMessageForEmail = "Please enter a valid email address.";
    String expectedErrorMessageForPassword = "Your password must be at least 5 characters long.";
    String expectedErrorMessageForConfirmPassword = "Your password must be at least 5 characters long.";
    String expectedErrorMessageForTermsAndConditions = "Please accept our Terms and Conditions.";


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
    public void checkBoxTermsAndConditions(){
        termsAndConditions.click();
    }
    public void checkBoxSubscribeNewsletter(){
        subscribeNewsletter.click();
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
    public void verifyErrorMessageForTermsAndConditions(){
        assertEquals(invalidMessageForTermsAndConditions, expectedErrorMessageForTermsAndConditions);
    }
    public void clickOnAcceptCookiesButton(){
        click(acceptCookies);
    }
    public void clickOnReCaptcha() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name,'a-')]")));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-checkmark")));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click();
        driver.switchTo().defaultContent();
    }

    public void fillRegistrationForm(String usernameText, String emailText, String passwordText, String confirmPasswordTex ){
        enterUsername(usernameText);
        enterEmailAddress(emailText);
        enterPassword(passwordText);
        enterConfirmPassword(confirmPasswordTex);
        checkBoxTermsAndConditions();
        checkBoxSubscribeNewsletter();
        clickCreateAnAccountButton();

    }




}
