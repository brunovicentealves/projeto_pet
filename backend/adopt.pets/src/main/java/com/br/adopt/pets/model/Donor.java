package com.br.adopt.pets.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.br.adopt.pets.dtos.DonorCompletDTO;
import com.br.adopt.pets.dtos.DonorDTO;


@Entity(name = "tb_doador")
public class Donor extends Client {
	
	@OneToMany(mappedBy = "donor")
	private List<Pet> pet;

	public Donor() {
		super();
		
	}

	public Donor(Long id, String nome, String email, String telefone, String localizacao, String foto) {
		super(id, nome, email, telefone, localizacao, foto);
		
	}
	
	
	
	public Donor(DonorDTO dto) {
		super(null, dto.getNome(), dto.getEmail(), dto.getTelefone(),dto.getLocalizacao(),dto.getFoto());
		
	}
	
	
	public Donor(DonorCompletDTO dto) {
		super(dto.getId(), dto.getNome(), dto.getEmail(), dto.getTelefone(),dto.getLocalizacao(),dto.getFoto());
		
	}


	
	
	
		
}
