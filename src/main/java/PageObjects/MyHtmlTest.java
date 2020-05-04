package PageObjects;

import com.google.common.collect.ImmutableList;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.network.Network;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.util.List;
import java.util.Optional;

public class MyHtmlTest extends PageAbstract{

    public MyHtmlTest(ChromeDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    @Step("OPEN LOGIN PAGE")
    public void open(){
        String userDirectory = System.getProperty("user.dir");
        System.out.println(userDirectory +"/TestPage.html");
        driver.get("file://" +userDirectory +"/TestPage.html");

    }

    @Step
    public void checkRelativeLocators() throws InterruptedException {
        this.open();
        Thread.sleep(5000);
        this.findElementByRelativeLocator();

    }

    private void findElementByRelativeLocator() throws InterruptedException {
        WebElement el = driver.findElement(RelativeLocator
                .withTagName("div")
                .toRightOf(By.cssSelector("#one"))
        .above(By.cssSelector("#eight"))
        .below(By.cssSelector("#three")));
        el.click();
        Thread.sleep(5000);

    }

}
