//package com.tma.bookmanagement;
//
//
//import com.tma.bookmanagement.entities.Employee;
//import com.tma.bookmanagement.services.EmployeeService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static net.bytebuddy.matcher.ElementMatchers.is;
//import static org.hamcrest.Matchers.hasSize;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebMvcTest(EmployeeRestController.class)
//public class EmployeeRestControllerIntegrationTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @MockBean
//    private EmployeeService employeeService;
//
//    @Test
//    public void givenEmployees_whenGetEmployees_thenReturnJsonArray()
//            throws Exception {
//        Employee alex = new Employee(1L,"alex","123-456","An Nhon");
//        List<Employee> allEmployee = Arrays.asList(alex);
//        when(employeeService.findAll()).thenReturn(allEmployee);
//        mockMvc.perform(get("/employee/all")
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[0].name_employee").value(alex.getName_employee()))
//                .andExpect(jsonPath("$[0].identity_card").value(alex.getIdentity_card()))
//                .andExpect(jsonPath("$[0].address").value(alex.getAddress()));
//    }
//
//}
