package com.br.adopt.pets.controller;

import com.br.adopt.pets.model.Adotante;
import com.br.adopt.pets.service.AdotanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/adotante")
public class AdotanteController {

    @Autowired
    private AdotanteService service;

    @GetMapping
    public ArrayList<Adotante> getAllAdotantes(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Adotante> getById(@PathVariable Long id){
        Adotante res = service.getById(id);

        if(res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Adotante> addNew(@RequestBody Adotante novo){
        Adotante res = service.addNew(novo);

        if(res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();

    }
    @PutMapping
    public ResponseEntity<Adotante> changeCad(@RequestBody Adotante dados){
        Adotante res = service.changeCad(dados);

        if(res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Adotante> deleteCad(@PathVariable Long id){
        service.deleteCad(id);
        return ResponseEntity.ok(null);
    }

}
