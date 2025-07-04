package uitest.m4;

import helper.DemoHelper;
import helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static helper.Pages.HOME;

public class TypingTest {

    @Test
    public void typingTest() {

        WebDriver driver = DriverFactory.newChromeDriver();
        driver.get(HOME);

        WebElement first = driver.findElement(By.id("firstName"));
        WebElement last = driver.findElement(By.id("lastName"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement dob = driver.findElement(By.id("dob"));

        first.sendKeys("Sofia");
        DemoHelper.pause();

        last.sendKeys("Diaz");
        DemoHelper.pause();

        email.sendKeys("sofia@email.com");
        DemoHelper.pause();

        dob.sendKeys("22/03/2022");
        DemoHelper.pause();

        driver.quit();



    }
}
