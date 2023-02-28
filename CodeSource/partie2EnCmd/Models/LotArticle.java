package Tp1.partie2EnCmd.Models;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class LotArticle extends Observable implements Observer{

	private int idLot;
	
	private int qtArticle;
	
	private float prixLot;
	
	private float pourcentage;
	
	private String reference;
	
	private String marque;
	
	private String libelleLot;
	
	private ArrayList<Article> ListeArticles=new ArrayList<>();
	
	private ArrayList<CommandeLot> ListeCommandesLot=new ArrayList<>();

	public LotArticle(int idLot, int qtArticle, float prixLot, float pourcentage, String reference, String marque,
			String libelleLot, ArrayList<Article> listeArticles, ArrayList<CommandeLot> listeCommandesLot) {
		super();
		this.idLot = idLot;
		this.qtArticle = qtArticle;
		this.prixLot = prixLot;
		this.pourcentage = pourcentage;
		this.reference = reference;
		this.marque = marque;
		this.libelleLot = libelleLot;
		ListeArticles = listeArticles;
		ListeCommandesLot = listeCommandesLot;
	}


	public LotArticle(int idLot, int qtArticle, float prixLot, float pourcentage, String reference, String marque,
			String libelleLot) {
		super();
		this.idLot = idLot;
		this.qtArticle = qtArticle;
		this.prixLot = prixLot;
		this.pourcentage = pourcentage;
		this.reference = reference;
		this.marque = marque;
		this.libelleLot = libelleLot;
	}

	public int getIdLot() {
		return idLot;
	}

	public void setIdLot(int idLot) {
		this.idLot = idLot;
	}

	public int getQtArticle() {
		return qtArticle;
	}

	public void setQtArticle(int qtArticle) {
		this.qtArticle = qtArticle;
		setChanged();
        notifyObservers();
	}

	public float getPrixLot() {
		return prixLot;
	}

	public void setPrixLot(float prixLot) {
		this.prixLot = prixLot;
		setChanged();
        notifyObservers();
	}

	public float getPourcentage() {
		return pourcentage;
	}

	public void setPourcentage(float pourcentage) {
		this.pourcentage = pourcentage;
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

	public String getLibelleLot() {
		return libelleLot;
	}

	public void setLibelleLot(String libelleLot) {
		this.libelleLot = libelleLot;
	}

	public ArrayList<Article> getListeArticles() {
		return ListeArticles;
	}

	public void setListeArticles(ArrayList<Article> listeArticles) {
		ListeArticles = listeArticles;
		setChanged();
        notifyObservers();
	}

	public ArrayList<CommandeLot> getListeCommandesLot() {
		return ListeCommandesLot;
	}

	public void setListeCommandesLot(ArrayList<CommandeLot> listeCommandesLot) {
		ListeCommandesLot = listeCommandesLot;
	}
	
    @Override
    public void update(Observable o, Object arg) {
        setChanged();
        notifyObservers();
    }

	
}
