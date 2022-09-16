package com.br.adopt.pets.service;

import com.br.adopt.pets.model.Doador;
import com.br.adopt.pets.repository.AdotanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.adopt.pets.repository.DoadorRepository;

import java.util.ArrayList;

@Service
public class DoadorService {


	@Autowired
	private DoadorRepository repository;

	public Doador addNew(Doador novo){
		if(novo.getNome() != null && novo.getTelefone() != null){
			return repository.save(novo);
		}
		return null;
	}

	public ArrayList<Doador> getAll(){
		return (ArrayList<Doador>) repository.findAll();
	}

	public Doador getById(Long id){
		return (Doador) repository.findById(id).orElse(null);
	}

	public Doador changeCad(Doador dados){
		if(dados.getId() != null && dados.getNome() != null){
			return repository.save(dados);
		}
		return null;
	}

	public void deleteCad(Long id){
		repository.deleteById(id);
	}

}
