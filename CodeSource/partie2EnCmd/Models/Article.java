package Tp1.partie2EnCmd.Models;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Article extends Observable implements Observer{
	
	private int idArt;
	
	private String reference;
	
	private String nom;
	
	private String marque;
	
	private int prixUnitaire;
	
	public static int id=0;

	private ArrayList<CommandeArt> ListeCommandesArt=new ArrayList<>();
	

	public Article(String reference, String nom, String marque, int prixUnitaire,
			ArrayList<CommandeArt> listeCommandesArt) {
		super();
		this.idArt = ++id;
		this.reference = reference;
		this.nom = nom;
		this.marque = marque;
		this.prixUnitaire = prixUnitaire;
		setListeCommandesArt(listeCommandesArt);
	}

	public Article() {
		
	}
	public Article(String reference, String nom, String marque, int prixUnitaire) {
		super();
		this.idArt = ++id;
		this.reference = reference;
		this.nom = nom;
		this.marque = marque;
		this.prixUnitaire = prixUnitaire;
	}
	
	public int getIdArt() {
		return idArt;
	}

	public void setIdArt(int idArt) {
		this.idArt = idArt;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
		setChanged();
        notifyObservers();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
		setChanged();
        notifyObservers();
	}

	public int getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(int prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
		setChanged();
        notifyObservers();
	}

	public ArrayList<CommandeArt> getListeCommandesArt() {
		return ListeCommandesArt;
	}

	public void setListeCommandesArt(ArrayList<CommandeArt> listeCommandesArt) {
		ListeCommandesArt = listeCommandesArt;
	}

	@Override
	public String toString() {
		return "Article [idArt=" + idArt + ", reference=" + reference + ", nom=" + nom + ", marque=" + marque
				+ ", prixUnitaire=" + prixUnitaire + ", ListeCommandesArt=" + ListeCommandesArt + "]";
	}
	
	
	   @Override
	    public void update(Observable o, Object arg) {
	        setChanged();
	        notifyObservers();
	    }

	
	

}
