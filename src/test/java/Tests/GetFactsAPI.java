package Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GetFactsAPI {

    @Test
    public void verifySingleCatFact() {
        // Base URL for the API
        RestAssured.baseURI = "https://catfact.ninja";

        // Query parameters
        String animalType = "cat";
        int amount = 1;

        // Send a GET request with query parameters
        Response response = RestAssured
                .given()
                .queryParam("animal_type", animalType)
                .queryParam("amount", amount)
                .when()
                .get("/facts/random")
                .then()
                .statusCode(200) // Assert that the status code is 200
                .extract()
                .response();

        // Extract and validate the fact
        String fact = response.jsonPath().getString("fact");
        Assert.assertNotNull(fact, "The cat fact should not be null");
        System.out.println("Single Cat Fact: " + fact);
    
    }
}
