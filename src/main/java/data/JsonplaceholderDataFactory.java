package data;


import models.request.JsonplaceholderRequestModelPOSTPUT;

public class JsonplaceholderDataFactory {

        private JsonplaceholderRequestModelPOSTPUT request;

        public  JsonplaceholderDataFactory(JsonplaceholderRequestModelPOSTPUT requestBody){
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




        public JsonplaceholderRequestModelPOSTPUT createRequest(){
            return request;
        }

    }

