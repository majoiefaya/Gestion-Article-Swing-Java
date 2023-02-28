package Tp1.partie2EnCmd.Models;

public class CommandeArt {

	private int  idCmdArt;
	
	private Client client;
	
	private Article article;
	
	private int qtArticle;
	
	private String facture;
	
	private int prixTotal;
	
	public static int id=0;

	public CommandeArt(Client client, Article article, int qtArticle, String facture, int prixTotal) {
		super();
		this.idCmdArt = ++id;
		this.client = client;
		this.article = article;
		this.qtArticle = qtArticle;
		this.facture = facture;
		this.prixTotal = prixTotal;
	}

	public int getIdCmdArt() {
		return idCmdArt;
	}

	public void setIdCmdArt(int idCmdArt) {
		this.idCmdArt = idCmdArt;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getQtArticle() {
		return qtArticle;
	}

	public void setQtArticle(int qtArticle) {
		this.qtArticle = qtArticle;
	}

	public String getFacture() {
		return facture;
	}

	public void setFacture(String facture) {
		this.facture = facture;
	}

	public int getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(int prixTotal) {
		this.prixTotal = prixTotal;
	}

	@Override
	public String toString() {
		return "CommandeArt [idCmdArt=" + idCmdArt + ", client=" + client + ", article=" + article + ", qtArticle="
				+ qtArticle + ", facture=" + facture + ", prixTotal=" + prixTotal + "]";
	}
	
	
	
	
}
