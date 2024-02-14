package models.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JsonplaceholderRequestModelPOSTPUT {
    String title;
    String body;
    int id;

}
