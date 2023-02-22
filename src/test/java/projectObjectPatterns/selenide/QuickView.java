package projectObjectPatterns.selenide;

import data.selenide.Share;
import data.selenide.Size;
import io.qameta.allure.Step;

import java.util.HashMap;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class QuickView {

    @Step("Set size")
    public void setSize(Size size) {
        $("group_1").selectOption(size.getValue());
    }

    @Step("Set Quantity")
    public void setQuantity(Integer number) {
        $("#quantity_wanted").clear();
        $("#quantity_wanted").sendKeys(number.toString());
    }

    @Step("Add To Cart")
    public void clickAddToCart() {
        $(".add >button").click();
    }

    @Step("Get Product Data")
    public HashMap<Object, Object> getProductData() {
        var productData = new HashMap<>();
        productData.put("Item Name", $(".h1").getText());
        productData.put("Item Description", $("#product-description-short p").getText());
        productData.put("Regular Price", $(".regular-price").getText());
        productData.put("Discounted Price", $(".current-price-value").getText());
        return productData;
    }

    @Step("Exit")
    public void exit() {
        $(".quickview .close").click();
    }

    @Step("Share")
    public void shareProduct(Share website) {
        $x(website.getValue()).click();
    }
}
