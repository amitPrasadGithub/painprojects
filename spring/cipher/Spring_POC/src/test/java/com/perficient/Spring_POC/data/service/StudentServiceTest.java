package com.perficient.Spring_POC.data.service;

import com.perficient.Spring_POC.data.entity.Address;
import com.perficient.Spring_POC.data.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class StudentServiceTest {
    @MockBean
    private com.perficient.Spring_POC.data.repositoty.StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void studentServiceNullCheck() {
        assertThat(studentService).isNotNull();
    }
    /**
     * Get
     */
    @Test
    void findById() {
        Student student = getStudent();
        when(studentRepository.findById(1L)).thenReturn(java.util.Optional.of(student));
        assertThat(studentService.findById(1L)).isEqualTo(student);
    }

    @Test
    void findByFirstName() {
        List<Student> list = getStudentList();
        when(studentRepository.findByFirstName("Jason")).thenReturn(list);
    }

    @Test
    void findByLastName() {
        List<Student> list = getStudentList();
        when(studentRepository.findByLastName("Parker")).thenReturn(list);
        assertThat(studentService.findByLastName("Parker")).isEqualTo(list);
    }

    @Test
    void findByEmail() {
        Student student = getStudent();
        when(studentRepository.findByEmail("jason.parker@riverdale.com")).thenReturn(student);
        assertThat(studentService.findByEmail("jason.parker@riverdale.com")).isEqualTo(student);
    }

    /**
     * Post
     */
    @Test
    void save() {
        Student student = getStudent();
        when(studentRepository.save(student)).thenReturn(student);
        assertThat(studentService.save(student)).isEqualTo(student);
    }

    @Test
    void saveAll() {
        List<Student> result = getStudentList();
        when(studentRepository.findAll()).thenReturn(result);
        assertThat(studentService.findAll()).isEqualTo(result);
    }

    /**
     * Put
     */
    @Test
    void update() {
        Student student = getStudent();
        when(studentRepository.save(student)).thenReturn(student);
        log.info("Data>>>["+studentRepository.save(student));
        assertThat(studentService.update(student, 1L)).isEqualTo(student);
    }

    /**
     * Delete
     * @return
     */

    @Test
    void deleteById() {
        studentService.deleteById(10L);
        verify(studentRepository, times(1)).deleteById(10L);
    }



    public Student getStudent() {
        Address address = new Address();
        address.setAddressId(1L);
        address.setArea("NorthHigh"); address.setCity("Riverdale"); address.setState("Utah"); address.setCountry("USA");
        List<Address> list = new ArrayList<>();
        list.add(address);

        Student student = new Student();
        student.setStudentId(1L); student.setFirstName("Jason"); student.setLastName("Parker"); student.setEmail("jason.parker@riverdale.com"); student.setAddress(list); student.setCreationDate(new Date());

        return student;
    }
    public List<Student> getStudentList() {
        Address address = new Address();
        address.setAddressId(1L);
        address.setArea("NorthHigh"); address.setCity("Riverdale"); address.setState("Utah"); address.setCountry("USA");
        List<Address> list = new ArrayList<>();
        list.add(address);

        Student student = new Student();
        student.setStudentId(1L); student.setFirstName("Jason"); student.setLastName("Parker"); student.setEmail("jason.parker@riverdale.com"); student.setAddress(list);
        List<Student> result = new ArrayList<>();
        result.add(student);

        return result;
    }
}