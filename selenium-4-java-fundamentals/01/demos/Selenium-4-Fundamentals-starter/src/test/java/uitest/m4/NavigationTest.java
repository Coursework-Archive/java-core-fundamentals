package uitest.m4;

import helper.DemoHelper;
import helper.DriverFactory;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;


import static helper.Pages.HOME;
import static helper.Pages.SAVINGS;


public class NavigationTest {



    @Test
    public void basicNavigation() {

        WebDriver driver = DriverFactory.newChromeDriver();

        driver.get(HOME);

        DemoHelper.pause();
        driver.get(SAVINGS);

        DemoHelper.pause();
        driver.navigate().back();

        DemoHelper.pause();
        driver.navigate().forward();

        driver.navigate().refresh();

        driver.quit();

    }

}
