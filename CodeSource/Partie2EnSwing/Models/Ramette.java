package Tp1.Partie2EnSwing.Models;

public class Ramette extends Article{
	private int idRamette;
	private double grammage;
	
	public Ramette(int id, String nom, String description, double prix, int quantite, String reference, String marque,
			int listeCommandesArt, int idRamette, double grammage) {
		super(id, nom, description, prix, quantite, reference, marque);
		this.idRamette = idRamette;
		this.grammage = grammage;
	}

	public Ramette(int id, String nom, String description, double prix, int quantite, String reference, String marque,
			int listeCommandesArt,double grammage) {
		super(id, nom, description, prix, quantite, reference, marque);
		this.grammage = grammage;
	}
	
	public int getIdRamette() {
		return idRamette;
	}

	public void setIdRamette(int idRamette) {
		this.idRamette = idRamette;
	}

	public double getGrammage() {
		return grammage;
	}

	public void setGrammage(double grammage) {
		this.grammage = grammage;
	}


}
