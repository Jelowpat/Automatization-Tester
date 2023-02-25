package backend.homework20;

import backend.data.*;
import com.codeborne.selenide.SelenideElement;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;


public class hw20 {

    public static final Gson gson = new Gson();

    @Test
    public void createUserTest() throws IOException, InterruptedException {

        var payloadObj = new CreateUserDummyRQ("Patryk Tester", "123", "33");

        var httpClient = HttpClient.newHttpClient();


        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .uri(URI.create("https://dummy.restapiexample.com/api/v1/create"))
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(payloadObj)))
                .build();

        HttpResponse<String> postResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        Assertions.assertEquals(200, postResponse.statusCode());
        var response = gson.fromJson(postResponse.body(), CreateUserDummyRS.class);
        Assertions.assertEquals("Patryk Tester", response.getData().getName());
    }

    @Test
    public void getUsersTest() throws IOException, InterruptedException {

        var httpClient = HttpClient.newHttpClient();

        HttpRequest requestGet = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .uri(URI.create("https://dummy.restapiexample.com/api/v1/employees"))
                .GET()
                .build();

        HttpResponse<String> getResponse = httpClient.send(requestGet, HttpResponse.BodyHandlers.ofString());
        Assertions.assertEquals(200, getResponse.statusCode());
        var responseGet = gson.fromJson(getResponse.body(), GetUsersDummyRS.class);
        var listOfUsers = responseGet.getData();

        var nameList = new ArrayList<>();
        for (GetUsersDummyUserRS element : listOfUsers) {
            nameList.add(element.getEmployee_name());
        }
        Assertions.assertTrue(nameList.contains("Tiger Nixon"));
    }
}
