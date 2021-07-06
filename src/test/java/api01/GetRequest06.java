package api01;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static io.restassured.RestAssured.given;

public class GetRequest06 extends TestBase {

    @Test
    public void get01(){
        Response response= given().
                spec(spec01).
                when().
                get("/booking/5");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
                body("firstname", equalTo("Mark"),
                        "lastname",equalTo("Jackson"),
                        "totalprice",equalTo(738),
                        "depositpaid",equalTo(true),
                        "bookingdates.checkin",equalTo("2019-03-19"),
                        "bookingdates.checkout",equalTo("2020-05-09"),
                        "additionalneeds",equalTo("Breakfast"));

    }



}
