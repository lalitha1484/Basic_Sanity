package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class  LoginPage {
    private ChromeDriver driver;
    private By userField = By.name("username");
    private By userPassword = By.name("password");
    private By loginButton = By.xpath("//span[text()='Log in']/parent::span[@class='x-btn-button']");


    public LoginPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void enterUserName(String username) {
        driver.findElement(userField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(userPassword).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public InboxPage performLogin(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(userField)));
        enterUserName(username);
        enterPassword(password);
        clickLoginButton();
        return new InboxPage(driver);
    }
}
