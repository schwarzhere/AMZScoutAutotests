package all.autotests.tests;

import all.autotests.pages.extensionsPages.OnlineArbitrage;
import all.autotests.testsBase.TestBaseOAExt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestOAExt extends TestBaseOAExt {

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
        String newFbmBuyBoxPrice = oa.getFbmBuyBoxPrice();
        String newFbmFees = oa.getFbmFees();
        String newFbmNetProfit = oa.getFbmNetProfit();
        String newFbmMinimumNet = oa.getFbmMinimumNet();

//        System.out.println("default values: " + defaultFbmBuyBoxPrice + " " + defaultFbmFees + " " + defaultFbmNetProfit +
//                " " + defaultFbmMinimumNet);
//
//        System.out.println("new values: " + newFbmBuyBoxPrice + " " + newFbmFees + " " + newFbmNetProfit + " "
//         + newFbmMinimumNet);

        Assertions.assertAll(
                () -> assertFalse(defaultFbmBuyBoxPrice.equals(newFbmBuyBoxPrice)),
                () -> assertFalse(defaultFbmFees.equals(newFbmFees)),
                () -> assertFalse(defaultFbmNetProfit.equals(newFbmNetProfit)),
                () -> assertFalse(defaultFbmMinimumNet.equals(newFbmMinimumNet)));
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
        String newFbaBuyBoxPrice = oa.getFbaBuyBoxPrice();
        String newFbaFees = oa.getFbaFees();
        String newFbaNetProfit = oa.getFbaNetProfit();
        String newProfitMargin = oa.getFbaProfitMargin();
        String newFbaMinimumNet = oa.getFbaMinimumNet();

//        System.out.println("default values: " + defaultFbaBuyBoxPrice + " " + defaultFbaFees + " " + defaultFbaNetProfit + " " +
//                        defaultProfitMargin + " " + defaultFbaMinimumNet);
//
//        System.out.println("new values: " + newFbaBuyBoxPrice + " " + newFbaFees + " " + newFbaNetProfit + " " +
//                newProfitMargin + " " + newFbaMinimumNet);

        Assertions.assertAll(
                () -> assertFalse(defaultFbaBuyBoxPrice.equals(newFbaBuyBoxPrice)),
                () -> assertFalse(defaultFbaFees.equals(newFbaFees)),
                () -> assertFalse(defaultFbaNetProfit.equals(newFbaNetProfit)),
                () -> assertFalse(defaultProfitMargin.equals(newProfitMargin)),
                () -> assertFalse(defaultFbaMinimumNet.equals(newFbaMinimumNet)));
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