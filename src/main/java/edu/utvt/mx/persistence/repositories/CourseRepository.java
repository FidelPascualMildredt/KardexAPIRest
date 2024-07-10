package edu.utvt.mx.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.utvt.mx.persistence.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
