package Tp1.partie2EnCmd.Views;

import java.util.Scanner;

public class Commande {
	
	public int nombreUser() {
		Scanner entre=new Scanner(System.in);
		System.out.println("1-Enregistrer Un Client \n2-Enregistrer un Article"+
		"\n3-Afficher La Liste des Clients\n4-Afficher la Liste des Articles"+
		"\n5-Effectuer Une Commande d'Article\n6-Afficher La Liste des Commandes des Articles");
		System.out.print("\nQue voulez vous faire?");
		int choix=entre.nextInt();
		return choix;
	
	}
}
