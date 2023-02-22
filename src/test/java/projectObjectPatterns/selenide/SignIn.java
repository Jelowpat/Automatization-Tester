package projectObjectPatterns.selenide;

import data.selenide.LoginDataModel;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class SignIn {

    @Step("Sign in")
    public void trySigningIn(LoginDataModel dataModel){
        $("#field-email").sendKeys(dataModel.getEmail());
        $("#field-password").sendKeys(dataModel.getPassword());
        $x("//button[@type=\"submit\"]").click();
    }

    @Step("Open Forgot Password Page")
    public void openForgotYourPassword(){
        $(".forgot-password > a").click();

    }

    @Step("Open Registration Page")
    public void openNoAccount(){
        $(".no-account > a").click();
    }
}
