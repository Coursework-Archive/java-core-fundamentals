package uitest.m6;

import helper.DemoHelper;
import helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.sql.Driver;

import static helper.Pages.LOANS;

public class ExecuteJavaScriptDemo {

    WebDriver driver;

    @Test
    public void firstAttempt() {
        driver = DriverFactory.newChromeDriver();
        driver.get(LOANS);

        var button = driver.findElement(By.id(("apply")));
        DemoHelper.pause();
        button.click();
    }


}
