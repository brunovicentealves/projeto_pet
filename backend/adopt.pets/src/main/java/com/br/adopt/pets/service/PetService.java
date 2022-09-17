package com.br.adopt.pets.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.adopt.pets.dtos.PetCompletDTO;
import com.br.adopt.pets.dtos.PetDTO;
import com.br.adopt.pets.exception.ResourceBadRequestException;
import com.br.adopt.pets.exception.ResourceNotFoundException;
import com.br.adopt.pets.model.Pet;
import com.br.adopt.pets.repository.PetRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class PetService {

	@Autowired
	private PetRepository repository;

	public PetCompletDTO addNewPet(PetDTO novo){
		
		log.info("criado usuario Pet:{}",novo);
		
		return new PetCompletDTO(repository.save(new Pet(novo)));
		
		
	}

	public List<PetCompletDTO> getPetAll(){
		
		log.info("Buscando todos usuarios Pet");
		
		List<Pet> list =repository.findAll();
		
		log.info("Buscando todos usuarios Pet com sucesso");
		
		return list.stream().map(x ->new PetCompletDTO(x)).collect(Collectors.toList());
		
	}

	public PetCompletDTO getPetById(Long id){
		
		log.info("Buscando usuario Pet pelo id :{}",id);	
		
		Pet pet= repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não encontrado Pet"));
		  
		log.info("Buscando usuario Pet pelo id :{} com sucesso",id);
	
		return new PetCompletDTO(pet);
	}

	public PetDTO changePet(PetDTO dados, Long id){
		
		log.info("Alterando informações do adotante :{} , id adotante:{}",dados,id);
		
		if(id == null) {
			throw new ResourceBadRequestException("Não informou id do Pet");
		}
		
		Pet pet = repository.save(new Pet(dados));
		
		
		log.info("Alterando com sucesso as informações do Pet :{} , id pet:{}");
		
			return new PetDTO(pet);
	}

	public void deletePet(Long id){
		
		if(id== null) {
			throw new ResourceBadRequestException("Não informou id do Pet ");
		}
		
		getPetById(id);
		
		repository.deleteById(id);
	}

}
