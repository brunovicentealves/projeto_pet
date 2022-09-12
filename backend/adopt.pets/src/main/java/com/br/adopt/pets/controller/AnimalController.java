package com.br.adopt.pets.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/animal")
public class AnimalController {
	
	
	
	@RequestMapping(path = "/getAll", method = RequestMethod.GET)
    @ApiOperation(
            value = "Get person by id",
            notes = "Returns person for id specified.")
	public ResponseEntity<String> getAnimal(){
		
		return ResponseEntity.ok("Gato");
		
	}
	
	
	
	


}
