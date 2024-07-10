package edu.utvt.mx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.utvt.mx.persistence.service.CareerService;
import edu.utvt.mx.persistence.entities.Career;

import java.util.List;

@RestController
@RequestMapping("/api/v1/careers")
public class CareerController {

    @Autowired
    private CareerService careerService;

    @GetMapping
    public List<Career> getAllCareers() {
        return careerService.getAllCareers();
    }

    @PostMapping
    public Career createCareer(@RequestBody Career career) {
        return careerService.saveCareer(career);
    }

    @GetMapping("/{id}")
    public Career getCareerById(@PathVariable Long id) {
        return careerService.getCareerById(id)
                .orElseThrow(() -> new RuntimeException("Career not found with id " + id));
    }

    @PutMapping("/{id}")
    public Career updateCareer(@PathVariable Long id, @RequestBody Career careerDetails) {
        // Ensure the careerDetails object has the correct id set before saving
        careerDetails.setId(id);
        return careerService.saveCareer(careerDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteCareer(@PathVariable Long id) {
        careerService.deleteCareer(id);
    }
}
