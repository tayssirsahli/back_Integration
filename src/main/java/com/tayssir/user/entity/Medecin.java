package com.tayssir.user.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Medecin extends User {
    private String code;
    
    @OneToOne(mappedBy = "medecin")
    private Image diplome;
    
    private int numCin;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Image getDiplome() {
		return diplome;
	}
	public void setDiplome(Image diplome) {
		this.diplome = diplome;
	}
	public int getNumCin() {
		return numCin;
	}
	public void setNumCin(int numCin) {
		this.numCin = numCin;
	}
	public Medecin(String nom, String prenom, String tel, String adresse, LocalDate dateDeNaissance, String email,
			String password, String code, Image diplome, int numCin) {
		super(nom, prenom, tel, adresse, dateDeNaissance, email, password);
		this.code = code;
		this.diplome = diplome;
		this.numCin = numCin;
	}
	public Medecin() {
		super();
		
	}
	public Medecin(String nom, String prenom, String tel, String adresse, LocalDate dateDeNaissance, String email,
			String password) {
		super(nom, prenom, tel, adresse, dateDeNaissance, email, password);
		
	}
    
    
}
