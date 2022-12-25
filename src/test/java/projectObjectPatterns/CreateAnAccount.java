package projectObjectPatterns;

import data.RegistrationDataModel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static framework.DriverProvider.getDriver;

public class CreateAnAccount {

    @FindBy(css = "#field-id_gender-1")
    private WebElement maleGender;

    @FindBy(css = "#field-id_gender-2")
    private WebElement femaleGender;

    @FindBy(css = "#field-firstname")
    private WebElement firstName;

    @FindBy(css = "#field-lastname")
    private WebElement lastName;

    @FindBy(css = "#field-email")
    private WebElement eMail;

    @FindBy(css = "#field-password")
    private WebElement password;

    @FindBy(css = "#field-birthday")
    private WebElement birthday;

    @FindBy(xpath = "//input[@name=\"optin\"]")
    private WebElement offers;

    @FindBy(xpath = "//input[@name=\"customer_privacy\"]")
    private WebElement dataPrivacy;

    @FindBy(xpath = "//input[@name=\"newsletter\"]")
    private WebElement newsletter;

    @FindBy(xpath = "//input[@name=\"psgdpr\"]")
    private WebElement termsAndConditions;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement submitButton;

    public CreateAnAccount(){
        PageFactory.initElements(getDriver(), this);
    }

    public void fillMinData(RegistrationDataModel dataModel){
        firstName.sendKeys(dataModel.getName());
        lastName.sendKeys(dataModel.getSurname());
        eMail.sendKeys(dataModel.getEmail());
        password.sendKeys(dataModel.getPassword());
        dataPrivacy.click();
        termsAndConditions.click();
        submitButton.click();
    }

    public void fillMaxData(RegistrationDataModel dataModel){
        maleGender.click();
        firstName.sendKeys(dataModel.getName());
        lastName.sendKeys(dataModel.getSurname());
        eMail.sendKeys(dataModel.getEmail());
        password.sendKeys(dataModel.getPassword());
        birthday.sendKeys(dataModel.getBirthDate());
        offers.click();
        dataPrivacy.click();
        newsletter.click();
        termsAndConditions.click();
        submitButton.click();
    }
}
