package all.autotests.pages.proExtPages;

import all.autotests.pages.GoogleAuthorization;
import all.autotests.testsBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProExtension extends TestBase {
    private WebDriver driver;
    private WebDriverWait wait;

    public ProExtension(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public String pageWithMoreThan24products = "https://www.amazon.com/s?i=specialty-aps&bbn=16225007011&rh=" +
            "n%3A16225007011%2Cn%3A1292110011&ref=nav_em__nav_desktop_sa_intl_data_storage_0_2_6_5";

    public String randomAmazonPage = "https://www.amazon.com/s?k=Outdoor+Plastic+Straw+Rug&rh=n%3A21487702011%2Cn%3A68\" +\n" +
            "                \"4541011&dc&qid=1655207004&rnid=2941120011&ref=sr_nr_n_5";

    public void switchWindow() {
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }

    @FindBy(css = ".btn-next")
    public WebElement nextPageButton;

    @FindBy(css = ".amzs-signin-email")
    public WebElement signInByEmailButton;

    @FindBy(css = ".amzs-signin-google")
    public WebElement signInByGoogleButton;

    @FindBy(css = ".amzs-signin-chrome")
    public WebElement signInByChromeButton;

    @FindBy(css = "#email")
    public WebElement emailFieldAuthByEmail;

    @FindBy(css = "#password")
    public WebElement passwordFieldAuthByEmail;

    @FindBy(css = "#button-signup")
    public WebElement confirmEmailButtonAuthByEmail;

    @FindBy(css = "#button-auth")
    public WebElement authButtonByEmail;

    @FindBy(css = ".spinner.centered")
    public WebElement loaderProductList;

    @FindBy(css = ".spinner.centered.ng-hide")
    public WebElement hiddenLoaderProductList;

    @FindBy(xpath = "//os-circle")
    public WebElement launchBubble;

    @FindBy(xpath = "//div[@class='animated as-pro-container']")
    public WebElement activeProExtWindow;

    @FindBy(xpath = "//div[@class='l-header__buy']//a")
    public WebElement buyButtonTrialUser;

    @FindBy(css = "#js_newPricingBlock")
    public WebElement pricing;

    @FindBy(id = "search-bar-button")
    public WebElement searchBar;

    @FindBy(css = "div.search-bar-wrapper button")
    public WebElement searchBarButton;

    @FindBy(css = "main.paywall-iframe-modal__main iframe")
    public WebElement frameElementPricing;

    @FindBy(xpath = "(//a[@data-event-action='BuyNow'])[4]")
    public WebElement buyNowPricingButton;

    @FindBy(css = "#score-item")
    public WebElement nicheScore;

    @FindBy(css = "#score-item i.i-question-na")
    public WebElement nicheScoreQuestionTooltip;

    @FindBy(css = "#score-item div.totals-item__score_circle span")
    public WebElement nicheScoreCircleHeader;

    @FindBy(css = "div.saturation-score div.totals-item__score_circle")
    public WebElement saturationScoreCircleHeader; //Оценка видимости

    @FindBy(css = "div.saturation-score div.totals-item__score_circle span")
    public WebElement saturationScoreCircleValueHeader; //Оценка видимости

    @FindBy(css = ".agmodal__wrapper--visible .os-progress-circle__overlay")
    public WebElement nicheScoreCircleOverlay;

    @FindBy(xpath = "//div[@ng-if='options.nicheHistory']")
    public WebElement nicheHistory;

    @FindBy(css = ".agmodal__wrapper--visible .modal--history")
    public WebElement nicheHistoryDiagram;

    @FindBy(xpath = "//i[@class='i-keywords-cloud']/ancestor::a")
    public WebElement nicheKeywords;

    @FindBy(css = ".agmodal__wrapper--visible .modal--keywords-cloud")
    public WebElement nicheKeywordsCloud;

    @FindBy(css = ".maintable__row-wrapper")
    public List<WebElement> productsList;

    @FindBy(xpath = "//div[@ng-if='options.results']/span")
    public WebElement totalItemsCountHeader;

    @FindBy(xpath = "//div[@ng-if='options.avgMonthlySales']/span")
    public WebElement avgMonthlySalesHeader;

    @FindBy(xpath = "//div[@ng-if='options.avgSalesRank']/span")
    public WebElement avgSalesRankHeader;

    @FindBy(xpath = "//div[@ng-if='options.avgPrice']/span")
    public WebElement avgPriceHeader;

    @FindBy(xpath = "//div[@ng-if='options.avgReviews']/span")
    public WebElement avgReviewsHeader;

    @FindBy(xpath = "//div[text()='Цена продукта']/ancestor::div[@class='calc-row']//input")
    public WebElement productPriceInputCalculator;

    @FindBy(xpath = "//input[@ng-model='ctrl.product.cost']")
    public WebElement productCostInputCalculator;

    @FindBy(xpath = "//div[@class='calc__totals']//div[@ng-show='ctrl.sales']//span")
    public WebElement estMonthlyProfitValueCalculator;

    @FindBy(css = "div.ng-scope.selected se")
    public WebElement profitCalculator;

    @FindBy(xpath = "//div[@class='agmodal__wrapper ng-scope agmodal__wrapper--visible']" +
            "//div[text()='Суммарный FBA сбор']//ancestor::div[@class='calc-row']//span")
    public WebElement totalFBAFeeValueCalculator;

    public String getEstMonthlyProfitValueCalculator() {
        return estMonthlyProfitValueCalculator.getText();
    }

    public String getTotalFBAFeeValueCalculator() {
        return totalFBAFeeValueCalculator.getText();
    }

    public String getSaturationScoreCircleValueHeader() {
        return saturationScoreCircleValueHeader.getText();
    }

    public String getNicheScoreValueHeader() {
        return nicheScoreCircleHeader.getText();
    }

    public void authByEmailSendEmail() {
        emailFieldAuthByEmail.sendKeys("vlad.b@amzscout.net");
    }

    public String getAvgReviewsHeader() {
        return avgReviewsHeader.getText();
    }

    public String getAvgPriceHeader() {
        return avgPriceHeader.getText();
    }

    public String getAvgSalesRankHeader() {
        return avgSalesRankHeader.getText();
    }

    public String getTotalItemCountHeader() {
        return totalItemsCountHeader.getText();
    }

    public String getAvgMonthlySalesHeader() {
        return avgMonthlySalesHeader.getText();
    }

    public void authByEmailSendPassword() {
        passwordFieldAuthByEmail.sendKeys("djnx3rfrjq");
    }

    public void waitForLoader() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("//div[@class='spinner centered']")));
    }

    public void waitForEstMonthlyProfitCalculator() {
        new WebDriverWait(driver, 7).until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//div[@class='calc__totals']//div[@ng-show='ctrl.sales']//span")));
    }

    public void waitForHiddenLoader() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.
                presenceOfElementLocated(By.cssSelector(".spinner.centered.ng-hide")));
    }

    public void waitForNicheScore() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated
                (By.cssSelector("#score-item div.totals-item__score_circle")));
    }

    public void waitForNicheScoreTooltip() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated
                (By.cssSelector("#score-item i.i-question-na")));
    }

    public void switchToFrame() {
        driver.switchTo().frame(frameElementPricing);
    }

    public void authByEmail() {
        var pro = new ProExtension(driver, wait);
        var proExtWindow = driver.getWindowHandle();

        pro.signInByEmailButton.click();
        pro.switchWindow();

        pro.authByEmailSendEmail();
        pro.confirmEmailButtonAuthByEmail.click();
        pro.switchWindow();

        pro.authByEmailSendPassword();
        pro.authButtonByEmail.click();
        driver.switchTo().window(proExtWindow);
    }

    public void authByGoogle() {
        var pro = new ProExtension(driver, wait);
        var proExtWindow = driver.getWindowHandle();

        pro.signInByGoogleButton.click();
        pro.switchWindow();

        var googleAuth = new GoogleAuthorization(driver, wait);

        googleAuth.authByGoogleSendEmail();
        googleAuth.confirmEmailButtonAuthByGoogle.click();
        googleAuth.switchWindow();

        googleAuth.authByGoogleSendPassword();
        googleAuth.confirmEmailButtonAuthByGoogle.click();
        driver.switchTo().window(proExtWindow);
    }

    public void authByChrome() {
        var pro = new ProExtension(driver, wait);
        var proExtWindow = driver.getWindowHandle();

        pro.signInByChromeButton.click();
        pro.switchWindow();

        var googleAuth = new GoogleAuthorization(driver, wait);

        googleAuth.authByGoogleSendEmail();
        googleAuth.confirmEmailButtonAuthByGoogle.click();
        googleAuth.switchWindow();

        googleAuth.authByGoogleSendPassword();
        googleAuth.confirmEmailButtonAuthByGoogle.click();
        driver.switchTo().window(proExtWindow);
    }

    public int getProductsListCount() {
        return productsList.size();
    }
}
