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
import org.springframework.web.bind.annotation.RestController;

import com.br.adopt.pets.dtos.DonorCompletDTO;
import com.br.adopt.pets.dtos.DonorDTO;
import com.br.adopt.pets.service.DonorService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/Donor")
public class DonorController {

    @Autowired
    private DonorService service;
    
    @ApiOperation(value = "Buscando uma lista de Doadores")
    @GetMapping
    public ResponseEntity<List<DonorCompletDTO>> getAllDonor(){
        return ResponseEntity.ok(service.getDonorAll());
    }
    
    
    @ApiOperation(value = "Buscando um Doador pelo id")
    @GetMapping("/{id}")
    public ResponseEntity<DonorCompletDTO> getDonorById(@PathVariable Long id){
    	DonorCompletDTO res = service.getDonorById(id);
        return ResponseEntity.ok(res);
    }
    
    
    @ApiOperation(value = "Adcionando um novo doador")
    @PostMapping
    public ResponseEntity<DonorCompletDTO> addNewDonor(@RequestBody @Valid DonorDTO novo){
    	DonorCompletDTO res = service.addNewDonor(novo);
            return ResponseEntity.ok(res);
   
    }
    
    @ApiOperation(value = "Alterando as informações de um doador")
    @PutMapping("/{id}")
    public ResponseEntity<DonorDTO> changeDonor(@RequestBody @Valid DonorDTO dados,@PathVariable Long id){
    	DonorDTO res = service.changeDonor(dados,id);   
            return ResponseEntity.ok(res);
    }
    
    @ApiOperation(value = "Deletando um doador")
    @DeleteMapping
    public ResponseEntity<String> deleteDonor(@PathVariable Long id){
        service.deleteDonor(id);
        return ResponseEntity.ok("Deletado com Sucesso o Doador!");
    }

}
