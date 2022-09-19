package com.br.adopt.pets.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.br.adopt.pets.model.Donor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonorDTO {
	
	
	@NotBlank(message = "Nome invalido!")
	private String nome;
	
	@Email(message = "Email invalido!")
	private String email;
	
	@Size(min = 11,max=14,message="Excedeu tamanho do numero do telefone do Adotante")
	private String telefone;
	
	private String localizacao;
	
	private String foto;

	
	
	public DonorDTO(Donor donor) {
		this.nome = donor.getNome();
		this.email = donor.getEmail();
		this.telefone = donor.getTelefone();
		this.localizacao = donor.getLocalizacao();
		this.foto = donor.getFoto();
	}

	
	
	
	

}
