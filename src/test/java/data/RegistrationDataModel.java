package data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrationDataModel {

    private String name;
    private String surname;
    private String email;
    private String password;
    private String birthDate;

    public RegistrationDataModel(String name, String surname, String email, String password, String birthDate) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
    }

    public RegistrationDataModel(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
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
        var email = String.format("test_%s@test.com",new SimpleDateFormat("yyyyMMdd_HHmmssSS").format(new Date()));
        return new RegistrationDataModel("aaa", "bbb", email, "aaaaaaaa");
    }

    public static RegistrationDataModel getWrongEmailData() {
        return new RegistrationDataModel("aaa", "bbb", "dddddddd", "aaaaaaaa");
    }

}
