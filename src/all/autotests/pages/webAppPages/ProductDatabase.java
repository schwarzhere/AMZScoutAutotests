package all.autotests.pages.webAppPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductDatabase {
    private WebDriver driver;
    private WebDriverWait wait;
    private int index;

    public ProductDatabase(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public String webAppUrl = "https://amzscout.net/app/#/database";

    @FindBy(xpath = "(//div[text()=' Find products '])[1]")
    public WebElement findProductsButton;

    @FindBy(xpath = "//div[@class='db-filters__input db-filters__input-btn has-data']")
    public WebElement categoriesFilter;

    @FindBy(className = "db-filters__input-items-controlls-unselect")
    public WebElement clearCategoriesButton;

    @FindBy(xpath = "//span[text()='Baby Products']")
    public WebElement babyProductsCategoryCheckbox;

    @FindBy(xpath = "//div[contains(@class,'button button_undefined')]")
    public WebElement applyButtonCategories;

    @FindBy(xpath = "//div[@class='meta__item']/span[text()='Baby Products']")
    public WebElement categoryColumn;

    @FindBy(xpath = "(//div[@title='Add Product to the Tracker'])[1]")
    public WebElement addProductToTheTrackerButton;

    @FindBy(xpath = "(//div[contains(@class,'pinfo-block__value')])[1]")
    public WebElement firstAsinInDatabase;

    @FindBy(xpath = "(//div[contains(@class,'pinfo-block__value')])[1]")
    public WebElement firstAsinInTracker;

    @FindBy(xpath = "//div[contains(@class,'acts__calc')]")
    public WebElement openFirstProductCalculator;

    @FindBy(xpath = "(//div[@class='calc-row__center']/input)[3]")
    public WebElement productPriceCalculatorInput;

    @FindBy(xpath = "(//div[@class='calc-row'][1]//span)[1]")
    public WebElement totalFeeIndex;

    @FindBy(xpath = "//div[@title='Refresh Product']")
    public List<WebElement> refreshProductButtons;

    @FindBy(xpath = "//datatable-body-row[contains(@class,'updating')]")
    public WebElement loaderAfterProductUpdate;

    @FindBy(xpath = "(//datatable-body-row[@class='datatable-body-row datatable-row-even'])[1]")
    public WebElement firstProductBodyWithoutLoader;

    @FindBy(xpath = "//popover-container//button")
    public WebElement mainOnboardSkipButton;

    public String getFirstAsinInDatabase() {
        return firstAsinInDatabase.getText();
    }

    public String getFirstAsinInTracker() {
        return firstAsinInTracker.getText();
    }

    public String getTotalFeeIndex() {
        return totalFeeIndex.getText();
    }

    public WebElement getRefreshProductButton(int index) {
        return refreshProductButtons.get(index);
    }
}
