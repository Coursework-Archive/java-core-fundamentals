package uitest.m9;

import helper.DevToolFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.Test;
import wait.WaitingUtils;

import java.time.Duration;

import static helper.DriverFactory.newChromeDriver;
import static helper.DriverFactory.newDevice;
import static helper.Pages.LOANS;
import static org.testng.AssertJUnit.assertEquals;

public class BasicRefactoringDemo {


    @Test
    public void beforeRefactoring() {

        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*", "headless=true");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();

    }


    @Test
    public void newDriverAndToolsDemo() {

        WebDriver chromeDriver = newChromeDriver();

        WebDriver nexus = newDevice("nexus 5");

        DevTools tools = DevToolFactory.newChromeDevTool(chromeDriver);

    }


    @Test
    public void refactoredTestDemo() {

        WebDriver driver = newChromeDriver();
        driver.get(LOANS);
        driver.findElement(By.id("borrow")).sendKeys("500");

        var message = WaitingUtils.waitUntilVisible(driver, By.id("result"), 6);
        assertEquals("You will pays us back 1000", message.getText());
        driver.quit();


    }


}
