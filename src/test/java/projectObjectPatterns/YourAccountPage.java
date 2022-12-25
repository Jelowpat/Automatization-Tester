package projectObjectPatterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

import static framework.DriverProvider.getDriver;

public class YourAccountPage {

    @FindBy (css = "#identity-link > span")
    private WebElement information;

    @FindBy (css = "#address-link > span")
    private WebElement address;

    @FindBy (css = "#history-link > span")
    private WebElement history;

    @FindBy (css = "#order-slips-link > span")
    private WebElement creditSlips;

    @FindBy (css = "#wishlist-link > span")
    private WebElement wishlist;

    @FindBy (css = ".page-footer a")
    private WebElement signOut;

    public YourAccountPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public void openInformation(){
        information.click();
    }

    public void openAddress(){
        address.click();
    }

    public void openHistory(){
        history.click();
    }

    public void openCreditSlips(){
        creditSlips.click();
    }

    public void openWishlist() throws InterruptedException {
        wishlist.click();
        getDriver().findElement(By.xpath("//p[@class=\"wishlist-list-item-title\"]")).click();
    }

    public void clickSignOut(){
        signOut.click();
    }

}
