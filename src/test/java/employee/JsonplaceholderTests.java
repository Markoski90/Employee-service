package employee;

import client.JsonplaceholderClient;
import data.JsonplaceholderDataFactory;
import io.restassured.response.Response;
import models.request.JsonplaceholderRequestModelPOSTPUT;
import models.response.*;
import org.junit.Test;


import java.util.List;

import static mother.JsonplaceholderMother.createBodyForJsonplaceholderPOST;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;



public class JsonplaceholderTests {
    String titleId1 ="sunt aut facere repellat provident occaecati excepturi optio reprehenderit";
    String bodyId1 ="quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto";

    @Test
    public void getJsonplaceholderAllPosts(){

        Response getResponse = new JsonplaceholderClient()
                .getAllPosts();
        List <JsonplacehodlerResponseModelGETAll> JsonplaceholderResponse = getResponse
                .body()
                .jsonPath()
                .getList("",JsonplacehodlerResponseModelGETAll.class);

        assertEquals(200,getResponse.statusCode());
        assertFalse(JsonplaceholderResponse.isEmpty());


    }

    @Test
    public void getPostById(){

        Response getResponse = new JsonplaceholderClient()
                .getPostById("1");

        JsonplacehodlerResponseModelGETAll postsResponse = getResponse.body().as(JsonplacehodlerResponseModelGETAll.class);

        assertEquals(200, getResponse.statusCode());
        assertEquals(titleId1, postsResponse.getTitle());
        assertEquals(bodyId1, postsResponse.getBody());

    }





    @Test
    public void postJsonPlaceholderRequestDefaultValuesTest(){

        JsonplaceholderRequestModelPOSTPUT requestBody = new JsonplaceholderDataFactory(createBodyForJsonplaceholderPOST())
                .createRequest();


        Response postResponse = new JsonplaceholderClient()

                .postPosts(requestBody);

        JsonplaceholderResponseModelPOSTPUT JsonplaceholderResponse = postResponse.body() .as (JsonplaceholderResponseModelPOSTPUT.class);


        assertEquals(201,postResponse.statusCode());
        assertEquals("Default title",JsonplaceholderResponse.getTitle());
        assertEquals("Default body",JsonplaceholderResponse.getBody());

    }

    @Test
    public void postJsonPlaceholderRequestValues(){

        JsonplaceholderRequestModelPOSTPUT requestBody = new JsonplaceholderDataFactory(createBodyForJsonplaceholderPOST())
                .setTitle("Makedonija osvoi svetsko prvenstvo vo fudbal")
                .setBody("Noviot svetski prvak Makedonija go osvoi svetskoto prvenstvo vo fudbal odrzano vo Madrid")
                .createRequest();


        Response postResponse = new JsonplaceholderClient()
                .postPosts(requestBody);

        JsonplaceholderResponseModelPOSTPUT JsonplaceholderResponse = postResponse.body() .as (JsonplaceholderResponseModelPOSTPUT.class);


        assertEquals(201,postResponse.statusCode());
        assertEquals("Makedonija osvoi svetsko prvenstvo vo fudbal",JsonplaceholderResponse.getTitle());
        assertEquals("Noviot svetski prvak Makedonija go osvoi svetskoto prvenstvo vo fudbal odrzano vo Madrid",JsonplaceholderResponse.getBody());
    }

    @Test
    public void updateJsonplaceholderTest(){

        JsonplaceholderRequestModelPOSTPUT requestBody = new JsonplaceholderDataFactory(createBodyForJsonplaceholderPOST())
                .setTitle("My Title")
                .setBody("This is body")
                .createRequest();

        Response postResponse = new JsonplaceholderClient()
                .updatePosts(requestBody,"2");

        JsonplaceholderResponseModelPOSTPUT JsonplaceholderResponse = postResponse.body() .as (JsonplaceholderResponseModelPOSTPUT.class);


        assertEquals(200,postResponse.statusCode());
        assertEquals("My Title",JsonplaceholderResponse.getTitle());
        assertEquals("This is body",JsonplaceholderResponse.getBody());


    }
    @Test
    public void deleteJsonplaceholderTest(){


        Response deleteResponse = new JsonplaceholderClient()
                .deletePost("5");

        JsonplaceholderResponseDELETE JsonplaceholderResponse = deleteResponse.body() .as (JsonplaceholderResponseDELETE.class);

        assertEquals(200,deleteResponse.statusCode());


    }
}
