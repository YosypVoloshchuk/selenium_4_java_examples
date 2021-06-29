package PageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.Random;

/**
 * Created by yoshka on 17.11.17.
 */
public abstract class PageAbstract {


    Random rand = new Random();
    protected String base_url ="https://www.google.com/";
    public ChromeDriver driver;
    public PageAbstract(ChromeDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    @Step("Open page")
    public abstract void open();

    public void enterText(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }
    public int randomLinkNumber() {
        int rand = (int)(Math.random()*(1000-101));
        return rand;
    }

    public void scroll_to_element(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    }


}
