package com.hico.hico;

import com.hico.hico.controller.EmployeeController;
import com.hico.hico.entity.Employee;
import com.hico.hico.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = EmployeeController.class)
@WithMockUser
public class EmployeeControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService service;

    Employee mockEmployee = new Employee(12L,"Kyle","Josias","Mr","Male",11111777,1000.0,"Red");

    @Test
    public void retrieveEmployeeDetails() throws Exception{

        Mockito.when(service.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(mockEmployee));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employees/employee/1").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse().getContentAsString());

        String expected = "{\"employeeId\":12,\"firstName\":\"Kyle\",\"lastName\":\"Josias\",\"salutation\":\"Mr\",\"gender\":\"Male\",\"employeeNumber\":11111777,\"salary\":1000.0,\"empProfileColor\":\"Red\"}";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);


    }

    @Test
    public void createEmployee() throws Exception {
        Employee mockEmployee = new Employee(15L,"Kyle","Josias","Mr","Male",1234567,100000.0,"Green");

        Mockito.when(service.save(Mockito.any(Employee.class))).thenReturn(mockEmployee);

        String exampleEmployeeJson = "{\"employeeId\":15,\"firstName\":\"Kyle\",\"lastName\":\"Josias\",\"salutation\":\"Mr\",\"gender\":\"Male\",\"employeeNumber\":1234567,\"salary\":100000.0,\"empProfileColor\":\"Green\"}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/employees/save")
                .accept(MediaType.APPLICATION_JSON).content(exampleEmployeeJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());

    }


}
