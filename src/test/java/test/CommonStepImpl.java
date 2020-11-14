package test;

import com.thoughtworks.gauge.Step;
import org.testng.Assert;
import util.driver.Driver;

public class CommonStepImpl {

    @Step("Page title is <title>")
    public void verifyPageTitle(String title) {
        Assert.assertEquals(Driver.webDriver.getTitle(), title);
    }
}
