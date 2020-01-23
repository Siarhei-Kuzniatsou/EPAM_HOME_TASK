package TestAutomation;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class RestAssuredTest {

    @Test
    public void testJSONPlaceholder(){
        Response response = given().when().get("https://jsonplaceholder.typicode.com/albums").then().extract().response();
//        response.as(RestAssuredForMyTest.class);
    }

    @Test
    public void testJSONPlaceholder2(){
        given().when().get("https://jsonplaceholder.typicode.com/albums/2").then().assertThat().body("title", equalTo("sunt qui excepturi placeat culpa"));
    }

}
