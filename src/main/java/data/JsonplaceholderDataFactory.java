package data;


import models.request.JsonplaceholderModelPOSTRequest;

public class JsonplaceholderDataFactory {

        private JsonplaceholderModelPOSTRequest request;

        public  JsonplaceholderDataFactory(JsonplaceholderModelPOSTRequest requestBody){
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


        public JsonplaceholderModelPOSTRequest createRequest(){
            return request;
        }

    }

