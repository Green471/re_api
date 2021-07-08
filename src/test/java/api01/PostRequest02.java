package api01;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class PostRequest02 extends  TestBase{
    @Test
    public void post01(){
       Response response= createRequestBody();
       response.prettyPrint();



    }
}
