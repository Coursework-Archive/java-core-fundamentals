package uitest.m6;

import helper.DemoHelper;
import helper.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static helper.Pages.HOME;
import static helper.Pages.LOANS;

public class UploadFileTest {

    WebDriver driver;


    @Test
    public void uploadFile() throws IOException {

        driver = DriverFactory.newChromeDriver();
        driver.get(LOANS);

        WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));

        Path path = Files.createTempFile("file",".txt");
        String fileName = path.toAbsolutePath().toString();
        System.out.println(fileName);

        fileInput.sendKeys(fileName);
        DemoHelper.pause();

        driver.quit();
        path.toFile().deleteOnExit();



    }


}
