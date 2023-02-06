package projectObjectPatterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static framework.DriverProvider.getDriver;

public class PrestaShopFrame {

    private ChromeDriver driver;

    public PrestaShopFrame(){
        this.driver = getDriver();
    }

    public void getPrestaShopUrl(){
        var wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#loadingMessage")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement element = driver.findElement(By.cssSelector("#framelive"));
        driver.switchTo().frame(element);
    }

}
