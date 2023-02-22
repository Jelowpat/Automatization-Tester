package projectObjectPatterns.selenide;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class ProductGrid {

    private ElementsCollection productList = $$(".thumbnail-container");


    private SelenideElement findProduct(String productName){

        return productList.stream().filter(selenideElement -> {
            return selenideElement.$(".product-title > a")
                    .getText()
                    .contains(productName);
        }).findFirst().get();
    }

    @Step("Open Product Page")
    public void openProductPage(String productName){
        findProduct(productName).click();
    }

    @Step("Add to favourite")
    public void addToFavourite(String productName){
        findProduct(productName)
                .$(".wishlist-button-add")
                .click();
        $(".wishlist-list-item > p").click();
    }

    @Step("Open Quick View")
    public void openQuickView(String productName) throws InterruptedException {
        SelenideElement thumbnail = findProduct(productName);
        thumbnail.hover();
        thumbnail.$(".quick-view").click();
    }

    @Step("Sort by")
    public void sortBy(String option){
        $x("//button[@class=\"btn-unstyle select-title\"]").click();
        $x(String.format("//a[contains(text(), \"%s\")]", option)).click();
    }

    public ElementsCollection getProductList(){
        return productList;
    }

    @Step("Is product displayed")
    public String getDisplayedProductName(String productName) {
        return $x(String.format("//p[contains(.,\"%s\")]", productName)).getText();
    }
}
