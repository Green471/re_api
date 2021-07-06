package api01;



import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import static io.restassured.RestAssured.*;



public class GetRequest05 {
    @Test
    public void get01() {
        Response response = given().

                when().
                get("https://restful-booker.herokuapp.com/booking/5");
        response.prettyPrint();
        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname", Matchers.equalTo("Mark")).
                body("totalprice", Matchers.equalTo(999)).
                body("bookingdates.checkin", Matchers.equalTo("2017-08-06"));

    }


}
