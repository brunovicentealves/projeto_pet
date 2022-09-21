package com.br.adopt.pets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.adopt.pets.model.Adopter;
import com.br.adopt.pets.model.AdopterPet;
import com.br.adopt.pets.model.AdopterPetId;
import com.br.adopt.pets.model.Pet;
import com.br.adopt.pets.repository.AdopterPetRepository;
import com.br.adopt.pets.repository.PetRepository;
import com.br.adopt.pets.util.StatusPet;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MatchService {

	@Autowired
	private AdopterService adopterService;

	@Autowired
	private DonorService donorService;

	@Autowired
	private AdopterPetRepository adopeterPetRespository;

	@Autowired
	private PetRepository petRepository;

	@Autowired
	private PetService petService;

	public String petAdoptionIntention(Long idAdopter, Long idPet) {

		log.info("O adotante Id:{} Registrou intenção de adoção no pet id:{}", idAdopter, idPet);

		AdopterPetId id = new AdopterPetId(new Adopter(adopterService.getAdopterById(idAdopter)),
				new Pet(petService.getPetById(idPet)));

		AdopterPet adopterPet = new AdopterPet(id, StatusPet.INTENCAO);

		adopeterPetRespository.save(adopterPet);

		log.info("O adotante Id:{} Registrou intenção de adoção no pet id:{} com Sucesso", idAdopter, idPet);

		return "Pet Selecionado com sucesso!";
	}

	public String matchAdoptionBetweenAdopterAndPet(Long idAdopter, Long idDonor) {

		log.info("Doador id:{} ira doar pet para Adotante id:{}",idDonor,idAdopter);

		donorService.getDonorById(idDonor);

		Pet pet = petRepository.findByIdDonor(idDonor);

		AdopterPetId id = new AdopterPetId(new Adopter(adopterService.getAdopterById(idAdopter)),pet);

		AdopterPet adopterPet = new AdopterPet(id, StatusPet.DOADO);

		adopeterPetRespository.save(adopterPet);

		log.info("Doador id:{} duou pet para Adotante id:{} com sucesso ", idAdopter, pet);

		return "Pet Adotando com Sucesso";
	}

}
