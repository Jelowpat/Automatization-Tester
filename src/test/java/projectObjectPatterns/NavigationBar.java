package projectObjectPatterns;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static framework.DriverProvider.getDriver;

public class NavigationBar {

    ChromeDriver driver;

    @FindBy(css = "#category-7 a")
    private WebElement stationery;

    public NavigationBar() {
        this.driver = getDriver();
        PageFactory.initElements(getDriver(), this);
    }

    private void moveToElement(String element) {
        new Actions(driver)
                .moveToElement(driver.findElement(By.xpath(element)))
                .perform();
    }

    public void openAccessoriesStationery() {
        moveToElement("//a[contains(.,\"  Accessories\")]");
        stationery.click();
    }

    public void openAccessoriesHome() {
        moveToElement("//a[contains(.,\"  Accessories\")]");
        driver.findElement(By.cssSelector("#category-8 a")).click();
    }

    public void openClothesMen() {
        moveToElement("//a[contains(.,\"  Clothes\")]");
        driver.findElement(By.cssSelector("#category-4 a")).click();
    }

    public void openClothesWomen() {
        moveToElement("//a[contains(.,\"  Clothes\")]");
        driver.findElement(By.cssSelector("#category-5 a")).click();
    }

    public void openArt() {
        driver.findElement(By.cssSelector("#category-9 a")).click();
    }

    public void openLoginPage() {
        driver.findElement(By.xpath("//a[@title=\"Log in to your customer account\"]")).click();
    }

    public void openContactUs() {
        driver.findElement(By.cssSelector("#contact-link > a")).click();
    }

    public void openCart() {
        driver.findElement(By.cssSelector(".blockcart")).click();

    }

    public void selectLanguage(String language) {
        String xpath = String.format("//a[contains(text(), \"%s\")]", language);
        driver.findElement(By.cssSelector(".language-selector")).click();
        driver.findElement(By.xpath(xpath)).click();
    }

    public void searchFor(String query) {
        var searchBar = driver.findElement(By.xpath("//input[@name=\"s\"]"));
        searchBar.clear();
        searchBar.sendKeys(query);
        searchBar.sendKeys(Keys.RETURN);
    }

    public void openYourAccount() {
        driver.findElement(By.cssSelector(".account > span")).click();
    }

    public void openMyStore() {
        driver.findElement(By.cssSelector("#_desktop_logo a")).click();
    }


}
