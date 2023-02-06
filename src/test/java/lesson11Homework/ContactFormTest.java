package lesson11Homework;

import framework.BaseTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactFormTest extends BaseTest{
    static ChromeDriver driver;

    @BeforeEach
    public void beforeEach(){
        driver = prepareDriverForTest();
    }

    @Test
    public void sendContactForm(){
        driver.findElement(By.xpath("//a[text()=\"Contact us\"]")).click();
        new Select(driver.findElement(By.cssSelector("#id_contact"))).selectByValue("1");
        driver.findElement(By.cssSelector("#email")).sendKeys("aaa@aaa.aa");
        driver.findElement(By.cssSelector("#contactform-message")).sendKeys("this is my message");
        driver.findElement(By.xpath("//input[@value=\"Send\"]")).click();

        assertTrue(driver.findElement(By.xpath("//li[contains(text(), \"Your message has been" +
                " successfully sent to our team.\")]")).isDisplayed());

    }

    @AfterAll
    public static void afterAll(){
        driver.quit();
    }
}
