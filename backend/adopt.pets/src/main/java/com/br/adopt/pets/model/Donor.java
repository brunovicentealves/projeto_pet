package com.br.adopt.pets.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class Donor extends Client {
	
	@OneToMany(mappedBy = "donor")
	private List<Pet> pet;

	public Donor() {
		super();
		
	}

	public Donor(Long id, String nome, String email, String telefone, String localizacao, String foto) {
		super(id, nome, email, telefone, localizacao, foto);
		
	}
	
	
	
	


	
	
	
		
}
