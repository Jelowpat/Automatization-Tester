package projectObjectPatterns.selenide;

import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import io.qameta.allure.Step;


public class NavigationBar {

    private void moveToElement(String element){
        $x(element).hover();
    }

    @Step("Open Stationery Accessories tab")
    public void openAccessoriesStationery(){
        $x("//a[contains(.,\"  Accessories\")]").hover();
        $x("//a[contains(.,\"  Stationery\")]").click();
    }

    @Step("Open Home Accessories tab")
    public void openAccessoriesHome(){
        $x("//a[contains(.,\"  Accessories\")]").hover();
        $x("//a[contains(.,\"Home Accessories\")]").click();
    }

    @Step("Open Men Clothes Tab")
    public void openClothesMen(){
        $x("//a[contains(.,\"  Clothes\")]").hover();
        $x("//div[@class=\"popover sub-menu js-sub-menu collapse\"]" +
               "//li/a[contains(.,\"Men\")]").click();
    }

    @Step("Open Woman Clothes Tab")
    public void openClothesWomen() {
        $x("//a[contains(.,\"  Clothes\")]").hover();
        $x("//div[@class=\"popover sub-menu js-sub-menu collapse\"]" +
                "//li/a[contains(.,\"Women\")]").click();
    }

    @Step("Open Art Tab")
    public void openArt(){
        $x("//ul[@id=\"top-menu\"]/li/a[contains(.,\"Art\")]").click();
    }

    @Step("Open Login Page")
    public void openLoginPage(){
        $x("//a[@title=\"Log in to your customer account\"]").click();
    }

    @Step("Open Contact Us Page")
    public void openContactUs(){
        $("#contact-link > a").click();
    }

    @Step("Open Cart")
    public void openCart(){
        $(".blockcart").click();
    }

    @Step("Cahnge language")
    public void selectLanguage(String language){
        String xpath = String.format("//a[contains(text(), \"%s\")]", language);
        $(".language-selector").click();
        $x(xpath).click();
    }

    @Step("use search")
    public void searchFor(String query){
        var searchBar = $x("//input[@name=\"s\"]");
        searchBar.clear();
        searchBar.sendKeys(query);
        searchBar.sendKeys(Keys.RETURN);
    }

    public void openYourAccount(){
        $(".account > span").click();
    }

    public void openMyStore(){
        $("#_desktop_logo a").click();
    }


}
