package com.br.adopt.pets.dtos;

import com.br.adopt.pets.model.Donor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonorCompletDTO {

	private Long id;
	private String nome;

	private String email;

	private String telefone;

	private String localizacao;

	private String foto;

	public DonorCompletDTO(Donor donor) {
		this.id=donor.getId();
		this.nome = donor.getNome();
		this.email = donor.getEmail();
		this.telefone = donor.getTelefone();
		this.localizacao = donor.getLocalizacao();
		this.foto = donor.getFoto();
	}

}
