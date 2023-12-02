package UtilFactory;

import com.sun.corba.se.spi.activation.Server;
import io.cucumber.java.it.Ma;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ServiceFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal();
    private static ServiceFactory instance = null;
    private static String BROWSER;

    private ServiceFactory() throws Exception {
//        sqlConnect();
    }

    public static ServiceFactory getInstance() throws Exception {
        if (instance == null) {instance = new ServiceFactory();}
        return instance;
    }

    public final void setDriver(String browser) throws Exception {
        switch (browser.toLowerCase()){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver(firefoxOptions()));
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver(new EdgeOptions()));
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver(chromeOptions()));
                break;

        }
    }

    public static WebDriver getDriver() {return driver.get();}

    private ChromeOptions chromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("useAutomaticExtension", false);
        chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        chromeOptions.addArguments("disable-popup-blocking");
        chromeOptions.addArguments("start-maximized");
        chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//        chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        chromeOptions.addArguments("--enable-automation");
        if (System.getenv("CHROME_HEADLESS") != null){
            chromeOptions.addArguments("headless");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("disable-setupid-sandbox");
            chromeOptions.addArguments("--hide-scrollbars");
            chromeOptions.addArguments("--ignore-ssl-errors");
        }

        Map<String, Object> perfs = new HashMap<String, Object>();
        perfs.put("credentials_enable_service", false);
        perfs.put("password_manager_enabled", false);
        chromeOptions.setExperimentalOption("perfs", perfs);

        return chromeOptions;
    }

    private FirefoxOptions firefoxOptions() {
        FirefoxOptions fireoptions = new FirefoxOptions();
        fireoptions.addArguments("window-size=1200,720");
        fireoptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//        fireoptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        fireoptions.addArguments("--enable-automation");
        return fireoptions;
    }

    private EdgeOptions edgeOptions() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("window-size=1200,720");
        edgeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//        fireoptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        edgeOptions.addArguments("--enable-automation");
        return edgeOptions;
    }

    public void setBrowser(String browser) {
        BROWSER = browser;
    }

    public static String getBrowser() {
        return BROWSER;
    }

    public static ServiceFactory serviceFactoryInstance;
    static {
        try {
            serviceFactoryInstance = ServiceFactory.getInstance();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        }
    }

