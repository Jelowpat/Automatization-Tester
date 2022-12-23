package framework;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverProvider {
    private static ChromeDriver chromeDriverInstance;

    public static ChromeDriver getDriver(){

        if(chromeDriverInstance == null){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kolorek\\Desktop\\chromedriver\\chromedriver.exe");

            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);

            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);
            options.addArguments("--start-maximized");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");

            chromeDriverInstance = new ChromeDriver(options);
        }
        return chromeDriverInstance;
    }
}
