package backend;

import backend.data.CreateUserGoRestV2RQ;
import backend.data.CreateUserGoRestV2RS;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BackendTest {

    public static final String BEARER = "Bearer 8d5d0e78b790d72f6b6db8a51e895639e35d80d45c197704db1ad1adabc724dc";
    public static final Gson gson = new Gson();

    @Test
    public void createUserTest() throws IOException, InterruptedException {

        var payloadObj = new CreateUserGoRestV2RQ("Patryk Tester", "male", "active");

        var httpClient = HttpClient.newHttpClient();


        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", BEARER)
                .uri(URI.create("https://gorest.co.in/public/v2/users"))
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(payloadObj)))
                .build();

        HttpResponse<String> postResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        Assertions.assertEquals(201, postResponse.statusCode());

        var response = gson.fromJson(postResponse.body(), CreateUserGoRestV2RS.class);

        Assertions.assertEquals("Patryk Tester", response.getName());

        HttpRequest requestGet = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", BEARER)
                .uri(URI.create("https://gorest.co.in/public/v2/users"))
                .GET()
                .build();

        HttpResponse<String> getResponse = httpClient.send(requestGet, HttpResponse.BodyHandlers.ofString());

        Assertions.assertEquals(200, getResponse.statusCode());


    }

}
