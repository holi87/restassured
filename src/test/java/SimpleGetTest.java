import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleGetTest {
    private String uri = "http://restapi.demoqa.com/utilities/weather/city";
    private RequestSpecification httpRequest = setHttpRequest(uri);

    @Test
    public void negativeGetTest() {
        Response response = sendGet(httpRequest, "/test");
        printHeader(response);
        printBody(response);
        Assert.assertEquals(response.statusCode(), 200, "Incorrect status code");

    }
    @Test
    public void positiveGetTest() {
        Response response = sendGet(httpRequest, "/Hyderabad");
        printHeader(response);
        printBody(response);
        Assert.assertEquals(response.statusCode(), 200, "Incorrect status code");

    }

    private void printHeader(Response response) {
        Headers allHeaders = response.headers();
        System.out.println("Header: ");
        for (Header header :
                allHeaders) {
            System.out.println(header.getName() + " : " + header.getValue());

        }
    }

    private Response sendGet(RequestSpecification httpRequest, String endpoint) {
        return httpRequest.request(Method.GET, endpoint);
    }

    private void printBody(Response response) {
        System.out.println("Response body: \n" + response.getBody().asString());
    }

    private RequestSpecification setHttpRequest(String uri) {
        RestAssured.baseURI = uri;
        return RestAssured.given();
    }


}
