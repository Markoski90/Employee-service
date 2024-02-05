package data;


import models.request.JsonplaceholderRequestModelPOST;

public class JsonplaceholderDataFactory {

        private JsonplaceholderRequestModelPOST request;

        public  JsonplaceholderDataFactory(JsonplaceholderRequestModelPOST requestBody){
            request = requestBody;
        }

        public data.JsonplaceholderDataFactory setTitle(String value) {
            request.setTitle(value);
            return this;
        }
        public data.JsonplaceholderDataFactory setBody(String value) {
            request.setBody(value);
            return this;
        }


        public JsonplaceholderRequestModelPOST createRequest(){
            return request;
        }

    }

