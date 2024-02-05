package client;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.request.JsonplaceholderRequestModelPOST;
import util.Configuration;


public class JsonplaceholderClient {


        public  Response postJsonplaceholder(JsonplaceholderRequestModelPOST request){
            return RestAssured.given()
                    .contentType(ContentType.JSON)
                    .when().log().all()
                    .body(request)
                    .post(Configuration.JSONPLACEHOLDER_POST)
                    .thenReturn();

        }
    }

