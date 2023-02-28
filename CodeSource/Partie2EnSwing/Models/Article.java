package Tp1.Partie2EnSwing.Models;

import java.util.Observable;
import java.util.Observer;

public class Article  extends Observable implements Observer{
    private int id;
    private String nom;
    private String description;
    private double prix;
    private int quantite;
	private String reference;
	private String marque;
	
	public Article(int id, String nom, String description, double prix, int quantite, String reference, String marque) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.reference = reference;
		this.marque = marque;
	}

	
	public Article(String nom, String description, double prix, int quantite, String reference, String marque) {
		super();
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.reference = reference;
		this.marque = marque;
	}


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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
		setChanged();
        notifyObservers();
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
		setChanged();
        notifyObservers();
	}


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
		setChanged();
        notifyObservers();
	}


	public String getReference() {
		return reference;

	}


	public void setReference(String reference) {
		this.reference = reference;
		setChanged();
        notifyObservers();
	}


	public String getMarque() {
		return marque;
	}


	public void setMarque(String marque) {
		this.marque = marque;
		setChanged();
        notifyObservers();
	}

   @Override
    public void update(Observable o, Object arg) {
        setChanged();
        notifyObservers();
    }

	
   
}
