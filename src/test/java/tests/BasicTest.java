package tests;
import PageObjects.GooglePage;
import PageObjects.SearchPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by yoshka on 17.11.17.
 */
public class BasicTest {
    public static ChromeDriver driver;
    protected GooglePage googlePage=null;
    protected SearchPage searchPage=null;

//    public static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>();;

    @BeforeMethod
    public void setUp(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        googlePage = new GooglePage(driver);
        searchPage = new SearchPage(driver);
        googlePage.open();
    }

    protected WebDriver getWebDriver(){
        return driver;}

    @AfterMethod
    public void closeWebDriver(){
        getWebDriver().quit();
    }


}


