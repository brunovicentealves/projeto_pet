package com.br.adopt.pets.dtos;

import com.br.adopt.pets.model.Donor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonorDTO {
	
	
	private Long id;

	private String nome;
	
	private String email;
	
	private String telefone;
	
	private String localizacao;
	
	private String foto;

	
	
	public DonorDTO(Donor donor) {
		
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.localizacao = localizacao;
		this.foto = foto;
	}

	
	
	
	

}
