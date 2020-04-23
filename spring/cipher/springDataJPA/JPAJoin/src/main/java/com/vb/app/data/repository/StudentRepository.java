package com.vb.app.data.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.vb.app.data.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}