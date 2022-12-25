package prestaShopTests;

import data.LoginDataModel;
import data.RegistrationDataModel;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import projectObjectPatterns.*;

import framework.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static framework.DriverProvider.getDriver;

public class PageObjectPatternTests extends BaseTest{

    private NavigationBar navigationBar;
    private PrestaShopFrame prestaShopFrame;
    private ProductGrid productGrid;
    private final SignIn signIn = new SignIn();
    private final CreateAnAccount createAnAccount = new CreateAnAccount();
    private final YourAccountPage yourAccountPage = new YourAccountPage();
    private QuickView quickView;
    private ProductAddedWindow productAddedWindow = new ProductAddedWindow();

    RegistrationDataModel registrationData = new RegistrationDataModel(
            "Patryk","Jelowicki", "kolorek94@wp.pl", "future", "12/12/1994");

    LoginDataModel loginData = new LoginDataModel("kolorek94@wp.pl", "future");


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
    public void allSortOfFunctionsTest() throws InterruptedException {
        navigationBar.selectLanguage("Polski");
        navigationBar.selectLanguage("English");
        navigationBar.openAccessoriesHome();
        navigationBar.openAccessoriesStationery();
        navigationBar.openClothesMen();
        navigationBar.openClothesWomen();
        navigationBar.openAccessoriesHome();
        navigationBar.openArt();
        navigationBar.openClothesWomen();

        productGrid.openQuickView("Hummingbird");

        quickView.setSize("M");
        quickView.setQuantity(3);
        quickView.clickAddToCart();
        Assertions.assertEquals("\uE876Product successfully added to your shopping cart",
                productAddedWindow.getSuccessConfirmation());
        productAddedWindow.clickContinueShopping();
        navigationBar.openMyStore();
        navigationBar.openCart();
        navigationBar.openContactUs();
        navigationBar.openLoginPage();
        navigationBar.searchFor("Mug");
        Assertions.assertTrue(productGrid.getProductList().size() > 0);}


}
