package com.br.adopt.pets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.adopt.pets.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
	
	
	List<Pet> findByPorteLikeOrTipoPetLikeOrEspecie(String porte,String tipoPet,String especie);
    

 

}
