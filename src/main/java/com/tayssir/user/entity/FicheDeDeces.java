package com.tayssir.user.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class FicheDeDeces {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate dateDeces;

	private LocalTime heureDeces;

	@Lob
	private byte[] certificatDeces;

	@Lob
	private byte[] cinDeces;

	private String nomMedecin;

	private String nomClient;

	@Column(unique = true, length = 8)
	private String cinClient;

	@OneToOne(mappedBy = "deces", cascade = CascadeType.ALL)
	private Payment payment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDateDeces() {
		return dateDeces;
	}

	public void setDateDeces(LocalDate dateDeces) {
		this.dateDeces = dateDeces;
	}

	public LocalTime getHeureDeces() {
		return heureDeces;
	}

	public void setHeureDeces(LocalTime heureDeces) {
		this.heureDeces = heureDeces;
	}

	public byte[] getCertificatDeces() {
		return certificatDeces;
	}

	public void setCertificatDeces(byte[] certificatDeces) {
		this.certificatDeces = certificatDeces;
	}

	public byte[] getCinDeces() {
		return cinDeces;
	}

	public void setCinDeces(byte[] cinDeces) {
		this.cinDeces = cinDeces;
	}

	public String getNomMedecin() {
		return nomMedecin;
	}

	public void setNomMedecin(String nomMedecin) {
		this.nomMedecin = nomMedecin;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getCinClient() {
		return cinClient;
	}

	public void setCinClient(String cinClient) {
		this.cinClient = cinClient;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public FicheDeDeces(LocalDate dateDeces, LocalTime heureDeces, byte[] certificatDeces, byte[] cinDeces,
			String nomMedecin, String nomClient, String cinClient, Payment payment) {
		super();
		this.dateDeces = dateDeces;
		this.heureDeces = heureDeces;
		this.certificatDeces = certificatDeces;
		this.cinDeces = cinDeces;
		this.nomMedecin = nomMedecin;
		this.nomClient = nomClient;
		this.cinClient = cinClient;
		this.payment = payment;
	}

	public FicheDeDeces() {
		super();
		// TODO Auto-generated constructor stub
	}

}
