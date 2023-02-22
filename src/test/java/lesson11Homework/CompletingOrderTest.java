package lesson11Homework;

import framework.BaseTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static framework.DriverProvider.getDriver;


public class CompletingOrderTest extends BaseTest {

    static ChromeDriver driver;
    WebDriverWait wait;

    @AfterAll
    public static void afterAll() {
        getDriver().close();
    }

    @BeforeEach
    public void beforeEach() {
        driver = prepareDriverForTest();
    }

    @Test
    public void OrderProduct() throws InterruptedException {
        driver.findElement(By.className("user-info")).click();

        driver.findElement(By.cssSelector("#field-email")).sendKeys("kolorek94@wp.pl");
        driver.findElement(By.cssSelector("#field-password")).sendKeys("futurecollar123");
        driver.findElement(By.xpath("//button[contains(text(),\"Sign in\")]")).click();

        if (driver.findElement(By.cssSelector(".alert")).getText().equals("Authentication failed.")) {
            driver.findElement(By.xpath("//a[contains(.,\"No account\")]")).click();

            driver.findElement(By.xpath("//label[@for=\"field-id_gender-1\"]/span")).click();
            driver.findElement(By.cssSelector("#field-firstname")).sendKeys("Patryk");
            driver.findElement(By.cssSelector("#field-lastname")).sendKeys("Jelowicki");
            driver.findElement(By.cssSelector("#field-email")).sendKeys("kolorek94@wp.pl");
            driver.findElement(By.cssSelector("#field-password")).sendKeys("futurecollar123");
            driver.findElement(By.xpath("//input[@name=\"customer_privacy\"]")).click();
            driver.findElement(By.xpath("//input[@name=\"psgdpr\"]")).click();
            driver.findElement(By.xpath("//button[contains(.,\"Save\")]")).click();
        }

        new Actions(driver)
                .moveToElement(driver.findElement(By.xpath("//a[contains(.,\"Clothes\")]")))
                .perform();

        driver.findElement(By.xpath("//div[@class=\"popover sub-menu js-sub-menu collapse\"]" +
                "//li/a[contains(.,\"Women\")]")).click();

        driver.findElement(By.xpath("//img[@alt=\"Brown bear printed sweater\"]")).click();

        new Select(driver.findElement(By.id("group_1"))).selectByValue("3");

        driver.findElement(By.xpath("//div[@class=\"add\"]/button")).click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(driver.findElement(By.xpath(
                "//div[@id=\"blockcart-modal\"]")), "style", "display: block;"));


        if (driver.findElement(By.cssSelector("#myModalLabel")).getText().contains(
                "Product successfully added to your shopping cart")) {
            driver.findElement(By.xpath("//a[contains(.,\"Proceed to checkout\")]")).click();
        } else {
            System.exit(0);
        }

        driver.findElement(By.xpath("//a[contains(text(), \"Proceed to checkout\")]")).click();
        new Select(driver.findElement(By.cssSelector("#field-id_country"))).selectByValue("8");
        driver.findElement(By.cssSelector("#field-address1")).sendKeys("zwyciestwa 1");
        driver.findElement(By.cssSelector("#field-postcode")).sendKeys("80333");
        driver.findElement(By.cssSelector("#field-city")).sendKeys("Gdansk");
        driver.findElement(By.xpath(
                "//button[@name=\"confirm-addresses\"]")).click();
        driver.findElement(By.xpath(
                "//button[@name=\"confirmDeliveryOption\"]")).click();
        driver.findElement(By.xpath("//label[@for=\"payment-option-1\"]")).click();
        driver.findElement(By.cssSelector(".condition-label")).click();
        driver.findElement(By.cssSelector(".ps-shown-by-js button")).click();

        Assertions.assertEquals("\uE876YOUR ORDER IS CONFIRMED", driver.findElement(By.xpath
                ("//h3[contains(.,\"Your order is confirmed\")]")).getText());
    }
}
