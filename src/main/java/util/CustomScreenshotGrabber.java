package util;

import com.thoughtworks.gauge.screenshot.CustomScreenshotWriter;
import com.thoughtworks.gauge.screenshot.ICustomScreenshotGrabber;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import util.driver.Driver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;

import static util.driver.DriverFactory.getDriver;

public class CustomScreenshotGrabber implements ICustomScreenshotGrabber {

//    @Override
//    public String takeScreenshot() {
//        TakesScreenshot driver = (TakesScreenshot) getDriver();
//        String screenshotFileName = String.format("screenshot-%s.png", UUID.randomUUID().toString());
//        File screenshotFile = new File(Paths.get(System.getenv("gauge_screenshots_dir"), screenshotFileName).toString());
//        File tempFile = driver.getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(tempFile, screenshotFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return screenshotFileName;
//    }

    @Override
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) Driver.webDriver).getScreenshotAs(OutputType.BYTES);
    }
}
