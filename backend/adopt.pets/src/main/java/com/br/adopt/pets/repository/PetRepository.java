package com.br.adopt.pets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.adopt.pets.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
	
	
	List<Pet> findByPorteLikeOrTipoPetLikeOrEspecie(String porte,String tipoPet,String especie);
	
	@Query(value = "SELECT * FROM tb_pet WHERE id_doador =:id",  nativeQuery = true)
	Pet findByIdDonor(Long id );
    

 

}
