package backend.data;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class GetUsersDummyRS {
    private String status;
    private ArrayList<GetUsersDummyUserRS> data;
    private String message;
}
