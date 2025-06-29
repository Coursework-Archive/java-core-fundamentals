package uitest.m6;

import helper.DemoHelper;
import helper.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static helper.Pages.HOME;

public class HandleDialogTest {


    WebDriver driver;


    @Test
    public void dismissAlert() {

        driver = DriverFactory.newChromeDriver();
        driver.get(HOME);

        WebElement first = driver.findElement(By.id("firstName"));
        WebElement last = driver.findElement(By.id("lastName"));

        first.sendKeys("John");
        last.sendKeys("Smith");

        DemoHelper.pause();
        driver.findElement(By.id("clear")).click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        DemoHelper.pause();

        Assert.assertEquals(first.getAttribute("value"), "John");
        Assert.assertEquals(last.getAttribute("value"), "Smith");

    }

    @Test
    public void acceptAlert() {

        driver = DriverFactory.newChromeDriver();
        driver.get(HOME);

        WebElement first = driver.findElement(By.id("firstName"));
        WebElement last = driver.findElement(By.id("lastName"));

        first.sendKeys("John");
        last.sendKeys("Smith");

        DemoHelper.pause();
        driver.findElement(By.id("clear")).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();
        DemoHelper.pause();

        Assert.assertEquals(first.getAttribute("value"), "");
        Assert.assertEquals(last.getAttribute("value"), "");

    }


    @AfterMethod
    public void cleanup() {
        driver.quit();
    }

}
