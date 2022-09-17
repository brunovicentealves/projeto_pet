package com.br.adopt.pets.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.adopt.pets.model.Donor;

@Repository
public interface DonorRepository  extends CrudRepository<Donor, Long> {
    void deleteById(Long id);



}
