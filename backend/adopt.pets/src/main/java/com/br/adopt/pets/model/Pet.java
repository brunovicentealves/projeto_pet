package com.br.adopt.pets.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.br.adopt.pets.dtos.PetDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="tb_pet")
public class Pet {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private Integer idade;
	private String tipoPet;
	private String porte;
	private String ambiente;
	private String foto;
	private String vacinado;
	

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDoador")
    private Donor donor;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAdotante")
    private Adopter adopter;
	
	
	
	public Pet( PetDTO pet) {
		super();
		this.nome = pet.getNome();
		this.idade = pet.getIdade();
		this.tipoPet = pet.getTipoPet();
		this.porte = pet.getPorte();
		this.ambiente = pet.getAmbiente();
		this.foto = pet.getFoto();
		this.vacinado = pet.getVacinado();
	}
	

}
