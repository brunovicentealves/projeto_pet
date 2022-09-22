package com.br.adopt.pets.controller;

import java.util.List;

import javax.validation.Valid;

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

import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping("/api/v1/adopter")
public class AdopterController {

	@Autowired
	private AdopterService service;

	
	@ApiOperation(value = "Retorna uma lista de Adotantes")
	@GetMapping
	public ResponseEntity<List<AdopterCompletDTO>> getAllAdopter() {
		return ResponseEntity.ok(service.getAllAdopter());
	}

	
	@ApiOperation(value = "Retorna um Adotante pelo Id")
	@GetMapping("/{id}")
	public ResponseEntity<AdopterCompletDTO> getById(@PathVariable Long id) {

		AdopterCompletDTO res = service.getAdopterById(id);
		return ResponseEntity.ok(res);
	}

	
	@ApiOperation(value = "Adciona uma adotante novo")
	@PostMapping(consumes = "application/json")
    public ResponseEntity<AdopterCompletDTO> addNewAdopter( @RequestBody @Valid AdopterDTO novo){
    	AdopterCompletDTO res = service.addNewAdopter(novo);
            return ResponseEntity.ok(res);
	}

	
	@ApiOperation(value = "Adciona as preferencias de um adotante especifico")
	@PatchMapping("/{id}" )
	public ResponseEntity<String> addAdopterPreferences(@RequestBody AdopterPreferencesDTO preferences ,@PathVariable Long id ) {
		 service.AdopterPreferences(preferences,id);
		return ResponseEntity.ok("Adcionado as preferencias para adotante ");

	}
	
	
	@ApiOperation(value = "Busca as preferencias de um adotante especifico")
	@GetMapping("/preferences/{id}")
	public ResponseEntity<AdopterPreferencesDTO> getByIdAdopterPreferences(@PathVariable Long id) {

		AdopterPreferencesDTO res = service.getAdopterPreferencesById(id);
		return ResponseEntity.ok(res);
	}

	@ApiOperation(value = "Realiza as alteração da informações de um adotante ")
	@PutMapping("/{id}")
	public ResponseEntity<AdopterDTO> changeAdopter(@RequestBody AdopterDTO dados, @PathVariable Long id) {
		AdopterDTO res = service.changeAdopter(dados, id);

		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}

	
	@ApiOperation(value = "Realiza Delete de um adotante")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAdopter(@PathVariable Long id) {
		service.deleteAdopter(id);
		return ResponseEntity.ok("Deletado com sucesso Usuario Adotante");
	}

}
