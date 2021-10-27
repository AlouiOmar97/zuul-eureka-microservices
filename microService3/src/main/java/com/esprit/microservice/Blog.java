package com.esprit.microservice;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Blog implements Serializable{
	private static final long serialVersionUID = 6;
	
	@Id
	@GeneratedValue
	private int id;
	private String titre, textB, auteur;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getTextB() {
		return textB;
	}
	public void setTextB(String textB) {
		this.textB = textB;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Blog() {
		super();
	}
	public Blog(String titre) {
		super();
		this.titre = titre;
	}
	public Blog(int id, String titre, String textB, String auteur) {
		super();
		this.id = id;
		this.titre = titre;
		this.textB = textB;
	this.auteur = auteur;
	
	}
	
	
	
	
	
	

	
	
	
	
	
	
}
