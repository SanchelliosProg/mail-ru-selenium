package config;


import config.properties_handling.PropertyManager;
import config.properties_handling.PropertyNames;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.UndefinedOSException;

/**
 * Created by alex on 22.10.16.
 */
public class WebDriverFactory {
    private final static int LINUX = 0;
    private final static int WIN_10 = 1;
    private final static int WIN_7 = 2;
    private final static String DIR = "./resources/drivers/";
    private static WebDriver driver;

    public static WebDriver getInstance() {
        if (driver == null) {
            try {
                driver = getDriver();
            } catch (UndefinedOSException e) {
                e.printStackTrace();
            }
            LogHelper.getInstance().info("Driver is initialized");
            return driver;
        } else {
            return driver;
        }
    }

    private static WebDriver getDriver() throws UndefinedOSException {
        String browser = getBrowser();
        if (browser.equals(TestConfig.CHROME)) {
            LogHelper.getInstance().info("Loading Chrome driver");
            return getChromeDriver();
        } else if (browser.equals(TestConfig.FIREFOX)) {
            LogHelper.getInstance().info("Loading Chrome driver");
            return getFirefoxDriver();
        } else {
            return getChromeDriver();
        }
    }

    private static WebDriver getChromeDriver() throws UndefinedOSException {
        String driverName = "webdriver.chrome.driver";

        switch (getSystemName()) {
            case WIN_10:
                LogHelper.getInstance().info("Getting driver for win-10");
                System.setProperty(driverName, DIR + "windows_10/chromedriver.exe");
                break;
            case LINUX:
                LogHelper.getInstance().info("Getting driver for linux");
                System.setProperty(driverName, DIR + "linux/chromedriver");
                break;
            case WIN_7:
                LogHelper.getInstance().info("Getting driver for win-7");
                System.setProperty(driverName, DIR + "win_7/chromedriver.exe");
            default:
                break;
        }
        return new ChromeDriver();
    }

    private static WebDriver getFirefoxDriver() throws UndefinedOSException {
        String driverName = "webdriver.gecko.driver";
        switch (getSystemName()) {
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

    private static int getSystemName() throws UndefinedOSException {
        String osName = System.getProperty("os.name");
        LogHelper.getInstance().info("OS: " + osName);
        if (osName.equals("Windows 10")) {
            return WIN_10;
        } else if (osName.equals("Windows 7")) {
            return WIN_7;
        } else if (osName.equals("Linux")) {
            return LINUX;
        } else {
            throw new UndefinedOSException("Current OS is not defined. Running Linux as default.");
        }
    }

    private static String getBrowser() {
        String browserName = PropertyManager.getInstance().getBrowserName();
        LogHelper.getInstance().info("Browser name - " + browserName);
        return PropertyManager.getInstance().getBrowserName();
    }
}
