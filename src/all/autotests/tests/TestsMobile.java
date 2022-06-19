package all.autotests.tests;

import all.autotests.pages.Checkout;
import all.autotests.pages.webAppPages.*;
import all.autotests.testsBase.TestBaseMobile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class TestsMobile extends TestBaseMobile {

    @Test
    public void menuBurgerListCheck() throws InterruptedException {
        var auth = new Authorization(driver, wait);
        auth.webAppSignUpByEmail();

        var header = new Header(driver, wait);
        header.menuBurger.click();

        var sidebar = new Sidebar(driver, wait);
        Assertions.assertTrue(sidebar.sidebarList.isDisplayed());
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
        String pricingWindow = driver.getWindowHandle();
        pricing.payMonthlyButtonPricing.click();
        pricing.monthlyBundleBuyNowButton.click();

        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        var checkout = new Checkout(driver, wait);
        Assertions.assertTrue(checkout.paymentForm.isDisplayed());
    }

    @Test
    public void openFiltersDatabase() throws InterruptedException {
        var auth = new Authorization(driver, wait);
        auth.webAppSignUpByEmail();

        var productDatabaseMobile = new ProductDatabaseMobile(driver, wait);
        productDatabaseMobile.openFiltersButton.click();

        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class='burger active']")).isDisplayed());
    }

    @Test
    public void findProductsDatabase() throws InterruptedException {
        var auth = new Authorization(driver, wait);
        auth.webAppSignUpByEmail();

        var productDatabaseMobile = new ProductDatabaseMobile(driver, wait);
        productDatabaseMobile.openFiltersButton.click();
        productDatabaseMobile.findProductsFiltersButton.click();
        Thread.sleep(7000);
        Assertions.assertTrue(productDatabaseMobile.elementIsNotPresent("//div[@class='loader ng-star-inserted']"));
    }

    @Test
    public void webAppChangeToChina() throws InterruptedException {
        var auth = new Authorization(driver, wait);
        auth.webAppSignUpByEmail();

        var header = new Header(driver, wait);
        header.changeToEngLanguageButton.click();
        header.changeToChinaLanguageButton.click();

        Assertions.assertEquals("产品数据库", header.getCnMarketplaceListTitle(), "Текст различается");
    }

//    @Test
//    public void teststststs() {
//        var page = new ProExtension(driver, wait);
//        driver.navigate().to("https://www.amazon.com/s?k=Outdoor+Plastic+Straw+Rug");
//        page.signInByEmailButton.click();
//    }

}
