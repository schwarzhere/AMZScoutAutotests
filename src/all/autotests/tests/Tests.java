package all.autotests.tests;

import all.autotests.pages.Checkout;
import all.autotests.pages.Header;
import all.autotests.pages.mainPage.MainPage;
import all.autotests.pages.webAppPages.Sidebar;
import all.autotests.testsBase.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests extends TestBase {

    @Test
    public void signUpInCtaForm() throws InterruptedException {
        var page = new MainPage(driver, wait);
        page.openMainPage();
        Thread.sleep(2000);
        page.mainPageSignUpCta();
        Thread.sleep(3000);
        page.switchWindow();

        var sidebar = new Sidebar(driver, wait);
        Assertions.assertTrue(sidebar.sidebar.isDisplayed());
    }

    @Test
    public void signUpInCtaFormSellersBundle() throws InterruptedException {
        var page = new MainPage(driver, wait);
        page.openSellersBundlePage();
        Thread.sleep(2000);
        page.mainPageSignUpCta();
        Thread.sleep(3000);
        page.switchWindow();

        var sidebar = new Sidebar(driver, wait);
        Assertions.assertTrue(sidebar.sidebar.isDisplayed());
    }

    @Test
    public void checkoutAnnualBundle() {
        var header = new Header(driver, wait);
        header.open();
        header.pricing.click();
        header.annualBundleBuyNowButton.click();

        var checkout = new Checkout(driver, wait);
        Assertions.assertTrue(checkout.paymentFormNoAuth.isDisplayed());
    }
}


