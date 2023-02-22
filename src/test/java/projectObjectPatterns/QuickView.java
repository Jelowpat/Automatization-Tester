package projectObjectPatterns;

import data.Size;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

import static framework.DriverProvider.getDriver;

public class QuickView {

    @FindBy(css = ".regular-price")
    private WebElement regularPrice;

    @FindBy(css = ".current-price-value")
    private WebElement discountedPrice;

    @FindBy(css = "#product-description-short p")
    private WebElement description;

    @FindBy(css = ".h1")
    private WebElement itemName;

    @FindBy(css = "#group_1")
    private WebElement size;

    @FindBy(css = "#quantity_wanted")
    private WebElement quantity;

    @FindBy(css = ".add >button")
    private WebElement addToCart;

    @FindBy(css = ".quickview .close")
    private WebElement close;

    @FindBy(xpath = "//a[@title=\"Share\"]")
    private WebElement facebook;

    @FindBy(xpath = "//a[@title=\"Tweet\"]")
    private WebElement twitter;

    @FindBy(xpath = "//a[@title=\"Pinterest\"]")
    private WebElement pinterest;

    public QuickView(){
        PageFactory.initElements(getDriver(), this);
    }

    public void setSize(Size size){
        new Select(this.size).selectByValue(size.getValue());

    }

    public void setQuantity(Integer number){
        quantity.clear();
        quantity.sendKeys(number.toString());
    }

    public void clickAddToCart(){
        addToCart.click();
        var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.cssSelector("#blockcart-modal"))));
    }

    public HashMap<Object, Object> getProductData(){
        var productData = new HashMap<>();
        productData.put("Item Name", itemName.getText());
        productData.put("Item Description", description.getText());
        productData.put("Regular Price", regularPrice.getText());
        productData.put("Discounted Price", discountedPrice.getText());
        return productData;
    }

    public void exit(){
        close.click();
    }

    public void shareProduct(String website){
        switch (website.toLowerCase()){
            case "facebook" -> facebook.click();
            case "twitter" -> twitter.click();
            case "pinterest" -> pinterest.click();
        }
    }

}
