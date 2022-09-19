package com.br.adopt.pets.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.br.adopt.pets.model.Pet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetDTO {
	

	@NotBlank(message = "Nome invalido!")
	private String nome;
	
	@Min(value = 0 , message = "idade invalida! não pode idade menor que Zero")
	private Integer idade;
	
	private String cor;
	
	@Size(min = 4, max = 40, message  = "Campo especie deve ter 4 a 25 caracteres")
	private String especie;
	
	@Size(min = 4, max = 40, message  = "Campo tipoPet deve ter 4 a 40 caracteres")
	private String tipoPet;
	
	@Size(min = 4, max = 15, message  = "Campo porte deve ter 4 a 15 caracteres")
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
