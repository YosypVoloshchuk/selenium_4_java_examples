package PageObjects;

import Utils.User;
import com.google.common.collect.ImmutableList;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.log.Log;
import org.openqa.selenium.devtools.network.Network;
import org.openqa.selenium.devtools.network.model.ConnectionType;
import org.openqa.selenium.devtools.network.model.LoadingFailed;
import org.openqa.selenium.devtools.security.Security;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

import static org.openqa.selenium.devtools.network.Network.*;

public class GooglePage extends PageAbstract{
    @FindBy(xpath = "//*[@id='tsf']/div[2]/div[1]/div[1]/div/div[2]/input")
    protected WebElement search_field;
    @FindBy(className = "gNO89b")
    protected WebElement search_button;

    public GooglePage(ChromeDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    @Step("OPEN LOGIN PAGE")
    public void open(){
      driver.get(base_url);
    }


    @Step
    public void openNewWindowAndNewTab(String text) throws InterruptedException {
        this.open();
        this.enterText(this.search_field, text);
        this.search_button.click();
        WebDriver tab = driver.switchTo().newWindow(WindowType.TAB);
        tab.get("https://yahoo.com");
        WebDriver tab2 = driver.switchTo().newWindow(WindowType.TAB);
        tab2.get("https://medium.com/");
        Thread.sleep(5000);
        Set<String> tabs = driver.getWindowHandles();
        List<String> list =new ArrayList<String>(tabs);
        String parentTab = list.get(0);
        String childFirstTab = list.get(1);
        String childSecondTab = list.get(2);
        driver.switchTo().window(parentTab);
        Thread.sleep(2000);
        driver.switchTo().window(childFirstTab);
        Thread.sleep(2000);
        driver.switchTo().window(childSecondTab);
        Thread.sleep(2000);
        driver.switchTo().window(parentTab);
        WebDriver window = driver.switchTo().newWindow(WindowType.WINDOW);
        window.get("https://weather.com/");
        Thread.sleep(15000);
    }

    @Step
    public void loadInsecureWebsite() throws InterruptedException {
        driver.get("https://expired.badssl.com/");
        Thread.sleep(3000);
        DevTools chromeDevTools = driver.getDevTools();
        chromeDevTools.createSession();
        chromeDevTools.send(Security.enable());
        chromeDevTools.send(Security.setIgnoreCertificateErrors(true));
        driver.get("https://expired.badssl.com/");
        Thread.sleep(3000);
        chromeDevTools.send(Security.disable());
        chromeDevTools.send(Security.setIgnoreCertificateErrors(false));
        driver.get("https://expired.badssl.com/");
        Thread.sleep(3000);
    }

    @Step
    public  void emulateNetworkConditionTest() throws MalformedURLException, InterruptedException {
        this.open();
        DevTools chromeDevTools = driver.getDevTools();
        chromeDevTools.createSession();
        chromeDevTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        chromeDevTools.send(
                emulateNetworkConditions(true,100,200000,100000, Optional.empty()));
        driver.navigate().to(base_url);
        Thread.sleep(5000);
    }
    @Step
    public void filterUrls() throws InterruptedException {
        DevTools chromeDevTools = driver.getDevTools();
        chromeDevTools.createSession();
        chromeDevTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        chromeDevTools.send(Network.setBlockedURLs(ImmutableList.of("*.css", "*.jpg", "*.js")));
        driver.navigate().to("https://rozetka.com.ua/");
        Thread.sleep(10000);
    }



}
