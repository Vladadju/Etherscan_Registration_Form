package pages;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }
    public void typeText(WebElement element, String text){
        try {
            if (text != null){
                element.clear();
                element.sendKeys();
            }else {
                System.out.println("Parameter was null!");
            }
        }catch (StaleElementReferenceException e) {
            if (text != null) {
                element.clear();
                element.sendKeys();
            } else {
                System.out.println("Parameter was null!");
            }
        }
    }
    public void click(WebElement element){
        element.click();
    }
    public void assertEquals(WebElement element, String expectedValue){
        Assert.assertEquals(element.getText(),expectedValue);
    }
    public void takeScreenshot(String fileName) throws IOException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("src/screenshot/"+fileName+"_"+System.currentTimeMillis()+".png"));
    }
}
