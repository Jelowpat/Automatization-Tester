package data.selenide;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginDataModel {
    private String email;
    private String password;

    private LoginDataModel() {
    }

    public static LoginDataModel getWrongEmailData() {
        return new LoginDataModelBuilder().setEmail("aaaaaa").setPassword("ssssssssssss").build();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static class LoginDataModelBuilder {
        private String email = String.format(
                "test_%s@test.com", new SimpleDateFormat("yyyyMMdd_HHmmssSS").format(new Date()));
        private String password = "future123";

        public LoginDataModelBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public LoginDataModelBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public LoginDataModel build() {
            var loginDataModel = new LoginDataModel();
            loginDataModel.email = this.email;
            loginDataModel.password = this.password;
            return loginDataModel;
        }

    }
}