package api01;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GetRequest01 {
    // Rest-Assured kullanarak Testing Yaptim
    // I tested the api by using Rest-Assured library.
    @Test
    public void getMethod01(){
      given(). //given methodu restAsured'den geliyor
                when().//when'den sonra get put patch delete methode'larini kullanacagig
                get("https://restful-booker.herokuapp.com/booking").
                then(). // then'den sonra assertion yapariz
                assertThat().statusCode(200);

    }

    @Test
    public void getMethod02(){
       Response response= given().
                when().
                get("https://restful-booker.herokuapp.com/booking/3");
                response.prettyPrint();

        System.out.println("statusCode "+response.getStatusCode());
        System.out.println("statusLine "+response.getStatusLine());
        System.out.println("contentType: "+response.getContentType());
        System.out.println("Date: "+response.getHeader("Date"));

        //Assertion
        response.
                then().
                statusCode(200).
                assertThat().
                contentType("application/json; charset=utf-8");
    }
}
