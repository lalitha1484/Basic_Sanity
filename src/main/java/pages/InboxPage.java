package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InboxPage {
    private ChromeDriver driver;
    private By composeButton = By.xpath("//*[contains(@class,'rui-mail-toolbar')]//a[contains(@class,'x-btn-toolbar') and (.//span[contains(text(),'Compose')])]");
    private By toMailAddressFiled = By.xpath("//input[@class='ow-forceLtr rui-mail-compose-recipientInput-input automation-mail-compose-to-input']");
    private By subjectField = By.xpath("//input[@placeholder='Subject:']");
    private By textArea = By.xpath("//textarea[@role='textbox']");
    private By sendButton = By.xpath("//span[text()='Send']/parent::span[@class='x-btn-button']");
    private By discardButton = By.xpath("//span[text()='Discard']/parent::span[@class='x-btn-button']");
    private By messageSaveAlert = By.xpath("//span[text()='Save draft']/parent::div[@class='x-component x-header-text-container x-window-header-text-container x-window-header-text-container-default x-box-item x-ltr x-component-default']");
    private By saveButton = By.xpath("//span[text()='Yes']/parent::span[@class='x-btn-button']");
    private By cancelButton = By.xpath("//span[text()='Cancel']/parent::span[@class='x-btn-button']");
    private By logoutButton = By.xpath("//span[text()='Sign out']/parent::a[@class='x-menu-item-link x-menu-item-indent-no-separator']");



    public InboxPage(ChromeDriver driver){
        this.driver = driver;
    }

    public void clickComposeButton(){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.presenceOfElementLocated(composeButton));
        driver.findElement(composeButton).click();
    }

    public void enterMailAddress(String mailID){
        driver.findElement(toMailAddressFiled).sendKeys(mailID);
    }

    public void enterSubjectName(String subject){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(subjectField));
        driver.findElement(subjectField).click();
        driver.findElement(subjectField).sendKeys(subject);
    }

    public void enterTextInTextArea(String text){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(textArea));
        driver.findElement(textArea).click();
        driver.findElement(textArea).sendKeys(text);
    }

    public void clickSendButton(){
        driver.findElement(sendButton).click();
    }

    /*public void clickOnLogOutButton(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        driver.findElement(logoutButton).click();
    }*/

    public void clickDiscardButton(){
        driver.findElement(discardButton).click();
    }

    public void getPopUpMessage(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(messageSaveAlert));
        driver.findElement(messageSaveAlert).click();
    }

    public void clickSaveButton(){
        driver.findElement(saveButton).click();
    }

    public void clickCancelButton(){
        driver.findElement(cancelButton).click();

    }

    public InboxPage performSendMessage(String emailID,String subject,String text){
        clickComposeButton();
        enterMailAddress(emailID);
        enterSubjectName(subject);
        enterTextInTextArea(text);
        clickSendButton();
        //clickOnLogOutButton();
        return new InboxPage(driver);
    }

    public InboxPage performDiscardMessage(String emailID,String subject,String text){
        clickComposeButton();
        enterMailAddress(emailID);
        enterSubjectName(subject);
        enterTextInTextArea(text);
        clickDiscardButton();
        getPopUpMessage();
        clickSaveButton();
        return new InboxPage(driver);
    }

    public InboxPage performCancelMessage(String emailID,String subject,String text){
        clickComposeButton();
        enterMailAddress(emailID);
        enterSubjectName(subject);
        enterTextInTextArea(text);
        clickDiscardButton();
        getPopUpMessage();
        clickCancelButton();
        return new InboxPage(driver);
    }


}
