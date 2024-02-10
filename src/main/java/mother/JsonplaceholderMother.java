package mother;


import models.request.JsonplaceholderModelPOSTRequest;

public class JsonplaceholderMother {
    public static JsonplaceholderModelPOSTRequest createBodyForJsonplaceholderPOST(){
        return JsonplaceholderModelPOSTRequest.builder()
                .title("Default title")
                .body("Default body")
                .build();
    }
}
