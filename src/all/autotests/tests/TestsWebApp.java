package all.autotests.tests;

import all.autotests.pages.Checkout;
import all.autotests.pages.webAppPages.*;
import all.autotests.testsBase.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestsWebApp extends TestBase {

    @Test
    public void signUpWebAppByEmail() {
        new Authorization(driver, wait).webAppSignUpByEmail();

        var sidebar = new Sidebar(driver, wait);
        assertTrue(sidebar.sidebar.isDisplayed());
    }

    @Test
    public void signUpWebAppByGoogle() throws InterruptedException {
        new Authorization(driver, wait).webAppSignUpByGoogle();
        driver.switchTo().window(initialWindow);

        var sidebar = new Sidebar(driver, wait);
        assertTrue(sidebar.sidebar.isDisplayed());
    }

    @Test
    public void signInWebApp() {
        new Authorization(driver, wait).webAppSignIn();

        var sidebar = new Sidebar(driver, wait);
        assertTrue(sidebar.sidebar.isDisplayed());
    }

    @Test
    public void menuSettingsMonthlyBundleCheckout() {
        new Authorization(driver, wait).webAppSignUpByEmail();
        new HeaderWebApp(driver, wait).menuSettings.click();
        new Settings(driver, wait).buyNowSettingsButton.click();

        var pricing = new Pricing(driver, wait);
        pricing.switchToFrame();
        pricing.payMonthlyButtonPricing.click();
        pricing.monthlyBundleBuyNowButton.click();

        pricing.switchWindow();

        var checkout = new Checkout(driver, wait);
        assertTrue(checkout.paymentForm.isDisplayed());
    }

    @Test
    public void productDatabaseFindProducts() {
        new Authorization(driver, wait).webAppSignUpByEmail();

        var productDatabase = new ProductDatabase(driver, wait);
        productDatabase.mainOnboardSkipButton.click();
        driver.navigate().refresh();
        productDatabase.openCategories();
        productDatabase.clearCategoriesButton.click();
        productDatabase.babyProductsCategoryCheckbox.click();
        productDatabase.applyButtonCategories.click();
        productDatabase.findProductsButton.click();

        Assertions.assertAll(
                () -> assertTrue(productDatabase.babyProductsCategoryColumn.isDisplayed()),
                () -> assertTrue(productDatabase.productBlocksList.size() > 3));
    }

    @Test
    public void openProductDatabaseFromClosedSidebar() {
        new Authorization(driver, wait).webAppSignUpByEmail();
        new ProductDatabase(driver, wait).mainOnboardSkipButton.click();

        var sidebar = new Sidebar(driver, wait);
        driver.navigate().to("https://amzscout.net/app/#/keywords");
        sidebar.productDatabaseClosedSidebar.click();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://amzscout.net/app/#/database";

        Assertions.assertEquals(expectedUrl, actualUrl,
                "?????????????? ?? Product Database ?????????? ?????????????? ???????? ???? ??????????????????");
    }

    @Test
    public void openProductTrackerFromClosedSidebar() {
        new Authorization(driver, wait).webAppSignUpByEmail();
        new ProductDatabase(driver, wait).mainOnboardSkipButton.click();

        var sidebar = new Sidebar(driver, wait);
        sidebar.productTrackerClosedSidebar.click();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://amzscout.net/app/#/tracker";

        Assertions.assertEquals(expectedUrl, actualUrl,
                "?????????????? ?? Product Tracker ?????????? ?????????????? ???????? ???? ??????????????????");
    }

    @Test
    public void openAsinLookupFromClosedSidebar() {
        new Authorization(driver, wait).webAppSignUpByEmail();
        new ProductDatabase(driver, wait).mainOnboardSkipButton.click();

        var sidebar = new Sidebar(driver, wait);
        sidebar.asinLookupClosedSidebar.click();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://amzscout.net/app/#/product-keywords";

        Assertions.assertEquals(expectedUrl, actualUrl,
                "?????????????? ?? Asin Lookup ?????????? ?????????????? ???????? ???? ??????????????????");
    }

    @Test
    public void openKeywordSearchFromClosedSidebar() {
        new Authorization(driver, wait).webAppSignIn();

        var sidebar = new Sidebar(driver, wait);
        sidebar.keywordSearchClosedSidebar.click();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://amzscout.net/app/#/keywords";

        Assertions.assertEquals(expectedUrl, actualUrl,
                "?????????????? ?? Keyword Search ?????????? ?????????????? ???????? ???? ??????????????????");
    }

    @Test
    public void openKeywordTrackerFromClosedSidebar() {
        new Authorization(driver, wait).webAppSignIn();

        var sidebar = new Sidebar(driver, wait);
        sidebar.keywordTrackerClosedSidebar.click();
        sidebar.switchWindow();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://chrome.google.com/webstore/detail/" +
                "amazon-keyword-tracker-re/fgkhimnkbaccbhigaeoggfbmggdidjjj";

        Assertions.assertEquals(expectedUrl, actualUrl,
                "?????????????? ?? Keyword Tracker ?? Chrome Webstore ?????????? ?????????????? ???????? ???? ??????????????????");
    }
    @Test
    public void openProExtensionFromClosedSidebar() {
        new Authorization(driver, wait).webAppSignIn();

        var sidebar = new Sidebar(driver, wait);
        sidebar.proExtensionClosedSidebar.click();
        sidebar.switchWindow();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://chrome.google.com/webstore/detail/" +
                "amazon-product-finder-amz/njopapoodmifmcogpingplfphojnfeea";

        Assertions.assertEquals(expectedUrl, actualUrl,
                "?????????????? ?? Pro Extension ?? Chrome Webstore ?????????? ?????????????? ???????? ???? ??????????????????");

    }
    @Test
    public void openQuickViewFromClosedSidebar() {
        new Authorization(driver, wait).webAppSignIn();

        var sidebar = new Sidebar(driver, wait);
        sidebar.quickViewClosedSidebar.click();
        sidebar.switchWindow();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://chrome.google.com/webstore/detail/" +
                "amazon-quick-view-by-amzs/pggamokfileohlopdonjmelbbghhnlah";

        Assertions.assertEquals(expectedUrl, actualUrl,
                "?????????????? ?? Quick View ?? Chrome Webstore ?????????? ?????????????? ???????? ???? ??????????????????");
    }
    @Test
    public void openStockStatsFromClosedSidebar() {
        new Authorization(driver, wait).webAppSignIn();

        var sidebar = new Sidebar(driver, wait);
        sidebar.stockStatsClosedSidebar.click();
        sidebar.switchWindow();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://chrome.google.com/webstore/detail/" +
                "amzscout-stock-stats-amaz/liobflkelkokkacdemhmgkbpefgaekkm";

        Assertions.assertEquals(expectedUrl, actualUrl,
                "?????????????? ?? Stock Stats ?? Chrome Webstore ?????????? ?????????????? ???????? ???? ??????????????????");
    }
    @Test
    public void openCoursesFromClosedSidebar() {
        new Authorization(driver, wait).webAppSignIn();

        var sidebar = new Sidebar(driver, wait);
        sidebar.coursesClosedSidebar.click();
        sidebar.switchWindow();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://amzscout.net/app/#/course";

        Assertions.assertEquals(expectedUrl, actualUrl,
                "?????????????? ?? Courses ?????????? ?????????????? ???????? ???? ??????????????????");
    }

    @Test
    public void openMasterclassesFromClosedSidebar() {
        new Authorization(driver, wait).webAppSignIn();

        var sidebar = new Sidebar(driver, wait);
        sidebar.masterclassesClosedSidebar.click();
        sidebar.switchWindow();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://amzscout.net/app/#/masterclasses";

        Assertions.assertEquals(expectedUrl, actualUrl,
                "?????????????? ?? Masterclasses ?????????? ?????????????? ???????? ???? ??????????????????");
    }

    @Test
    public void openUniversityFromClosedSidebar() {
        new Authorization(driver, wait).webAppSignIn();

        var sidebar = new Sidebar(driver, wait);
        sidebar.universityClosedSidebar.click();
        sidebar.switchWindow();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://amzscout.net/app/#/university";

        Assertions.assertEquals(expectedUrl, actualUrl,
                        "?????????????? ?? University ?????????? ?????????????? ???????? ???? ??????????????????");
    }

    @Test
    public void openReportsFromClosedSidebar() {
        new Authorization(driver, wait).webAppSignIn();

        var sidebar = new Sidebar(driver, wait);
        sidebar.reportsClosedSidebar.click();
        sidebar.switchWindow();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://amzscout.net/app/#/reports/reports";

        Assertions.assertEquals(expectedUrl, actualUrl,
                "?????????????? ?? Reports ?????????? ?????????????? ???????? ???? ??????????????????");
    }

    @Test
    public void openHotProductsFromClosedSidebar() {
        new Authorization(driver, wait).webAppSignIn();

        var sidebar = new Sidebar(driver, wait);
        sidebar.hotProductsClosedSidebar.click();
        sidebar.switchWindow();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://amzscout.net/app/#/reports/insights";

        Assertions.assertEquals(expectedUrl, actualUrl,
                "?????????????? ?? Hot Products ?????????? ?????????????? ???????? ???? ??????????????????");
    }

    @Test
    public void openCustomIdeasFromClosedSidebar() {
        new Authorization(driver, wait).webAppSignIn();

        var sidebar = new Sidebar(driver, wait);
        sidebar.customIdeasClosedSidebar.click();
        sidebar.switchWindow();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://amzscout.net/app/#/reports/customideas";

        Assertions.assertEquals(expectedUrl, actualUrl,
                "?????????????? ?? Custom Ideas ?????????? ?????????????? ???????? ???? ??????????????????");
    }

    @Test
    public void openFreeBonusesFromClosedSidebar() {
        new Authorization(driver, wait).webAppSignIn();

        var sidebar = new Sidebar(driver, wait);
        sidebar.freeBonusesClosedSidebar.click();
        sidebar.switchWindow();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://amzscout.net/app/#/reports/bonuses";

        Assertions.assertEquals(expectedUrl, actualUrl,
                "?????????????? ?? Free Bonuses ?????????? ?????????????? ???????? ???? ??????????????????");
    }

    @Test
    public void openSidebar() {
        new Authorization(driver, wait).webAppSignIn();

        var sidebar = new Sidebar(driver, wait);
        Actions actions = new Actions(driver);
        actions.moveToElement(sidebar.sidebar);
        actions.build().perform();

        Assertions.assertTrue(sidebar.openedSidebar.isDisplayed(), "?????????????? ???????? ???? ????????????????????");
    }

    @Test
    public void clickableLogo() {
        new Authorization(driver, wait).webAppSignIn();
        new HeaderWebApp(driver, wait).logo.click();

        var actualUrl = driver.getCurrentUrl();
        var expectedUrl = "https://amzscout.net/";

        Assertions.assertEquals(expectedUrl, actualUrl,
                "?????????????? ???? ?????????? ???? ???????? ???? ??????????????????");
    }

    @Test
    public void totalFeeInCalculatorChanging() throws InterruptedException {
        new Authorization(driver, wait).webAppSignUpByEmail();

        var productDatabase = new ProductDatabase(driver, wait);
        productDatabase.mainOnboardSkipButton.click();
        driver.navigate().refresh();
        productDatabase.findProductsButton.click();
        productDatabase.openFirstProductCalculator.click();
        var actualTotalFee = productDatabase.getTotalFeeIndex();
        Thread.sleep(2000);
        productDatabase.productPriceCalculatorInput.clear();
        productDatabase.productPriceCalculatorInput.sendKeys("123");
        Thread.sleep(3000);
        var changedTotalFee = productDatabase.getTotalFeeIndex();

        Assertions.assertFalse(actualTotalFee.equals(changedTotalFee), "Total Fee ???? ??????????????????");
    }

    @Test
    public void addProductToAsinLookup() {
        new Authorization(driver, wait).webAppSignUpByEmail();

        var productDatabase = new ProductDatabase(driver, wait);
        productDatabase.mainOnboardSkipButton.click();
        driver.navigate().refresh();

        var asinLookup = new AsinLookup(driver, wait);
        asinLookup.open();
        asinLookup.productAsinInput.sendKeys("B09JVPPB2C");
        asinLookup.findKeywordsButton.click();
        wait = new WebDriverWait(driver, 60);

        assertTrue(asinLookup.resultsList.size() > 6, "???????????????????? ???? ????????????????????");
    }

    @Test
    public void addProductToKeywordSearch() {
        new Authorization(driver, wait).webAppSignUpByEmail();
        var productDatabase = new ProductDatabase(driver, wait);
        productDatabase.mainOnboardSkipButton.click();
        driver.navigate().refresh();

        var keywordSearch = new KeywordSearch(driver, wait);
        keywordSearch.open();
        keywordSearch.closeOnboarding();
        keywordSearch.keywordInput.sendKeys("office");
        keywordSearch.findKeywordsButton.click();
        wait = new WebDriverWait(driver, 60);
        var firstProductContainsKeyword = keywordSearch.firstFoundKeyword.getText();

        assertTrue(firstProductContainsKeyword.contains("office"), "???????????????????????? ???????????????????????? ????????????????");
    }

//    @Test
//    public void addProductToTrackerByAsin() throws InterruptedException {
//        new Authorization(driver, wait).webAppSignUpByEmail();
//
//        var productTracker = new ProductTracker(driver, wait);
//        productTracker.open();
//
//        if (productTracker.addProductToTrackerButton.isDisplayed() && productTracker.deleteProductFromTrackerButtons.size() >= 1) {
//            for (int i = 1; i == productTracker.deleteProductFromTrackerButtons.size(); i++) {
//                productTracker.deleteProductFromTrackerButton.click();
//                Thread.sleep(1000);
//                if (productTracker.addProductToTrackerButton.isDisplayed()) {
//                    return;
//                } else {
//                    productTracker.addProductByAsinInput.sendKeys("B08PV4Z9V1");
//                    productTracker.addProductToTrackerButton.click();
//                    break;
//                }
//            }
//        } else {
//            productTracker.addProductByAsinInput.sendKeys("B08PV4Z9V1");
//            productTracker.addProductToTrackerButton.click();
//        }
//
//        var addedProductToTracker = productTracker.getFirstAsinInTracker();
//        Assertions.assertEquals("B08PV4Z9V1", addedProductToTracker, "?????????????????????? ?????????????????? ?????????? ?? ????????????");
//
//        productTracker.deleteProductFromTrackerButton.click();
//    }
//
//    @Test
//    public void addProductToTracker() {
//        new Authorization(driver, wait).webAppSignUpByEmail();
//
//        var productDatabase = new ProductDatabase(driver, wait);
//        productDatabase.mainOnboardSkipButton.click();
//        driver.navigate().refresh();
//        productDatabase.findProductsButton.click();
//        var productDatabaseAsin = productDatabase.getFirstAsinInDatabase();
//
//        productDatabase.addProductToTheTrackerButton.click();
//        driver.navigate().to("https://amzscout.net/app/#/tracker");
//        var productTrackerAsin = productDatabase.getFirstAsinInTracker();
//
//        Assertions.assertEquals(productDatabaseAsin, productTrackerAsin, "ASIN ?? ?????????????? ????????????????????");
//    }
//
//    @Test
//    public void refreshProductInDatabase() throws InterruptedException {
//        new Authorization(driver, wait).webAppSignUpByEmail();
//        var loaderLocator = By.xpath("//datatable-body-row[contains(@class,'updating')]");
//
//        var productDatabase = new ProductDatabase(driver, wait);
//
//        driver.navigate().to(productDatabase.webAppUrl);
//        Thread.sleep(2000);
//        productDatabase.findProductsButton.click();
//        productDatabase.getRefreshProductButton(0).click();
//
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderLocator));
//
//        assertTrue(driver.findElements(loaderLocator).size() == 0, "?????????? ???? ??????????????????");
//    }
}
