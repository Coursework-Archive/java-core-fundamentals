package uitest.m6;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static helper.Pages.LOANS;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class WaitingTest {

    WebDriver driver;

    @Test
    public void implicitWaitTest() {

        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get(LOANS);

        //implicit wait makes the findElement method wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        //element in HTML not dynamically displayed with js
        driver.findElement(By.id("borrow")).sendKeys("500");

        //Assertion will not work (isDisplayed, isEnabled) the element is found in HTML before the wait time and it is
        //not displayed at this time
//        Assert.assertTrue(driver.findElement(By.id("result")).isDisplayed());

        //When it comes to actions (click(), tyoe()) the implicit wait will force Selenium to wait for it to become
        //visible and interactable
        driver.findElement(By.id("result")).click();

    }


    @Test
    public void explicitWaitTest() {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get(LOANS);
        driver.findElement(By.id("borrow")).sendKeys("500");

        WebElement result = waitUntilClickable(driver, By.id("result"));
        Assert.assertTrue(result.isDisplayed());
        result.click();

    }

    public static WebElement waitUntilClickable(WebDriver driver, By locator) {

        return new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(elementToBeClickable(locator));
    }


    @Test
    public void fluentWaitTest() {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get(LOANS);
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(6))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);

        driver.findElement(By.id("borrow")).sendKeys("500");

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        element.click();

    }


    @AfterMethod
    public void cleanup() { driver.quit(); }




}
