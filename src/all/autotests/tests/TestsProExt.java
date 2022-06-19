package all.autotests.tests;

import all.autotests.pages.Checkout;
import all.autotests.pages.GoogleAuthorization;
import all.autotests.pages.proExtPages.ProExtension;
import all.autotests.pages.webAppPages.Authorization;
import all.testsBase.TestBaseProExt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestsProExt extends TestBaseProExt {

    @Test
    public void proExtAuthByEmail() {
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
        pro.waitForHiddenLoader();

        Assertions.assertTrue(pro.hiddenLoaderProductList.isEnabled());
    }

    @Test
    public void proExtAuthByGoogle() {
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
        pro.waitForHiddenLoader();

        Assertions.assertTrue(pro.hiddenLoaderProductList.isEnabled());
    }

    @Test
    public void proExtAuthByChrome() {
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
        pro.waitForHiddenLoader();

        Assertions.assertTrue(pro.hiddenLoaderProductList.isEnabled());
    }

    @Test
    public void launchBubble() {
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

    @Test void checkoutOpen() throws InterruptedException {
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
}
