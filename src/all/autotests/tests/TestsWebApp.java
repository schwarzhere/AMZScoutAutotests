package all.autotests.tests;

import all.autotests.pages.Checkout;
import all.autotests.pages.webAppPages.*;
import all.autotests.testsBase.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestsWebApp extends TestBase {

    @Test
    public void signUpWebAppByEmail() throws InterruptedException {
        var auth = new Authorization(driver, wait);
        auth.webAppSignUpByEmail();

        var sidebar = new Sidebar(driver, wait);
        Assertions.assertTrue(sidebar.sidebar.isDisplayed());
    }

    @Test
    public void signUpWebAppByGoogle() throws InterruptedException {
        var auth = new Authorization(driver, wait);
        auth.webAppSignUpByGoogle();

        driver.switchTo().window(initialWindow);

        var sidebar = new Sidebar(driver, wait);
        Assertions.assertTrue(sidebar.sidebar.isDisplayed());
    }

    @Test
    public void menuSettingsMonthlyBundleCheckout() throws InterruptedException {
        var auth = new Authorization(driver, wait);
        auth.webAppSignUpByEmail();

        var header = new Header(driver, wait);
        header.menuSettings.click();
        header.buyNowSettingsButton.click();

        var pricing = new Pricing(driver, wait);
        pricing.switchToFrame();
        pricing.payMonthlyButtonPricing.click();
        pricing.monthlyBundleBuyNowButton.click();

        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        var checkout = new Checkout(driver, wait);
        Assertions.assertTrue(checkout.paymentForm.isDisplayed());
    }

    @Test
    public void signInWebApp() throws InterruptedException {
        var page = new Authorization(driver, wait);
        page.webAppSignIn();

        var sidebar = new Sidebar(driver, wait);
        Assertions.assertTrue(sidebar.sidebar.isDisplayed());
    }

    @Test
    public void productDatabaseFindProducts() throws InterruptedException {
        var auth = new Authorization(driver, wait);
        auth.webAppSignUpByEmail();

        var productDatabase = new ProductDatabase(driver, wait);

        //skip онборда для новых юзеров
        //        driver.switchTo().parentFrame();
        //        productDatabase.mainOnboardSkipButton.click();

//        productDatabase.mainOnboardSkipButton.click();
//        driver.navigate().to(productDatabase.webAppUrl);
//        Thread.sleep(2000);
//        productDatabase.categoriesFilter.click();
//        productDatabase.clearCategoriesButton.click();
//        productDatabase.babyProductsCategoryCheckbox.click();
//        productDatabase.applyButtonCategories.click();
//        productDatabase.findProductsButton.click();
//
//        Assertions.assertTrue(productDatabase.categoryColumn.isDisplayed());
    }

    @Test
    public void checkSidebarTitles() throws InterruptedException {
        var page = new Authorization(driver, wait);
        page.webAppSignUpByEmail();

        var sidebar = new Sidebar(driver, wait);
    }

    @Test
    public void totalFeeInCalculatorChanging() throws InterruptedException {
        var auth = new Authorization(driver, wait);
        auth.webAppSignUpByEmail();

        var productDatabase = new ProductDatabase(driver, wait);
        driver.navigate().to(productDatabase.webAppUrl);
        Thread.sleep(2000);
        productDatabase.findProductsButton.click();
        productDatabase.openFirstProductCalculator.click();
        var actualTotalFee = productDatabase.getTotalFeeIndex();
        Thread.sleep(2000);
        productDatabase.productPriceCalculatorInput.clear();
        productDatabase.productPriceCalculatorInput.sendKeys("123");
        Thread.sleep(3000);
        var changedTotalFee = productDatabase.getTotalFeeIndex();

        Assertions.assertFalse(actualTotalFee.equals(changedTotalFee), "Total Fee не изменился");
    }

    @Test
    public void refreshProductInDatabase() throws InterruptedException {
        var auth = new Authorization(driver, wait);
        auth.webAppSignUpByEmail();
        var loaderLocator = By.xpath("//datatable-body-row[contains(@class,'updating')]");

        var productDatabase = new ProductDatabase(driver, wait);

        driver.navigate().to(productDatabase.webAppUrl);
        Thread.sleep(2000);
        productDatabase.findProductsButton.click();
        productDatabase.getRefreshProductButton(0).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderLocator));

        Assertions.assertTrue(driver.findElements(loaderLocator).size() == 0, "Товар не обновился");
    }

    @Test
    public void addProductToTracker() throws InterruptedException {
        var auth = new Authorization(driver, wait);
        auth.webAppSignUpByEmail();

        var productDatabase = new ProductDatabase(driver, wait);
        driver.navigate().to(productDatabase.webAppUrl);
        Thread.sleep(2000);
        productDatabase.findProductsButton.click();
        productDatabase.addProductToTheTrackerButton.click();
        var productDatabaseAsin = productDatabase.getFirstAsinInDatabase();
        var productTrackerAsin = productDatabase.getFirstAsinInTracker();
        driver.navigate().to("https://amzscout.net/app/#/tracker");

        Assertions.assertEquals(productDatabaseAsin, productTrackerAsin, "ASIN в трэкере отличается");

        var productTracker = new ProductTracker(driver, wait);
        productTracker.deleteProductFromTrackerButton.click();
    }

    @Test
    public void addProductToTrackerByAsin() throws InterruptedException {
        var auth = new Authorization(driver, wait);
        auth.webAppSignUpByEmail();

        var productTracker = new ProductTracker(driver, wait);
        productTracker.open();

        if (productTracker.addProductToTrackerButton.isDisplayed() && productTracker.deleteProductFromTrackerButtons.size() >= 1) {
            for (int i = 1; i == productTracker.deleteProductFromTrackerButtons.size(); i++) {
                productTracker.deleteProductFromTrackerButton.click();
                Thread.sleep(1000);
                if (productTracker.addProductToTrackerButton.isDisplayed()) {
                    return;
                } else {
                    productTracker.addProductByAsinInput.sendKeys("B08PV4Z9V1");
                    productTracker.addProductToTrackerButton.click();
                    break;
                }
            }
        } else {
            productTracker.addProductByAsinInput.sendKeys("B08PV4Z9V1");
            productTracker.addProductToTrackerButton.click();
        }

        var addedProductToTracker = productTracker.getFirstAsinInTracker();
        Assertions.assertEquals("B08PV4Z9V1", addedProductToTracker, "Некорректно добавился товар в трэкер");

        productTracker.deleteProductFromTrackerButton.click();
    }

    @Test
    public void addProductToAsinLookup() throws InterruptedException {
        var auth = new Authorization(driver, wait);
        auth.webAppSignUpByEmail();

        var asinLookup = new AsinLookup(driver, wait);
        asinLookup.open();
        asinLookup.productAsinInput.sendKeys("B09JVPPB2C");
        asinLookup.findKeywordsButton.click();
        wait = new WebDriverWait(driver, 60);

        Assertions.assertTrue(asinLookup.resultsList.isDisplayed(), "Результаты не отображены");
    }

    @Test
    public void addProductToKeywordSearch() throws InterruptedException {
        var auth = new Authorization(driver, wait);
        auth.webAppSignUpByEmail();

        var keywordSearch = new KeywordSearch(driver, wait);
        keywordSearch.open();
        keywordSearch.keywordInput.sendKeys("office");
        keywordSearch.findKeywordsButton.click();
        wait = new WebDriverWait(driver, 60);
        var firstProductContainsKeyword = keywordSearch.firstFoundKeyword.getText();

        Assertions.assertTrue(firstProductContainsKeyword.contains("office"), "Отображаются некорректные кейворды");
    }
}
