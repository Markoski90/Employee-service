package models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public class JsonplaceholderResponseModelPOSTPUT {
        String title;
        String body;
        int id;
    }

