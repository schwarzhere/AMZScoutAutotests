package all.autotests.tests;

import all.autotests.pages.Checkout;
import all.autotests.pages.extensionsPages.ProExtension;
import all.autotests.pages.webAppPages.Authorization;
import all.autotests.pages.webAppPages.ProductDatabase;
import all.autotests.testsBase.TestBaseProExt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestsProExt extends TestBaseProExt {

    @Test
    public void proExtAuthByEmail() {
        var pro = new ProExtension(driver, wait);
        pro.authByEmail();

        pro.waitForHiddenLoader();

        assertTrue(pro.hiddenLoaderProductList.isEnabled(),
                "Неудачная авторизация через Email");
    }

    @Test
    public void proExtAuthByGoogle() {
        var pro = new ProExtension(driver, wait);
        pro.authByGoogle();

        pro.waitForHiddenLoader();

        assertTrue(pro.hiddenLoaderProductList.isEnabled(),
                "Неудачная авторизация через Google");
    }

    @Test
    public void proExtAuthByChrome() {
        var pro = new ProExtension(driver, wait);
        pro.authByChrome();

        pro.waitForHiddenLoader();

        assertTrue(pro.hiddenLoaderProductList.isEnabled(),
                "Неудачная авторизация через Chrome");
    }

    @Test
    public void launchBubble() {
        var pro = new ProExtension(driver, wait);
        pro.authByEmail();

        driver.navigate().to(pro.randomAmazonPage);
        pro.launchBubble.click();

        assertTrue(pro.activeProExtWindow.isDisplayed());
    }

    @Test
    public void pricingOpen() throws InterruptedException {
        new Authorization(driver, wait).webAppSignUpByEmailForProExt();

        var pro = new ProExtension(driver, wait);
        driver.navigate().to(pro.randomAmazonPage);
        pro.launchBubble.click();
        pro.buyButtonTrialUser.click();
        pro.switchToFrame();
        pro.waitForPricing();
        assertTrue(pro.pricing.isDisplayed() && pro.buyNowYearly349BundleButton.isDisplayed());
    }

    @Test
    public void checkoutMonthly45ProExtOpen() throws InterruptedException {
        var auth = new Authorization(driver, wait);
        auth.webAppSignUpByEmailForProExt();

        var pro = new ProExtension(driver, wait);
        driver.navigate().to(pro.randomAmazonPage);
        pro.launchBubble.click();
        pro.buyButtonTrialUser.click();
        pro.switchToFrame();
        Thread.sleep(3000);
        pro.payMonthlyTab.click();
        pro.buyNowMonthly45ProExtButton.click();
        pro.switchWindow();

        var checkout = new Checkout(driver, wait);
        var expectedPrice = "$ 45.99";
        var actualPrice = pro.getCheckoutPriceValue();

        Assertions.assertAll(
                () -> assertTrue(checkout.paymentForm.isDisplayed()),
                () -> assertTrue(actualPrice.equals(expectedPrice),
                        "Некорректная цена в чекауте")
        );
    }

    @Test
    public void checkoutMonthly49BundleOpen() throws InterruptedException {
        var auth = new Authorization(driver, wait);
        auth.webAppSignUpByEmailForProExt();

        var pro = new ProExtension(driver, wait);
        driver.navigate().to(pro.randomAmazonPage);
        pro.launchBubble.click();
        pro.buyButtonTrialUser.click();
        pro.switchToFrame();
        Thread.sleep(3000);
        pro.payMonthlyTab.click();
        pro.buyNowMonthly48BundleButton.click();
        pro.switchWindow();

        var checkout = new Checkout(driver, wait);
        var expectedPrice = "$ 49.99";
        var actualPrice = pro.getCheckoutPriceValue();

        Assertions.assertAll(
                () -> assertTrue(checkout.paymentForm.isDisplayed()),
                () -> assertTrue(actualPrice.equals(expectedPrice),
                        "Некорректная цена в чекауте")
        );
    }

    @Test
    public void checkoutYearly197ProExtOpen() throws InterruptedException {
        var auth = new Authorization(driver, wait);
        auth.webAppSignUpByEmailForProExt();

        var pro = new ProExtension(driver, wait);
        driver.navigate().to(pro.randomAmazonPage);
        pro.launchBubble.click();
        pro.buyButtonTrialUser.click();
        pro.switchToFrame();
        Thread.sleep(3000);
        pro.buyNowYearly197ProExtButton.click();
        pro.switchWindow();

        var checkout = new Checkout(driver, wait);
        var expectedPrice = "$ 197.99";
        var actualPrice = pro.getCheckoutPriceValue();

        Assertions.assertAll(
                () -> assertTrue(checkout.paymentForm.isDisplayed()),
                () -> assertTrue(actualPrice.equals(expectedPrice),
                        "Некорректная цена в чекауте")
        );
    }

    @Test
    public void checkoutYearly349BundleOpen() throws InterruptedException {
        var auth = new Authorization(driver, wait);
        auth.webAppSignUpByEmailForProExt();

        var pro = new ProExtension(driver, wait);
        driver.navigate().to(pro.randomAmazonPage);
        pro.launchBubble.click();
        pro.buyButtonTrialUser.click();
        pro.switchToFrame();
        Thread.sleep(3000);
        pro.buyNowYearly349BundleButton.click();
        pro.switchWindow();

        var checkout = new Checkout(driver, wait);
        assertTrue(checkout.paymentForm.isDisplayed());
    }

    @Test
    public void checkoutLifetime499ProExtOpen() throws InterruptedException {
        var auth = new Authorization(driver, wait);
        auth.webAppSignUpByEmailForProExt();

        var pro = new ProExtension(driver, wait);
        driver.navigate().to(pro.randomAmazonPage);
        pro.launchBubble.click();
        pro.buyButtonTrialUser.click();
        pro.switchToFrame();
        Thread.sleep(3000);
        pro.payForALifetimeTab.click();
        pro.buyNowLifetime499ProExtButton.click();
        pro.switchWindow();

        var checkout = new Checkout(driver, wait);
        var expectedPrice = "$ 499";
        var actualPrice = pro.getCheckoutPriceValue();

        Assertions.assertAll(
                () -> assertTrue(checkout.paymentForm.isDisplayed()),
                () -> assertTrue(actualPrice.equals(expectedPrice),
                        "Некорректная цена в чекауте")
        );
    }

    @Test
    public void checkoutLifetime1499BundleOpen() throws InterruptedException {
        var auth = new Authorization(driver, wait);
        auth.webAppSignUpByEmailForProExt();

        var pro = new ProExtension(driver, wait);
        driver.navigate().to(pro.randomAmazonPage);
        pro.launchBubble.click();
        pro.buyButtonTrialUser.click();
        pro.switchToFrame();
        Thread.sleep(3000);
        pro.payForALifetimeTab.click();
        pro.buyNowLifetime1499BundleButton.click();
        pro.switchWindow();

        var checkout = new Checkout(driver, wait);
        var expectedPrice = "$ 1,499";
        var actualPrice = pro.getCheckoutPriceValue();

        Assertions.assertAll(
                () -> assertTrue(checkout.paymentForm.isDisplayed()),
                () -> assertTrue(actualPrice.equals(expectedPrice),
                        "Некорректная цена в чекауте")
        );
    }

    @Test
    public void nicheScoreOpen() {
        var pro = new ProExtension(driver, wait);
        pro.authByEmail();

        pro.waitForHiddenLoader();
        pro.nicheScore.click();

        assertTrue(pro.nicheScoreCircleOverlay.isDisplayed());
    }

    @Test
    public void nicheHistoryOpen() {
        var pro = new ProExtension(driver, wait);
        pro.authByEmail();

        pro.waitForHiddenLoader();
        pro.nicheHistory.click();

        assertTrue(pro.nicheHistoryDiagram.isDisplayed());
    }

    @Test
    public void nicheKeywordsOpen() {
        var pro = new ProExtension(driver, wait);
        pro.authByEmail();

        pro.waitForHiddenLoader();
        pro.nicheKeywords.click();

        assertTrue(pro.nicheKeywordsCloud.isDisplayed());
    }

    @Test
    public void goToNextPage() {
        var pro = new ProExtension(driver, wait);
        pro.authByEmail();
        driver.navigate().to(pro.pageWithMoreThan24products);
        pro.launchBubble.click();

        pro.waitForLoader();
        pro.waitForHiddenLoader();
        var productCount = pro.getProductsListCount();
        pro.nextPageButton.click();

        pro.waitForHiddenLoader();
        var productCountWithNextPage = pro.getProductsListCount();

        assertTrue(productCountWithNextPage > productCount,
                "Следующая страница не подгрузилась");
    }

    @Test
    public void totalItemsCountHeaderIsDisplayed() {
        var pro = new ProExtension(driver, wait);
        pro.authByEmail();

        pro.waitForHiddenLoader();
        int totalItemCount = Integer.parseInt(pro.getTotalItemCountHeader());

        assertTrue(totalItemCount > 0,
                "Не отображается общее количество продуктов");
    }

    @Test
    public void avgMonthlySalesHeaderIsDisplayed() {
        var pro = new ProExtension(driver, wait);
        pro.authByEmail();

        pro.waitForHiddenLoader();
        String avgMonthlySales = pro.getAvgMonthlySalesHeader();

        assertTrue(avgMonthlySales != "N/A",
                "Не отображаются средние продажи по нише");
    }

    @Test
    public void avgSalesRankHeaderIsDisplayed() {
        var pro = new ProExtension(driver, wait);
        pro.authByEmail();

        pro.waitForHiddenLoader();
        String avgSalesRank = pro.getAvgSalesRankHeader();

        assertTrue(avgSalesRank != "N/A",
                "Не отображается средний ранг по нише");
    }

    @Test
    public void avgPriceHeaderIsDisplayed() {
        var pro = new ProExtension(driver, wait);
        pro.authByEmail();

        pro.waitForHiddenLoader();
        String avgPrice = pro.getAvgPriceHeader();

        assertTrue(avgPrice != "N/A",
                "Не отображается средняя цена по нише");
    }

    @Test
    public void avgReviewsIsDisplayed() {
        var pro = new ProExtension(driver, wait);
        pro.authByEmail();

        pro.waitForHiddenLoader();
        String avgReviews = pro.getAvgReviewsHeader();

        assertTrue(avgReviews != "N/A",
                "Не отображается среднее количество комментариев по нише");
    }

    @Test
    public void nicheScoreIsDisplayed() {
        var pro = new ProExtension(driver, wait);
        pro.authByEmail();

        pro.waitForNicheScoreTooltip();
        pro.waitForNicheScore();
        int nicheScoreValue = Integer.parseInt(pro.getNicheScoreValueHeader());
        pro.waitForHiddenLoader();

        assertTrue(pro.nicheScoreCircleHeader.isDisplayed() && nicheScoreValue > 0,
                "Niche Score не подгрузился");
    }

    @Test
    public void saturationScoreIsDisplayed() {
        var pro = new ProExtension(driver, wait);
        pro.authByEmail();

        int saturationScoreValue = Integer.parseInt(pro.getSaturationScoreCircleValueHeader());
        pro.waitForHiddenLoader();

        assertTrue(pro.saturationScoreCircleHeader.isDisplayed() && saturationScoreValue > 0,
                "Оценка видимости ниши не подгрузилась");
    }

    @Test
    public void searchProductsInSearchBar() {
        var pro = new ProExtension(driver, wait);
        pro.authByEmail();

        pro.waitForHiddenLoader();
        pro.searchBar.clear();
        pro.searchBar.sendKeys("xbox controller");
        pro.searchBarButton.click();

        String currentUrl = driver.getCurrentUrl();
        String newUrl = "https://www.amazon.com/s?k=xbox+controller&ref=nb_sb_noss";

        assertEquals(currentUrl, newUrl);
    }

    @Test
    public void calculatorTotalFBAFeeChanging() throws InterruptedException {
        var pro = new ProExtension(driver, wait);
        pro.authByEmail();

        pro.waitForHiddenLoader();
        pro.profitCalculator.click();
        String defaultTotalFBAFeeValue = pro.getTotalFBAFeeValueCalculator();
        System.out.println(defaultTotalFBAFeeValue);
        pro.productPriceInputCalculator.clear();
        pro.productPriceInputCalculator.sendKeys("10035");
        Thread.sleep(3000);
        String changedTotalFBAFeeValue = pro.getTotalFBAFeeValueCalculator();
        System.out.println(changedTotalFBAFeeValue);

        Assertions.assertFalse(defaultTotalFBAFeeValue == changedTotalFBAFeeValue,
                "Значение Total FBA Fee не изменилось");
    }

    @Test
    public void calculatorEstMonthlyProfitChanging() throws InterruptedException {
        var pro = new ProExtension(driver, wait);
        pro.authByEmail();

        pro.waitForHiddenLoader();
        pro.profitCalculator.click();
        pro.waitForEstMonthlyProfitCalculator();
        String defaultEstMonthlyProfit = pro.getEstMonthlyProfitValueCalculator();
        System.out.println(defaultEstMonthlyProfit);
        pro.productCostInputCalculator.sendKeys("20");
        Thread.sleep(2000);
        String changedEstMonthlyProfit = pro.getEstMonthlyProfitValueCalculator();
        System.out.println(changedEstMonthlyProfit);

        Assertions.assertFalse(defaultEstMonthlyProfit == changedEstMonthlyProfit,
                "Значение Est Monthly Profit не изменилось");
    }

    @Test
    public void trialLicenceIsActive() {
        var pro = new ProExtension(driver, wait);
        pro.authByEmail();

        pro.waitForHiddenLoader();
        pro.profitCalculator.click();

        Assertions.assertAll(
                () -> assertTrue(pro.productPriceInputCalculator. isDisplayed()),
                () -> assertTrue(pro.parsedProductsList.size() > 15)
        );
    }

    @Test
    public void searchForRandomProductIdea() {
        var pro = new ProExtension(driver, wait);
        pro.authByEmail();

        pro.waitForHiddenLoader();

        pro.productIdeasButton.click();
        pro.randomProductIdeaButton.click();

        pro.waitForHiddenLoader();

        assertTrue(pro.hiddenLoaderProductList.isEnabled(),
                "Не спарсилась новая ниша");
    }

    @Test
    public void searchForTop1000Bestsellers() {
        var pro = new ProExtension(driver, wait);
        pro.authByEmail();

        pro.productIdeasButton.click();
        pro.top1000BestsellersButton.click();

        pro.switchWindow();

        var productDatabase = new ProductDatabase(driver, wait);
        int actualRank = Integer.parseInt(productDatabase.getFirstProductRank());

        Assertions.assertTrue((actualRank >= 1) && (actualRank) <= 1000,
                "Отображены продукты с некорректным рангом");
    }

    @Test
    public void searchForNewAndTrendingItems() {
        var pro = new ProExtension(driver, wait);
        pro.authByEmail();

        pro.productIdeasButton.click();
        pro.newAndTrendingItemsButton.click();

        pro.switchWindow();
        var productDatabase = new ProductDatabase(driver, wait);

        Assertions.assertTrue((productDatabase.newMarkMarkList.size() > 3)
                        && (productDatabase.trendingMarkMarkList.size() > 3),
                "Фильтр New and Trending не был применен");
    }

    @Test
    public void checkAllColumns() {
        var pro = new ProExtension(driver, wait);
        pro.authByEmail();

        pro.personalizeViewButton.click();
        pro.markAllEmptyCheckboxesPersonalizeView();
        pro.waitForHiddenLoader();

        Assertions.assertAll(
                () -> assertTrue(pro.avgMonthlyRevenueHeader.isDisplayed()),
                () -> assertTrue(pro.avgMarginImpactHeader.isDisplayed()),
                () -> assertTrue(pro.bsr30valuesList.size() > 10),
                () -> assertTrue(pro.price30valuesList.size() > 10),
                () -> assertTrue(pro.minPriceValuesList.size() > 10),
                () -> assertTrue(pro.netPriceValuesList.size() > 10),
                () -> assertTrue(pro.bestsellerColumnList.size() > 10),
                () -> assertTrue(pro.inventoryColumnTitle.isDisplayed()),
                () -> assertTrue(pro.inventoryValuesList.size() > 10),
                () -> assertTrue(pro.ebcValuesList.size() > 10),
                () -> assertTrue(pro.oversizeValuesList.size() > 10));

        pro.firstProductName.click();
        pro.switchWindow();
        pro.launchBubble.click();
        pro.waitForHiddenLoader();

        Assertions.assertAll(
                () -> assertTrue(pro.parsedProductsList.size() == 1)
        );
    }

    @Test
    public void productHistoryOpen() {
        var pro = new ProExtension(driver, wait);
        pro.authByEmail();

        pro.waitForHiddenLoader();

        var firstProductName = pro.getFirstProductName();
        pro.productHistoryButton.click();

        Assertions.assertAll(
                () -> assertTrue(pro.productHistoryModal.isDisplayed()),
                () -> assertEquals("- " + firstProductName, pro.getProductNameInProductHistory())
        );
    }

    @Test
    public void checkProductScoreForPLnoDataTooltipText() {
        var pro = new ProExtension(driver, wait);
        pro.authByEmail();

        pro.waitForHiddenLoader();

        pro.checkProductScoreForPLnoDataTooltipText();
    }

    @Test
    public void checkProductScoreForResellingNoDataTooltipText() {
        var pro = new ProExtension(driver, wait);
        pro.authByEmail();

        pro.waitForHiddenLoader();

        pro.checkProductScoreForResellingNoDataTooltipText();
    }


}
