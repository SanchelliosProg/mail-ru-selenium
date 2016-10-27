package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by alex on 22.10.16.
 */
public class WebDriverFactory {

    public static WebDriver getDriver(int id){
        switch (id){
            case TestConfig.CHROME:
                return getChromeDriver();
            case TestConfig.FIREFOX:
                return getFirefoxDriver();
            default:
                throw new IllegalArgumentException();
        }
    }

    private static WebDriver getChromeDriver(){
        return new ChromeDriver();
    }

    private static WebDriver getFirefoxDriver(){
        System.setProperty("webdriver.gecko.driver",
                "./resources/drivers/geckodriver");
        return new FirefoxDriver();
    }
}
