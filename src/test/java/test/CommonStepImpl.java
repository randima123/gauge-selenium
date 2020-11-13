package test;

import com.thoughtworks.gauge.Step;
import driver.Driver;
import org.testng.Assert;

public class CommonStepImpl {

    @Step("Page title is <title>")
    public void verifyPageTitle(String title) {
        Assert.assertEquals(Driver.webDriver.getTitle(), title);
    }
}
