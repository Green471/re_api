package api01;


import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import org.junit.Test;



public class getRequest13 extends TestBase{

    @Test
    public void get01() {
        Response response = given().
                spec(spec02).
                when().
                get();
        response.prettyPrint();
    }

   /*     SoftAssert softAssert = new SoftAssert();
            JsonPath json= response.jsonPath();

        softAssert.assertEquals(json.getString("data.[0].employee_name"),"Tiger Nixon");
        softAssert.assertEquals(json.getString("data.[1].employee_name"),"Garrett Winters");


        List<String> isimList = new ArrayList<>();
        isimList.add("Tiger Nixon");
        isimList.add("Garrett Winters");
        isimList.add("Ashton Cox");
        isimList.add("Cedric Kelly");
        isimList.add("Airi Satou");



        for (int i=0; i<isimList.size();i++){
            softAssert.assertEquals(json.getString("data["+i+"].employee_name"),isimList.get(i));

        }


        List<String> firstfive = new ArrayList<String>();
        firstfive.add("Tiger Nixon");
        firstfive.add("Garrett Winters");
        firstfive.add("Ashton Cox");
        firstfive.add("Cedric Kelly");
        firstfive.add("Airi Satou");

        softAssert.assertEquals(json.getList("data[0,1,2,3,4].employee_name" ),firstfive);
        softAssert.assertAll();

    */




}
