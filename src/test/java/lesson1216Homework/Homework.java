package lesson1216Homework;

import data.LoginDataModel;
import data.RegistrationDataModel;
import framework.BaseTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import projectObjectPatterns.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static framework.DriverProvider.getDriver;

public class Homework extends BaseTest {

    private NavigationBar navigationBar;
    private PrestaShopFrame prestaShopFrame;
    private ProductGrid productGrid;
    private final SignIn signIn = new SignIn();
    private final CreateAnAccount createAnAccount = new CreateAnAccount();
    private final YourAccountPage yourAccountPage = new YourAccountPage();
    private QuickView quickView;
    private ProductAddedWindow productAddedWindow = new ProductAddedWindow();

    RegistrationDataModel registrationData = new RegistrationDataModel(
            "Patryk","Jelowicki", "kolorek94@wp.pl", "futurecollar123", "12/12/1994");

    RegistrationDataModel noNameData = new RegistrationDataModel(
            "","Jelowicki", "kolorek94@wp.pl", "futurecollar123", "12/12/1994");

    RegistrationDataModel noSurnameData = new RegistrationDataModel(
            "Patryk","", "kolorek94@wp.pl", "futurecollar123", "12/12/1994");

    RegistrationDataModel wrongEmailData = new RegistrationDataModel(
            "Patryk","Jelowicki", "kolorek94wppl", "futurecollar123", "12/12/1994");

    RegistrationDataModel tooShortPasswordData = new RegistrationDataModel(
            "Patryk","Jelowicki", "kolorek94wppl", "fut", "12/12/1994");

    LoginDataModel loginData = new LoginDataModel("kolorek94@wp.pl", "futurecollar123");

    RegistrationDataModel invalidNameFormat = new RegistrationDataModel(
            "Patryk%%%","Jelowicki", "kolorek94@wp.pl", "futurecollar123", "12/12/1994");

    @BeforeEach
    public void setup(){
        openPageOnUrl("https://demo.prestashop.com");
        prestaShopFrame = new PrestaShopFrame();
        navigationBar = new NavigationBar();
        prestaShopFrame.getPrestaShopUrl();
        productGrid = new ProductGrid();
        quickView = new QuickView();
    }

    @AfterAll
    public static void afterAll(){
        getDriver().close();
    }

    @Test
    public void sortLowToHigh() throws InterruptedException {
        navigationBar.openArt();
        productGrid.sortBy("low to high");
    }

    @Test
    public void registerAndAddToFavourite() throws InterruptedException {

        navigationBar.openLoginPage();
        signIn.trySigningIn(loginData);
        signIn.openNoAccount();
        createAnAccount.fillMaxData(registrationData);
        navigationBar.openArt();
        productGrid.addToFavourite("Brown Bear");
        navigationBar.openYourAccount();
        yourAccountPage.openWishlist();
        Assertions.assertTrue(productGrid.isProductDisplayedByName("bear"));
    }



    @Test
    public void searchForMugTest() {
        navigationBar.searchFor("Mug");
        Assertions.assertTrue(productGrid.getProductList().size() > 0);
    }

    @Test
    public void dataValidationNoFirstNameTest(){
        navigationBar.openLoginPage();
        signIn.openNoAccount();
        createAnAccount.fillMinData(noNameData);
        Assertions.assertEquals("Please fill out this field.", getDriver().findElement(
                By.xpath("//input[@name=\"firstname\"]")).getAttribute("validationMessage"));

    }

    @Test
    public void dataValidationNoLastNameTest() {
        navigationBar.openLoginPage();
        signIn.openNoAccount();
        createAnAccount.fillMinData(noSurnameData);
        Assertions.assertEquals("Please fill out this field.", getDriver().findElement(
                By.xpath("//input[@name=\"lastname\"]")).getAttribute("validationMessage"));
    }

    @Test
    public void dataValidationWrongEmailTest() {
        navigationBar.openLoginPage();
        signIn.openNoAccount();
        createAnAccount.fillMinData(wrongEmailData);
        var expectedValidationText = String.format(
                "Please include an '@' in the email address. '%s' is missing an '@'.", wrongEmailData.getEmail());
        Assertions.assertEquals(expectedValidationText, getDriver().findElement(
                By.xpath("//input[@name=\"email\"]")).getAttribute("validationMessage"));
    }

    @Test
    public void dataValidationTooShortPasswordTest() {
        navigationBar.openLoginPage();
        signIn.openNoAccount();
        createAnAccount.fillMinData(tooShortPasswordData);
        Assertions.assertEquals("Please match the requested format.", getDriver().findElement(
                By.xpath("//input[@name=\"password\"]")).getAttribute("validationMessage"));
    }

    @Test
    public void dataValidationInvalidNameFormatTest() {
        navigationBar.openLoginPage();
        signIn.openNoAccount();
        createAnAccount.fillMinData(invalidNameFormat);
        Assertions.assertEquals("Invalid format.", getDriver().findElement(
                By.cssSelector(".alert")).getText());
    }
}
