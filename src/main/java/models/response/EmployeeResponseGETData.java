package models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseGETData {
    int id;
    String employee_name;
    String employee_salary;
    String employee_age;
    String profile_image;
}
