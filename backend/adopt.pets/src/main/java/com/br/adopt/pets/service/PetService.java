package com.br.adopt.pets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.adopt.pets.repository.PetRepository;

@Service
public class PetService {
	
	
	@Autowired
	private PetRepository repository;

}
