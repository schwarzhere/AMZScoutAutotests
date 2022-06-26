package all.autotests.pages.webAppPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Settings {
    private WebDriver driver;
    private WebDriverWait wait;

    public Settings(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".settings__lic-row_btn")
    public WebElement buyNowSettingsButton;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement emailInput;

    public String getEmailInputText() {
        return emailInput.getText();
    }
}
