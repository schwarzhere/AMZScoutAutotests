package all.autotests.pages.webAppPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AsinLookup {
    private WebDriver driver;
    private WebDriverWait wait;

    public AsinLookup(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to("https://amzscout.net/app/#/product-keywords");
    }

    @FindBy(xpath = "//input[@placeholder='Type product ASIN']")
    public WebElement productAsinInput;

    @FindBy(xpath = "//button[text()=' Find keywords ']")
    public WebElement findKeywordsButton;

    @FindBy(css = "datatable-row-wrapper.datatable-row-wrapper")
    public List<WebElement> resultsList;
}
