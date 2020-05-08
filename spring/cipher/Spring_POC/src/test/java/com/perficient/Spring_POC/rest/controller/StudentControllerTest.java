package com.perficient.Spring_POC.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.perficient.Spring_POC.data.entity.Address;
import com.perficient.Spring_POC.data.entity.Student;
import com.perficient.Spring_POC.data.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class StudentControllerTest {
    @Autowired
    private StudentController studentController;
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void studentContrllerInitilized() throws Exception {
        assertThat(studentController).isNotNull();
    }

    /**
     * Get
     * @throws Exception
     */
    @Test
    public void findAll() {
        List<Student> s_list = getStudentList();
        when(studentService.findAll()).thenReturn(s_list);
        assertThat(studentController.findAll().getBody()).isEqualTo(s_list);
    }

    @Test
    public void findByEmail() throws Exception {
        Student student = getStudent();
        when(studentService.findByEmail("jason.parker@riverdale.com")).thenReturn(student);
        RequestBuilder builder = MockMvcRequestBuilders.get("/rest/students/email/jason.parker@riverdale.com").accept(MediaType.APPLICATION_JSON);
        MvcResult result = this.mockMvc.perform(builder).andReturn();

        Student student1 = objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);
        assertThat(student.getFirstName()).isEqualTo(student1.getFirstName());
    }

    @Test
    public void findById() {
        Student student = getStudent();
        when(studentService.findById(1L)).thenReturn(student);
        assertThat(studentController.findById(1L).getBody()).isEqualTo(student);
    }

    /**
     * Post
     *
     */

    @Test
    public void save() throws Exception {
        Student expected = getStudent10();
        when(studentService.save(expected)).thenReturn(expected);
        RequestBuilder builder = MockMvcRequestBuilders.post("/rest/admin/students/post/student").accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(expected));
        MvcResult result = this.mockMvc.perform(builder).andReturn();

        Student actual = objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);
        assertThat(expected.getFirstName()).isEqualTo(actual.getFirstName());
    }

    /**
     * Delete
     */
    @Test
    public void deleteById() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/rest/admin/students/studentId/10"))
                    .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Put
     */
    @Test
    public void update() throws Exception {
        Student student = getStudent();
        this.mockMvc.perform(
                MockMvcRequestBuilders.put("/rest/admin/students/studentId/10")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(student)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    public Student getStudent() {
        Address address = new Address();
        address.setAddressId(1L); address.setArea("NorthHigh"); address.setCity("Riverdale"); address.setState("Utah"); address.setCountry("USA");
        List<Address> list = new ArrayList<>();
        list.add(address);
        Student student = new Student();
        student.setStudentId(1L); student.setFirstName("Jason"); student.setLastName("Parker"); student.setEmail("jason.parker@riverdale.com"); student.setAddress(list); student.setCreationDate(new Date());
        return student;
    }
    public List<Student> getStudentList() {
        Address a1 = new Address();
        a1.setAddressId(1L); a1.setArea("NorthHigh"); a1.setCity("Riverdale"); a1.setState("Utah"); a1.setCountry("USA");
        List<Address> list = new ArrayList<>();
        list.add(a1);
        Student s1 = new Student();
        s1.setStudentId(1L); s1.setFirstName("Jason"); s1.setLastName("Parker"); s1.setEmail("jason.parker@riverdale.com"); s1.setAddress(list); s1.setCreationDate(new Date());
        List<Student> s_list = new ArrayList<>();
        s_list.add(s1);
        return s_list;
    }
    public Student getStudent10() {
        Address address = new Address();
        address.setAddressId(10L); address.setArea("deleteArea"); address.setCity("deleteCity"); address.setState("deleteState"); address.setCountry("deleteCountry");
        List<Address> list = new ArrayList<>();
        list.add(address);

        Student student = new Student();
        student.setStudentId(10L); student.setFirstName("deleteFirstName"); student.setLastName("deleteLastName"); student.setEmail("deleteEmail"); student.setCreationDate(new Date()); student.setAddress(list);
        return student;
    }
}