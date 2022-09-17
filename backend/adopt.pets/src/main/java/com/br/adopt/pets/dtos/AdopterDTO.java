package com.br.adopt.pets.dtos;

import com.br.adopt.pets.model.Adopter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdopterDTO {
	
	private String nome;
	
	private String email;
	
	private String telefone;
	
	private String localizacao;
	
	private String foto;

	public AdopterDTO(Adopter adopter) {
		this.nome = adopter.getNome();
		this.email=adopter.getEmail();
		this.telefone=adopter.getTelefone();
		this.localizacao=adopter.getLocalizacao();
		this.foto=adopter.getFoto();
		
	}
	
	

	
	
}
