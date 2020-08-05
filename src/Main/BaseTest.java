package Main;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected ChromeDriver driver;
    public String driverPath="C:\\Users\\ankit.deshmukh\\Downloads\\chromedriver_win32\\chromedriver.exe";

    @BeforeTest
    public void SetUpDriver(){
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @AfterTest
    public void Quit(){
        driver.quit();
    }


}
