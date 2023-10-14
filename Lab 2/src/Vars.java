import org.openqa.selenium.chrome.ChromeOptions;

class Vars {
    static String driverPath = "driver/chromedriver.exe";
    static String driverProperty = "webdriver.chrome.driver";
    static String username = "standard_user";
    static String password = "secret_sauce";
    static ChromeOptions options = new ChromeOptions();
    static String argument = "--remote-allow-origins=*";
    static String URL = "https://www.saucedemo.com";
    static int delay = 3;
    static String website_title = "Swag Labs";
    static String username_ID = "user-name";
    static String password_ID = "password";
    static String loginBtn_ID = "login-button";
    static String title_XPATH = "//span[@class='title']";
    static String expected_results = "Products";
}