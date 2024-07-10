package edu.utvt.mx.persistence.service;

import edu.utvt.mx.persistence.entities.Career;

import java.util.List;
import java.util.Optional;

public interface CareerService {

    List<Career> getAllCareers();

    Optional<Career> getCareerById(Long id);

    Career saveCareer(Career career);

    void deleteCareer(Long id);
}
