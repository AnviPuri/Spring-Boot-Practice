package com.student.dal;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.student.dal.entities.Student;
import com.student.dal.repositories.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentDalApplicationTests {

	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void testCreateStudent() {

		Student student = new Student();
		student.setName("Mandy");
		student.setCourse("Painting");
		student.setFees(10000.00);

		studentRepository.save(student);

	}

	@Test
	public void testFindStudentById() {

		Optional<Student> student = studentRepository.findById(1l);
		if (student.isPresent()) {
			String name = student.get().getName();
			String course = student.get().getCourse();

			System.out.print(name + " is studying " + course + ".");
		}

	}

	@Test
	public void testUpdateStudentById() {

		Optional<Student> student = studentRepository.findById(2l);
		Student updatedStudent = student.get();
		if (student.isPresent()) {
			updatedStudent.setName("Sandy");
			updatedStudent.setCourse("Science");
			studentRepository.save(updatedStudent);
		}

	}

	@Test
	public void testDeleteStudentById() {

		studentRepository.deleteById(2l);

		// OR

		Student student = new Student();
		student.setId(1l);
		studentRepository.delete(student);

	}

}
