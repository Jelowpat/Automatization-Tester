package projectObjectPatterns.selenide;

import static com.codeborne.selenide.Selenide.$;
import io.qameta.allure.Step;

public class Cart {

    @Step("Proceed to Checkout")
    public void clickProceedToCheckout(){
        $(".text-sm-center a.btn").click();
    }

}