package com.br.adopt.pets.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.br.adopt.pets.util.StatusPet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_adotante_pet")
public class AdopterPet {
	
	@EmbeddedId
	private AdopterPetId id;
	
	private StatusPet  status ;

}
