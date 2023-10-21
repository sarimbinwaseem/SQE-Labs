import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Method {
    public static void waitForTime(WebDriver driver, int ms) throws Exception {
//        new WebDriverWait(driver, Duration.ofSeconds(Vars.delay));
            Thread.sleep(3000);
    }


    public static WebDriver initiateWebBrowserSession() throws Exception {
        System.setProperty(Vars.driverProperty, Vars.driverPath);

//            ChromeOptions options = new ChromeOptions();
        Vars.options.addArguments(Vars.argument);

        WebDriver driver = new ChromeDriver(Vars.options);
        driver.manage().window().maximize();

        return driver;
    }

    public static void navigateToURL(WebDriver driver) {
        driver.get(Vars.URL);
    }

    public static void enterText(WebDriver driver, String identifier, String testData) {
        WebElement textarea = driver.findElement(By.ById.id(identifier));
        textarea.sendKeys(testData);
    }

    public static void clickElement(WebDriver driver, String identifier) {
        WebElement loginButton = driver.findElement(By.ById.id(identifier));
        loginButton.click();
    }

    public static int compareText(String actual, String expected) {
        if (actual.equals(expected)){
            System.out.println("The right page...");
            return 0;
        }
        else {
            System.out.println("Not The right page...");
            return 1;
        }
    }

}
