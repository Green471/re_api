package api01;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Before;


import static io.restassured.RestAssured.*;

public class TestBase {

    protected RequestSpecification spec01,spec02, spec03;



    @Before
    public void setUp01() {
        spec01 = new RequestSpecBuilder().
                setBaseUri("https://restful-booker.herokuapp.com").
                build();
    }
    @Before
    public void setUp02(){
        spec02= new RequestSpecBuilder().
                setBaseUri("http://dummy.restapiexample.com/api/v1/employees").
                build();


    }

    @Before
    public void setUp03(){
        spec03=new RequestSpecBuilder().
                setBaseUri("http://jsonplaceholder.typicode.com/todos").
                build();
    }


    protected Response createRequestBody(){
        JSONObject jsonBookingDatesBody= new JSONObject();
        jsonBookingDatesBody.put("checkin","2000-05-06");
        jsonBookingDatesBody.put("checkout","2000-05-06");

        JSONObject jsonReqBody=new JSONObject();
        jsonReqBody.put("firstname","Adil");
        jsonReqBody.put("lastname","2000-05-06");
        jsonReqBody.put("totalprice",5000);
        jsonReqBody.put("depositpaid",true);
        jsonReqBody.put("bookingdates",jsonBookingDatesBody);
        jsonReqBody.put("additionalneeds","Wifi");

        Response response= given().
                contentType(ContentType.JSON).
                spec(spec01).auth().
                basic("admin","password123").
                body(jsonReqBody.toString()).when().post("/booking");

        return response;
    }



}
