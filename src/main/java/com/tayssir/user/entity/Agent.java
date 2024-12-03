package com.tayssir.user.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Agent extends User {
    private String service;

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public Agent(String nom, String prenom, String tel, String adresse, LocalDate dateDeNaissance, String email,
			String password, String service) {
		super(nom, prenom, tel, adresse, dateDeNaissance, email, password);
		this.service = service;
	}

	public Agent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Agent(String nom, String prenom, String tel, String adresse, LocalDate dateDeNaissance, String email,
			String password) {
		super(nom, prenom, tel, adresse, dateDeNaissance, email, password);
		// TODO Auto-generated constructor stub
	}
    
    
    
}
