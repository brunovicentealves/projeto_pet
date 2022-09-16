package com.br.adopt.pets.controller;


import com.br.adopt.pets.model.Pet;
import com.br.adopt.pets.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/pet")
public class PetController {
    @Autowired
    private PetService service;
    @GetMapping
    public ArrayList<Pet> getAllDoador(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pet> getById(@PathVariable Long id){
        Pet res = service.getById(id);

        if(res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Pet> addNew(@RequestBody Pet novo){
        Pet res = service.addNew(novo);

        if(res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();

    }
    @PutMapping
    public ResponseEntity<Pet> changeCad(@RequestBody Pet dados){
        Pet res = service.changeCad(dados);

        if(res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }
    @DeleteMapping
    public ResponseEntity<Pet> deleteCad(@PathVariable Long id){
        service.deleteCad(id);
        return ResponseEntity.ok(null);
    }
}
