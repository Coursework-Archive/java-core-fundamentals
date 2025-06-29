package uitest.m8;

import helper.DriverFactory;
import io.netty.handler.codec.http.HttpMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.network.Network;
import org.openqa.selenium.devtools.v107.network.model.Request;
import org.openqa.selenium.devtools.v107.network.model.Response;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class InterceptRequestDemo {

    WebDriver driver;
    DevTools devTools;



    @Test
    public void howToGetDevToolsObject() {

        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        FirefoxDriver firefoxDriver = new FirefoxDriver();
        DevTools tools = firefoxDriver.getDevTools();

        ChromeDriver chromeDriver = new ChromeDriver(options);
        DevTools tools1 = chromeDriver.getDevTools();

        WebDriver chromeDriver1 = new ChromeDriver(options);
        DevTools tools2 = ((ChromeDriver) chromeDriver1).getDevTools();

    }


    @Test
    public void captureRequestTraffic() {
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        devTools.addListener(Network.requestWillBeSent(),
                requestEvent -> {
                    Request r = requestEvent.getRequest();
                    System.out.printf("URL: %s, Method: %s \n", r.getUrl(), r.getMethod());
                }
                );
        driver.get("http://127.0.0.1:8000/src/web/index.html");

    }

    @Test
    public void captureResponseTraffic() {
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        List<Integer> statuses = new ArrayList<>();
        devTools.addListener(Network.responseReceived(),
                responseReceived -> {
                    Response r = responseReceived.getResponse();
                    System.out.printf("Response status: %s \n", r.getStatus());
//                    Assert.assertTrue(r.getStatus() <= 400);
//                    Assert.assertFalse(r.getStatus() <= 400);
                    statuses.add(r.getStatus());

                }
                );
        driver.get("http://127.0.0.1:8000/src/web/index.html");
        statuses.forEach(status -> Assert.assertFalse(status <= 400));

    }


    @Test
    public void manipulateTraffic() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        devTools = ((ChromeDriver) driver).getDevTools();
//        devTools.send(Network.setBlockedURLs(List.of("*/footer.js")));

        driver.get("http://127.0.0.1:8000/src/web/index.html");

        WebElement location = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(visibilityOfElementLocated(By.id("location")));
        Assert.assertTrue(location.getText().contains("You are visiting us from"));





    }





    @AfterMethod
    public void cleanup() {
        devTools.send(Network.disable());
        devTools.close();
        driver.quit();
    }



}
