package homeworkButSelenide;

import com.codeborne.selenide.Configuration;
import data.selenide.LoginDataModel;
import data.selenide.RegistrationDataModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectObjectPatterns.selenide.*;

import static com.codeborne.selenide.Selenide.*;

public class Lesson12 {

    private final SignIn signIn = new SignIn();
    private final CreateAnAccount createAnAccount = new CreateAnAccount();
    private final YourAccountPage yourAccountPage = new YourAccountPage();
    RegistrationDataModel registrationData = new RegistrationDataModel.RegistrationDataModelBuilder().build();
    RegistrationDataModel noNameData = new RegistrationDataModel.RegistrationDataModelBuilder()
            .setName("").build();
    RegistrationDataModel noSurnameData = new RegistrationDataModel.RegistrationDataModelBuilder()
            .setSurname("").build();
    RegistrationDataModel wrongEmailData = new RegistrationDataModel.RegistrationDataModelBuilder()
            .setEmail("kolorek94wppl").build();
    RegistrationDataModel tooShortPasswordData = new RegistrationDataModel.RegistrationDataModelBuilder()
            .setPassword("fut").build();
    LoginDataModel loginData = new LoginDataModel.LoginDataModelBuilder().build();
    RegistrationDataModel invalidNameFormat = new RegistrationDataModel.RegistrationDataModelBuilder()
            .setName("Patryk%%%").build();
    private NavigationBar navigationBar;
    private PrestaShopFrame prestaShopFrame;
    private ProductGrid productGrid;
    private QuickView quickView;
    private ProductAddedWindow productAddedWindow = new ProductAddedWindow();

    @BeforeEach
    public void setup() {
        Configuration.timeout = 15000;
        Configuration.browserSize = "1920x1080";

        open("https://demo.prestashop.com");
        prestaShopFrame = new PrestaShopFrame();
        navigationBar = new NavigationBar();
        productGrid = new ProductGrid();
        quickView = new QuickView();
        prestaShopFrame.getPrestaShopUrl();
    }

    @Test
    public void sortLowToHigh() throws InterruptedException {
        navigationBar.openArt();
        productGrid.sortBy("low to high");
        Thread.sleep(2000);
        boolean isSorted = true;
        var listed = productGrid.getProductList();
        for (int i = 0; i < listed.size() - 1; i++) {
            Double firstPriceButDouble = Double.parseDouble(listed.get(i).$("span.price")
                    .getText().replaceAll("[^\\d\\.]", ""));
            Double secondPriceButDouble = Double.parseDouble(listed.get(i + 1).$("span.price")
                    .getText().strip().replace("\u20AC", ""));
            if (firstPriceButDouble > secondPriceButDouble) {
                isSorted = false;
            }
        }
        Assertions.assertTrue(isSorted);
    }

    @Test
    public void registerAndAddToFavourite() {

        navigationBar.openLoginPage();
        signIn.trySigningIn(loginData);
        signIn.openNoAccount();
        createAnAccount.fillMaxData(registrationData);
        navigationBar.openArt();
        productGrid.addToFavourite("Brown Bear");
        navigationBar.openYourAccount();
        yourAccountPage.openWishlist();
        Assertions.assertEquals("Brown bear - Vector graphics", productGrid.getDisplayedProductName("bear"));
    }


    @Test
    public void searchForMugTest() {
        navigationBar.searchFor("Mug");
        Assertions.assertTrue(productGrid.getProductList().size() > 0);
    }

    @Test
    public void dataValidationNoFirstNameTest() {
        navigationBar.openLoginPage();
        signIn.openNoAccount();
        createAnAccount.fillMinData(noNameData);
        Assertions.assertEquals("Please fill out this field.",
                $x("//input[@name=\"firstname\"]").getAttribute("validationMessage"));

    }

    @Test
    public void dataValidationNoLastNameTest() {
        navigationBar.openLoginPage();
        signIn.openNoAccount();
        createAnAccount.fillMinData(noSurnameData);
        Assertions.assertEquals("Please fill out this field.",
                $x("//input[@name=\"lastname\"]").getAttribute("validationMessage"));
    }

    @Test
    public void dataValidationWrongEmailTest() {
        navigationBar.openLoginPage();
        signIn.openNoAccount();
        createAnAccount.fillMinData(wrongEmailData);
        var expectedValidationText = String.format(
                "Please include an '@' in the email address. '%s' is missing an '@'.", wrongEmailData.getEmail());
        Assertions.assertEquals(expectedValidationText,
                $x("//input[@name=\"email\"]").getAttribute("validationMessage"));
    }

    @Test
    public void dataValidationTooShortPasswordTest() {
        navigationBar.openLoginPage();
        signIn.openNoAccount();
        createAnAccount.fillMinData(tooShortPasswordData);
        Assertions.assertEquals("Please match the requested format.",
                $x("//input[@name=\"password\"]").getAttribute("validationMessage"));
    }

    @Test
    public void dataValidationInvalidNameFormatTest() {
        navigationBar.openLoginPage();
        signIn.openNoAccount();
        createAnAccount.fillMinData(invalidNameFormat);
        Assertions.assertEquals("Invalid format.", $(".alert").getText());
    }
}
