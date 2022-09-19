package com.br.adopt.pets.dtos;

import com.br.adopt.pets.model.Adopter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdopterPreferencesDTO {
	
	private String tipoPet;
	
	private String especie;
	
	private String porte;
	
	

	public AdopterPreferencesDTO(Adopter adopter) {
		this.tipoPet = adopter.getTipoPet();
		this.especie = adopter.getEspecie();
		this.porte = adopter.getPorte();
	}
	
	

}
