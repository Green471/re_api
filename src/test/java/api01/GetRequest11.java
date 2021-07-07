package api01;


import io.restassured.response.Response;
import org.junit.Assert;

import org.junit.Test;
import org.testng.asserts.SoftAssert;


import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class GetRequest11 extends TestBase{
    /*
     * GSON: GSON, 1) Json formatindaki data'lari Java Objectlerine donusturur.(De-Serialization)
     *  2) Java Object'lerini Json formatindaki data'lara donusturur.(Serialization)
     *
     *  Note: GSON ile ayni isi yapan ObjectMapper Class'da var
     */

    @Test
    public void get01(){

        Response response= given().spec(spec03).when().get("/2");
        response.prettyPrint();
        HashMap<String, String> map= response.as(HashMap.class); //Deserialization
        System.out.println(map);
        System.out.println(map.keySet());
        System.out.println(map.values());

       SoftAssert softAssert = new SoftAssert();
       softAssert.assertEquals(map.get("completed"),false);
       softAssert.assertAll();
    }

}

