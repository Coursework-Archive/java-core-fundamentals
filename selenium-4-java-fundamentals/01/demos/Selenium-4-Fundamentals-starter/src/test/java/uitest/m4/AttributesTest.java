package uitest.m4;

import helper.DemoHelper;
import helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static helper.Pages.HOME;


public class AttributesTest {

    @Test
    public void isEnabledTest() {

        WebDriver driver = DriverFactory.newChromeDriver();
        driver.get(HOME);

        WebElement textarea = driver.findElement(By.id("textarea"));
        Assert.assertFalse(textarea.isEnabled());

        if(textarea.isEnabled()) {

            textarea.sendKeys("test");
            DemoHelper.pause();
        }

        driver.quit();
    }

    @Test
    public void isDisplayedTest() {

        WebDriver driver = DriverFactory.newChromeDriver();
        driver.get(HOME);

        List<WebElement> feedback = driver.findElements(By.className("invalid-feedback"));

        print("Feedback", feedback.get(0).getText());
        print("Feedback", feedback.get(1).getText());
        DemoHelper.pause();

        driver.findElement(By.id("register")).click();
        print("Feedback", feedback.get(0).getText());
        print("Feedback", feedback.get(1).getText());
        DemoHelper.pause();

        //single element
//        WebElement feedback = driver.findElement(By.className("invalid-feedback"));
//        Assert.assertFalse(feedback.isDisplayed());
//        DemoHelper.pause();
//
//        driver.findElement(By.id("register")).click();
//        Assert.assertTrue(feedback.isDisplayed());
//        DemoHelper.pause();


        driver.quit();

    }

    private void print(String expectedText, String actualText ) {

        System.out.println(expectedText + ": " + actualText);

    }

}
