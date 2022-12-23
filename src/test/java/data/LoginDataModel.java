package data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginDataModel {
    private String email;
    private String password;

    public LoginDataModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static LoginDataModel getExampleData() {
        var email = String.format(
                "test_%s@test.com",new SimpleDateFormat("yyyyMMdd_HHmmssSS").format(new Date()));
        return new LoginDataModel(email, "aaaaaaaa");
    }

    public static LoginDataModel getWrongEmailData() {
        return new LoginDataModel("dddddddd", "aaaaaaaa");
    }

}

