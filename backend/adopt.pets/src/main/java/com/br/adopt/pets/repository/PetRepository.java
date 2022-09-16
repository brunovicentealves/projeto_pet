package com.br.adopt.pets.repository;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.adopt.pets.model.Pet;

import java.util.Optional;

@Repository
public interface PetRepository extends CrudRepository<Pet, Id> {
    void deleteById(Long id);

    Optional<Object> findById(Long id);

}
