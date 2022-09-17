package com.br.adopt.pets.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	protected String nome;
	
	protected String email;
	
	protected String telefone;
	
	protected String localizacao;
	
	protected String foto;

}
