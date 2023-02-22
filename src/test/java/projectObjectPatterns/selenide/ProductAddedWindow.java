package projectObjectPatterns.selenide;

import static com.codeborne.selenide.Selenide.$;
import io.qameta.allure.Step;

public class ProductAddedWindow {

    @Step ("Get Success information")
    public String getSuccessConfirmation() {
        return $("#myModalLabel").getText();
    }

    @Step("Continue Shopping")
    public void clickContinueShopping(){
        $(".cart-content-btn button").click();
    }

    @Step("Proceed to Checkout")
    public void clickProceedToCheckout(){
        $(".cart-content-btn a").click();
    }

}
