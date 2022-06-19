package all.autotests.pages.webAppPages;

import all.testsBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sidebar extends TestBase {
    private WebDriver driver;
    private WebDriverWait wait;

    public Sidebar(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@touranchor='start.tour']")
    public WebElement sidebar;

    @FindBy(xpath = "//div[@class='main-menu__list']")
    public WebElement sidebarList;

    public void isSidebarDisplayed() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.
                xpath("//div[@touranchor='start.tour']"))).isDisplayed();
    }
}
