package com.esprit.microservice;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AcessoirePlante implements Serializable{
	private static final long serialVersionUID = 6;
	
	@Id
	@GeneratedValue
	private int id;
	private String nom, genre, couleur;
	private double prix;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public  AcessoirePlante() {
		super();
	}
	public  AcessoirePlante(String nom) {
		super();
		this.nom = nom;
	}
	public   AcessoirePlante(int id, String nom, String genre, String couleur,double prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.genre = genre;
	this.couleur = couleur;
	this.prix = prix;
	}
	
	
	
	
	
	

	
	
	
	
	
	
}
