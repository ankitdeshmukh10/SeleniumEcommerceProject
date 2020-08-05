package Test;

import Main.TestUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseOne extends TestUtilities {

    public String url = "http://live.demoguru99.com/";
    By MobileMenu = By.xpath("//a[@href='http://live.demoguru99.com/index.php/mobile.html']");
    By drplist = By.xpath("//select[@title='Sort By']");

    @Test
    public void verifyIndexPageTitle(){

        GetUrl(url);
        String ActualTitle = GetTitle();
        String ExpectedTitle = "Home page";

        Assert.assertEquals(ActualTitle, ExpectedTitle, "Title did not Match");

        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void ClickMobileMenuAndVerifyTitle(){

        Submit(MobileMenu);
        Sleep(2000);
        String ActualTitle = GetTitle();
        String ExpectedTitle = "Mobile";

        Assert.assertEquals(ActualTitle, ExpectedTitle, "Title did not Match");

        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void SortByName(){

        WebElement NameDropDown = FindElement(drplist);
        Select drplist = new Select(NameDropDown);
        drplist.selectByVisibleText("Name");

    }
}
