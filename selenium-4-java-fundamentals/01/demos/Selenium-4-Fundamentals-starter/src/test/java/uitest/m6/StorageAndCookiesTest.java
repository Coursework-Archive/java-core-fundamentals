package uitest.m6;

import helper.DemoHelper;
import helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Driver;
import java.util.Set;

import static helper.Pages.*;

public class StorageAndCookiesTest {

    WebDriver driver;


    @Test
    public void storageTest() throws IOException {

        driver = DriverFactory.newChromeDriver();
        driver.get(HOME);

        WebElement first = driver.findElement(By.id("firstName"));
        WebElement last = driver.findElement(By.id("lastName"));
        WebElement save = driver.findElement(By.id("save"));

        first.sendKeys("Maria");
        last.sendKeys("Diaz");
        save.click();

        DemoHelper.pause();
        save.click();

        WebStorage webStorage = (WebStorage) driver;
        SessionStorage storage = webStorage.getSessionStorage();
        storage.keySet()
                .forEach(key -> System.out.println(key + "=" + storage.getItem(key)));
        DemoHelper.pause();
        driver.get(SAVINGS);
        driver.navigate().back();
        DemoHelper.pause();

        WebElement first1 = driver.findElement(By.id("firstName"));
        WebElement last1 = driver.findElement(By.id("lastName"));
        Assert.assertEquals(first1.getAttribute("value"), "Maria");
        Assert.assertEquals(last1.getAttribute("value"), "Diaz");

        storage.clear();
        driver.navigate().refresh();
        DemoHelper.pause();

        WebElement first2 = driver.findElement(By.id("firstName"));
        WebElement last2 = driver.findElement(By.id("lastName"));
        Assert.assertEquals(first2.getAttribute("value"), "");
        Assert.assertEquals(last2.getAttribute("value"), "");



        driver.quit();

    }

    @Test
    public void cookiesTest() {

        WebDriver driver = DriverFactory.newChromeDriver();
        WebDriver.Options options = driver.manage();

        Set<Cookie> cookies = options.getCookies();
        Cookie thing = options.getCookieNamed("thing");
        options.deleteAllCookies();


    }

}
