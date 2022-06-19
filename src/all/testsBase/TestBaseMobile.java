package all.testsBase;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class TestBaseMobile {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public String initialWindow;

    public Set<String> getAllWindows() {
        return driver.getWindowHandles();
    }

    public void switchToFirstNewWindow() {
        var newWindows = getAllWindows().stream().filter(w -> !w.equals(initialWindow)).collect(Collectors.toList());
        driver.switchTo().window(newWindows.stream().findFirst().get());
    }

    public void switchToWindow(String windowId) {
        driver.switchTo().window(windowId);
    }

    public void takeScreenshot() throws IOException {
        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hh__mm__ss");
        String fileName = format.format(dateNow) + ".png";

        var sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFile, new File("C:\\Screenshots\\" + fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        var options = new ChromeOptions();
        driver = new ChromeDriver(options);
        Dimension dimension = new Dimension(500, 1000);
        driver.manage().window().setSize(dimension);
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
        initialWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown() throws IOException {
        try {
            takeScreenshot();

        } catch (UnhandledAlertException alertException) {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert text: " + alert.getText());
            alert.accept();
            takeScreenshot();
        }

        driver.quit();
    }
}
