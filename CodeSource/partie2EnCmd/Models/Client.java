package Tp1.partie2EnCmd.Models;

import java.util.ArrayList;

public class Client {

	private int idClient;
	
	private String nom;
	
	private String prenom;
	
	public static int id=0;
	
	private ArrayList<CommandeLot> ListeCommandesLot=new ArrayList<>();

	private ArrayList<CommandeArt> ListeCommandesArt=new ArrayList<>();

	public Client(int idClient, String nom, String prenom, ArrayList<CommandeLot> listeCommandesLot,
			ArrayList<CommandeArt> listeCommandesArt) {
		super();
		this.idClient = ++id;
		this.nom = nom;
		this.prenom = prenom;
		ListeCommandesLot = listeCommandesLot;
		ListeCommandesArt = listeCommandesArt;
	}

	public Client(String nom, String prenom) {
		super();
		this.idClient = ++id;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public Client() {
		
	}
	
	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public ArrayList<CommandeLot> getListeCommandesLot() {
		return ListeCommandesLot;
	}

	public void setListeCommandesLot(ArrayList<CommandeLot> listeCommandesLot) {
		ListeCommandesLot = listeCommandesLot;
	}

	public ArrayList<CommandeArt> getListeCommandesArt() {
		return ListeCommandesArt;
	}

	public void setListeCommandesArt(ArrayList<CommandeArt> listeCommandesArt) {
		ListeCommandesArt = listeCommandesArt;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nom=" + nom + ", prenom=" + prenom + ", ListeCommandesLot="
				+ ListeCommandesLot + ", ListeCommandesArt=" + ListeCommandesArt + "]";
	}
	
	
}
