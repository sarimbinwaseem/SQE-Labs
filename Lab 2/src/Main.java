import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Main{

    public static void main(String[] args) throws Exception{
        System.out.println("Hey there");
        try{

            WebDriver driver = Method.initiateWebBrowserSession();
            Method.navigateToURL(driver);
            waitForTime(driver, Vars.delay);
            String getTile = driver.getTitle();
            if (getTile.equals(Vars.website_title)) {
                System.out.println("They matched...");
            }
            else {
                System.out.println("Not good.. didn't match");
            }

//            Sending keys to username
            Method.enterText(driver, Vars.username_ID, Vars.username);
//            Sending keys to password
            Method.enterText(driver, Vars.password_ID, Vars.password);
//            Clicking the login button
            Method.clickElement(driver, Vars.loginBtn_ID);
//          Explicit Waiting...
//          new WebDriverWait(driver, Duration.ofSeconds(Vars.delay));
            waitForTime(driver, Vars.delay);
            System.out.println("Waiting Done..");

//          Getting the title

            WebElement title_from_xpath = driver.findElement(By.ByXPath.xpath(Vars.title_XPATH));
            String text = title_from_xpath.getText();

//          Checking
            Method.compareText(text, Vars.expected_results);
        }
        catch (Exception e) {
            System.out.println("Oh noo...");
        }
    }
    public static void waitForTime(WebDriver driver, int ms) throws Exception {
        new WebDriverWait(driver, Duration.ofSeconds(Vars.delay));
//        Thread.sleep(Vars.delay);
    }
}