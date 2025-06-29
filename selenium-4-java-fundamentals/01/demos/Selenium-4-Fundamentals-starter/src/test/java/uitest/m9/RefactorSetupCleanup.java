package uitest.m9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static helper.DriverFactory.newChromeDriver;
import static helper.Pages.LOANS;
import static org.testng.AssertJUnit.assertEquals;
import static wait.WaitingUtils.waitUntilVisible;

public class RefactorSetupCleanup {

    WebDriver driver;

    @BeforeMethod
    public void initDriver() {

        driver = newChromeDriver();

    }

    @Test
    public void refactoredTestDemo() {

        driver.get(LOANS);
        driver.findElement(By.id("borrow")).sendKeys("500");

        var message = waitUntilVisible(driver, By.id("result"), 6);
        assertEquals("You will pays us back 1000", message.getText());

    }


    @Test
    public void refactoredTestDemoDuplicate() {

        driver.get(LOANS);
        driver.findElement(By.id("borrow")).sendKeys("100");

        var message = waitUntilVisible(driver, By.id("result"), 6);
        assertEquals("You will pays us back 200", message.getText());

    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }


}
