package com.perficient.Spring_POC.data.repository;

import com.perficient.Spring_POC.data.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
class StudentRepositoryTest {

    @Autowired
    private com.perficient.Spring_POC.data.repositoty.StudentRepository studentRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void findByEmail() {
        Student s1 = studentRepository.findByEmail("jason.parker@riverdale.com");
        log.info("Data..."+s1.getFirstName()+" "+s1.getLastName());
        assertThat(s1.getFirstName()).isEqualTo("Jason");
    }

    @Test
    void findByFirstName() {
        List<Student> list = studentRepository.findByFirstName("Jason");
        for(Student s1:list) {
            log.info("Data___["+s1.getFirstName()+".."+s1.getLastName()+".."+s1.getEmail());
        }
        assertNotNull(list);
    }

    @Test
    void findByLastName() {
        List<Student> list = studentRepository.findByLastName("Parker");
        for(Student s1:list) {
            log.info("Data____["+s1.getFirstName()+" "+s1.getLastName()+" "+s1.getEmail());
        }
        assertNotNull(list);
    }

}