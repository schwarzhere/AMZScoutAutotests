package all.autotests.tests;

import all.autotests.pages.Checkout;
import all.autotests.pages.proExtPages.ProExtension;
import all.autotests.pages.webAppPages.Authorization;
import all.autotests.testsBase.TestBaseProExt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestsProExt extends TestBaseProExt {

    @Test
    public void proExtAuthByEmail() {
        var pro = new ProExtension(driver, wait);
        pro.authByEmail();

        pro.waitForHiddenLoader();

        Assertions.assertTrue(pro.hiddenLoaderProductList.isEnabled(),
                "Неудачная авторизация через Email");
    }

    @Test
    public void proExtAuthByGoogle() {
        var pro = new ProExtension(driver, wait);
        pro.authByGoogle();

        pro.waitForHiddenLoader();

        Assertions.assertTrue(pro.hiddenLoaderProductList.isEnabled(),
                "Неудачная авторизация через Google");
    }

    @Test
    public void proExtAuthByChrome() {
        var pro = new ProExtension(driver, wait);
        pro.authByChrome();

        pro.waitForHiddenLoader();

        Assertions.assertTrue(pro.hiddenLoaderProductList.isEnabled(),
                "Неудачная авторизация через Chrome");
    }

    @Test
    public void launchBubble() {
        var pro = new ProExtension(driver, wait);
        pro.authByEmail();

        driver.navigate().to(pro.randomAmazonPage);
        pro.launchBubble.click();

        Assertions.assertTrue(pro.activeProExtWindow.isDisplayed());
    }

    @Test
    public void pricingOpen() throws InterruptedException {
        var auth = new Authorization(driver, wait);
        auth.webAppSignUpByEmail();

        var pro = new ProExtension(driver, wait);
        driver.navigate().to(pro.randomAmazonPage);
        pro.launchBubble.click();
        pro.buyButtonTrialUser.click();
        pro.switchToFrame();

        Assertions.assertTrue(pro.pricing.isDisplayed() && pro.buyNowPricingButton.isDisplayed());
    }

    @Test
    public void checkoutOpen() throws InterruptedException {
        var auth = new Authorization(driver, wait);
        auth.webAppSignUpByEmail();

        auth.switchWindow();
        driver.close();
        auth.switchWindow();

        var pro = new ProExtension(driver, wait);
        driver.navigate().to(pro.randomAmazonPage);
        pro.launchBubble.click();
        pro.buyButtonTrialUser.click();
        pro.switchToFrame();
        Thread.sleep(3000);
        pro.buyNowPricingButton.click();
        pro.switchWindow();

        var checkout = new Checkout(driver, wait);
        Assertions.assertTrue(checkout.paymentForm.isDisplayed());
    }

    @Test
    public void nicheScoreOpen() {
        var pro = new ProExtension(driver, wait);
        pro.authByEmail();

        pro.waitForHiddenLoader();
        pro.nicheScore.click();

        Assertions.assertTrue(pro.nicheScoreCircleOverlay.isDisplayed());
    }

    @Test
    public void nicheHistoryOpen() {
        var pro = new ProExtension(driver, wait);
        pro.authByEmail();

        pro.waitForHiddenLoader();
        pro.nicheHistory.click();

        Assertions.assertTrue(pro.nicheHistoryDiagram.isDisplayed());
    }

    @Test
    public void nicheKeywordsOpen() {
        var pro = new ProExtension(driver, wait);
        pro.authByGoogle();

        pro.waitForHiddenLoader();
        pro.nicheKeywords.click();

        Assertions.assertTrue(pro.nicheKeywordsCloud.isDisplayed());
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

        Assertions.assertTrue(productCountWithNextPage > productCount,
                "Следующая страница не подгрузилась");
    }

    @Test
    public void totalItemsCountHeaderIsDisplayed() {
        var pro = new ProExtension(driver, wait);
        pro.authByGoogle();

        pro.waitForHiddenLoader();
        int totalItemCount = Integer.parseInt(pro.getTotalItemCountHeader());

        Assertions.assertTrue(totalItemCount > 0,
                "Не отображается общее количество продуктов");
    }

    @Test
    public void avgMonthlySalesHeaderIsDisplayed() {
        var pro = new ProExtension(driver, wait);
        pro.authByGoogle();

        pro.waitForHiddenLoader();
        String avgMonthlySales = pro.getAvgMonthlySalesHeader();

        Assertions.assertTrue(avgMonthlySales != "N/A",
                "Не отображаются средние продажи по нише");
    }

    @Test
    public void avgSalesRankHeaderIsDisplayed() {
        var pro = new ProExtension(driver, wait);
        pro.authByGoogle();

        pro.waitForHiddenLoader();
        String avgSalesRank = pro.getAvgSalesRankHeader();

        Assertions.assertTrue(avgSalesRank != "N/A",
                "Не отображается средний ранг по нише");
    }

    @Test
    public void avgPriceHeaderIsDisplayed() {
        var pro = new ProExtension(driver, wait);
        pro.authByGoogle();

        pro.waitForHiddenLoader();
        String avgPrice = pro.getAvgPriceHeader();

        Assertions.assertTrue(avgPrice != "N/A",
                "Не отображается средняя цена по нише");
    }

    @Test
    public void avgReviewsIsDisplayed() {
        var pro = new ProExtension(driver, wait);
        pro.authByGoogle();

        pro.waitForHiddenLoader();
        String avgReviews = pro.getAvgReviewsHeader();

        Assertions.assertTrue(avgReviews != "N/A",
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

        Assertions.assertTrue(pro.nicheScoreCircleHeader.isDisplayed() && nicheScoreValue > 0,
                "Niche Score не подгрузился");
    }

    @Test
    public void saturationScoreIsDisplayed() {
        var pro = new ProExtension(driver, wait);
        pro.authByChrome();

        int saturationScoreValue = Integer.parseInt(pro.getSaturationScoreCircleValueHeader());
        pro.waitForHiddenLoader();

        Assertions.assertTrue(pro.saturationScoreCircleHeader.isDisplayed() && saturationScoreValue > 0,
                "Оценка видимости ниши не подгрузилась");
    }

    @Test
    public void searchProductsInSearchBar() {
        var pro = new ProExtension(driver, wait);
        pro.authByChrome();

        pro.waitForHiddenLoader();
        pro.searchBar.clear();
        pro.searchBar.sendKeys("xbox controller");
        pro.searchBarButton.click();

        String currentUrl = driver.getCurrentUrl();
        String newUrl = "https://www.amazon.com/s?k=xbox+controller&ref=nb_sb_noss";

        Assertions.assertEquals(currentUrl, newUrl);
    }

    @Test
    public void calculatorTotalFBAFeeChanging() throws InterruptedException {
        var pro = new ProExtension(driver, wait);
        pro.authByChrome();

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
}
