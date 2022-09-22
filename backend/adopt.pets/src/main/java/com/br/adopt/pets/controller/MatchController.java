package com.br.adopt.pets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.adopt.pets.dtos.AdopterCompletDTO;
import com.br.adopt.pets.service.MatchService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/pet/match")
public class MatchController {
	
	
	@Autowired
	private MatchService service;
	
	
	@ApiOperation(value = "Manifestando a intenção de adoção do pet ")
	@PostMapping("/intention")
    public ResponseEntity<String> petAdoptioniIntention(@RequestParam Long adopterId , @RequestParam Long petId){
	
        return ResponseEntity.ok(service.petAdoptionIntention(adopterId, petId));
    }
	
	@ApiOperation(value = "Realizando match de adoção  entre doador e adotante ")
	@PostMapping
    public ResponseEntity<String> matchAdoptionBetweenAdopterAndPet(@RequestParam Long adopterId , @RequestParam Long idDonor){
	
        return ResponseEntity.ok(service.matchAdoptionBetweenAdopterAndPet(adopterId, idDonor));
    }
	
	
	@ApiOperation(value = "Buscando lista de Adotantes que manifestaram interesse no pet do doador ")
	@GetMapping
    public ResponseEntity<List<AdopterCompletDTO>> matchAdoptionBetweenAdopterAndPet( @RequestParam Long idDonor){
	
        return ResponseEntity.ok(service.lookForSuitorsForAdoption(idDonor));
    }
	
	
}
