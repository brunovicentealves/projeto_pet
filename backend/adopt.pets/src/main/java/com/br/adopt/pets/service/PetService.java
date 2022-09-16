package com.br.adopt.pets.service;

import com.br.adopt.pets.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.adopt.pets.repository.PetRepository;

import java.util.ArrayList;

@Service
public class PetService {

	@Autowired
	private PetRepository repository;

	public Pet addNew(Pet novo){
		if(novo.getNome() != null && novo.getFoto() != null){
			return repository.save(novo);
		}
		return null;
	}

	public ArrayList<Pet> getAll(){
		return (ArrayList<Pet>) repository.findAll();
	}

	public Pet getById(Long id){
		return (Pet) repository.findById(id).orElse(null);
	}

	public Pet changeCad(Pet dados){
		if(dados.getId() != null && dados.getNome() != null){
			return repository.save(dados);
		}
		return null;
	}

	public void deleteCad(Long id){
		repository.deleteById(id);
	}

}
