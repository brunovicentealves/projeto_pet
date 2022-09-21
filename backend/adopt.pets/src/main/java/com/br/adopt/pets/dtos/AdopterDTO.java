package com.br.adopt.pets.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

	@NotBlank(message = "Nome invalido!")
	private String nome;

	@Email(message = "Email invalido!")
	private String email;

	@Size(min = 11,max=14,message="Excedeu tamanho do numero do telefone do Adotante")
	private String telefone;

	private String localizacao;

	private String foto;

	public AdopterDTO(Adopter adopter) {
		this.nome = adopter.getNome();
		this.email = adopter.getEmail();
		this.telefone = adopter.getTelefone();
		this.localizacao = adopter.getLocalizacao();
		this.foto = adopter.getFoto();

	}

}
