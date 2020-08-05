package Test;

import Main.TestUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestCaseFive extends TestUtilities {


    public String url = "http://live.demoguru99.com/";
    By Account  = By.xpath("//a[@href='http://live.demoguru99.com/index.php/customer/account/']");
    By MyAccount = By.xpath("(//a[@title='My Account'])[1]");
    By TVMenu = By.xpath("//a[@href='http://live.demoguru99.com/index.php/tv.html']");
    By WishListLink = By.xpath("(//a[@class='link-wishlist'])[1]");
    By ShareLink = By.name("save_and_share");
    By Message = By.id("message");
    By ShareWishlistButton = By.xpath("//button[@title='Share Wishlist']");
    By LoginMail = By.id("email");
    By LoginPassword = By.xpath("//input[@title='Password']");
    By LoginButton = By.xpath("//button[@title='Login']");
    By EmailID = By.id("email_address");
    By Password = By.id("password");

    @Parameters({"username","password"})
    @Test
    public void Login( String username, String password){

        GetUrl(url);
        Submit(Account);
        Submit(MyAccount);

        WebElement loginmail = FindElement(LoginMail);
        log.info(" Entering Username...");
        loginmail.click();
        loginmail.sendKeys(username);

        WebElement pwd = FindElement(LoginPassword);
        log.info("Entering password...");
        pwd.click();
        pwd.sendKeys(password);

        Submit(LoginButton);
        log.info("Login Successful");

        Sleep(2000);

    }

    @Parameters({"emailid","message"})
    @Test
    public void ShareWishList(String emailid, String message){

        Submit(TVMenu);
        Sleep(1000);
        Submit(WishListLink);
        Sleep(1000);
        Submit(ShareLink);
        Sleep(1000);

        WebElement Emailid = FindElement(EmailID);
        Emailid.click();
        Emailid.sendKeys(emailid);

        WebElement msg = FindElement(Message);
        msg.click();
        msg.sendKeys(message);


        //Scroll Down Page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//div[@class='page-title']")));
        Sleep(1000);

        Submit(ShareWishlistButton);

        Sleep(2000);

    }

}
