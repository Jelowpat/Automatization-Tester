package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static framework.DriverProvider.getDriver;


public class BaseTest {
    public void openPageOnUrl(String url){
        getDriver().get(url);
    }

    public ChromeDriver prepareDriverForTest(){
        ChromeDriver driver = getDriver();
        loadAndSwitchToIframe(driver);
        return driver;
    }

    private void loadAndSwitchToIframe(ChromeDriver driver){
        driver.get("https://demo.prestashop.com/#/en/front");
        var wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#loadingMessage")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement element = driver.findElement(By.cssSelector("#framelive"));
        driver.switchTo().frame(element);
    }
}
