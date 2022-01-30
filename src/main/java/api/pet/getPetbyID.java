package api.pet;

import api.BaseAPI;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.builder.RequestSpecBuilder;
import org.testng.Assert;
import pojo.petResponse;

import java.math.BigInteger;

import static io.restassured.RestAssured.given;

public class getPetbyID extends BaseAPI {
    String apiPath = "v2/pet";

    public getPetbyID(String baseURI) {
        super(baseURI);

    }





    @Override
    protected void createRequest() throws JsonProcessingException {
        requestSpecBuilder.setBaseUri(baseURI);
        requestSpecBuilder.setBasePath(apiPath+"/"+petID);
        System.out.println("Base Url is"+baseURI);
        System.out.println("Path Url is"+apiPath);
        //requestSpecification = this.addqueryparameter(requestSpecBuilder).build();
        requestSpecification = requestSpecBuilder.build();
    }

    @Override
    protected void executeRequest() {
        System.out.println("Path Url is"+requestSpecification.request().contentType("application/json"));
        apiResponse = given().spec(requestSpecification).get();

        System.out.println("Response is"+apiResponse.asPrettyString());
    }

    @Override
    protected void validateResponse() {
        responseSpecBuilder.expectStatusCode(expectedStatusCode);
        responseSpecification = responseSpecBuilder.build();
        apiResponse.then().spec(responseSpecification);
    }

    public void validateNewlyCreatepet(petResponse[] petresponse,BigInteger petID) {
        for(int i=0;i<petresponse.length;i++)
        {
            if(petresponse[i].getID().compareTo(petID)==0)
            {
                Assert.assertEquals(petresponse[i].getStatus(),"available");
                System.out.println("Index matched with index"+i);
                break;
            }

        }
    }

}
