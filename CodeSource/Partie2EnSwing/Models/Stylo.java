package Tp1.Partie2EnSwing.Models;

import java.util.Observable;

public class Stylo extends Article{

	private String couleur;
	
	private int idStylo;

	public Stylo(int id, String nom, String description, double prix, int quantite, String reference, String marque,
			int listeCommandesArt, String couleur, int idStylo) {
		super(id, nom, description, prix, quantite, reference, marque);
		this.couleur = couleur;
		this.idStylo = idStylo;
	}

	
	public Stylo(int id, String nom, String description, double prix, int quantite, String reference, String marque,
			int listeCommandesArt, String couleur) {
		super(id, nom, description, prix, quantite, reference, marque);
		this.couleur = couleur;
	}


	public String getCouleur() {
		return couleur;

	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}


	public int getIdStylo() {
		return idStylo;
	}


	public void setIdStylo(int idStylo) {
		this.idStylo = idStylo;
	}
		

	
}
