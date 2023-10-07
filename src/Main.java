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

            System.setProperty("webdriver.chrome.driver",
                    "driver/chromedriver.exe");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");

            WebDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.get("https://www.saucedemo.com");
            Thread.sleep(3000);

            String title = "Swag Labs";
            String getTile = driver.getTitle();

            if (getTile.equals(title)) {
                System.out.println("They matched...");

            }
            else {
                System.out.println("Not good.. didn't match");
            }
            String theusername = "standard_user";
            String thepassword = "secret_sauce";

//            Sending keys to username
            WebElement username_txt_box = driver.findElement(By.ById.id("user-name"));
            username_txt_box.sendKeys(theusername);

//            Sending keys to password
            WebElement password_txt_box = driver.findElement(By.ById.id("password"));
            password_txt_box.sendKeys(thepassword);

//            Clicking the login button
            WebElement login_button = driver.findElement(By.ById.id("login-button"));
            login_button.click();

    //      Explicit Waiting...
            new WebDriverWait(driver, Duration.ofSeconds(3));
            System.out.println("Waiting Done..");

//          Getting the title
            String expected_results = "Products";
            WebElement title_from_xpath = driver.findElement(By.ByXPath.xpath("//span[@class='title']"));
            String text = title_from_xpath.getText();

//          Checking
            if (text.equals(expected_results)){
                System.out.println("The right page...");
            }
            else {
                System.out.println("Not The right page...");
            }
        }
        catch (Exception e) {
            System.out.println("Oh noo...");
        }
    }
}
