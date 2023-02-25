package cucumber;

import com.codeborne.selenide.Configuration;
import data.selenide.LoginDataModel;
import data.selenide.RegistrationDataModel;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import projectObjectPatterns.selenide.*;

import static com.codeborne.selenide.Selenide.*;

public class MyStepdefs {

    private NavigationBar navigationBar;
    private PrestaShopFrame prestaShopFrame;
    private ProductGrid productGrid;
    private final SignIn signIn = new SignIn();
    private final CreateAnAccount createAnAccount = new CreateAnAccount();
    private final YourAccountPage yourAccountPage = new YourAccountPage();
    private QuickView quickView;
    private ProductAddedWindow productAddedWindow = new ProductAddedWindow();

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



    @Given("Art tab is opened")
    public void artTabIsOpened() {
        navigationBar.openArt();
    }

    @When("pressed sort from low to high")
    public void pressedSortFromLowToHigh() {
        productGrid.sortBy("low to high");
    }

    @Then("items are presented with prices from low to high")
    public void sortLowToHigh() throws InterruptedException {
        navigationBar.openArt();
        productGrid.sortBy("low to high");
        Thread.sleep(2000);
        boolean isSorted = true;
        var listed = productGrid.getProductList();
        for (int i = 0; i < listed.size()-1; i++) {
            Double firstPriceButDouble = Double.parseDouble(listed.get(i).$("span.price").getText().strip().replace("\u20AC", ""));
            Double secondPriceButDouble = Double.parseDouble(listed.get(i+1).$("span.price").getText().strip().replace("\u20AC", ""));
            if (firstPriceButDouble > secondPriceButDouble) {
                isSorted = false;
            }
        }
        Assertions.assertTrue(isSorted);
    }

    @Given("login page is open")
    public void loginPageIsOpen() {
        navigationBar.openLoginPage();
    }

    @And("user registration is completed")
    public void userRegistrationIsCompleted() {
        signIn.openNoAccount();
        createAnAccount.fillMaxData(registrationData);
    }

    @When("adding {string} to favourites")
    public void addingToFavourites(String productName) {
        productGrid.addToFavourite(productName);
    }

    @And("navigating to Wishlist")
    public void navigatingToWishlist() {
        navigationBar.openYourAccount();
        yourAccountPage.openWishlist();
    }

    @Then("{string} is listed as {string}")
    public void isListed(String productName, String displayName) {
        Assertions.assertEquals(displayName,productGrid.getDisplayedProductName(productName));
    }

    @Given("Page loaded")
    public void pageLoaded() {
            Configuration.timeout = 15000;
            Configuration.browserSize = "1920x1080";

            open("https://demo.prestashop.com");
            prestaShopFrame = new PrestaShopFrame();
            navigationBar = new NavigationBar();
            productGrid = new ProductGrid();
            quickView = new QuickView();
            prestaShopFrame.getPrestaShopUrl();
    }

    @When("searching for {string}")
    public void searchingFor(String productName) {
        navigationBar.searchFor(productName);
    }

    @Then("Items are being found")
    public void itemsAreBeingFound() {
        Assertions.assertTrue(productGrid.getProductList().size() > 0);
    }

    @Given("create your account page is opened")
    public void createYourAccountPageIsOpened() {
        navigationBar.openLoginPage();
        signIn.openNoAccount();
    }

    @When("providing no first name data")
    public void providingNoFirstNameData() {
        createAnAccount.fillMinData(noNameData);
    }

    @Then("we receive first name validation message")
    public void weReceiveFirstNameValidationMessage() {
        Assertions.assertEquals("Please fill out this field.",
                $x("//input[@name=\"firstname\"]").getAttribute("validationMessage"));
    }

    @When("providing no last name data")
    public void providingNoLastNameData() {
        createAnAccount.fillMinData(noSurnameData);
    }

    @When("providing incorrect email format")
    public void providingIncorrectEmailFormat() {
        createAnAccount.fillMinData(wrongEmailData);
    }

    @Then("we receive email validation message")
    public void weReceiveEmailValidationMessage() {
        var expectedValidationText = String.format(
                "Please include an '@' in the email address. '%s' is missing an '@'.", wrongEmailData.getEmail());
        Assertions.assertEquals(expectedValidationText,
                $x("//input[@name=\"email\"]").getAttribute("validationMessage"));
    }

    @When("providing too short password")
    public void providingTooShortPassword() {
        createAnAccount.fillMinData(tooShortPasswordData);
    }

    @Then("we receive password validation message")
    public void weReceivePasswordValidationMessage() {
        Assertions.assertEquals("Please match the requested format.",
                $x("//input[@name=\"password\"]").getAttribute("validationMessage"));
    }

    @When("providing incorrect name format")
    public void providingIncorrectNameFormat() {
        createAnAccount.fillMinData(invalidNameFormat);
    }

    @Then("we receive invalid format validation message")
    public void weReceiveInvalidFormatValidationMessage() {
        Assertions.assertEquals("Invalid format.", $(".alert").getText());
    }

    @Then("we receive last name validation message")
    public void weReceiveLastNameValidationMessage() {
        Assertions.assertEquals("Please fill out this field.",
                $x("//input[@name=\"lastname\"]").getAttribute("validationMessage"));
    }

    @And("Not logged in")
    public void notLoggedIn() {
        if($(".logout").exists()){
            $(".logout").click();
        }
    }
}
