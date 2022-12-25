package projectObjectPatterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static framework.DriverProvider.getDriver;

public class ProductAddedWindow {

    @FindBy (css = "#myModalLabel")
    private WebElement successNote;

    @FindBy (css = ".cart-content-btn button")
    private WebElement continueShopping;

    @FindBy (css = ".cart-content-btn a")
    private WebElement proceedToCheckout;

    String successConfirmation;

    public ProductAddedWindow() {
        PageFactory.initElements(getDriver(), this);
    }

    public String getSuccessConfirmation() {
        this.successConfirmation = successNote.getText();
        return successConfirmation;
    }

    public void clickContinueShopping(){
        continueShopping.click();
        var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(getDriver().findElement(By.cssSelector("#blockcart-modal"))));
    }

    public void clickProceedToCheckout(){
        proceedToCheckout.click();
    }

}
