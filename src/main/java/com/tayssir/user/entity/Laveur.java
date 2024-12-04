package com.tayssir.user.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Laveur extends User {
    private String genre;

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Laveur(String nom, String prenom, String tel, String adresse, LocalDate dateDeNaissance, String email,
			String password, String genre,Double prix) {
		super(nom, prenom, tel, adresse, dateDeNaissance, email, password,prix);
		this.genre = genre;
	}

	public Laveur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Laveur(String nom, String prenom, String tel, String adresse, LocalDate dateDeNaissance, String email,
			String password,Double prix) {
		super(nom, prenom, tel, adresse, dateDeNaissance, email, password,prix);
		// TODO Auto-generated constructor stub
	}
    
    
    
}
