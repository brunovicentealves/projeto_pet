package com.br.adopt.pets.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.adopt.pets.dtos.PetCompletDTO;
import com.br.adopt.pets.dtos.PetDTO;
import com.br.adopt.pets.service.PetService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/pet")
public class PetController {
    @Autowired
    private PetService service;
    
    
    @ApiOperation(value = "Buscando uma lista de pets")
    @GetMapping
    public ResponseEntity<List<PetCompletDTO>> getAllPet(){
    
        return ResponseEntity.ok(service.getPetAll()); 
    }
    

    @ApiOperation(value = "Buscando um pet por id ")
    @GetMapping("/{id}")
    public ResponseEntity<PetCompletDTO> getPetById(@PathVariable Long id){
    	PetCompletDTO res = service.getPetById(id);

            return ResponseEntity.ok(res);
    }
    
    @ApiOperation(value = "Adcionando um pet novo ")
    @PostMapping
    public ResponseEntity<PetCompletDTO> addNewPet(@RequestBody @Valid PetDTO novo, @RequestParam Long idDonor){
    	PetCompletDTO res = service.addNewPet(novo,idDonor);

            return ResponseEntity.ok(res);
    }
    
    @ApiOperation(value = "Alterando informações de  um pet espeficico ")
    @PutMapping("/{id}")
    public ResponseEntity<PetDTO> changePet(@RequestBody @Valid PetDTO dados,@PathVariable Long id){
    	PetDTO res = service.changePet(dados,id);
            return ResponseEntity.ok(res);
       
    }
    
    @ApiOperation(value = "Deletando um pet ")
    @DeleteMapping
    public ResponseEntity<String> deletePet(@PathVariable Long id){
        service.deletePet(id);
        return ResponseEntity.ok("Pet deletado com sucesso !");
    }
}
