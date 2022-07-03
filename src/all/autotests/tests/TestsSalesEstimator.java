package all.autotests.tests;

import all.autotests.pages.SalesEstimator;
import all.autotests.testsBase.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestsSalesEstimator extends TestBase {

    @Test
    public void usMarketplaceSalesCheck() throws InterruptedException {
        var se = new SalesEstimator(driver, wait);
        se.open();

        Thread.sleep(1500);
        se.openCategoriesList();
        se.selectUsCategory();
        se.valueInput.sendKeys("123");
        se.calculateSalesButtonClick();
        int salesPerMonthValue = Integer.parseInt(se.getSalesPerMonthValue());

        Assertions.assertTrue(salesPerMonthValue > 5000,"Количество продаж не отобразилось");
    }
}
