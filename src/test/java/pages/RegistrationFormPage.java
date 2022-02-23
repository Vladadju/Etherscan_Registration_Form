package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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



}
