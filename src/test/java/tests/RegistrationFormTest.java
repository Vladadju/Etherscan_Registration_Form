package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class RegistrationFormTest {
    WebDriver driver;
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




}
