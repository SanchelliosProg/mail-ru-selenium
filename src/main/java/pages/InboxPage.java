package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by alex on 28.10.16.
 */
public class InboxPage extends BasePage {
    public InboxPage(WebDriver driver) {
        super(driver);
        setTitleFragment("Входящие - Почта Mail.Ru");
    }

    protected void setBaseUrl() {
        super.baseUrl = driver.getCurrentUrl();
    }
}
