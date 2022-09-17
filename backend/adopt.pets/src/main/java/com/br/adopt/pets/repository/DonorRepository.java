package com.br.adopt.pets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.adopt.pets.model.Donor;

@Repository
public interface DonorRepository  extends JpaRepository<Donor, Long> {
   
}
