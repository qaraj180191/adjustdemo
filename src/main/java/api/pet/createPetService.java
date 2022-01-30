package api.pet;

import api.BaseAPI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;

import pojo.category;
import pojo.petRequest;
import pojo.photoUrls;
import pojo.tags;

import java.math.BigInteger;

import static io.restassured.RestAssured.given;

public class createPetService extends BaseAPI {
    String apiPath = "/v2/pet";

    public createPetService(String baseURI) {
        super(baseURI);

    }



    private String  addBody(RequestSpecBuilder requestSpecBuilder) throws JsonProcessingException {
        petRequest createpetRequest=new petRequest();
        createpetRequest.setID(BigInteger.ZERO);
        createpetRequest.setName("Dog1");
        createpetRequest.setStatus("available");
        category petcategory=new category();
        petcategory.setID(0);
        petcategory.setName("Personal");
        createpetRequest.setcategory(petcategory);
        tags pettags = new tags();
        pettags.setID(0);
        pettags.setName("pamerian");
        createpetRequest.settags(pettags);
        photoUrls urls =new photoUrls();
        urls.setUrls("https://www.thesprucepets.com/cute-teacup-dog-breeds-4587847");
        urls.setUrls("https://www.thesprucepets.com/cute-teacup-dog-breeds-4587848");
        System.out.println(urls.getUrls());
        createpetRequest.setphotoUrls(urls.getUrls());
        ObjectMapper obj= new ObjectMapper();
        String payload=obj.writerWithDefaultPrettyPrinter().writeValueAsString(createpetRequest);
        System.out.println("Body is"+payload);
        requestSpecBuilder.setBody(payload);

        return payload;

    }

    @Override
    protected void createRequest() throws JsonProcessingException {
        requestSpecBuilder.setBaseUri(baseURI);
        requestSpecBuilder.setBasePath(apiPath);
        System.out.println("Base Url is"+baseURI);
        System.out.println("Path Url is"+apiPath);

        requestSpecification = requestSpecBuilder.build();
        requestSpecification.body(this.addBody(requestSpecBuilder));
    }

    @Override
    protected void executeRequest() {
        System.out.println("Path Url is"+requestSpecification.request().contentType("application/json"));
        apiResponse = given().spec(requestSpecification).post();

System.out.println("Response is"+apiResponse.asPrettyString());
    }

    @Override
    protected void validateResponse() {
        responseSpecBuilder.expectStatusCode(expectedStatusCode);
        responseSpecification = responseSpecBuilder.build();
        apiResponse.then().spec(responseSpecification);
    }
}
