package com.br.adopt.pets.repository;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.adopt.pets.model.Pet;

@Repository
public interface PetRepository  extends JpaRepository<Pet,Id>{

}
