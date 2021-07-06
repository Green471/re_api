package api01;

import io.restassured.response.Response;

import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;


public class GetRequest07 extends TestBase {

    @Test
    public void get01(){
        Response response= given().spec(spec01).get("/booking?firstname=Susan");
        response.prettyPrint();
       assertTrue(response.getBody().toString().contains("bookingid"));
    }

    @Test
    public void get02(){
        spec01.queryParams("firstname","Susan");
        Response response= given().spec(spec01).get("/booking");
        response.prettyPrint();
        Assert.assertTrue(response.getBody().toString().contains("bookingid"));
    }

}
