package com.br.adopt.pets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.adopt.pets.model.Adopter;

@Repository
public interface AdopterRepository extends JpaRepository<Adopter, Long> {
    
}
