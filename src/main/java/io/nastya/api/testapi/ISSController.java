package io.nastya.api.testapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

@RestController
public class ISSController {

    private String URI = "https://api.wheretheiss.at/v1/satellites";
    private String satelliteId = "25544";

    @GetMapping("/")
    public String getSatellites() throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        return client.send(HttpRequest.newBuilder()
                .uri(new URI(URI))
                .GET()
                .build(), HttpResponse.BodyHandlers.ofString()).body();
    }

    //25544 - id of ISS
    @GetMapping("/25544")
    public String whereIsISSNow() throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        return client.send(HttpRequest.newBuilder()
                .uri(new URI(URI+ "/" +satelliteId))
                .GET()
                .build(), HttpResponse.BodyHandlers.ofString()).body();
    }
}
