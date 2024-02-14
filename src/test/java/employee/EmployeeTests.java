package employee;

import client.EmployeeClient;
import data.EmployeeDataFactory;
import io.restassured.response.Response;
import models.request.EmployeeRequestModelPOSTPUT;
import models.response.EmployeeResponseGETModelById;
import models.response.EmployeeResponseModelDELETE;
import models.response.EmployeeResponseModelGETAll;
import models.response.EmployeeResponseModelPOSTPUT;
import org.junit.Test;

import static mother.EmployeeMother.createBodyForEmployeesPOST;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class EmployeeTests {

    @Test
    public void getAllEmployeesTest(){
        Response getResponse = new EmployeeClient()
                .getAllEmployees();

        EmployeeResponseModelGETAll employeeResponse = getResponse.body() .as (EmployeeResponseModelGETAll.class);

        assertEquals(200,getResponse.statusCode());
        assertEquals("success",employeeResponse.getStatus());
        assertFalse(employeeResponse.getData().isEmpty());
        assertEquals("Successfully! All records has been fetched.",employeeResponse.getMessage());

    }

    @Test
    public void getEmployeeByIdTest() {
        //new EmployeeDataFactory(createBodyForEmployeesPOST())
           //     .setName("Petko")
            //    .setAge("30")
            //    .setSalary("10 000")
            //    .createRequest();

        Response getResponse = new EmployeeClient()
                .getEmployeeByID("5");

        EmployeeResponseGETModelById employeeResponse = getResponse.body().as(EmployeeResponseGETModelById.class);

        assertEquals(200, getResponse.statusCode());
        assertEquals("success", employeeResponse.getStatus());
        assertEquals(5, employeeResponse.getData().getId());
        assertEquals("Airi Satou", employeeResponse.getData().getEmployee_name());
        assertEquals("162700", employeeResponse.getData().getEmployee_salary());
        assertEquals("33", employeeResponse.getData().getEmployee_age());
        assertEquals("Successfully! Record has been fetched.", employeeResponse.getMessage());
    }
    @Test
    public void postEmployeeRequestDefaultValuesTest(){
        //Kreirame request body i zadavame vrednosti na atributite
        EmployeeRequestModelPOSTPUT requestBody = new EmployeeDataFactory(createBodyForEmployeesPOST())
                .createRequest();


        //Go prakame request bodito so post request
        Response postResponse = new EmployeeClient()
                .postEmployee(requestBody);

        //go zacuvuvame response bodyto kako klasen tip (response-> Employeeresponse) za da mozeme da gi pristapime atrubutite na modelite
        EmployeeResponseModelPOSTPUT employeeResponse = postResponse.body() .as (EmployeeResponseModelPOSTPUT.class);

        //pravime sporedbi na vrednostite
        assertEquals(200,postResponse.statusCode());
        assertEquals("success",employeeResponse.getStatus());
        assertEquals("Default name",employeeResponse.getData().getName());
        assertEquals("Default age",employeeResponse.getData().getAge());
        assertEquals("Default salary",employeeResponse.getData().getSalary());
        assertEquals("Successfully! Record has been added.",employeeResponse.getMessage());

    }

    @Test
    public void postEmployeeRequestTest(){

        EmployeeRequestModelPOSTPUT requestBody = new EmployeeDataFactory(createBodyForEmployeesPOST())
                .setName("Petko")
                .setAge("30")
                .setSalary("10 000")
                .createRequest();

        Response postResponse = new EmployeeClient()
                .postEmployee(requestBody);

        EmployeeResponseModelPOSTPUT employeeResponse = postResponse.body() .as (EmployeeResponseModelPOSTPUT.class);


        assertEquals(200,postResponse.statusCode());
        assertEquals("success",employeeResponse.getStatus());
        assertEquals("Petko",employeeResponse.getData().getName());
        assertEquals("30",employeeResponse.getData().getAge());
        assertEquals("10 000",employeeResponse.getData().getSalary());
        assertEquals("Successfully! Record has been added.",employeeResponse.getMessage());

    }

    @Test
    public void updateEmployeeTest(){

        EmployeeRequestModelPOSTPUT requestBody = new EmployeeDataFactory(createBodyForEmployeesPOST())
                .setName("Petko")
                .setAge("30")
                .setSalary("10 000")
                .createRequest();

        Response postResponse = new EmployeeClient()
                .updateEmployee(requestBody,"10");

//Serializacija
EmployeeResponseModelPOSTPUT employeeResponse = postResponse.body() .as (EmployeeResponseModelPOSTPUT.class);


        assertEquals(200,postResponse.statusCode());
        assertEquals("success",employeeResponse.getStatus());
        assertEquals("Petko",employeeResponse.getData().getName());
        assertEquals("30",employeeResponse.getData().getAge());
        assertEquals("10 000",employeeResponse.getData().getSalary());
        assertEquals("Successfully! Record has been updated.",employeeResponse.getMessage());

    }

    @Test
    public void deleteEmployeeTest(){

        // EmployeeRequestModelPOSTPUT requestBody = new EmployeeDataFactory(createBodyForEmployeesPOST())
        //        .setName("Petko")
        //        .setAge("30")
        //        .setSalary("10 000")
        //        .createRequest();

        Response deleteResponse = new EmployeeClient()
                .deleteEmployee("5");

//Serializacija
        EmployeeResponseModelDELETE employeeResponse = deleteResponse.body() .as (EmployeeResponseModelDELETE.class);

        assertEquals(200,deleteResponse.statusCode());
        assertEquals("success",employeeResponse.getStatus());
        assertEquals("5",employeeResponse.getData());
        assertEquals("Successfully! Record has been deleted",employeeResponse.getMessage());

    }
}
