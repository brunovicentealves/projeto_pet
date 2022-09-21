package com.br.adopt.pets.dtos;

import javax.validation.constraints.Size;

import com.br.adopt.pets.model.Adopter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdopterPreferencesDTO {
	
	
	@Size(min = 4, max = 40, message  = "Campo tipoPet deve ter 4 a 40 caracteres")
	private String tipoPet;
	
	@Size(min = 4, max = 40, message  = "Campo especie deve ter 4 a 25 caracteres")
	private String especie;
	
	@Size(min = 4, max = 15, message  = "Campo porte deve ter 4 a 15 caracteres")
	private String porte;
	
	public AdopterPreferencesDTO(Adopter adopter) {
		this.tipoPet = adopter.getTipoPet();
		this.especie = adopter.getEspecie();
		this.porte = adopter.getPorte();
	}
	
	

}
