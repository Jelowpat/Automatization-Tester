package data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContactFormDataModel {

    private String email;
    private String message;
    private String selectorData;
    private String linkToAttachment;

    public ContactFormDataModel(String email, String message, String selectorData, String linkToAttachment) {
        this.email = email;
        this.message = message;
        this.selectorData = selectorData;
        this.linkToAttachment = linkToAttachment;
    }

    public ContactFormDataModel(String email, String message) {
        this.email = email;
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

    public String getSelectorData() {
        return selectorData;
    }

    public String getLinkToAttachment() {
        return linkToAttachment;
    }

    public static ContactFormDataModel getMinimumData(){
        return new ContactFormDataModel("abc@aa.pl", "message");
    }

    public static ContactFormDataModel getRandomEmail(){
        var email = String.format("test_%s@test.com",new SimpleDateFormat("yyyyMMdd_HHmmssSS").format(new Date()));
        return new ContactFormDataModel(email,"message");
    }

}
