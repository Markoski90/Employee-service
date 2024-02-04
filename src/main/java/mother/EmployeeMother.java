package mother;

import models.request.EmployeeRequestModelPOST;

public class EmployeeMother {

    public static EmployeeRequestModelPOST createBodyForEmployeesPOST(){
        return EmployeeRequestModelPOST.builder()
                .name("Default name")
                .age("Default age")
                .salary("Default salary")
                .build();
    }
}
