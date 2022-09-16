package com.br.adopt.pets.service;

import com.br.adopt.pets.model.Adotante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.adopt.pets.repository.AdotanteRepository;

import java.sql.PreparedStatement;
import java.util.ArrayList;

@Service
public class AdotanteService {

	@Autowired
	private AdotanteRepository repository;

	public Adotante addNew(Adotante novo){
		if(novo.getNome() != null && novo.getTipoPet() != null){
			return repository.save(novo);
		}
		return null;
	}

	public ArrayList<Adotante> getAll(){

		return (ArrayList<Adotante>) repository.findAll();
	}

	public Adotante getById(Long id){
		return (Adotante) repository.findById(id).orElse(null);
	}

	public Adotante changeCad(Adotante dados){
		if(dados.getId() != null && dados.getNome() != null){
			return repository.save(dados);
		}
		return null;
	}

	public void deleteCad(Long id){
		repository.deleteById(id);
	}

}
