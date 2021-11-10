package base;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;

public class BaseTests {

    protected static ChromeDriver driver;
    protected LoginPage loginPage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "resource/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.get("http://10.167.35.50:8080/webmail/");
        loginPage.performLogin("n2@openwave.com","p");
        driver.manage().window().maximize();
    }

    @AfterClass

    public void tearDown() {
        driver.quit();
    }

    public void delay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {

        }
    }

}
