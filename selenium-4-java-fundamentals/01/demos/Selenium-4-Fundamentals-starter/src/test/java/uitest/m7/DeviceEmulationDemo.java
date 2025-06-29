package uitest.m7;

import helper.DemoHelper;
import helper.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.Map;

import static helper.Pages.HOME;

public class DeviceEmulationDemo {

    @Test
    public void deviceEmulation(){

        Map<String, String> mobileEmulation = Map.of("deviceName", "Nexus 5");
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setExperimentalOption("mobileEmulation", mobileEmulation);
        WebDriver driver = new ChromeDriver(options);
        driver.get(HOME);


        DemoHelper.pause();
        driver.quit();

    }
}
