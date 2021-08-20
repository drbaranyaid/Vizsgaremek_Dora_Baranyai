package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;
    protected HomePage homePage;
    protected String user = "KisVirág9";
    protected String pass = "kukac423";
    protected String userFalse="GezaNagy";
    protected String passFalse = "páva987";
    protected String userFalse2=" ";
    protected String passFalse2 = " ";
    protected String email = "zalog39@freemail.hu ";

    protected String URL = "https://en.wikipedia.org/wiki/Main_Page";

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeEach
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        homePage = new HomePage(driver);
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }


}



