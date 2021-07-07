package api01;

import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.*;

import static io.restassured.RestAssured.*;

public class getRequest12 extends TestBase{

    @Test
    public void get01(){
        Response response = given().spec(spec03).get();
        response.prettyPrint();
        ArrayList<Map<Object,Object>> listOfMap = response.as(ArrayList.class);
        System.out.println(listOfMap.get(1));
        SoftAssert softAssert =new SoftAssert() ;
        softAssert.assertEquals(listOfMap.size(),200,"size 200 degil");

        softAssert.assertEquals(listOfMap.get(121).get("completed"),true);
        softAssert.assertEquals(listOfMap.get(listOfMap.size()-2).get("title"),"numquam repellendus a magnam");

        softAssert.assertAll();
    }
}
