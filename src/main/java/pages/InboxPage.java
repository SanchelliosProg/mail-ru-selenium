package pages;

import config.WebDriverFactory;
import org.openqa.selenium.WebDriver;

/**
 * Created by alex on 28.10.16.
 */
public class InboxPage extends BasePage {
    private final String TITLE = "Входящие - Почта Mail.Ru";
    public InboxPage() {
        this.driver = WebDriverFactory.getInstance();
        setTitleFragment(TITLE);
    }

    protected void setBaseUrl() {
        super.baseUrl = driver.getCurrentUrl();
    }
}
