package com.br.adopt.pets.repository;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.adopt.pets.model.Doador;

import java.util.Optional;

@Repository
public interface DoadorRepository  extends CrudRepository<Doador, Id> {
    void deleteById(Long id);

    Optional<Object> findById(Long id);

}
