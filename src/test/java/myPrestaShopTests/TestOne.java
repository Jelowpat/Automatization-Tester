package myPrestaShopTests;

import framework.BaseTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestOne extends BaseTest {

    static ChromeDriver driver;

    @BeforeEach
    public void beforeEach(){
        driver = prepareDriverForTest();
    }

    @Test
    public void CheckLoginValidation(){
        driver.findElement(By.className("user-info")).click();
        WebElement element = driver.findElement(By.cssSelector("#login-form"));
        element.findElement(By.cssSelector("#field-email")).sendKeys("aaaaaa@aaaa.aaaa");
        element.findElement(By.cssSelector("#field-password")).sendKeys("bbbbbbbb");
        element.findElement(By.xpath("//button[contains(text(),\"Sign in\")]")).click();

        assertTrue(driver.findElement(By.cssSelector(".alert")).isDisplayed());
        assertEquals("Authentication failed.", driver.findElement(By.cssSelector(".alert")).getText());
    }

    @AfterAll
    public static void afterAll(){
        driver.quit();
    }
}
