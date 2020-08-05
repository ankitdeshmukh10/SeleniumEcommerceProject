package Test;

import Main.TestUtilities;
import com.google.common.base.FinalizableSoftReference;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestCaseSeven extends TestUtilities {

    public String backendurl = "http://live.demoguru99.com/index.php/backendlogin";
    By BackEndUSername = By.id("username");
    By BackEndPassword = By.id("login");
    By BackEndLoginBtn = By.xpath("//input[@title='Login']");
    By BackEndPopup = By.xpath("//a[@title='close']");
    By SalesIcon = By.xpath("//span[text()='Sales']");
    By OrdersIcon = By.xpath("//span[text()='Orders']");
    By drpCSVOption = By.name("sales_order_grid_export");
    By Exportbtn = By.xpath("//button[@title=\"Export\"]");

    @Test
    public void ExportToCSVAndMail(){

        GetUrl(backendurl);
        WebElement backendusername = FindElement(BackEndUSername);
        WebElement backendpwd = FindElement(BackEndPassword);

        log.info("Entering Username...");
        backendusername.click();
        backendusername.sendKeys("user01");

        log.info("Entering Password...");
        backendpwd.click();
        backendpwd.sendKeys("guru99com");

        Submit(BackEndLoginBtn);
        Sleep(2000);
        log.info("Login Successful...");

        Submit(BackEndPopup);
        log.info("pop up closed...");
        Sleep(2000);

        Submit(SalesIcon);
        Sleep(1000);
        Submit(OrdersIcon);

        Select drpOrderList = new Select(FindElement(drpCSVOption));
        drpOrderList.selectByVisibleText("CSV");

        Submit(Exportbtn);
        Sleep(3000);


    }

}
