package uitest.m8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.emulation.Emulation;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Map;
import java.util.Optional;

import static helper.Pages.HOME;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class GeoLocationDemo {

    @Test
    public void geoLocationDemo() {
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        ChromeDriver driver = new ChromeDriver(options);
        DevTools tools = ((ChromeDriver) driver).getDevTools();
        tools.createSession();

//        tools.send(Emulation.setGeolocationOverride(Optional.of(51.49937053990275),
//                        Optional.of(-0.09953871364387087), Optional.of(100)));

        driver.get(HOME);
        WebElement location = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(visibilityOfElementLocated(By.id("location")));

        Assert.assertEquals(location.getText(), "You are visiting us from London");



        tools.close();
        driver.quit();


    }
}
