import config.TestConfig;
import config.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MailMainPage;

import static org.testng.Assert.*;

/**
 * Created by alex on 22.10.16.
 */
public class MailMainPageTest {
    private MailMainPage page;
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        this.driver = WebDriverFactory.getDriver(TestConfig.FIREFOX);
        page = new MailMainPage(driver);
    }

    @Test
    public void testOpen() throws Exception {
        page.open(driver);
        assertEquals(driver.getTitle(), "Mail.Ru: почта, поиск в интернете, новости, игры");
    }

    @Test
    public void testLogin() throws InterruptedException {
        page.authorise("isildurelrosovich", "my_prescious_2016");
        waitForSeconds(5);
        assertEquals(driver.getTitle().contains("Входящие - Почта Mail.Ru"), true);
    }

    @Test
    public void testSearch() throws InterruptedException {
        String java = "java";
        page.search(java);
        waitForSeconds(2);
        assertEquals(driver.getTitle().contains(java), true);
    }

    @Test
    public void testOpenPictures() throws InterruptedException {
        page.openPictures();
        waitForSeconds(2);
        assertEquals(driver.getTitle().contains("Поиск по картинкам"), true);
    }

    @Test
    public void testOpenVideos() throws InterruptedException {
        page.openVideos();
        waitForSeconds(2);
        assertEquals(driver.getTitle().contains("Поиск по видео"), true);
    }

    private void waitForSeconds(int seconds) throws InterruptedException {
        Thread.sleep(seconds*1000);
    }

    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}