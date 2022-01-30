package api.pet;

import api.BaseAPI;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.builder.RequestSpecBuilder;
import org.testng.Assert;
import pojo.petResponse;

import java.math.BigInteger;

import static io.restassured.RestAssured.given;

public class deletePetbyID extends BaseAPI {
    String apiPath = "v2/pet";

    public deletePetbyID(String baseURI) {
        super(baseURI);

    }



    private RequestSpecBuilder addheader(RequestSpecBuilder requestSpecBuilder) throws JsonProcessingException {
        requestSpecBuilder.addHeader("api_key","special-key");
        return requestSpecBuilder;
    }

    @Override
    protected void createRequest() throws JsonProcessingException {
        requestSpecBuilder.setBaseUri(baseURI);
        requestSpecBuilder.setBasePath(apiPath+"/"+petID);
        System.out.println("Base Url is"+baseURI);
        System.out.println("Path Url is"+apiPath);
        requestSpecification = this.addheader(requestSpecBuilder).build();
        requestSpecification = requestSpecBuilder.build();
    }

    @Override
    protected void executeRequest() {
        System.out.println("Path Url is"+requestSpecification.request().contentType("application/json"));
        apiResponse = given().spec(requestSpecification).delete();

        System.out.println("Response is"+apiResponse.asPrettyString());
    }

    @Override
    protected void validateResponse() {
        responseSpecBuilder.expectStatusCode(expectedStatusCode);
        responseSpecification = responseSpecBuilder.build();
        apiResponse.then().spec(responseSpecification);
    }



}
