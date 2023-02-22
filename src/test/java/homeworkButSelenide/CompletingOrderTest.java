package homeworkButSelenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import framework.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectObjectPatterns.selenide.PrestaShopFrame;

import static com.codeborne.selenide.Selenide.*;


public class CompletingOrderTest extends BaseTest {

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
    public void OrderProduct() {
        $(".user-info").click();

        $("#field-email").sendKeys("kolorek94@wp.pl");
        $("#field-password").sendKeys("future");
        $x("//button[contains(text(),\"Sign in\")]").click();

        if ($(".alert").getText().equals("Authentication failed.")) {
            $x("//a[contains(.,\"No account\")]").click();

            $x("//label[@for=\"field-id_gender-1\"]/span").click();
            $("#field-firstname").sendKeys("Patryk");
            $("#field-lastname").sendKeys("Jelowicki");
            $("#field-email").sendKeys("kolorek94@wp.pl");
            $("#field-password").sendKeys("futurecollar123");
            $x("//input[@name=\"customer_privacy\"]").click();
            $x("//input[@name=\"psgdpr\"]").click();

            $x("//button[contains(.,\"Save\")]").click();
        }

        $x("//a[contains(.,\"Clothes\")]").hover();
        $x("//div[@class=\"popover sub-menu js-sub-menu collapse\"]" +
                "//li/a[contains(.,\"Women\")]").shouldBe(Condition.visible).click();
        $x("//img[@alt=\"Brown bear printed sweater\"]").click();
        $x("//select[@aria-label=\"Size\"]").selectOptionByValue("3");
        $("div.add>button").click();
        $x("//a[contains(.,\"Proceed to checkout\")]").click();
        $x("//a[contains(text(), \"Proceed to checkout\")]").click();
        $("#field-id_country").selectOptionByValue("8");
        $("#field-city").sendKeys("Gdansk");
        $("#field-address1").sendKeys("zwyciestwa 1");
        $("#field-postcode").sendKeys("80333");
        $x("//button[@name=\"confirm-addresses\"]").click();
        $x("//button[@name=\"confirmDeliveryOption\"]").click();

        $x("//label[@for=\"payment-option-1\"]").click();
        $(".condition-label").click();
        $(".ps-shown-by-js button").click();

        Assertions.assertEquals("\uE876YOUR ORDER IS CONFIRMED", $x
                ("//h3[contains(.,\"Your order is confirmed\")]").getText());

    }
}
