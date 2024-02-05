package employee;


import client.JsonplaceholderClient;
import data.JsonplaceholderDataFactory;
import io.restassured.response.Response;
import models.request.JsonplaceholderRequestModelPOST;
import models.response.JsonplaceholderResponseModelPOST;
import org.junit.Test;



import static mother.JsonplaceholderMother.createBodyForJsonplaceholderPOST;
import static org.junit.Assert.assertEquals;

public class JsonplaceholderTests {
    @Test
    public void postJsonplaceholderRequestDefaultValues(){
        JsonplaceholderRequestModelPOST requestBody = new JsonplaceholderDataFactory(createBodyForJsonplaceholderPOST())
                .createRequest();


        Response postResponse = new JsonplaceholderClient()
                .postJsonplaceholder(requestBody);


        JsonplaceholderResponseModelPOST JsonplaceholderResponse = postResponse.body() .as (JsonplaceholderResponseModelPOST.class);

        //pravime sporedbi na vrednostite
        assertEquals(201,postResponse.statusCode());
       assertEquals("Default title",JsonplaceholderResponse.getData().getTitle());
        assertEquals("Default body",JsonplaceholderResponse.getData().getBody());


    }

    @Test
    public void postJsonplacehoderDefaultRequest(){

        JsonplaceholderRequestModelPOST requestBody = new JsonplaceholderDataFactory(createBodyForJsonplaceholderPOST())
                .setTitle("Petko")
                .setBody("30")


                .createRequest();

        Response postResponse = new JsonplaceholderClient()
                .postJsonplaceholder(requestBody);

        JsonplaceholderResponseModelPOST JsonplaceholderResponse = postResponse.body() .as (JsonplaceholderResponseModelPOST.class);


        assertEquals(201,postResponse.statusCode());
       assertEquals("Petko",JsonplaceholderResponse.getData().getTitle());
       assertEquals("30",JsonplaceholderResponse.getData().getBody());


    }
}

