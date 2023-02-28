package Tp1.partie2EnCmd.Models;

import java.util.ArrayList;

public class Ramette extends Article{

	private int idRamette;
	private double grammage;
	
	public static int id=0;




	public Ramette(String reference, String nom, String marque, int prixUnitaire,
			ArrayList<CommandeArt> listeCommandesArt, int idRamette, double grammage) {
		super(reference, nom, marque, prixUnitaire, listeCommandesArt);
		this.idRamette = ++id;
		this.grammage = grammage;
	}
	

	public Ramette(String reference, String nom, String marque, int prixUnitaire, double grammage) {
		super(reference, nom, marque, prixUnitaire);
		this.idRamette = ++id;
		this.grammage = grammage;
	}

	public double getGrammage() {
		return grammage;
	}

	public void setGrammage(double grammage) {
		this.grammage = grammage;
	}

	public int getIdRamette() {
		return idRamette;
	}

	public void setIdRamette(int idRamette) {
		this.idRamette = idRamette;
	}

}
