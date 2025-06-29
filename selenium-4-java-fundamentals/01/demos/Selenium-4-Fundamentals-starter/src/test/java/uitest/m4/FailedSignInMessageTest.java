package uitest.m4;

import helper.DriverFactory;
import net.bytebuddy.matcher.ElementMatcher;
import org.junit.After;
import org.junit.Before;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.*;
import java.util.regex.Matcher;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


public class FailedSignInMessageTest {

    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;


    @Before
    public void setUp() {

        driver = DriverFactory.newChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();

    }

    @After
    public void tearDown() { driver.quit(); }

    @Test
    public void failedSignInMessage() {

        driver.get("https://www.pluralsight.com/");
        driver.manage().window().setSize(new Dimension(1936, 1096));
        driver.switchTo().frame(4);
        driver.findElement(By.cssSelector(".drift-widget-naked-button")).click();
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("ul:nth-child(1) > .menu-link:nth-child(50 > .menu-a")).click();
        driver.findElement(By.cssSelector("li:nth-child(1) .alt-image-w-arrow > img")).click();
        driver.findElement(By.cssSelector(".close")).click();
        driver.findElement(By.id("Username")).click();
        driver.findElement(By.id("Username")).sendKeys("someEmail");
        driver.findElement(By.id("Password")).sendKeys("somepwd");
        driver.findElement(By.id("Login")).click();
//        assertThat(driver.findElement(By.id("errorMessage")).getText(), is("Invalid user name or password\\\\n"));
        driver.close();

    }



}
