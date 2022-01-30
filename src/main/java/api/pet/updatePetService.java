package api.pet;

import api.BaseAPI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.testng.Reporter;
import pojo.category;
import pojo.petRequest;
import pojo.photoUrls;
import pojo.tags;

import java.math.BigInteger;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;

public class updatePetService extends BaseAPI {
    String apiPath = "/v2/pet";

    public updatePetService(String baseURI) {
        super(baseURI);

    }



    private RequestSpecBuilder  AddFormData(RequestSpecBuilder requestSpecBuilder) throws JsonProcessingException {
        requestSpecBuilder.addFormParam("name","Dog3");
        requestSpecBuilder.addFormParam("status","pending");

        return requestSpecBuilder;

    }

    @Override
    protected void createRequest() throws JsonProcessingException {
        requestSpecBuilder.setBaseUri(baseURI);
        requestSpecBuilder.setBasePath(apiPath+"/"+petID);
        System.out.println("Base Url is"+baseURI);
        System.out.println("Path Url is"+apiPath+"/"+petID);
        Reporter.log("Path Url is"+apiPath+"/"+petID);

        requestSpecification = this.AddFormData(requestSpecBuilder).build();

        requestSpecification = requestSpecBuilder.build();

    }

    @Override
    protected void executeRequest() {

        apiResponse = given().config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("application/x-www-form-urlencoded",ContentType.URLENC))).spec(requestSpecification).post();

System.out.println("Response is"+apiResponse.asPrettyString());
    }

    @Override
    protected void validateResponse() {
        responseSpecBuilder.expectStatusCode(expectedStatusCode);
        responseSpecification = responseSpecBuilder.build();
        apiResponse.then().spec(responseSpecification);
    }
}
