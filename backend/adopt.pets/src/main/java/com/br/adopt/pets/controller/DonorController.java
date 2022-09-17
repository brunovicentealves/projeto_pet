package com.br.adopt.pets.controller;

import java.util.ArrayList;

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

import com.br.adopt.pets.model.Donor;
import com.br.adopt.pets.service.DonorService;

@RestController
@RequestMapping("/api/v1/Donor")
public class DonorController {

    @Autowired
    private DonorService service;
    @GetMapping
    public ArrayList<Donor> getAllDoador(){
        return service.getDonorAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Donor> getById(@PathVariable Long id){
        Donor res = service.getDonorById(id);

        if(res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Donor> addNew(@RequestBody Donor novo){
        Donor res = service.addNewDonor(novo);

        if(res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();

    }
    @PutMapping
    public ResponseEntity<Donor> changeCad(@RequestBody Donor dados){
        Donor res = service.changeDonor(dados);

        if(res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }
    @DeleteMapping
    public ResponseEntity<Donor> deleteCad(@PathVariable Long id){
        service.deleteDonor(id);
        return ResponseEntity.ok(null);
    }

}
