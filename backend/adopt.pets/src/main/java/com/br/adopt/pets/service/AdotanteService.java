package com.br.adopt.pets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.adopt.pets.repository.AdotanteRepository;

@Service
public class AdotanteService {
	
	
	@Autowired
	private AdotanteRepository repository;

}
