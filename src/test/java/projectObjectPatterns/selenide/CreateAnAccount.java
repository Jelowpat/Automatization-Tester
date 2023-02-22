package projectObjectPatterns.selenide;

import data.selenide.RegistrationDataModel;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import io.qameta.allure.Step;

public class CreateAnAccount {

    @Step("Send Minimum Data")
    public void fillMinData(RegistrationDataModel dataModel){
        $("#field-firstname").sendKeys(dataModel.getName());
        $("#field-lastname").sendKeys(dataModel.getSurname());
        $("#field-email").sendKeys(dataModel.getEmail());
        $("#field-password").sendKeys(dataModel.getPassword());
        $x("//input[@name=\"customer_privacy\"]").click();
        $x("//input[@name=\"psgdpr\"]").click();
        $x("//button[@type=\"submit\"]").click();
    }

    @Step("Send Maximum Data")
    public void fillMaxData(RegistrationDataModel dataModel){
        $("#field-id_gender-1").click();
        $("#field-firstname").sendKeys(dataModel.getName());
        $("#field-lastname").sendKeys(dataModel.getSurname());
        $("#field-email").sendKeys(dataModel.getEmail());
        $("#field-password").sendKeys(dataModel.getPassword());
        $("#field-birthday").sendKeys(dataModel.getBirthDate());
        $x("//input[@name=\"optin\"]").click();
        $x("//input[@name=\"customer_privacy\"]").click();
        $x("//input[@name=\"newsletter\"]").click();
        $x("//input[@name=\"psgdpr\"]").click();
        $x("//button[@type=\"submit\"]").click();
    }
}
