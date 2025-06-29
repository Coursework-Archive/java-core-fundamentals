package uitest.m5;

import helper.DemoHelper;
import helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static helper.Pages.HOME;

public class ByCssTest {

    WebDriver driver;

    @Test
    public void byCssSelector() {

        driver = DriverFactory.newChromeDriver();
        driver.get(HOME);
        WebElement datePicker = driver.findElement(By.cssSelector("input[type=date]"));
        datePicker.sendKeys("10/12/2023");
        DemoHelper.pause();


    }

    @Test
    public void byCssSelector1() {

        driver = DriverFactory.newChromeDriver();
        driver.get(HOME);
        WebElement checkbox = driver.findElement(By.cssSelector("[type=checkbox]:not(:checked)"));
        checkbox.click();
        DemoHelper.pause();

    }


    @AfterMethod
    public void cleanUp(){
        driver.quit();
    }

}
