package Test;

import Main.TestUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class TestCaseFour extends TestUtilities {

    public String url = "http://live.demoguru99.com/";
    By MobileMenu = By.xpath("//a[@href='http://live.demoguru99.com/index.php/mobile.html']");
    By CompareLink_1 = By.xpath("(//a[@class='link-compare'])[1]");
    By CompareLink_2 = By.xpath("(//a[@class='link-compare'])[2]");
    By CompareButton = By.xpath("//button[@title='Compare']");

    @Test
    public void CompareMobiles(){

        GetUrl(url);
        Submit(MobileMenu);

        //Scroll Down Page so that Compare link is visible
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//div[@class='page-title category-title']")));
        Sleep(1000);

        Submit(CompareLink_1);
        Submit(CompareLink_2);
        Sleep(1000);
        //popup will open here
        Submit(CompareButton);
        Sleep(3000);


        String MainWindow=driver.getWindowHandle();

        // To handle all new opened window.
        Set<String> s1=driver.getWindowHandles();
        Iterator<String> i1=s1.iterator();

        while(i1.hasNext())
        {
            String ChildWindow=i1.next();

            if(!MainWindow.equalsIgnoreCase(ChildWindow))
            {

                // Switching to Child window
                driver.switchTo().window(ChildWindow);

                // Closing the Child Window.
                driver.close();
                Sleep(2000);
            }
        }
        // Switching to Parent window i.e Main Window.
        driver.switchTo().window(MainWindow);
        System.out.println(driver.getCurrentUrl());


    }
}
