package Test;

import Main.TestUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseTwo extends TestUtilities {


    public String url = "http://live.demoguru99.com/";
    By MobileMenu = By.xpath("//a[@href='http://live.demoguru99.com/index.php/mobile.html']");
    By SonyXperiaPrice = By.xpath("//span[@id='product-price-1']//span[@class='price']");
    By SonyXperiaIcon = By.xpath("//a[@href='http://live.demoguru99.com/index.php/mobile/sony-xperia.html']");

    @Test
    public void CompareValueWithDetailsPage(){

        GetUrl(url);
        Submit(MobileMenu);
        String XperiaValue = FindElement(SonyXperiaPrice).getText();
        System.out.println("Xperia Value:"+ XperiaValue);

        Submit(SonyXperiaIcon);
        Sleep(2000);

        String XperiaValueLatest = FindElement(SonyXperiaPrice).getText();
        System.out.println("Xperia Latest Value:"+ XperiaValueLatest);

        //compare both values
        Assert.assertEquals(XperiaValue,XperiaValueLatest,"Values are not matching");
    }


}
