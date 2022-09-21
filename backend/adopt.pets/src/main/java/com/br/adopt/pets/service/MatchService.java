package com.br.adopt.pets.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.adopt.pets.dtos.AdopterCompletDTO;
import com.br.adopt.pets.exception.ResourceBadRequestException;
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
	private AdopterPetRepository adopterPetRespository;

	@Autowired
	private PetRepository petRepository;

	@Autowired
	private PetService petService;

	public String petAdoptionIntention(Long idAdopter, Long idPet) {

		log.info("O adotante Id:{} Registrou intenção de adoção no pet id:{}", idAdopter, idPet);

		AdopterPetId id = new AdopterPetId(new Adopter(adopterService.getAdopterById(idAdopter)),
				new Pet(petService.getPetById(idPet)));
		
		AdopterPet adopterPet = new AdopterPet(id, StatusPet.INTENCAO);

		adopterPetRespository.save(adopterPet);
		

		log.info("O adotante Id:{} Registrou intenção de adoção no pet id:{} com Sucesso", idAdopter, idPet);

		return "Pet Selecionado com sucesso!";
	}

	public String matchAdoptionBetweenAdopterAndPet(Long idAdopter, Long idDonor) {

		log.info("Doador id:{} ira doar pet para Adotante id:{}",idDonor,idAdopter);

		donorService.getDonorById(idDonor);

		Pet pet = petRepository.findByIdDonor(idDonor);

		AdopterPetId id = new AdopterPetId(new Adopter(adopterService.getAdopterById(idAdopter)),pet);
		
		Optional<AdopterPet> optionalAdopterPet	= adopterPetRespository.findById(id);
		
		if(optionalAdopterPet.isEmpty()) {
			throw new ResourceBadRequestException("Adotante id: "+idAdopter+" não manifestou interesse ainda pelo seu pet,entao não pode Doar para ele !");
		}

		AdopterPet adopterPet = optionalAdopterPet.get();
		
		adopterPet.setStatus(StatusPet.DOADO);

		adopterPetRespository.save(adopterPet);

		log.info("Doador id:{} duou pet para Adotante id:{} com sucesso ", idAdopter, pet);

		return "Pet Adotando com Sucesso";
	}
	
	
	public List<AdopterCompletDTO> lookForSuitorsForAdoption(Long idDonor) {

		List<Adopter> adopterList=adopterPetRespository.getAdopterIntentionAdoptionPet();

		return  adopterList.stream().map(x -> new AdopterCompletDTO(x)).collect(Collectors.toList());
	}
	
	

}
