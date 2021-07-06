package api01;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.*;

import static io.restassured.RestAssured.*;

public class GetRequest09 extends TestBase{
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void get01(){

        Response response= given().spec(spec02).when().get();
        response.prettyPrint();

        JsonPath json=response.jsonPath();
        System.out.println(json.getString("data.employee_name"));
        Assert.assertEquals("second name is not as expected","Garrett Winters", json.getString("data.employee_name[1]"));
        System.out.println(json.getString("data.employee_name[1]"));
        softAssert.assertEquals(json.getString("data[1].employee_name"),"Garrett Winters","second name is not as expected");
        softAssert.assertAll();



        softAssert.assertTrue(json.getList("data.employee_name").contains("Garrett Winters"),"true");
        softAssert.assertAll();
        softAssert.assertEquals(json.getList("data.id").size(),24,"24 isci yok");
        softAssert.assertAll();
        softAssert.assertEquals(json.getInt("data[5].employee_salary"),3720000,"maas is npt expected");
        softAssert.assertAll();

    }
}
