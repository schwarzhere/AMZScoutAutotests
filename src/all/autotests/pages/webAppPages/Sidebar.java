package all.autotests.pages.webAppPages;

import all.autotests.testsBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sidebar extends TestBase {
    private WebDriver driver;
    private WebDriverWait wait;

    public Sidebar(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void switchWindow() {
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }

    @FindBy(xpath = "//div[@touranchor='start.tour']")
    public WebElement sidebar;

    @FindBy(xpath = "//a[@class='main-menu__list-item-content-wrp active use-hover']")
    public WebElement openedSidebar;

    @FindBy(xpath = "//div[@class='main-menu__list']")
    public WebElement sidebarList;

    @FindBy(xpath = "//div[@class='menu-panel__content-top']/div[text()=' Product Database ']")
    public WebElement productDatabaseClosedSidebar;

    @FindBy(xpath = "//div[@class='menu-panel__content-top']/div[text()=' Product Tracker ']")
    public WebElement productTrackerClosedSidebar;

    @FindBy(xpath = "//div[@class='menu-panel__content-top']/div[text()=' ASIN Lookup ']")
    public WebElement asinLookupClosedSidebar;

    @FindBy(xpath = "//div[@class='menu-panel__content-top']/div[text()=' Keyword Search ']")
    public WebElement keywordSearchClosedSidebar;

    @FindBy(xpath = "//div[@class='menu-panel__content-top']/div[text()=' Keyword Tracker ']")
    public WebElement keywordTrackerClosedSidebar;

    @FindBy(xpath = "//div[@class='menu-panel__content-top']/div[text()=' PRO Extension ']")
    public WebElement proExtensionClosedSidebar;

    @FindBy(xpath = "//div[@class='menu-panel__content-top']/div[text()='  Quick View  ']")
    public WebElement quickViewClosedSidebar;

    @FindBy(xpath = "//div[@class='menu-panel__content-top']/div[text()='  Stock Stats  ']")
    public WebElement stockStatsClosedSidebar;

    @FindBy(xpath = "//div[@class='menu-panel__content-top']/div[text()=' Courses ']")
    public WebElement coursesClosedSidebar;

    @FindBy(xpath = "//div[@class='menu-panel__content-top']/div[text()=' Master Classes ']")
    public WebElement masterclassesClosedSidebar;

    @FindBy(xpath = "//div[@class='menu-panel__content-top']/div[text()=' University ']")
    public WebElement universityClosedSidebar;

    @FindBy(xpath = "//div[@class='menu-panel__content-top']/div[text()=' Trends ']")
    public WebElement reportsClosedSidebar;

    @FindBy(xpath = "//div[@class='menu-panel__content-top']/div[text()=' Hot Products ']")
    public WebElement hotProductsClosedSidebar;

    @FindBy(xpath = "//div[@class='menu-panel__content-top']/div[text()=' Personal Ideas ']")
    public WebElement customIdeasClosedSidebar;

    @FindBy(xpath = "//div[@class='menu-panel__content-top']/div[text()=' Free Bonuses ']")
    public WebElement freeBonusesClosedSidebar;
}
