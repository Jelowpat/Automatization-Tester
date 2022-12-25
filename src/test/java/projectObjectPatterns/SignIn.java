package projectObjectPatterns;

import data.LoginDataModel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static framework.DriverProvider.getDriver;


public class SignIn {
    @FindBy(css = "#field-email")
    private WebElement emailField;

    @FindBy(css = "#field-password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement signInButton;

    @FindBy(css = ".forgot-password > a")
    private WebElement forgotPassword;

    @FindBy(css = ".no-account > a")
    private WebElement noAccount;


    public SignIn(){
        PageFactory.initElements(getDriver(), this);
    }

    public void trySigningIn(LoginDataModel dataModel){
        emailField.sendKeys(dataModel.getEmail());
        passwordField.sendKeys(dataModel.getPassword());
        signInButton.click();
    }

    public void openForgotYourPassword(){
        forgotPassword.click();

    }
    public void openNoAccount(){
        noAccount.click();
    }
}
