package mother;


import models.request.JsonplaceholderRequestModelPOST;

public class JsonplaceholderMother {
    public static JsonplaceholderRequestModelPOST createBodyForJsonplaceholderPOST(){
        return JsonplaceholderRequestModelPOST.builder()
                .title("Default title")
                .body("Default age")
                .build();
    }
}
