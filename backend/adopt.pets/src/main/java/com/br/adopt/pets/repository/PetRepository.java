package com.br.adopt.pets.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.adopt.pets.model.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
    void deleteById(Long id);

 

}
