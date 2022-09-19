package com.br.adopt.pets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.adopt.pets.dtos.PetCompletDTO;
import com.br.adopt.pets.service.PetService;

@RestController
@RequestMapping("/api/v1/pet/chose")
public class ChoseController {
	
	
	@Autowired
	private PetService service;

	@GetMapping("/{id}")
    public ResponseEntity<List<PetCompletDTO>> getListSelectedPets(@PathVariable Long id){
		
        return ResponseEntity.ok(service.getChoseAll(id));
    }
	
	

	@PostMapping
    public ResponseEntity<String> performPetAdoption(@RequestParam Long adopterId , @RequestParam Long petId){
		
		
        return ResponseEntity.ok("Pet adotado com sucesso!");
    }


}
