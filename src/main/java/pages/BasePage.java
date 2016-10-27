package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by alex on 27.10.16.
 */
public abstract class BasePage {
    protected WebDriver driver;
    protected String baseUrl;

    public BasePage(WebDriver driver, String baseUrl){
        this.driver = driver;
        this.baseUrl = baseUrl;
    }

    public void init(WebDriver driver){
        driver.navigate().to(baseUrl);
    }

    protected void init(){
        this.driver.navigate().to(baseUrl);
    }


    protected void click(By by) {
        WebElement button = driver.findElement(by);
        button.click();
    }

    protected void input(String login, By by) {
        WebElement inputField = driver.findElement(by);
        inputField.sendKeys(login);
    }
}
