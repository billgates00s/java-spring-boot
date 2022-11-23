//package com.tma.bookmanagement;
//
//import com.tma.bookmanagement.services.CandidateService;
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
//import java.util.Optional;
//
//import static org.hamcrest.Matchers.hasSize;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebMvcTest(CandidateRestController.class)
//public class CandidateRestControllerIntegrationTest{
//    @MockBean
//    private CandidateService candidateService;
//    @Autowired
//    private MockMvc mockMvc;
//    @Test
//    public void getCandidateById() throws Exception {
//        Candidate candidate = new Candidate(1L, "HieuPC");
//        //// verify phuong thuc finById() cua candidateService duoc goi chinh xac 1 lan
//        when(candidateService.findById(1L)).thenReturn(Optional.of(candidate)); //
//        this.mockMvc.perform(get("/candidate/{id}", 1L))
//                //Verify HTTP status code la 200 (OK)
//                .andExpect(status().isOk())
//                // verify content-type cua response la application/json va bo ki tu cua no la UTF-8
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//                // verify body
//                .andExpect(jsonPath("$.id").value(1)) //
//                .andExpect(jsonPath("$.name").value("HieuPC"));
//
//        verify(candidateService, times(1)).findById(1L);
//        //Verify sau phản hồi, không có thêm tương tác nào được thực hiện cho candidateService
//        // (verify(candidateService, times(1)).getAll())
//        verifyNoMoreInteractions(candidateService);
//        //Verify nếu bất kỳ giả định nhất định có bất kỳ tương tác chưa được xác minh
//        // (verifyNoMoreInteractions(candidateService)).
//    }
//    @Test
//    public void get_all_success() throws Exception {
//        List<Candidate> candidates = Arrays.asList(
//                new Candidate(1L, "HieuPC"),
//                new Candidate(2L, "NhanPC"));
//        when(candidateService.findAll()).thenReturn(candidates);
//        mockMvc.perform(get("/candidate/all"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andExpect(jsonPath("$",hasSize(2)))
//                .andExpect(jsonPath("[0].id").value(1))
//                .andExpect(jsonPath("[0].name").value("HieuPC"))
//                .andExpect(jsonPath("[1].id").value(2))
//                .andExpect(jsonPath("[1].name").value("NhanPC"));
//        verify(candidateService, times(1)).findAll();
//        verifyNoMoreInteractions(candidateService);
//    }
//}
