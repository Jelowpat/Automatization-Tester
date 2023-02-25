package backend.data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateUserGoRestV2RQ {
    private String name;
    private String gender;
    private final String email = String.format("test_%s@test.com",new SimpleDateFormat("yyyyMMdd_HHmmssSS").format(new Date()));
    private String status;

    public CreateUserGoRestV2RQ(String name, String gender, String status) {
        this.name = name;
        this.gender = gender;
        this.status = status;
    }
}
