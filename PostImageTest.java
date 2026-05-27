package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.Image;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.APIConfig;
import utils.TestData;

public class PostImageTest {

    @Test
    public void verifyUserCanCreateImage() {

        Image image = new Image(TestData.imageTitle, TestData.imageURL);

        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(image)
                .when()
                .post(APIConfig.base_URL + APIConfig.image_endpoint);

        //Status code validation
        Assert.assertEquals(response.statusCode(), 201);

        //Response body validation
        Assert.assertEquals(response.jsonPath().getString("title"), TestData.imageTitle);

        //URL validation
        Assert.assertEquals(response.jsonPath().getString("url"), TestData.imageURL);

    }
}
