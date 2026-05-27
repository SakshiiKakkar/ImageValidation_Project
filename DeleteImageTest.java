package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.APIConfig;

public class DeleteImageTest {

    @Test
    public void verifyUserCanDeleteImage() {

        int imageId = 1;

        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .when()
                .delete(APIConfig.base_URL + APIConfig.image_endpoint + "/" + imageId);

        //Status code validation
        Assert.assertTrue(response.statusCode() == 200 || response.statusCode() == 204);

        //Response time validations
        Assert.assertTrue(response.getTime() < 5000);

    }
}
