package com.br.adopt.pets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.adopt.pets.service.MatchService;

@RestController
@RequestMapping("/api/v1/pet/match")
public class MatchController {
	
	
	@Autowired
	private MatchService service;
	
	
	@PostMapping
    public ResponseEntity<String> petAdoptioniIntention(@RequestParam Long adopterId , @RequestParam Long petId){
	
        return ResponseEntity.ok(service.petAdoptionIntention(adopterId, petId));
    }
	
	
}
