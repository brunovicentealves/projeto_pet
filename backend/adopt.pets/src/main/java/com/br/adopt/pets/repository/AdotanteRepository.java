package com.br.adopt.pets.repository;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.adopt.pets.model.Adotante;

import java.util.Optional;

@Repository
public interface AdotanteRepository extends JpaRepository<Adotante, Id> {
    Optional<Object> findById(Long id);

    void deleteById(Long id);
}
