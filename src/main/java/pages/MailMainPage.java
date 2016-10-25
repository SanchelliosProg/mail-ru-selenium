package pages;

import config.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import static config.TestData.*;
/**
 * Created by alex on 22.10.16.
 */
public class MailMainPage {

    public static final String BASE_URL = "https://mail.ru/";
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



    public MailMainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open(WebDriver driver){
        driver.navigate().to(BASE_URL);
    }

    protected void open(){
        this.driver.navigate().to(BASE_URL);
    }


    public void authorise(String login, String password){
        open();
        input(login, By.cssSelector(LOGIN_CSS_SELECTOR));
        input(password, By.cssSelector(PASSWORD_CSS_SELECTOR));
        click(By.cssSelector(AUTH_BUTTON_CSS_SELECTOR));
    }

    public void search(String searchString){
        open();
        input(searchString, By.cssSelector(SEARCH_FIELD_SELECTOR));
        click(By.cssSelector(SEARCH_BUTTON_SELECTOR));
    }

    public void openPictures() {
        open();
        click(By.xpath(PICTURES_XPATH));
    }

    public void openVideos() {
        open();
        click(By.xpath(VIDEOS_XPATH));
    }


    private void click(By by) {
        WebElement button = driver.findElement(by);
        button.click();
    }

    private void input(String login, By by) {
        WebElement inputField = driver.findElement(by);
        inputField.sendKeys(login);
    }


}
