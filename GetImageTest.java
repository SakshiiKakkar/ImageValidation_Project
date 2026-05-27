package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.APIConfig;

public class GetImageTest {

    @Test
    public void verifyGetAllImages() {

        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .when()
                .get(APIConfig.base_URL + APIConfig.image_endpoint);

        //Validation of status code
        Assert.assertEquals(response.statusCode(), 200);

        //Response body validation
        Assert.assertFalse(response.getBody().asString().isEmpty());

        //Validation for response time
        Assert.assertTrue(response.getTime() < 5000);

        //Validation for Content type
        Assert.assertTrue(response.getContentType().contains("application/json"));

    }
}
