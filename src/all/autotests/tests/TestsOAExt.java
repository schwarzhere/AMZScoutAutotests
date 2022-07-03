package all.autotests.tests;

import all.autotests.pages.extensionsPages.OnlineArbitrage;
import all.autotests.testsBase.TestBaseOAExt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestsOAExt extends TestBaseOAExt {

    @Test
    public void oaExtAuthByGoogle() {
        var oa = new OnlineArbitrage(driver, wait);
        oa.authByGoogle();
    }

    @Test
    public void oaExtAuthByEmail() {
        var oa = new OnlineArbitrage(driver, wait);
        oa.authByEmail();

//        oa.closeBigBanner();

        assertTrue(oa.oaWindow.isDisplayed(), "Расширение не отображается");
    }

    @Test
    public void onboardingNewUserIsDisplayed() {
        var oa = new OnlineArbitrage(driver, wait);
        oa.authByEmail();

//        oa.closeBigBanner();

        assertTrue(oa.onboardingNewUser.isDisplayed(), "Онбординг не отображается");
    }

    @Test
    public void fbmBuyBoxPriceChanging() throws InterruptedException {
        var oa = new OnlineArbitrage(driver, wait);
        oa.authByEmail();

        oa.closeBigBanner();
        oa.skipOnboardingButton.click();
        Thread.sleep(2000);

        String defaultFbmBuyBoxPrice = oa.getFbmBuyBoxPrice();
        String defaultFbmFees = oa.getFbmFees();
        String defaultFbmNetProfit = oa.getFbmNetProfit();
        String defaultFbmMinimumNet = oa.getFbmMinimumNet();

        oa.fbmBuyBoxPriceInput.sendKeys("100");
        Thread.sleep(2000);
        String updatedFbmBuyBoxPrice = oa.getFbmBuyBoxPrice();
        String updatedFbmFees = oa.getFbmFees();
        String updatedFbmNetProfit = oa.getFbmNetProfit();
        String updatedFbmMinimumNet = oa.getFbmMinimumNet();

//        System.out.println("default values: " + defaultFbmBuyBoxPrice + " " + defaultFbmFees + " " + defaultFbmNetProfit +
//                " " + defaultFbmMinimumNet);
//
//        System.out.println("new values: " + newFbmBuyBoxPrice + " " + newFbmFees + " " + newFbmNetProfit + " "
//         + newFbmMinimumNet);

        Assertions.assertAll(
                () -> assertFalse(defaultFbmBuyBoxPrice.equals(updatedFbmBuyBoxPrice)),
                () -> assertFalse(defaultFbmFees.equals(updatedFbmFees)),
                () -> assertFalse(defaultFbmNetProfit.equals(updatedFbmNetProfit)),
                () -> assertFalse(defaultFbmMinimumNet.equals(updatedFbmMinimumNet)));
    }

    @Test
    public void fbaBuyBoxPriceChanging() throws InterruptedException {
        var oa = new OnlineArbitrage(driver, wait);
        oa.authByEmail();

        oa.closeBigBanner();
        oa.skipOnboardingButton.click();
        Thread.sleep(2000);

        String defaultFbaBuyBoxPrice = oa.getFbaBuyBoxPrice();
        String defaultFbaFees = oa.getFbaFees();
        String defaultFbaNetProfit = oa.getFbaNetProfit();
        String defaultProfitMargin = oa.getFbaProfitMargin();
        String defaultFbaMinimumNet = oa.getFbaMinimumNet();

        oa.fbaBuyBoxPriceInput.sendKeys("100");
        Thread.sleep(2000);
        String updatedFbaBuyBoxPrice = oa.getFbaBuyBoxPrice();
        String updatedFbaFees = oa.getFbaFees();
        String updatedFbaNetProfit = oa.getFbaNetProfit();
        String updatedProfitMargin = oa.getFbaProfitMargin();
        String updatedFbaMinimumNet = oa.getFbaMinimumNet();

//        System.out.println("default values: " + defaultFbaBuyBoxPrice + " " + defaultFbaFees + " " + defaultFbaNetProfit + " " +
//                        defaultProfitMargin + " " + defaultFbaMinimumNet);
//
//        System.out.println("new values: " + newFbaBuyBoxPrice + " " + newFbaFees + " " + newFbaNetProfit + " " +
//                newProfitMargin + " " + newFbaMinimumNet);

        Assertions.assertAll(
                () -> assertFalse(defaultFbaBuyBoxPrice.equals(updatedFbaBuyBoxPrice)),
                () -> assertFalse(defaultFbaFees.equals(updatedFbaFees)),
                () -> assertFalse(defaultFbaNetProfit.equals(updatedFbaNetProfit)),
                () -> assertFalse(defaultProfitMargin.equals(updatedProfitMargin)),
                () -> assertFalse(defaultFbaMinimumNet.equals(updatedFbaMinimumNet)));
    }

    @Test
    public void rankAndPriceHistoryDiagramOpen() {
        var oa = new OnlineArbitrage(driver, wait);
        oa.authByEmail();

        oa.closeBigBanner();
        oa.skipOnboardingButton.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(oa.rankAndPriceHistory);
        actions.build().perform();

        Assertions.assertTrue(oa.buyBoxHistory.isDisplayed(), "buybox history не открылся");
    }
}