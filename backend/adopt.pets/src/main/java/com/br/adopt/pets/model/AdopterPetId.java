package com.br.adopt.pets.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Embeddable
public class AdopterPetId  implements Serializable {
	
	private static final long serialVersionUID = 4671531966792866602L;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Adopter adopter;

	@ManyToOne(fetch = FetchType.LAZY)
	private Pet pet;

	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(adopter, pet);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdopterPetId other = (AdopterPetId) obj;
		return Objects.equals(adopter, other.adopter) && Objects.equals(pet, other.pet);
	}
	
	

}
