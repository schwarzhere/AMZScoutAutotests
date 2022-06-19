package all.autotests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleAuthorization {
    private WebDriver driver;
    private WebDriverWait wait;

    public GoogleAuthorization(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void switchWindow() {
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }

    public void authByGoogleSendEmail() {
        emailFieldAuthByGoogle.sendKeys("vincent@amzscout.net");
    }

    public void authByGoogleSendPassword() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.
                xpath("//input[@type='password']"))).sendKeys("Djnx3rfrjqamz");
    }

    @FindBy(xpath = "//input[@type='email']")
    public WebElement emailFieldAuthByGoogle;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordFieldAuthByGoogle;

    @FindBy(xpath = "//button/span[text()='Далее']")
    public WebElement confirmEmailButtonAuthByGoogle;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement authButtonByGoogle;
}
