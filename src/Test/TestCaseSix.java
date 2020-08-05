package Test;

import Main.TestUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseSix extends TestUtilities {

    public String url = "http://live.demoguru99.com/";
    By MobileMenu = By.xpath("//a[@href='http://live.demoguru99.com/index.php/mobile.html']");
    By AddToCartIphone = By.xpath("(//button[@type='button'])[2]");
    By Couponcode = By.id("coupon_code");
    By ApplyLink = By.xpath("//button[@title='Apply']");

    @Test
    public void ApplyDiscount(){

        GetUrl(url);
        Submit(MobileMenu);
        Submit(AddToCartIphone);
        Sleep(1000);

        WebElement couponcode = FindElement(Couponcode);
        couponcode.click();;
        couponcode.clear();
        couponcode.sendKeys("GURU50");

        FindElement(ApplyLink).click();
        Sleep(1000);

        String ActualMessage = driver.findElementByXPath("//li[@class='success-msg']").getText();
        String ExpectedMessage = "Coupon code \"GURU50\" was applied.";

        Assert.assertEquals(ActualMessage,ExpectedMessage,"Coupon code not applied...");

    }
}
