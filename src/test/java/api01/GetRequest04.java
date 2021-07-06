package api01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GetRequest04 {
    /*
    Positive Scenario:
        When I send a GET Request to
        http://dummy.restapiexample.com/api/v1/employees
        And Accept type  “application/JSON” should be 200
        Then
        HTTP Status Code 200 olsun
        And Response'in format should be "application/JSON"
        And there should be 24 employees
        And "Ashton Cox" should be one of the employees
        And 21, 61, ve 23 should be among the employee ages
   */
    @Test
    public void get01(){

        Response response = given().accept(ContentType.JSON).
                when().get("http://dummy.restapiexample.com/api/v1/employees");
        response.prettyPrint();
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("data.id", Matchers.hasSize(24),
                        "data.employee_name",Matchers.hasItem("Ashton Cox"),
                "data.employee_age",Matchers.hasItems(63,61,66));




    }
}
