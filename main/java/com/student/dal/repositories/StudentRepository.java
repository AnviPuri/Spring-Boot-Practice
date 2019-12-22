package com.student.dal.repositories;

import org.springframework.data.repository.CrudRepository;

import com.student.dal.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
