package data.selenide;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrationDataModel {

    private String name;
    private String surname;
    private String email;
    private String password;
    private String birthDate;

    private RegistrationDataModel(){
    }


    public static class RegistrationDataModelBuilder {
        private String name = "Patryk";
        private String surname = "Jelowicki";
        private String email = "kolorek94@wp.pl";
        private String password = "future123";
        private String birthDate = "12/12/1994";


        public RegistrationDataModelBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public RegistrationDataModelBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public RegistrationDataModelBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public RegistrationDataModelBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public RegistrationDataModelBuilder setBirthDate(String birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public RegistrationDataModel build(){
            var registartionDataModel = new RegistrationDataModel();
            registartionDataModel.name = this.name;
            registartionDataModel.surname = this.surname;
            registartionDataModel.email = this.email;
            registartionDataModel.password = this.password;
            registartionDataModel.birthDate = this.birthDate;

            return registartionDataModel;
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public static RegistrationDataModel getExampleData() {
        return new RegistrationDataModelBuilder()
                .setEmail(String.format("test_%s@test.com",new SimpleDateFormat("yyyyMMdd_HHmmssSS").format(new Date())))
                .build();
    }
}
