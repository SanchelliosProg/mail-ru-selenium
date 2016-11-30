package pages;

import config.WebDriverFactory;
import config.properties_handling.WebPropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by alex on 22.10.16.
 */
public class MailMainPage extends BasePage{
    //LOGIN
    private final String LOGIN_CSS_SELECTOR = "#mailbox__login";
    private final String PASSWORD_CSS_SELECTOR = "#mailbox__password";
    private final String AUTH_BUTTON_CSS_SELECTOR = "#mailbox__auth__button";
    //SEARCH
    private final String SEARCH_FIELD_SELECTOR = "#q";
    private final String SEARCH_BUTTON_SELECTOR = "#search__button__wrapper__field";
    private final String PICTURES_XPATH = ".//*[@id='search__projects-list']/span[2]/a";
    private final String VIDEOS_XPATH = ".//*[@id='search__projects-list']/span[3]/a";

    private WebDriver driver;

    public MailMainPage(){
        this.driver = WebDriverFactory.getInstance();
        setTitleFragment("Mail.Ru: почта, поиск в интернете, новости, игры");
    }

    public void openPage(WebDriver driver){
        driver.navigate().to(baseUrl);
    }

    protected void setBaseUrl() {
        super.baseUrl = WebPropertyManager.getInstance().getBaseUrl();
    }


    protected void openPage(){
        this.driver.navigate().to(baseUrl);
    }


    public InboxPage authorise(String login, String password){
        openPage();
        input(login, By.cssSelector(LOGIN_CSS_SELECTOR));
        input(password, By.cssSelector(PASSWORD_CSS_SELECTOR));
        click(By.cssSelector(AUTH_BUTTON_CSS_SELECTOR));
        return new InboxPage();
    }

    public void search(String searchString){
        openPage();
        input(searchString, By.cssSelector(SEARCH_FIELD_SELECTOR));
        click(By.cssSelector(SEARCH_BUTTON_SELECTOR));
    }

    public void openPictures() {
        openPage();
        click(By.xpath(PICTURES_XPATH));
    }

    public void openVideos() {
        openPage();
        click(By.xpath(VIDEOS_XPATH));
    }
}
