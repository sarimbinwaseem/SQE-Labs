import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class Main {
    public static String driverPath = "driver/chromedriver.exe";
    public static String driverProperty = "webdriver.chrome.driver";
    public static String username = "standard_user";
    public static String password = "secret_sauce";
    public static ChromeOptions options = new ChromeOptions();
    public static String argument = "--remote-allow-origins=*";
    public static String URL = "https://www.saucedemo.com";
    public static int delay = 3;
    public static String website_title = "Swag Labs";
    public static String username_ID = "user-name";
    public static String password_ID = "password";
    public static String loginBtn_ID = "login-button";
    public static String title_XPATH = "//span[@class='title']";
    public static String product_XPATH = "//div/div/a[@id='item_!_img_link']";
    public static String expected_results = "Products";

    static Random random = new Random();

    public static void main(String[] args) {
        try{
            System.out.println("Starting...");
            WebDriver driver = initiateWebBrowserSession();
            System.out.println("Navigating to URL...");
            navigateToURL(driver);
            enterText(driver, username_ID, username);
            enterText(driver, password_ID, password);
            clickElement(driver, loginBtn_ID, "id");
            WebElement title_from_xpath = driver.findElement(By.ByXPath.xpath(title_XPATH));
            String text = title_from_xpath.getText();
            compareText(expected_results, text);
            clickProduct(driver);
            new WebDriverWait(driver, Duration.ofSeconds(3));
            clickElement(driver, "//div/button[@class='btn btn_primary btn_small btn_inventory']", "xpath");
//            Clicking Back button.
            clickElement(driver, "//div/button[@id='back-to-products']", "xpath");

            for (int i = 0; i <= 4; i++) {
                clickProduct(driver);
                new WebDriverWait(driver, Duration.ofSeconds(3));
                clickElement(driver, "//div/button[@class='btn btn_primary btn_small btn_inventory']", "xpath");
                new WebDriverWait(driver, Duration.ofSeconds(3));
                //            Clicking Back button.
                clickElement(driver, "//div/button[@id='back-to-products']", "xpath");
                new WebDriverWait(driver, Duration.ofSeconds(3));
            }

        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public static WebDriver initiateWebBrowserSession() throws Exception {
        System.setProperty(driverProperty, driverPath);

//            ChromeOptions options = new ChromeOptions();
        options.addArguments(argument);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        return driver;
    }

    public static void navigateToURL(WebDriver driver) {
        driver.get(URL);
    }

    public static void enterText(WebDriver driver, String identifier, String testData) {
        WebElement textarea = driver.findElement(By.ById.id(identifier));
        textarea.sendKeys(testData);
    }

    public static void clickElement(WebDriver driver, String identifier, String tag) {
        if (tag == "id"){
            WebElement clickable_element = driver.findElement(By.ById.id(identifier));
            clickable_element.click();
        }
        if (tag == "class") {
            WebElement clickable_element = driver.findElement(By.ByClassName.className(identifier));
            clickable_element.click();
        }
        if (tag == "xpath"){
            WebElement clickable_element = driver.findElement(By.ByXPath.xpath(identifier));
            clickable_element.click();
        }

//        WebElement clickable_element;
//        switch (tag) {
//            case "id":
//                clickable_element = driver.findElement(By.ById.id(identifier));
//                clickable_element.click();
//                break;
//
//            case "class":
//                clickable_element = driver.findElement(By.ByClassName.className(identifier));
//                clickable_element.click();
//                break;
//
//            case "xpath":
//                clickable_element = driver.findElement(By.ByXPath.xpath(identifier));
//                clickable_element.click();
//                break;
//        }
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

    public static void clickProduct(WebDriver driver){
        int num = random.nextInt(6);
        String product_number = Integer.toString(num);

        System.out.println(product_number);
        String new_ID = product_XPATH.replace("!", product_number);
        System.out.println(new_ID);
        clickElement(driver, new_ID, "xpath");
    }
}