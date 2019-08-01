import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleGetTest {
    private String uri = "http://restapi.demoqa.com/utilities/weather/city";

    @Test
    public void positiveGetTest() {
        RequestSpecification httpRequest = setHttpRequest(uri);
        sendGet(httpRequest, "/Hyderabad");
    }

    @Test
    public void negativeGetTest() {
        RequestSpecification httpRequest = setHttpRequest(uri);
        sendGet(httpRequest, "/xdafafsa");
    }

    private RequestSpecification setHttpRequest(String uri) {
        RestAssured.baseURI = uri;
        return RestAssured.given();
    }

    private void sendGet(RequestSpecification httpRequest, String s) {
        Response response = httpRequest.request(Method.GET, s);
        int statusCode = response.statusCode();
        System.out.println("Response body: " + response.getBody().asString());
        Assert.assertEquals(statusCode, 200, "Incorrect status code");
    }

}
