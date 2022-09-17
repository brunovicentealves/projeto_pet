package com.br.adopt.pets.dtos;

import com.br.adopt.pets.model.Pet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetCompletDTO {
	
	private Long id;
	private String nome;
	private Integer idade;
	private String tipoPet;
	private String porte;
	private String ambiente;
	private String foto;
	private String vacinado;
	
	
	
	
	public PetCompletDTO( Pet pet) {
		super();
		this.nome = pet.getNome();
		this.idade = pet.getIdade();
		this.tipoPet = pet.getTipoPet();
		this.porte = pet.getPorte();
		this.ambiente = pet.getAmbiente();
		this.foto = pet.getFoto();
		this.vacinado = pet.getVacinado();
	}
	

}
