package edu.utvt.mx.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.utvt.mx.persistence.entities.Career;

public interface CareerRepository extends JpaRepository<Career, Long> {

}
