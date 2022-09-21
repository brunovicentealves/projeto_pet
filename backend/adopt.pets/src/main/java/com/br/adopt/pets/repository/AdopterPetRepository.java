package com.br.adopt.pets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.adopt.pets.model.AdopterPet;
import com.br.adopt.pets.model.AdopterPetId;

@Repository
public interface AdopterPetRepository extends  JpaRepository<AdopterPet, AdopterPetId> {
	
	

}
