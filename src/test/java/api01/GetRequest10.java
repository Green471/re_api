package api01;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class GetRequest10 extends TestBase{

    SoftAssert softAssert = new SoftAssert();
    @Test
    public void get01(){
        Response response= given().spec(spec02).when().get();
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        JsonPath json=response.jsonPath();

        List<String> list= json.getList("data.findAll{Integer.valueOf(it.id)>10}.id");
        System.out.println(list);
        softAssert.assertEquals(list.size(),14,"elemen sayisi is not mathced");
        softAssert.assertAll();
    }
}
