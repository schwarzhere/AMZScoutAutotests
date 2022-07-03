package all.autotests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SalesEstimator {
    private WebDriver driver;
    private WebDriverWait wait;

    public SalesEstimator(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to("https://amzscout.net/sales-estimator");
    }

    @FindBy(xpath = "//input[@type='number']")
    public WebElement valueInput;

    @FindBy(xpath = "//button[@class='button']")
    public WebElement activeButton;

    @FindBy(css = "div#salesEstimator-behavior_data p")
    public WebElement salesPerMonthValue;

    @FindBy(xpath = "//label[text()='Select Category']/parent::div//button")
    public WebElement categoriesListButton;

    @FindBy(xpath = "//ul[@id='salesEstimator-category']//li[17]")
    public WebElement usMarketplaceCategory;

    public void openCategoriesList() {
        new WebDriverWait(driver, 7).until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Select Category']/parent::div//button")));
        categoriesListButton.click();
    }

    public void selectUsCategory() {
        new WebDriverWait(driver, 7).until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='salesEstimator-category']//li[17]")));
        usMarketplaceCategory.click();
    }

    public String getSalesPerMonthValue() {
        return salesPerMonthValue.getText();
    }

    public void calculateSalesButtonClick() {
        new WebDriverWait(driver, 5).until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='button']")));
        activeButton.click();
    }
}
