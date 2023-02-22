package projectObjectPatterns.selenide;

import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PrestaShopFrame {

    public void getPrestaShopUrl() {
        $("#loadingMessage").shouldBe(not(visible));
        WebDriverRunner.getWebDriver().switchTo().frame($("#framelive"));
    }
}
