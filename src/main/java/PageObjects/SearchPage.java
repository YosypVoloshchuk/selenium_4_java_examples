package PageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends PageAbstract{

    @FindBy(css = ".TbwUpd")
    List<WebElement> elements;

    @Override
    public void open(){
    }

    public SearchPage(ChromeDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }



}

