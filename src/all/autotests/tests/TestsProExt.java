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

        Assertions.assertTrue(pro.hiddenLoaderProductList.isEnabled());
    }

    @Test
    public void proExtAuthByGoogle() {
        var pro = new ProExtension(driver, wait);
        pro.authByGoogle();

        pro.waitForHiddenLoader();

        Assertions.assertTrue(pro.hiddenLoaderProductList.isEnabled());
    }

    @Test
    public void proExtAuthByChrome() {
        var pro = new ProExtension(driver, wait);
        pro.authByChrome();

        pro.waitForHiddenLoader();

        Assertions.assertTrue(pro.hiddenLoaderProductList.isEnabled());
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
}
