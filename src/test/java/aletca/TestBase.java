package aletca;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static final String OS = System.getProperty("os.name")
                                             .toLowerCase();

    @BeforeEach
    public void setUp() {

        if (isWindows()) {
            System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "drivers//chromedriver-2");
        }

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage()
              .timeouts()
              .implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage()
              .window()
              .maximize();
    }

    protected static boolean isWindows() {
        return (OS.contains("win"));
    }

    @AfterEach
    public void tearDown() throws IOException {
        var sourseFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourseFile, new File("c:\\tmp\\screenshot.png"));
        driver.close();
        driver.quit();
    }
}
