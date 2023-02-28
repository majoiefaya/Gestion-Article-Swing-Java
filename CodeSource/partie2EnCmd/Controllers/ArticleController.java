package Tp1.partie2EnCmd.Controllers;

import java.util.ArrayList;
import java.util.Scanner;

import Tp1.partie2EnCmd.Models.Article;
import Tp1.partie2EnCmd.Models.Client;
import Tp1.partie2EnCmd.Models.CommandeArt;
import Tp1.partie2EnCmd.Models.Ramette;
import Tp1.partie2EnCmd.Models.Stylo;

public class ArticleController {

	public  Article RechercherArticle(ArrayList<Article> ListeArticles) {
		Scanner entre=new Scanner(System.in);
		System.out.println("Entrez le nom de l'Article Commande ");
		String nom=entre.next();
		Article article=new Article();
		for (int i = 0; i<ListeArticles.size(); i++) {
			if(ListeArticles.get(i).getNom()==nom){
				article=ListeArticles.get(i);
				System.out.println("voici les informations de l'Article selectionnée"+ article.toString());
				return article;
			}
		  }
		return article;
	}
		

	public Article CreerArticle() {
		Scanner entre=new Scanner(System.in);
		System.out.println("Quel type d'Article voulez-vous creer?\n1-Ramette\n2-Stylo");
		int choix=entre.nextInt();
		Article a=new Article();
		if (choix==1) {
			System.out.println("Entrez la reference");
			String reference=entre.next();
			
			System.out.println("Entrez le nom de l'Article");
			String nom=entre.next();
			
			System.out.println("Entrez la Marque");
			String marque=entre.next();
			
			System.out.println("Entrez le Prix Unitaire");
			int prixUnitaire=entre.nextInt();
			
			System.out.println("Entrez le grammage");
			double grammage=entre.nextDouble();
			
			Ramette m=new Ramette(reference,nom,marque,prixUnitaire,grammage);	
			a=m;
			System.out.println("\n-----------------------\nArticle Bien enregistrée!!\n------------------------\n");
			return a;
		}else if(choix==2) {
			System.out.println("Entrez la reference");
			String reference=entre.next();
			
			System.out.println("Entrez le nom de l'Article");
			String nom=entre.next();
			
			System.out.println("Entrez la Marque");
			String marque=entre.next();
			
			System.out.println("Entrez le Prix Unitaire");
			int prixUnitaire=entre.nextInt();
			
			System.out.println("Entrez la Couleur du Stylo");
			String couleur=entre.next();
			
			Stylo s=new Stylo(reference,nom,marque,prixUnitaire,couleur);
			a=s;
			System.out.println("\n-----------------------\nArticle Bien enregistrée!!\n------------------------\n");
			return a;
		}
		return a;
	}
	
	public void ListeArticles(ArrayList<Article> ListeArticles) {
		System.out.println("Liste des Articles");
   	 	for (int i = 0; i<ListeArticles.size(); i++) {
			 System.out.println(ListeArticles.get(i).toString());
		  }
	}
	



	
}
