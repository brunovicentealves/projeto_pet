package com.br.adopt.pets.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.adopt.pets.dtos.DonorCompletDTO;
import com.br.adopt.pets.dtos.DonorDTO;
import com.br.adopt.pets.exception.ResourceBadRequestException;
import com.br.adopt.pets.exception.ResourceNotFoundException;
import com.br.adopt.pets.model.Donor;
import com.br.adopt.pets.repository.DonorRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class DonorService {


	@Autowired
	private DonorRepository repository;

	public DonorCompletDTO addNewDonor(DonorDTO novo){
		
		log.info("criado usuario Doador:{}",novo);
		
			return new DonorCompletDTO(repository.save(new Donor(novo))) ;
		
	}

	public List<DonorCompletDTO> getDonorAll(){
		log.info("Buscando todos usuarios Doador");
		
		List<Donor> list =	repository.findAll();
		
		log.info("Buscando todos usuarios Doador com sucesso");
		
		return list.stream().map(x ->new DonorCompletDTO(x)).collect(Collectors.toList());
	}

	public DonorCompletDTO getDonorById(Long id){
		log.info("Buscando usuario Doador pelo id :{}",id);
		
		Donor doner=repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não encontrado Doador"));
		  
		log.info("Buscando usuario Doador pelo id :{} com sucesso",id);
		
		  return new DonorCompletDTO(doner);
	}

	public DonorDTO changeDonor(DonorDTO dados,Long id){
		
		log.info("Alterando informações do adotante :{} , id adotante:{}",dados,id);
		
		if(id == null) {
			throw new ResourceBadRequestException("Não informou id do Doador");
		}
		Donor donor = repository.save(new Donor(dados));
		
		log.info("Alterando com sucesso as informações do Doador :{} , id doador:{}");
		
		return new DonorDTO(donor); 
	}

	public void deleteDonor(Long id){
		
		log.info("deletando usuario Doador do id:{}",id);
		
		if(id== null) {
			throw new ResourceBadRequestException("Não informou id do Dono ");
		}
		
		getDonorById(id);
		
		repository.deleteById(id);
		
		log.info("deletado com sucesso usuario Doador do id:{}",id);
	}

}
