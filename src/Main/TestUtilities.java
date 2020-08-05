package Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.logging.Logger;

public class TestUtilities extends BaseTest{


    protected Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public void GetUrl(String url){

        driver.get(url);
    }

    public WebElement FindElement(By locator){

        return driver.findElement(locator);
    }

    public String GetTitle(){
        return driver.getTitle();
    }

    public void ClearField(By locator){
        driver.findElement(locator).clear();
    }

    public void Submit(By locator){

        driver.findElement(locator).click();
    }

    public String GetCurrentUrl(){
        return driver.getCurrentUrl();
    }


    public void Sleep(int n){
        try{
            Thread.sleep(n);
        }catch(Exception e){
            System.out.println("Timeout...");
        }
    }
}
