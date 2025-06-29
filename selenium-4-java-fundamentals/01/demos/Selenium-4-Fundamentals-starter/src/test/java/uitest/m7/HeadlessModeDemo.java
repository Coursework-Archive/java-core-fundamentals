package uitest.m7;

import helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import static helper.Pages.HOME;


public class HeadlessModeDemo {



    @Test
    public void headlessDemo(){


        WebDriver driver = DriverFactory.newChromeDriver();
        driver.get(HOME);

        WebElement button = driver.findElement(By.id("register"));
        System.out.println(button.getText()); //proves that we loaded the page



        driver.quit();
    }

}
