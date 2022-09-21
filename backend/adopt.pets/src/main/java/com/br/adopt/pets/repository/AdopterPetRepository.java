package com.br.adopt.pets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.adopt.pets.model.Adopter;
import com.br.adopt.pets.model.AdopterPet;
import com.br.adopt.pets.model.AdopterPetId;

@Repository
public interface AdopterPetRepository extends  JpaRepository<AdopterPet, AdopterPetId> {
	
	@Query("SELECT a FROM tb_adotante  a inner join  tb_adotante_pet  ap on(a.id= ap.id.adopter) inner join tb_pet p on (ap.id.pet=p.id) ")
	List<Adopter> getAdopterIntentionAdoptionPet();

}
