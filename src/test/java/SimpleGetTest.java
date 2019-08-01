
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleGetTest {

    @Test
    public void GetWeatherDetails() {
        RequestSpecification httpRequest = setHttpRequest();
        sendGet(httpRequest, "/Hyderabad");
        sendGet(httpRequest, "/xdafafsa");
    }

    private RequestSpecification setHttpRequest() {
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
        return RestAssured.given();
    }

    private void sendGet(RequestSpecification httpRequest, String s) {
        Response response = httpRequest.request(Method.GET, s);
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200, "Incorrect status code");
    }

}
