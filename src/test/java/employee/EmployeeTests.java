package employee;

import client.EmployeeClient;
import data.EmployeeDataFactory;
import io.restassured.response.Response;
import models.request.EmployeeRequestModelPOST;
import models.response.EmployeeResponseModelPOST;
import org.junit.Test;

import static mother.EmployeeMother.createBodyForEmployeesPOST;
import static org.junit.Assert.assertEquals;

public class EmployeeTests {
    @Test
    public void postEmployeeRequestDefaultValues(){
        //Kreirame request body i zadavame vrednosti na atributite
        EmployeeRequestModelPOST requestBody = new EmployeeDataFactory(createBodyForEmployeesPOST())
                .createRequest();


        //Go prakame request bodito so post request
        Response postResponse = new EmployeeClient()
                .postEmployee(requestBody);

        //go zacuvuvame response bodyto kako klasen tip (response-> Employeeresponse) za da mozeme da gi pristapime atrubutite na modelite
        EmployeeResponseModelPOST employeeResponse = postResponse.body() .as (EmployeeResponseModelPOST.class);

        //pravime sporedbi na vrednostite
        assertEquals(200,postResponse.statusCode());
        assertEquals("success",employeeResponse.getStatus());
        assertEquals("Default name",employeeResponse.getData().getName());
        assertEquals("Default age",employeeResponse.getData().getAge());
        assertEquals("Default salary",employeeResponse.getData().getSalary());
        assertEquals("Successfully! Record has been added.",employeeResponse.getMessage());

    }

    @Test
    public void postEmployeeRequest(){

        EmployeeRequestModelPOST requestBody = new EmployeeDataFactory(createBodyForEmployeesPOST())
                .setName("Petko")
                .setAge("30")
                .setSalary("10 000")
                .createRequest();

        Response postResponse = new EmployeeClient()
                .postEmployee(requestBody);

        EmployeeResponseModelPOST employeeResponse = postResponse.body() .as (EmployeeResponseModelPOST.class);


        assertEquals(200,postResponse.statusCode());
        assertEquals("success",employeeResponse.getStatus());
        assertEquals("Petko",employeeResponse.getData().getName());
        assertEquals("30",employeeResponse.getData().getAge());
        assertEquals("10 000",employeeResponse.getData().getSalary());
        assertEquals("Successfully! Record has been added.",employeeResponse.getMessage());

    }
}
