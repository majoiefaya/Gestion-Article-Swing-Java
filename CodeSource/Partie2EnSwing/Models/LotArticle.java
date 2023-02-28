package Tp1.Partie2EnSwing.Models;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class LotArticle extends Observable implements Observer {
	
	private int idLot;
	
	private int qtArticle;
	
	private float prixLot;
	
	private float pourcentage;
	
	private String reference;
	
	private String marque;
	
	private List<Article> articles;
	
	private String libelleLot;

	public LotArticle(int idLot, int qtArticle, float prixLot, float pourcentage, String reference, String marque,
			String libelleLot) {
		super();
		this.setIdLot(idLot);
		this.setQtArticle(qtArticle);
		this.setPrixLot(prixLot);
		this.pourcentage = pourcentage;
		this.reference = reference;
		this.marque = marque;
		this.setLibelleLot(libelleLot);
	}


    public String getReference() {
        return reference;
    }

    @SuppressWarnings("deprecation")
	public void setReference(String reference) {
        this.reference = reference;
        setChanged();
        notifyObservers();
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marqueArticle) {
        this.marque = marqueArticle;
        setChanged();
        notifyObservers();
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
        setChanged();
        notifyObservers();
    }

    public double getPourcentage() {
        return pourcentage;
    }


	public String getLibelleLot() {
		return libelleLot;
	}


	public void setLibelleLot(String libelleLot) {
		this.libelleLot = libelleLot;
	}


	public float getPrixLot() {
		return prixLot;
	}


	public void setPrixLot(float prixLot) {
		this.prixLot = prixLot;
	      setChanged();
	      notifyObservers();
	}


	public int getQtArticle() {
		return qtArticle;
	}


	public void setQtArticle(int qtArticle) {
		this.qtArticle = qtArticle;
		setChanged();
        notifyObservers();
	}


	public int getIdLot() {
		return idLot;
	}


	public void setIdLot(int idLot) {
		this.idLot = idLot;
	}
	

    public void addArticle(Article article) {
        this.articles.add(article);
        article.addObserver(this);
        setChanged();
        notifyObservers();
    }

    public void removeArticle(Article article) {
        this.articles.remove(article);
        article.deleteObserver(this);
        setChanged();
        notifyObservers();
    }


    @Override
    public void update(Observable o, Object arg) {
        setChanged();
        notifyObservers();
    }

	
	
}
