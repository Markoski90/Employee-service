package models.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class JsonplacehodlerResponseModelGETAll {
    int id;
    String title;
    String body;
    int userId;
}
