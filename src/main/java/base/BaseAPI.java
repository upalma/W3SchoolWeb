package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseAPI {
    public static WebDriver driver = null;

    @BeforeMethod
    public void initializeBrowser(){
        String getOSNameFromSystem = System.getProperty("OS.Name");
        System.out.println("Chrome browser is firing");

        if(getOSNameFromSystem.contains("Mac")){
            System.setProperty("webdriver.chrome.driver", "/Users/palmauzzal/ComW3School/Driver-Browser/chromedriver");
        } if(getOSNameFromSystem.contains("Windows")){
            System.setProperty("webdriver.chrome.driver", "/Users/palmauzzal/ComW3School/Driver-Browser/chromedriver.exe");
        } else if (getOSNameFromSystem.contains("Linux")){
            System.setProperty("webdriver.chrome.driver", "/Users/palmauzzal/ComW3School/Driver-Browser/chromedriver.exe");
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
    }

    @AfterMethod
    public void driverClose(){
        System.out.println("Chrome browser is closing");
        driver.quit();
    }
}


