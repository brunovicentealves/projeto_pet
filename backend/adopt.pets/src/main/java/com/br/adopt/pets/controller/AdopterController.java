package com.br.adopt.pets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.adopt.pets.dtos.AdopterCompletDTO;
import com.br.adopt.pets.dtos.AdopterDTO;
import com.br.adopt.pets.dtos.AdopterPreferencesDTO;
import com.br.adopt.pets.service.AdopterService;

@RestController
@RequestMapping("/api/v1/adopter")
public class AdopterController {

	@Autowired
	private AdopterService service;

	@GetMapping
	public ResponseEntity<List<AdopterCompletDTO>> getAllAdopter() {
		return ResponseEntity.ok(service.getAllAdopter());
	}

	@GetMapping("/{id}")
	public ResponseEntity<AdopterCompletDTO> getById(@PathVariable Long id) {

		AdopterCompletDTO res = service.getAdopterById(id);
		return ResponseEntity.ok(res);
	}

	@PostMapping
    public ResponseEntity<AdopterCompletDTO> addNewAdopter(@RequestBody AdopterDTO novo){
    	AdopterCompletDTO res = service.addNewAdopter(novo);
            return ResponseEntity.ok(res);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<String> addAdopterPreferences(@RequestBody AdopterPreferencesDTO preferences ,@PathVariable Long id ) {
		 service.AdopterPreferences(preferences,id);
		return ResponseEntity.ok("Adcionado as preferencias para adotante ");

	}
	
	
	@GetMapping("/preferences/{id}")
	public ResponseEntity<AdopterPreferencesDTO> getByIdAdopterPreferences(@PathVariable Long id) {

		AdopterPreferencesDTO res = service.getAdopterPreferencesById(id);
		return ResponseEntity.ok(res);
	}

	@PutMapping("/{id}")
	public ResponseEntity<AdopterDTO> changeAdopter(@RequestBody AdopterDTO dados, @PathVariable Long id) {
		AdopterDTO res = service.changeAdopter(dados, id);

		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAdopter(@PathVariable Long id) {
		service.deleteAdopter(id);
		return ResponseEntity.ok("Deletado com sucesso Usuario Adotante");
	}

}