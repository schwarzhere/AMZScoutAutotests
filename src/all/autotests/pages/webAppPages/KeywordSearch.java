package all.autotests.pages.webAppPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KeywordSearch {
    private WebDriver driver;
    private WebDriverWait wait;

    public KeywordSearch(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to("https://amzscout.net/app/#/keywords");
    }

    public void closeOnboarding() {
        new WebDriverWait(driver, 5).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='custom-tour-class__btn']")));
        closeOnboardingButton.click();
    }

    @FindBy(xpath = "//button[@class='custom-tour-class__btn']")
    public WebElement closeOnboardingButton;

    @FindBy(xpath = "//input[@placeholder='Type something to search']")
    public WebElement keywordInput;

    @FindBy(xpath = "//button[text()=' Find keywords ']")
    public WebElement findKeywordsButton;

    @FindBy(xpath = "(//div[@class='datatable-body-cell-label']//span[contains(text(),'office')])[1]")
    public WebElement firstFoundKeyword;
}
