package edu.utvt.mx.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import edu.utvt.mx.persistence.entities.Course;

public interface CourseService {

	public Course save (Course course);

	public Course update (String id, Course course);
	
	public List<Course> getAll ();
	
	public Optional<Course> findById(String id);
	
	public ResponseEntity<Course> deleteById(String id);
	
	public Page<Course> get(Integer page, Integer size);
}
