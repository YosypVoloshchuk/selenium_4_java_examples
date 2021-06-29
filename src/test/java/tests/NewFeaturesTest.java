package tests;

import PageObjects.MyHtmlTest;
import Utils.User;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import utils.Listeners.TestListener;

import java.net.MalformedURLException;


/**
 * Created by yoshka on 17.11.17.
 */
@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("New features Tests")
public class NewFeaturesTest extends BasicTest {
    private String text="autotest";

    @Test (priority = 0, description="Check opening new tab and new window")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: just simple check")
    public void checkOpeningNewWindowAndTab() throws InterruptedException, MalformedURLException {
    googlePage.openNewWindowAndNewTab(text);
        Assert.assertTrue(true);
    }
//
//    @Test (priority = 1, description="Check opening insecure site")
//    public void checkLoaInsecure() throws InterruptedException, MalformedURLException {
//        googlePage.loadInsecureWebsite();
//
//    }
//
//    @Test (priority = 2, description="emulate network offline")
//    public void checkTurningNetworkOff() throws InterruptedException, MalformedURLException {
//      googlePage.emulateNetworkConditionTest();
//    }
//
//    @Test (priority = 3, description="check filtering url")
//    public void checkUrlFiltering() throws InterruptedException {
//        googlePage.filterUrls();
//    }
//
//    @Test (priority = 5, description="check filtering url")
//    public void checkUrlCheckRelativeLocators() throws InterruptedException {
//        myHtmlTest.checkRelativeLocators();
//    }


}