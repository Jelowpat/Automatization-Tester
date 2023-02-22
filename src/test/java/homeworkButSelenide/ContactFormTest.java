package homeworkButSelenide;

import com.codeborne.selenide.Configuration;
import framework.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectObjectPatterns.selenide.PrestaShopFrame;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactFormTest extends BaseTest{
    private PrestaShopFrame prestaShopFrame;

    @BeforeEach
    public void beforeEach() {
        Configuration.timeout = 15000;
        Configuration.browserSize = "1920x1080";

        open("https://demo.prestashop.com");
        prestaShopFrame = new PrestaShopFrame();
        prestaShopFrame.getPrestaShopUrl();
    }

    @Test
    public void sendContactForm(){
        $x("//a[text()=\"Contact us\"]").click();
        $("#id_contact").selectOptionByValue("1");
        $("#email").sendKeys("aaa@aaa.aa");
        $("#contactform-message").sendKeys("this is my message");
        $x("//input[@value=\"Send\"]").click();

        assertTrue($x("//li[contains(text(), \"Your message has been" +
                " successfully sent to our team.\")]").isDisplayed());

    }
}
