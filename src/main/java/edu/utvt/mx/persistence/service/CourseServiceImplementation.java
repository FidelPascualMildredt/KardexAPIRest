package edu.utvt.mx.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.utvt.mx.persistence.entities.Course;
import edu.utvt.mx.persistence.repositories.CourseRepository;

@Service
public class CourseServiceImplementation {

    @Autowired
    private CourseRepository courseRepository;

    public Course save(Course course) {
        return this.courseRepository.save(course);
    }

    public Course update(Long id, Course course) {
        Optional<Course> courseOptional = this.courseRepository.findById(id);
        
        if (courseOptional.isPresent()) {
            Course existingCourse = courseOptional.get();
            existingCourse.setName(course.getName());
            existingCourse.setFourMonthPeriod(course.getFourMonthPeriod());
            existingCourse.setCareer(course.getCareer());
            
            return this.courseRepository.save(existingCourse);
        }
        
        return courseOptional.orElseThrow();
    }

    public List<Course> getAll() {
        return this.courseRepository.findAll();
    }

    public Optional<Course> findById(Long id) {
        return this.courseRepository.findById(id);
    }

    public ResponseEntity<Course> deleteById(Long id) {
        Optional<Course> courseOptional = this.courseRepository.findById(id);
        
        if (courseOptional.isPresent()) {
            this.courseRepository.delete(courseOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public Page<Course> get(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("name"));
        return this.courseRepository.findAll(pageRequest);
    }
}
