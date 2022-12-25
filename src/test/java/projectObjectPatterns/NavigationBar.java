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

    @FindBy(xpath = "//a[contains(.,\"  Stationery\")]")
    private WebElement stationery;

    public NavigationBar(){
        this.driver = getDriver();
        PageFactory.initElements(getDriver(),this);
    }

    private void moveToElement(String element){
        new Actions(driver)
                .moveToElement(driver.findElement(By.xpath(element)))
                .perform();
    }

    public void openAccessoriesStationery(){
        moveToElement("//a[contains(.,\"  Accessories\")]");
        stationery.click();
    }

    public void openAccessoriesHome(){
        moveToElement("//a[contains(.,\"  Accessories\")]");
        driver.findElement(By.xpath("//a[contains(.,\"Home Accessories\")]")).click();
    }

    public void openClothesMen(){
        moveToElement("//a[contains(.,\"  Clothes\")]");
        driver.findElement(By.xpath("//div[@class=\"popover sub-menu js-sub-menu collapse\"]" +
                "//li/a[contains(.,\"Men\")]")).click();
    }
    public void openClothesWomen() {
        moveToElement("//a[contains(.,\"  Clothes\")]");
        driver.findElement(By.xpath("//div[@class=\"popover sub-menu js-sub-menu collapse\"]" +
                "//li/a[contains(.,\"Women\")]")).click();
    }

    public void openArt(){
        driver.findElement(By.xpath("//ul[@id=\"top-menu\"]/li/a[contains(.,\"Art\")]")).click();
    }
    public void openLoginPage(){
        driver.findElement(By.xpath("//a[@title=\"Log in to your customer account\"]")).click();
    }

    public void openContactUs(){
        driver.findElement(By.cssSelector("#contact-link > a")).click();
    }

    public void openCart(){
//        if (driver.findElements(By.xpath("//div[@class=\"header\"]/a")).size() > 0){
        driver.findElement(By.cssSelector(".blockcart")).click();
//        }
//        else{
//            System.exit(0);
//        }
    }

    public void selectLanguage(String language){
        String xpath = String.format("//a[contains(text(), \"%s\")]", language);
        driver.findElement(By.cssSelector(".language-selector")).click();
        driver.findElement(By.xpath(xpath)).click();
    }

    public void searchFor(String query){
        var searchBar = driver.findElement(By.xpath("//input[@name=\"s\"]"));
        searchBar.clear();
        searchBar.sendKeys(query);
        searchBar.sendKeys(Keys.RETURN);
    }

    public void openYourAccount(){
        driver.findElement(By.cssSelector(".account > span")).click();
    }

    public void openMyStore(){
        driver.findElement(By.cssSelector("#_desktop_logo a")).click();
    }


}
