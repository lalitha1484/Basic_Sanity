import base.BaseTests;
import org.testng.annotations.Test;
import pages.InboxPage;
import pages.LoginPage;
import sun.rmi.runtime.Log;

public class SmokeTest extends BaseTests {

    @Test
    public void verifyComposeMail(){
        InboxPage inboxPagePage = new InboxPage(driver);
        /*mailLayoutPage.clickComposeButton();
        System.out.println("Click compose button");
        mailLayoutPage.enterMailAddress("n3@openwave.com");
        System.out.println("Enter mail Address");
        mailLayoutPage.enterSubjectName("Test mail");
        System.out.println("Enter subject name");
        mailLayoutPage.enterTextInTextArea("Hello Everyone");
        System.out.println("Enter text in message body");
        mailLayoutPage.clickSendButton();
        System.out.println("click send button");*/
        inboxPagePage.performSendMessage("n3@openwave.com","Hello","Helloooooo Everyone");
        System.out.println("Compose new mail and send");
    }

    @Test
    public void verifyDiscardMessage(){
        InboxPage inboxPage = new InboxPage(driver);
        /*System.out.println("Verify Discard Message");
        inboxPage.clickComposeButton();
        System.out.println("Click compose Button");
        inboxPage.enterMailAddress("n2@openwave.com");
        System.out.println("Enter email id");
        inboxPage.enterSubjectName("Discard");
        System.out.println("Enter Subject");
        inboxPage.enterTextInTextArea("Discard message");
        System.out.println("Perform discarding message");
        inboxPage.clickDiscardButton();
        System.out.println("Click on discard Button");
        inboxPage.getMessageSaveAlert();
        System.out.println("get message save alert message");
        inboxPage.alert_accept();
        System.out.println("Accept the alert");*/
        inboxPage.performDiscardMessage("n3@openwave.com","Discard","Click on Discard button");
        System.out.println("Disarding Message");
    }

    @Test

    public void verifyCancelMessage(){
        InboxPage inboxPage = new InboxPage(driver);
        System.out.println("Verify Cancel Message");
        inboxPage.clickComposeButton();
        System.out.println("Click compose Button");
        inboxPage.enterMailAddress("n2@openwave.com");
        System.out.println("Enter email id");
        inboxPage.enterSubjectName("Discard");
        System.out.println("Enter Subject");
        inboxPage.enterTextInTextArea("Discard message");
        System.out.println("Perform discarding message");
        inboxPage.clickDiscardButton();
        System.out.println("Click on discard Button");
        inboxPage.getPopUpMessage();
        System.out.println("get popup message");
        inboxPage.clickCancelButton();
        System.out.println("Click cancel button");

    }
}
