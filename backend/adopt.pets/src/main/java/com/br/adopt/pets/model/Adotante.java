package com.br.adopt.pets.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_adotante")
public class Adotante extends Cliente {
	
	private String tipoPet;
	
	private String especie;
	
	private String porte;
	
	@OneToMany(mappedBy = "adotante")
	private List<Pet> pet;

	
	public Adotante(Long id, String nome, String email, String telefone, String localizacao, String foto, String tipoPet,String especie, String porte) {
		super(id, nome, email, telefone, localizacao, foto);
		this.tipoPet=tipoPet;
		this.especie = especie;
		this.porte=porte;
	}
	

	public String getTipoPet() {
		return tipoPet;
	}

	public void setTipoPet(String tipoPet) {
		this.tipoPet = tipoPet;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}
	
	
	


	
	

	
	
	
	
		
}
