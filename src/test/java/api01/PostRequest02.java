package api01;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class PostRequest02 extends  TestBase{
    @Test
    public void post01(){
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
        response.prettyPrint();


    }
}
