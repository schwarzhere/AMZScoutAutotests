package all.autotests.pages.webAppPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductTracker {
    private WebDriver driver;
    private WebDriverWait wait;

    public ProductTracker(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to("https://amzscout.net/app/#/tracker");
    }

    @FindBy(xpath = "//input[@placeholder='Add Product by ASIN or URL']")
    public WebElement addProductByAsinInput;

    @FindBy(xpath = "//button[@class='tracker-bar__btn {disabled: !query}']")
    public WebElement addProductToTrackerButton;

    @FindBy(xpath = "//div[@title='Remove Product from Result']")
    public List<WebElement> deleteProductFromTrackerButtons;

    @FindBy(xpath = "//img[@class='ng-star-inserted']")
    public WebElement productImage;

    @FindBy(css = ".acts__delete.acts__i")
    public WebElement deleteProductFromTrackerButton;

    @FindBy(xpath = "(//div[@class='pinfo-block__value ng-star-inserted'])[1]")
    public WebElement firstAsinInTracker;

    public String getFirstAsinInTracker() {
        return firstAsinInTracker.getText();
    }
}
