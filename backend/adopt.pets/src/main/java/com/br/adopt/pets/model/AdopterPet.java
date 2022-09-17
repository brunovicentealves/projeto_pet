package com.br.adopt.pets.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.br.adopt.pets.util.StatusPet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tb_adopter_Pet")
public class AdopterPet {
	
	@EmbeddedId
	private AdopterPetId id;
	
	private StatusPet  status ;

}
