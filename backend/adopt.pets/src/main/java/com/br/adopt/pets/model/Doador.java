package com.br.adopt.pets.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class Doador extends Cliente {
	
	@OneToMany(mappedBy = "doador")
	private List<Pet> pet;

	public Doador() {
		super();
		
	}

	public Doador(Long id, String nome, String email, String telefone, String localizacao, String foto) {
		super(id, nome, email, telefone, localizacao, foto);
		
	}
	
	
	
	


	
	
	
		
}
