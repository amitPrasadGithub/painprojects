package com.perficient.Spring_POC.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.perficient.Spring_POC.data.entity.Address;
import com.perficient.Spring_POC.data.entity.Student;
import com.perficient.Spring_POC.data.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class StudentControllerIntegrationTest {
    @Autowired
    private StudentService studentService;

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    @Test
    void findByEmail() throws Exception {
        Student student = getStudent();
        RequestBuilder builder = MockMvcRequestBuilders.get("/rest/students/email/jason.parker@riverdale.com").accept(MediaType.APPLICATION_JSON);
        MvcResult result = this.mockMvc.perform(builder).andReturn();
        Student student1 = objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);
        log.info("\n\n expected Id : "+student.getStudentId()+"::: Actual : "+student1.getStudentId());
        assertThat(student1.getFirstName()).isEqualTo(student.getFirstName());

    }

    @Test
    void deleteById() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/rest/admin/students/studentId/1"))
                    .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void save() throws Exception {
        Student student = getStudent();
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/rest/admin/students/post/student")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void update() throws Exception {
        Student student = getStudent();
        this.mockMvc.perform(MockMvcRequestBuilders.put("/rest/admin/students/studentId/1")
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(student)))
                    .andExpect(MockMvcResultMatchers.status().isOk());
    }

    public Student getStudent() {
        Address address = new Address();
        address.setAddressId(1L); address.setArea("NorthHigh"); address.setCity("Riverdale"); address.setState("Utah"); address.setCountry("USA");
        List<Address> list = new ArrayList<>();
        list.add(address);
        Student student = new Student();
        student.setStudentId(1L); student.setFirstName("Jason11"); student.setLastName("Parker"); student.setEmail("jason.parker@riverdale.com"); student.setAddress(list); student.setCreationDate(new Date());

        return student;
    }
    public Student updateStudent() {
        Address address = new Address();
        address.setAddressId(10L); address.setArea("updatedArea"); address.setCity("updatedCity"); address.setState("updatedState"); address.setCountry("updatedCountry");
        List<Address> list = new ArrayList<>();
        list.add(address);

        Student student = new Student();
        student.setStudentId(10L); student.setFirstName("updatedFirstName"); student.setLastName("updatedLastName"); student.setEmail("updatedEmail"); student.setCreationDate(new Date()); student.setAddress(list);

        return student;
    }


}