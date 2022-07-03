package all.autotests.tests;

import all.autotests.pages.extensionsPages.QuickView;
import all.autotests.testsBase.TestBaseQuickViewExt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestsQuickView extends TestBaseQuickViewExt {

    @Test
    public void qvExtAuthByEmail() {
        var qv = new QuickView(driver, wait);
        qv.authByEmail();

        qv.closeBigBanner();

        Assertions.assertTrue(qv.qvBlock.isDisplayed(), "Неудачная авторизация");
    }

    @Test
    public void qvExtAuthByGoogle() {
        var qv = new QuickView(driver, wait);
        qv.authByGoogle();

        qv.closeBigBanner();

        Assertions.assertTrue(qv.qvBlock.isDisplayed(), "Неудачная авторизация");
    }

//    @Test
//    public void getFullVersionCheckout() throws InterruptedException {
//        var auth = new Authorization(driver, wait);
//        auth.webAppSignUpByEmail();
//        driver.navigate().to("https://www.amazon.com/s?i=specialty-aps&bbn=16225007011&r" +
//                "h=n%3A16225007011%2Cn%3A1292115011&ref=nav_em__nav_desktop_sa_intl_monitors_0_2_6_8");
//
//        var qv = new QuickView(driver, wait);
//        qv.closeAuthWindow.click();
//        driver.navigate().refresh();
//        qv.getFullVersionButton.click();
//
//    }
}
