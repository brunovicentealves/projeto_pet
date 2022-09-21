package com.br.adopt.pets.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.adopt.pets.dtos.AdopterPreferencesDTO;
import com.br.adopt.pets.dtos.DonorCompletDTO;
import com.br.adopt.pets.dtos.PetCompletDTO;
import com.br.adopt.pets.dtos.PetDTO;
import com.br.adopt.pets.exception.ResourceBadRequestException;
import com.br.adopt.pets.exception.ResourceNotFoundException;
import com.br.adopt.pets.model.Donor;
import com.br.adopt.pets.model.Pet;
import com.br.adopt.pets.repository.PetRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PetService {

	@Autowired
	private PetRepository repository;

	@Autowired
	private AdopterService adopterService;
	
	
	@Autowired
	private DonorService donorService;

	public PetCompletDTO addNewPet(PetDTO novo,Long idDonor) {

		log.info("criado usuario Pet:{}", novo);
		
		DonorCompletDTO donorDto=donorService.getDonorById(idDonor);
		
		return new PetCompletDTO(repository.save(new Pet(novo, new Donor(donorDto))));

	}

	public List<PetCompletDTO> getPetAll() {

		log.info("Buscando todos usuarios Pet");

		List<Pet> list = repository.findAll();

		log.info("Buscando todos usuarios Pet com sucesso");

		return list.stream().map(x -> new PetCompletDTO(x)).collect(Collectors.toList());

	}

	public List<PetCompletDTO> getChoseAll(Long id) {
		
		log.info("Buscando todos os pet com as preferencias do adotante id:{}",id);

		adopterService.getAdopterById(id);

		AdopterPreferencesDTO preferences = adopterService.getAdopterPreferencesById(id);

		if (preferences.getPorte() == null && preferences.getTipoPet() == null && preferences.getEspecie() == null) {
			throw new ResourceBadRequestException(
					"o usuario Adotante id: " + id + "não tem as preferencias preenchidas ainda,porfavor preencher!");
		}

		List<Pet> list = repository.findByPorteLikeOrTipoPetLikeOrEspecie(preferences.getPorte(),
				preferences.getTipoPet(), preferences.getEspecie());
		
		
		log.info("Buscado com sucesso todos os pet com as preferencias do adotante id:{}",id);

		return list.stream().map(x -> new PetCompletDTO(x)).collect(Collectors.toList());

	}

	public PetCompletDTO getPetById(Long id) {

		log.info("Buscando usuario Pet pelo id :{}", id);

		Pet pet = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não encontrado Pet"));

		log.info("Buscando usuario Pet pelo id :{} com sucesso", id);

		return new PetCompletDTO(pet);
	}

	public PetDTO changePet(PetDTO dados, Long id) {

		log.info("Alterando informações do adotante :{} , id adotante:{}", dados, id);

		if (id == null) {
			throw new ResourceBadRequestException("Não informou id do Pet");
		}

		Pet pet = repository.save(new Pet(dados));

		log.info("Alterando com sucesso as informações do Pet :{} , id pet:{}");

		return new PetDTO(pet);
	}

	public void deletePet(Long id) {

		if (id == null) {
			throw new ResourceBadRequestException("Não informou id do Pet ");
		}

		getPetById(id);

		repository.deleteById(id);
	}

}
