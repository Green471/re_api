package api01;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class PostRequest03 extends TestBase{

    @Test
    public void post03(){
        Map<String,String> bookingDatesMap = new HashMap<>();
        bookingDatesMap.put("checkin","2020-05-02");
        bookingDatesMap.put("checout","2020-05-29");

        Map<String,Object> reqBodyMap= new HashMap<>();
        reqBodyMap.put("firstname","Omer");
        reqBodyMap.put("lastname","Furkan");
        reqBodyMap.put("totalpreise","500");
        reqBodyMap.put("depositpaid",true);
        reqBodyMap.put("bookingdates",bookingDatesMap);
        reqBodyMap.put("additionalneeds","wifi");

        Response response= given().
                contentType(ContentType.JSON).
                spec(spec01).
                auth().
                basic("admin","password123").
                body(reqBodyMap).
                when().
                post("/booking");

        response.prettyPrint();



    }

}
