package com.br.adopt.pets.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.br.adopt.pets.dtos.AdopterDTO;


@Entity(name = "tb_adotante")
public class Adopter extends Client {
	
	private String tipoPet;
	
	private String especie;
	
	private String porte;
	
	@OneToMany(mappedBy = "adopter")
	private List<Pet> pet;

	
	public Adopter(Long id, String nome, String email, String telefone, String localizacao, String foto, String tipoPet,String especie, String porte) {
		super(id, nome, email, telefone, localizacao, foto);
		this.tipoPet=tipoPet;
		this.especie = especie;
		this.porte=porte;
	}
	
	
	public Adopter(AdopterDTO adopter,Long id) {
		super(id, adopter.getNome(), adopter.getEmail(), adopter.getTelefone(), adopter.getLocalizacao(), adopter.getFoto());
		
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

	public Adopter() {
		super();
	}

	public Adopter(String tipoPet, String especie, String porte, List<Pet> pet) {
		super();
		this.tipoPet = tipoPet;
		this.especie = especie;
		this.porte = porte;
		this.pet = pet;
	}
	
	
	


	
	

	
	
	
	
		
}
