package mother;


import models.request.JsonplaceholderRequestModelPOSTPUT;

public class JsonplaceholderMother {
    public static JsonplaceholderRequestModelPOSTPUT createBodyForJsonplaceholderPOST(){
        return JsonplaceholderRequestModelPOSTPUT.builder()
                .title("Default title")
                .body("Default body")
                .build();
    }
}
