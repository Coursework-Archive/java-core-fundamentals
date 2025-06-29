package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Period;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Loans {

    private static final String URL = "file:///" + System.getProperty("user.dir") + "\\src\\web\\loans.html";
    private final WebDriver driver;

    public Loans(WebDriver driver) { this.driver = driver; }

    public static Loans loansPage(WebDriver driver) { return new Loans(driver); }

    public void goTo() {driver.get(URL); }

    public void enterBorrowAmount(String value) {
        driver.findElement(By.id("borrow")).sendKeys(value);
    }

    public void selectTimePeriod(Period period) {
        Select dropdown = new Select(driver.findElement(By.id("period")));
    }


    public String getResultMessageText() {
        var result = new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(visibilityOfElementLocated(By.id("result")));

        return result.getText();
    }

    public enum Period {
        ONE_MONTH("1 Month"),
        ONE_YEAR("1 Year"),
        TWO_YEARS("2 Years");

        final String period;
        Period(String period) { this.period = period; }
        @Override
        public String toString() { return period; }

    }
}
