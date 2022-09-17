package com.br.adopt.pets.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.adopt.pets.exception.ResourceNotFoundException;
import com.br.adopt.pets.model.Donor;
import com.br.adopt.pets.repository.DonorRepository;

@Service
public class DonorService {


	@Autowired
	private DonorRepository repository;

	public Donor addNewDonor(Donor novo){
		if(novo.getNome() != null && novo.getTelefone() != null){
			return repository.save(novo);
		}
		return null;
	}

	public ArrayList<Donor> getDonorAll(){
		return (ArrayList<Donor>) repository.findAll();
	}

	public Donor getDonorById(Long id){
		return (Donor) repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não encontrado Doador"));
	}

	public Donor changeDonor(Donor dados){
		if(dados.getId() != null && dados.getNome() != null){
			return repository.save(dados);
		}
		return null;
	}

	public void deleteDonor(Long id){
		getDonorById(id);
		
		repository.deleteById(id);
	}

}
