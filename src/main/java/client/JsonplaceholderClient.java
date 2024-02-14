package client;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.request.JsonplaceholderRequestModelPOSTPUT;
import util.Configuration;


public class JsonplaceholderClient {


        public  Response postPosts(JsonplaceholderRequestModelPOSTPUT request){
            return RestAssured.given()
                    .contentType(ContentType.JSON)
                    .when().log().all()
                    .body(request)
                    .post(Configuration.JSONPLACEHOLDER_POST)
                    .thenReturn();

        }

    public  Response updatePosts(JsonplaceholderRequestModelPOSTPUT request, String id){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(request)
                .put(Configuration.JSONPLACEHOLDER_UPDATE + id)
                .thenReturn();

    }

    public Response deletePost(String id){
        return RestAssured.given()
                .when().log().all()
                .delete(Configuration.JSONPLACEHOLDER_DELETE + id)
                .thenReturn();

    }

    public Response getAllPosts() {
        return RestAssured.given()
                .when().log().all()
                .get(Configuration.JSONPLACEHOLDER_GET_ALL)
                .thenReturn();
    }

    public Response getPostById(String id) {
        return RestAssured.given()
                .when().log().all()
                .get(Configuration.JSONPLACEHOLDER_GET_BY_ID + id)
                .thenReturn();
    }

}

