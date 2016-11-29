package config;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by alex on 22.10.16.
 */
public class WebDriverFactory {
    private final static int LINUX = 0;
    private final static int WIN_10 = 1;
    private final static int WIN_7 = 2;
    private final static String DIR = "./resources/drivers/";
    private static WebDriver driver;

    public static WebDriver getInstance(){
        if (driver == null){
            driver = getDriver();
            LogHelper.getInstance().info("Driver is initialized");
            return driver;
        } else {
            return driver;
        }
    }

    private static WebDriver getDriver(){
        String browser = getBrowser();
        if (browser.equals(TestConfig.CHROME)){
            return getChromeDriver();
        }else if (browser.equals(TestConfig.FIREFOX)){
            return getFirefoxDriver();
        }else {
            return getChromeDriver();
        }
    }

    private static WebDriver getChromeDriver(){
        String driverName = "webdriver.chrome.driver";

        switch (getSystemName()){
            case WIN_10:
                System.setProperty(driverName, DIR + "windows_10/chromedriver.exe");
                break;
            case LINUX:
                System.setProperty(driverName, DIR + "linux/chromedriver.exe");
                break;
            case WIN_7:
                System.setProperty(driverName, DIR + "win_7/chromedriver.exe");
            default:
                break;
        }
        return new ChromeDriver();
    }

    private static WebDriver getFirefoxDriver(){
        String driverName = "webdriver.gecko.driver";
        switch (getSystemName()){
            case WIN_10:
                System.setProperty(driverName,
                        DIR + "windows_10/geckodriver.exe");
                break;
            case WIN_7:
                System.setProperty(driverName,
                        DIR + "win_7/geckodriver.exe");
            case LINUX:
                System.setProperty(driverName,
                        DIR + "linux/geckodriver");
                break;
            default:
                break;
        }

        return new FirefoxDriver();
    }

    private static int getSystemName() {
        String osName = System.getProperty("os.name");
        LogHelper.getInstance().info("OS: "+osName);
        if(osName.equals("Windows 10")){
            return WIN_10;
        }else if (osName.equals("Windows 7")){
            return WIN_7;
        }else {
            return LINUX;
        }
    }

    private static String getBrowser(){
        Properties properties = new Properties();
        InputStream inputStream;

        try{
            inputStream = new FileInputStream("./resources/config.properties");
            properties.load(inputStream);
            return properties.getProperty("browser");
        }catch (IOException ex){
            ex.printStackTrace();
            return null;
        }
    }
}
