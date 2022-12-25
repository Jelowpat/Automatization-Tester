package projectObjectPatterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

import static framework.DriverProvider.getDriver;

public class ProductGrid {

    @FindBy(css = ".thumbnail-container")
    private List<WebElement> productList;

    public ProductGrid(){
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(),20),this);
    }

    private WebElement findProduct(String productName){
        for (WebElement element:productList){
            if(element.findElement(By.cssSelector(".product-title > a"))
                    .getText()
                    .contains(productName)){
                return element;
            }
        }
        return null;
    }

    public void openProductPage(String productName){
        findProduct(productName).click();
    }

    public void addToFavourite(String productName){
//        productList.stream().parallel()
//                .filter(webElement -> webElement
//                        .findElement(By.cssSelector(".product-title > a"))
//                        .getText()
//                        .contains(productName))
//                .forEach(WebElement -> WebElement
//                        .findElement(By.cssSelector(".wishlist-button-add"))
//                        .click());
        findProduct(productName)
                .findElement(By.cssSelector(".wishlist-button-add"))
                .click();
        getDriver().findElement(By.cssSelector(".wishlist-list-item > p")).click();
    }

    public void openQuickView(String productName) throws InterruptedException {
        WebElement thumbnail = findProduct(productName);
        new Actions(getDriver())
                .moveToElement(thumbnail)
                .perform();
        thumbnail.findElement(By.cssSelector(".quick-view")).click();
        Thread.sleep(2000);
//        getDriver().findElement(By.cssSelector(
//                ".quickview button[class=\"close\"]")).click();
    }

    public void sortBy(String option) throws InterruptedException {
        getDriver().findElement(By.xpath("//button[@class=\"btn-unstyle select-title\"]")).click();
        getDriver().findElement(By.xpath(String.format("//a[contains(text(), \"%s\")]", option))).click();
        Thread.sleep(500);
    }

    public List<WebElement> getProductList(){
        return productList;
    }

    public boolean isProductDisplayedByName(String productName) {
        var locator = String.format("//p[contains(.,\"%s\")]", productName);
        return getDriver().findElement(By.xpath(locator)).isDisplayed();
    }
}
