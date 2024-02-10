package employee;


import client.JsonplaceholderClient;
import data.JsonplaceholderDataFactory;
import io.restassured.response.Response;
import models.request.JsonplaceholderModelPOSTRequest;
import models.response.JsonplaceholderResponseModelPOST;
import org.junit.Test;


import static mother.JsonplaceholderMother.createBodyForJsonplaceholderPOST;
import static org.junit.Assert.assertEquals;

public class JsonplaceholderTests {
    @Test
    public void postJsonPlaceholderRequestDefaultValues(){

        JsonplaceholderModelPOSTRequest requestBody = new JsonplaceholderDataFactory(createBodyForJsonplaceholderPOST())
                .createRequest();


        Response postResponse = new JsonplaceholderClient()
                .postJsonplaceholder(requestBody);

        JsonplaceholderResponseModelPOST JsonplaceholderResponse = postResponse.body() .as (JsonplaceholderResponseModelPOST.class);


        assertEquals(201,postResponse.statusCode());
        assertEquals("Default title",JsonplaceholderResponse.getTitle());
        assertEquals("Default body",JsonplaceholderResponse.getBody());
    }

    @Test
    public void postJsonPlaceholderRequestValues(){

        JsonplaceholderModelPOSTRequest requestBody = new JsonplaceholderDataFactory(createBodyForJsonplaceholderPOST())
                .setTitle("Makedonija osvoi svetsko prvenstvo vo fudbal")
                .setBody("Noviot svetski prvak Makedonija go osvoi svetskoto prvenstvo vo fudbal odrzano vo Madrid")
                .createRequest();


        Response postResponse = new JsonplaceholderClient()
                .postJsonplaceholder(requestBody);

        JsonplaceholderResponseModelPOST JsonplaceholderResponse = postResponse.body() .as (JsonplaceholderResponseModelPOST.class);


        assertEquals(201,postResponse.statusCode());
        assertEquals("Makedonija osvoi svetsko prvenstvo vo fudbal",JsonplaceholderResponse.getTitle());
        assertEquals("Noviot svetski prvak Makedonija go osvoi svetskoto prvenstvo vo fudbal odrzano vo Madrid",JsonplaceholderResponse.getBody());


    }
}
