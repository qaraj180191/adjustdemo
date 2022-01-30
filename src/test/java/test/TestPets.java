package test;

import java.io.IOException;
import java.math.BigInteger;

import api.BaseAPI;
import api.pet.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import pojo.petResponse;
import pojo.updatePetServiceResponse;
import utils.PropertiesManager;

public class TestPets extends BaseTest {


    @Test(priority = 1)
    public void createPet() throws IOException {
        createPetService createpet = new createPetService(PropertiesManager.getProperty("baseURI"));
        createpet.setExpectedStatusCode(200);
        createpet.perform();
        petResponse petresponse = createpet.getAPIResponseAsPOJO(petResponse.class);
        System.out.println(petresponse.toString());
        Assert.assertEquals(petresponse.getName(),"Dog1");
        BaseAPI.petID=petresponse.getID();

        System.out.println("Create Pet ID"+BaseAPI.petID);

    }
    @Test(priority = 2)
    public void GetpetWithStatus() throws IOException {

        //BaseAPI.petID=new BigInteger("9223372000001087958");
        getPetbyStatusService getPets = new getPetbyStatusService(PropertiesManager.getProperty("baseURI"));
        getPets.setExpectedStatusCode(200);
        getPets.perform();
        petResponse[] petresponse = getPets.getAPIResponseAsPOJO(petResponse[].class);
        getPets.validateNewlyCreatepet(petresponse,BaseAPI.petID);

    }

    @Test(priority = 3)
    public void UpdatePet() throws IOException, InterruptedException {

       // BaseAPI.petID=new BigInteger("9223372000001087000");
        updatePetService updatePet = new updatePetService(PropertiesManager.getProperty("baseURI"));
        updatePet.setExpectedStatusCode(200);
        updatePet.perform();
        updatePetServiceResponse updateResponse = updatePet.getAPIResponseAsPOJO(updatePetServiceResponse.class);
        Assert.assertTrue(updateResponse.getcode()==200);
        Assert.assertEquals(updateResponse.getMessage(),String.valueOf(BaseAPI.petID));
        //As there is Delay in responce to get updated values Some Hard sleep so that Pet Database get updated and get will return correct data
        Thread.sleep(10000);
    }

    @Test(priority = 4)
    public void getPetByID() throws IOException {

        //BaseAPI.petID=new BigInteger("9223372000001087958");
        getPetbyID getPet = new getPetbyID(PropertiesManager.getProperty("baseURI"));
        getPet.setExpectedStatusCode(200);
        getPet.perform();
        petResponse updateResponse = getPet.getAPIResponseAsPOJO(petResponse.class);

        Assert.assertEquals(updateResponse.getStatus(),"pending");

    }

    @Test(priority = 5)
    public void deletePetByID() throws IOException {

        //BaseAPI.petID=new BigInteger("9223372000001087958");
        deletePetbyID deletePet = new deletePetbyID(PropertiesManager.getProperty("baseURI"));
        deletePet.setExpectedStatusCode(200);
        deletePet.perform();
        updatePetServiceResponse updateResponse = deletePet.getAPIResponseAsPOJO(updatePetServiceResponse.class);
        Assert.assertTrue(updateResponse.getcode()==200);
        Assert.assertEquals(updateResponse.getMessage(),String.valueOf(BaseAPI.petID));

    }


}
