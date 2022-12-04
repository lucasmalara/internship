package com.internship.adb.scheduling.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class ScheduleTask {

    // printing random fact every 8s.
    @Scheduled(fixedRate = 8000)
    public void printRandomFact() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://dog-facts-api.herokuapp.com/api/v1/resources/dogs?number=1"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String fact = response.body();
        String[] split = fact.split("\"");
        System.out.print("\n" + split[3]);
    }
}