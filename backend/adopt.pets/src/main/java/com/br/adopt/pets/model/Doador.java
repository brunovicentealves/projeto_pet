package com.br.adopt.pets.model;

import javax.persistence.Entity;


@Entity(name = "tb_doador")
public class Doador extends Cliente {

	public Doador() {
		super();
	}

	public Doador(Long id, String nome, String email, String telefone, String localizacao, String foto) {
		super(id, nome, email, telefone, localizacao, foto);
		
	}
	
	
	
		
}
