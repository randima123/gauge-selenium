import com.thoughtworks.gauge.Step;
import org.testng.Assert;
import util.DataStoreProcessor;

import static util.DataStoreProcessor.DataStoreType.SCENARIO;


public class SampleDataStoreStepImpl {

    @Step("My name is <name>")
    public void saveName(String name) {
        DataStoreProcessor.save(name, "myName", SCENARIO);
    }

    @Step("Hello")
    public void sayHello() {
        Assert.assertNotNull(DataStoreProcessor.read("myName", SCENARIO));
    }
}
