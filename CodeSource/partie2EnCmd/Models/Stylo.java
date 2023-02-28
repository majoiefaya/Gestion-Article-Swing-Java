package Tp1.partie2EnCmd.Models;

import java.util.ArrayList;

public class Stylo extends Article{

	private String couleur;
	
	private int idStylo;

	public static int id=0;



	public Stylo(String reference, String nom, String marque, int prixUnitaire,
			ArrayList<CommandeArt> listeCommandesArt, String couleur) {
		super(reference, nom, marque, prixUnitaire, listeCommandesArt);
		this.couleur = couleur;
		this.idStylo = ++id;
	}


	public Stylo(String reference, String nom, String marque, int prixUnitaire, String couleur) {
		super(reference, nom, marque, prixUnitaire);
		this.couleur = couleur;
		this.idStylo = ++id;
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
