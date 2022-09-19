package com.br.adopt.pets.dtos;

import com.br.adopt.pets.model.Pet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetDTO {
	

	private String nome;
	private Integer idade;
	private String cor;
	private String especie;
	private String tipoPet;
	private String porte;
	private String ambiente;
	private String foto;
	private String vacinado;
	
	
	public PetDTO( Pet pet) {
		super();
		this.nome = pet.getNome();
		this.idade = pet.getIdade();
		this.cor=pet.getCor();
		this.especie=pet.getEspecie();
		this.tipoPet = pet.getTipoPet();
		this.porte = pet.getPorte();
		this.ambiente = pet.getAmbiente();
		this.foto = pet.getFoto();
		this.vacinado = pet.getVacinado();
	}
	
	
	
	

}
