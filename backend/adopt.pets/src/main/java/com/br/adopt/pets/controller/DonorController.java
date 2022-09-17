package com.br.adopt.pets.controller;

import java.util.List;

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

@RestController
@RequestMapping("/api/v1/Donor")
public class DonorController {

    @Autowired
    private DonorService service;
    @GetMapping
    public ResponseEntity<List<DonorCompletDTO>> getAllDonor(){
        return ResponseEntity.ok(service.getDonorAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DonorCompletDTO> getDonorById(@PathVariable Long id){
    	DonorCompletDTO res = service.getDonorById(id);
        return ResponseEntity.ok(res);
    }
    @PostMapping
    public ResponseEntity<DonorCompletDTO> addNewDonor(@RequestBody DonorDTO novo){
    	DonorCompletDTO res = service.addNewDonor(novo);
            return ResponseEntity.ok(res);
   
    }
    @PutMapping("/{id}")
    public ResponseEntity<DonorDTO> changeDonor(@RequestBody DonorDTO dados,@PathVariable Long id){
    	DonorDTO res = service.changeDonor(dados,id);   
            return ResponseEntity.ok(res);
    }
    @DeleteMapping
    public ResponseEntity<String> deleteDonor(@PathVariable Long id){
        service.deleteDonor(id);
        return ResponseEntity.ok("Deletado com Sucesso o Doador!");
    }

}
