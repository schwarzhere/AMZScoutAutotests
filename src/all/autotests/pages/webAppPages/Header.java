package all.autotests.pages.webAppPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header {
    private WebDriver driver;
    private WebDriverWait wait;

    public Header(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".main-menu__item-settings")
    public WebElement menuSettings;

    @FindBy(xpath = "//div[@class='main-menu__burger']//div[@class='burger']")
    public WebElement menuBurger;

    @FindBy(xpath = "//button[contains(@class, 'db-filters__input-btnlang')][text()=' EN ']")
    public WebElement changeToEngLanguageButton;

    @FindBy(xpath = "//button[contains(@class, 'db-filters__input-btnlang')][text()=' 中文 ']")
    public WebElement changeToChinaLanguageButton;

    @FindBy(xpath = "//div[text()='产品数据库']")
    public WebElement cnProductDatabaseTitle;

    public String getCnMarketplaceListTitle() {
        return cnProductDatabaseTitle.getText();
    }
}
