package com.br.adopt.pets.controller;

import com.br.adopt.pets.model.Doador;
import com.br.adopt.pets.service.AdotanteService;
import com.br.adopt.pets.service.DoadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/doador")
public class DoadorController {

    @Autowired
    private DoadorService service;
    @GetMapping
    public ArrayList<Doador> getAllDoador(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Doador> getById(@PathVariable Long id){
        Doador res = service.getById(id);

        if(res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Doador> addNew(@RequestBody Doador novo){
        Doador res = service.addNew(novo);

        if(res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();

    }
    @PutMapping
    public ResponseEntity<Doador> changeCad(@RequestBody Doador dados){
        Doador res = service.changeCad(dados);

        if(res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }
    @DeleteMapping
    public ResponseEntity<Doador> deleteCad(@PathVariable Long id){
        service.deleteCad(id);
        return ResponseEntity.ok(null);
    }

}
