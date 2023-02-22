package projectObjectPatterns.selenide;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class YourAccountPage {


    public void openInformation(){
        $("#identity-link > span").click();
    }

    public void openAddress(){
        $("#address-link > span").click();
    }

    public void openHistory(){
        $("#history-link > span").click();
    }

    public void openCreditSlips(){
        $("#order-slips-link > span").click();
    }

    public void openWishlist(){
        $("#wishlist-link > span").click();
        $x("//p[@class=\"wishlist-list-item-title\"]").click();
    }

    public void clickSignOut(){
        $(".page-footer a").click();
    }

}
