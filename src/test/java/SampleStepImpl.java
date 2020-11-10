import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;

public class SampleStepImpl {

    @Step("This is a setup step 1")
    public void setupStep1() {
        Gauge.writeMessage("This is a setup step 1");
    }

    @Step("This is a setup step 2")
    public void setupStep2() {
        Gauge.writeMessage("This is a setup step 2");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step("This is a scenario step 1")
    public void scenarioStep1() {
        Gauge.writeMessage("This is a scenario step 1");
    }

    @Step("This is a scenario step 2")
    public void scenarioStep2() {
        Gauge.writeMessage("This is a scenario step 2");
    }

    @Step("This is a tear down step 1")
    public void tearDownStep1() {
        Gauge.writeMessage("This is a tear down step 1");
    }

    @Step("This is a tear down step 2")
    public void tearDownStep2() {
        Gauge.writeMessage("This is a tear down step 2");
    }
}
