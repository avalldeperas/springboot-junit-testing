package com.avalldeperas.springbootjunittesting.unittesting.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

/**
 * This Integration Test (IT) launches up the entire Spring Boot application, present in the main class
 * with the annotation @SpringBootApplication.
 * @SpringBootTest looks recursively in all packages in order to find the annotation @SpringBootTest and, therefore,
 * launch up all components, in-memory DB, etc.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // picks an available port
public class ItemControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws JSONException {
        String response = restTemplate.getForObject("/all-items-from-database", String.class);
        JSONAssert.assertEquals("[{id: 10001},{id: 10002},{id: 10003}]", response, false);
    }

}
