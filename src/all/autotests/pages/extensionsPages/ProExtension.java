package all.autotests.pages.extensionsPages;

import all.autotests.pages.GoogleAuthorization;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProExtension {
    private WebDriver driver;
    private WebDriverWait wait;

    public ProExtension(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public String productScoreForPLnoDataTooltipText = "Amazon does not provide a rank in a parent category " +
            "for this product, therefore there's not enough data to evaluate how this product would perform " +
            "via Private Label, Dropshipping or Online Arbitrage";

    public String productScoreForResellingNoDataTooltipText = "This product would not be appropriate for" +
            " Dropshipping or Online Arbitrage because the label only sells this product themselves";

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

    @FindBy(css = "div.maintable__row")
    public List<WebElement> parsedProductsList;

    @FindBy(xpath = "(//div[contains(@class,'col-name')])[2]//a")
    public WebElement firstProductName;

    @FindBy(css = "div.modal--history h3")
    public WebElement productHistoryProductName;

    @FindBy(css = "div.search-bar-wrapper button")
    public WebElement searchBarButton;

    @FindBy(css = "main.paywall-iframe-modal__main iframe")
    public WebElement frameElementPricing;

    @FindBy(xpath = "//span[@id='promoTarget']")
    public WebElement checkoutLicencePrice;

    @FindBy(xpath = "//button[@data-id='tab1']")
    public WebElement payMonthlyTab;

    @FindBy(xpath = "//button[@data-id='tab3']")
    public WebElement payForALifetimeTab;

    @FindBy(xpath = "(//a[@data-event-action='BuyNow'])[1]")
    public WebElement buyNowMonthly45ProExtButton;

    @FindBy(xpath = "(//a[@data-event-action='BuyNow'])[2]")
    public WebElement buyNowMonthly48BundleButton;

    @FindBy(xpath = "(//a[@data-event-action='BuyNow'])[3]")
    public WebElement buyNowYearly197ProExtButton;

    @FindBy(xpath = "(//a[@data-event-action='BuyNow'])[4]")
    public WebElement buyNowYearly349BundleButton;

    @FindBy(xpath = "(//a[@data-event-action='BuyNow'])[5]")
    public WebElement buyNowLifetime499ProExtButton;

    @FindBy(xpath = "(//a[@data-event-action='BuyNow'])[6]")
    public WebElement buyNowLifetime1499BundleButton;

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

    @FindBy(css = "div.selected div.history-action")
    public WebElement productHistoryButton;

    @FindBy(css = "div.modal--history")
    public WebElement productHistoryModal;

    @FindBy(id = "chartjs-tooltip")
    public WebElement productHistoryModalTooltip;

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

    @FindBy(xpath = "//div[@ng-if='options.avgMonthlyRevenue']")
    public WebElement avgMonthlyRevenueHeader;

    @FindBy(xpath = "//div[@ng-if='options.avgMarginImpact']")
    public WebElement avgMarginImpactHeader;

    @FindBy(xpath = "//div[@ng-if='options.bsr30']")
    public List<WebElement> bsr30valuesList;

    @FindBy(xpath = "//div[@ng-if='options.price30']")
    public List<WebElement> price30valuesList;

    @FindBy(xpath = "//div[@ng-if='options.minPrice']")
    public List<WebElement> minPriceValuesList;

    @FindBy(xpath = "//div[@ng-if='options.netPrice']")
    public List<WebElement> netPriceValuesList;

    @FindBy(xpath = "//div[@ng-if='options.bestseller']")
    public List<WebElement> bestsellerColumnList;

    @FindBy(xpath = "//div[@ng-if='options.inventory']")
    public WebElement inventoryColumnTitle;

    @FindBy(xpath = "//div[@ng-if='options.ebc']")
    public List<WebElement> ebcValuesList;

    @FindBy(xpath = "//div[@ng-if='options.oversize']")
    public List<WebElement> oversizeValuesList;

    @FindBy(xpath = "//section[@ng-if='options.inventory']")
    public List<WebElement> inventoryValuesList;

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

    @FindBy(css = "a.btn-niche-idea")
    public WebElement productIdeasButton;

    @FindBy(xpath = "//a[@ng-click='ctrl.openRandomNicheIdea()']")
    public WebElement randomProductIdeaButton;

    @FindBy(xpath = "//a[@ng-click='ctrl.openBest1000Products()']")
    public WebElement top1000BestsellersButton;

    @FindBy(xpath = "//a[@ng-click='ctrl.openNewProducts()']")
    public WebElement newAndTrendingItemsButton;

    @FindBy(xpath = "//a[@ng-click='ctrl.showOptions()']")
    public WebElement personalizeViewButton;

    @FindBy(xpath = "//h2[text()='Данные']/ancestor::form//input[@class='ng-pristine " +
            "ng-untouched ng-valid ng-empty']//parent::label")
    public WebElement emptyCheckboxPersonalizeView;

    @FindBy(xpath = "//h2[text()='Данные']/ancestor::form//input[@class='ng-pristine " +
            "ng-untouched ng-valid ng-empty']//parent::label")
    public List<WebElement> emptyCheckboxesPersonalizeView;

    @FindBy(xpath = "//button[@ng-click='ctrl.save()']")
    public WebElement applyButtonPersonalizeView;

    @FindBy(xpath = "//div[@ng-if='options.productScore']//div[@message-type='ScoreL']")
    public WebElement productScoreForPLnoDataTooltip;

    @FindBy(xpath = "//div[@ng-if='options.productScoreReselling']//div[@message-type='ScoreL']")
    public WebElement productScoreForResellingNoDataTooltip;

    public boolean checkProductScoreForPLnoDataTooltipText() {
        if (productScoreForPLnoDataTooltip.isDisplayed()) {
            Assertions.assertTrue(productScoreForPLnoDataTooltip.getAttribute
                    ("tooltip-template").contains(productScoreForPLnoDataTooltipText),
                    "Некорректный текст тултипа");
        } else {
            return false;
        }
        return false;
    }

    public boolean checkProductScoreForResellingNoDataTooltipText() {
        if (productScoreForResellingNoDataTooltip.isDisplayed()) {
            Assertions.assertTrue(productScoreForResellingNoDataTooltip.getAttribute
                            ("tooltip-template").contains(productScoreForResellingNoDataTooltipText),
                    "Некорректный текст тултипа");
        } else {
            return false;
        }
        return false;
    }

    public void markAllEmptyCheckboxesPersonalizeView() {
        if (emptyCheckboxesPersonalizeView.size() > 0) {
            for (int i = emptyCheckboxesPersonalizeView.size(); i >= 1; i--) {
                emptyCheckboxPersonalizeView.click();
            }
            applyButtonPersonalizeView.click();
        }
    }

    public String getFirstProductName() {
        return firstProductName.getText();
    }

    public String getProductNameInProductHistory() {
        return productHistoryProductName.getText();
    }

    public String getCheckoutPriceValue() {
        return checkoutLicencePrice.getText();
    }

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

    public void waitForPricing() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("#js_newPricingBlock")));
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
