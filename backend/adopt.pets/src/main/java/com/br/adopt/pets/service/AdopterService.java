package com.br.adopt.pets.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.adopt.pets.dtos.AdopterCompletDTO;
import com.br.adopt.pets.dtos.AdopterDTO;
import com.br.adopt.pets.exception.ResourceBadRequestException;
import com.br.adopt.pets.exception.ResourceNotFoundException;
import com.br.adopt.pets.model.Adopter;
import com.br.adopt.pets.repository.AdopterRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AdopterService {

	@Autowired
	private AdopterRepository repository;

	public AdopterCompletDTO addNewAdopter(Adopter adopter){
		
		log.info("criado usuario Adotante:{}",adopter);
		
			return new AdopterCompletDTO( repository.save(adopter));	
	}

	public List<AdopterDTO> getAllAdopter(){
		
		log.info("Buscando todos usuarios adotantes");
		
		List<Adopter> list = repository.findAll();
		
		log.info("Buscando todos usuarios adotantes com sucesso");
		
		return list.stream().map(x ->new AdopterDTO(x)).collect(Collectors.toList());
	}
	
	

	public AdopterCompletDTO getAdopterById(Long id){
		
		log.info("Buscando usuario adotante pelo id :{}",id);
		
		Adopter adopter= repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não Encontrado Adotante!"));
		
		log.info("Buscando usuario adotante pelo id :{} com sucesso",id);
		
		return new AdopterCompletDTO(adopter);
	}
	
	

	public AdopterDTO changeAdopter(AdopterDTO dados , Long id){
		
		log.info("Alterando informações do adotante :{} , id adotante:{}",dados,id);
		
		if(id == null) {
			throw new ResourceBadRequestException("Não informou id do adotante");
		}
		
		Adopter adopter = repository.save( new Adopter(dados, id));
			
		log.info("Alterando com sucesso as informações do adotante :{} , id adotante:{}");
		
		return new AdopterDTO(adopter);
			
	}

	public void deleteAdopter(Long id){
		log.info("deletando usuario adotante do id:{}",id);
		
		if(id== null) {
			throw new ResourceBadRequestException("Não informou id do adotante");
		}
		
		 getAdopterById(id);
		 
		repository.deleteById(id);
		
		log.info("deletado com sucesso usuario adotante do id:{}",id);
	}

}
