package Test;

import Main.TestUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseThree extends TestUtilities {

    public String url = "http://live.demoguru99.com/";
    By MobileMenu = By.xpath("//a[@href='http://live.demoguru99.com/index.php/mobile.html']");
    By AddToCartXperia = By.xpath("(//button[@type='button'])[1]");
    By Quantity = By.xpath("//input[@title='Qty']");
    By UpdateButton = By.xpath("//button[@title='Update']");
    By ErrorMessage = By.xpath("//p[@class='item-msg error']");
    By EmptyCartText = By.id("empty_cart_button");
    By EmptyCartMessage = By.xpath("//div[@class='page-title']");

    @Test
    public void AddXperiaToCartAndEmptyCart(){

        GetUrl(url);
        Submit(MobileMenu);
        Submit(AddToCartXperia);
        Sleep(2000);

        WebElement quantitytext = FindElement(Quantity);
        quantitytext.click();
        quantitytext.clear();
        quantitytext.sendKeys("1000");
        Sleep(2000);

        Submit(UpdateButton);

        String ExpectedErrorMessage = "* The maximum quantity allowed for purchase is 500.";
        String ActualErrorMessage = FindElement(ErrorMessage).getText();

        Assert.assertEquals(ExpectedErrorMessage,ActualErrorMessage,"Error Message did not match...");

        //Empty Cart

        WebElement element = driver.findElement(By.xpath("//a[@href='http://live.demoguru99.com/index.php/mobile.html']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Sleep(2000);

        Submit(EmptyCartText);

        String ExpectedMessage="SHOPPING CART IS EMPTY";
        String ActualMessage=FindElement(EmptyCartMessage).getText();

        Assert.assertEquals(ActualMessage,ExpectedMessage,"Message did not match...");

    }
}
