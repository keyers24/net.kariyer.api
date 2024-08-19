package api;

import api.utils.apiUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;
import static io.restassured.RestAssured.given;

public class searchTest extends baseTest {
    @Test(description = "Succes Valid Scnario")
    public void searchJobWithValidData() {
        JSONObject payload = apiUtils.createSearchPayload(0, 10, 1, "Developer", Arrays.asList(1, 2), true);

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .body(payload.toString())
                        .when()
                        .post("/search")
                        .then()
                        .extract()
                        .response();

        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println(response.asPrettyString());

    }

    @Test(description = "404 invalid  Scnario")
    public void searchJobWithoutKeyword() {
        JSONObject payload = apiUtils.createSearchPayload(0, 10, 1, "", Arrays.asList(1), true);

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .body(payload.toString())
                        .when()
                        .post("/searchh")
                        .then()
                        .extract()
                        .response();
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 404, "Expected a 400 Bad Request due to missing keyword");
    }
}

