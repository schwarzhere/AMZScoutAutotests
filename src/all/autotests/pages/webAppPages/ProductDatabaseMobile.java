package all.autotests.pages.webAppPages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDatabaseMobile {

    private WebDriver driver;
    private WebDriverWait wait;

    public ProductDatabaseMobile(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='burger-icon']")
    public WebElement openFiltersButton;

    @FindBy(xpath = "//span[text()=' Excl. Keywords:']/parent::div/input")
    public WebElement excludeKeywordsFieldBurger;

    @FindBy(xpath = "//div[text()=' Find products ']")
    public WebElement findProductsFiltersButton;

    @FindBy(xpath = "//div[@class='loader ng-star-inserted']")
    public WebElement loaderFindingProducts;

    public Dimension getLoaderFindingProductsSize() {
        return loaderFindingProducts.getSize();
    }

    public boolean elementIsNotPresent(String locator){
        return driver.findElements(By.xpath("//div[@class='loader ng-star-inserted']")).isEmpty();
    }
}
