package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
    @FindBy(xpath = "//input[@id=\"ContentPlaceHolder1_txtPassword\"]")
    WebElement password;
    @FindBy(css = "input[id*='txtPassword2']")
    WebElement confirmPassword;
    @FindBy(css = "input[id*='MyCheckBox']")
    WebElement termsAndConditions;
    @FindBy(css = "input[id*='SubscribeNewsletter']")
    WebElement subscribeNewsletter;
    @FindBy(css = "input[id*='btnRegister']")
    WebElement createAnAccountButton;

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
