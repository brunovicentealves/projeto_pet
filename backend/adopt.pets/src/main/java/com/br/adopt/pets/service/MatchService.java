package com.br.adopt.pets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.adopt.pets.model.Adopter;
import com.br.adopt.pets.model.AdopterPet;
import com.br.adopt.pets.model.AdopterPetId;
import com.br.adopt.pets.model.Pet;
import com.br.adopt.pets.repository.AdopterPetRepository;
import com.br.adopt.pets.util.StatusPet;

@Service
public class MatchService {

	@Autowired
	private AdopterService adopterService;

	
	@Autowired
	private AdopterPetRepository adopeterPetRespository;
	
	
	@Autowired
	private PetService petService;
	
	
	public String petAdoptionIntention(Long idAdopter, Long idPet) {

	
		AdopterPetId id = new AdopterPetId(new Adopter(adopterService.getAdopterById(idAdopter)), new Pet( petService.getPetById(idPet)));
		
		AdopterPet adopterPet = new AdopterPet(id, StatusPet.DOADO);
		
		adopeterPetRespository.save(adopterPet);
		
		return "Pet Selecionado com sucesso!";
	}

}
