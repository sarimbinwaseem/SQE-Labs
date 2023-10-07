import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
//            IDs:
//            user-name
//            password
//            login-button
        }
        catch (Exception e) {
            System.out.println("Oh noo...");
        }
    }
}
