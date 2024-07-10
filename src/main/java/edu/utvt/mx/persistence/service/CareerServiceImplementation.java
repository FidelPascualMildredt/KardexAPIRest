package edu.utvt.mx.persistence.service;

import edu.utvt.mx.persistence.entities.Career;
import edu.utvt.mx.persistence.repositories.CareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CareerServiceImplementation implements CareerService {

    @Autowired
    private CareerRepository careerRepository;

    @Override
    public List<Career> getAllCareers() {
        return careerRepository.findAll();
    }

    @Override
    public Optional<Career> getCareerById(Long id) {
        return careerRepository.findById(id);
    }

    @Override
    public Career saveCareer(Career career) {
        return careerRepository.save(career);
    }

    @Override
    public void deleteCareer(Long id) {
        careerRepository.deleteById(id);
    }
}
