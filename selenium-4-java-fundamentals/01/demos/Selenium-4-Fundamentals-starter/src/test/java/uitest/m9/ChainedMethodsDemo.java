package uitest.m9;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoansVersion2;

import static helper.DriverFactory.newChromeDriver;
import static pages.Loans.Period.ONE_MONTH;

public class ChainedMethodsDemo {

    WebDriver driver;

    @BeforeMethod
    public void initDriver() { driver = newChromeDriver(); }

    @Test
    public void loansTest() {
        var page = pages.LoansVersion2.loansPage(driver);

        page.goTo()
                .enterBorrowAmount("500")
                .selectTimePeriod(ONE_MONTH)
                .getResultMessageText();
    }


    @AfterMethod
    public void closeDriver() { driver.quit(); }

}
