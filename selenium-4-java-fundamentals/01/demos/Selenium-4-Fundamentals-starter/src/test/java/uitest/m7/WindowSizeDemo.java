package uitest.m7;

import helper.DemoHelper;
import helper.DriverFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import static helper.Pages.HOME;

public class WindowSizeDemo {


    @Test
    public void implicitWaitTest() {

        WebDriver driver = DriverFactory.newChromeDriver();
        WebDriver.Window window = driver.manage().window();

        window.maximize();
        DemoHelper.pause();
        window.maximize();
        DemoHelper.pause();
        window.setSize(new Dimension(1200, 800));
        DemoHelper.pause();

        driver.get(HOME);

        DemoHelper.pause();
        driver.quit();
    }


}
