package Tp1.partie2EnCmd.Controllers;

import java.util.ArrayList;
import java.util.Scanner;

import Tp1.partie2EnCmd.Models.Article;
import Tp1.partie2EnCmd.Models.Client;
import Tp1.partie2EnCmd.Models.CommandeArt;

public class ArticleCommandeController {
	public ArticleController a=new ArticleController();
	public ClientController c=new ClientController();
	
	public CommandeArt CreerCommandeArticle(ArrayList<Client> ListeClients,ArrayList<Article> ListeArticles) {
		
		Scanner entre=new Scanner(System.in);
		
		c.ListeClients(ListeClients);
		Client c1 =c.RechercherClient(ListeClients);

		a.ListeArticles(ListeArticles);
		Article a1=a.RechercherArticle(ListeArticles);

		System.out.println("Entrez la quantite de l'Article");
		
		int qtArticle=entre.nextInt();
		
		int prixTotal=a1.getPrixUnitaire()*qtArticle;
		
		String facture="Facture de La Commande:\n"+"L'Article Commandé est :"+a1.getNom()+"\n"
		+"La quantité commandée est: "+qtArticle+"\nLe Nom du Client: "
		+c1.getNom()+"\nLe Prix Total de la Commande est: "+prixTotal;		
	
		
		CommandeArt cmdArt=new CommandeArt(c1,a1,qtArticle,facture,prixTotal);
		
		System.out.println(facture);
		
		return cmdArt;
	}
	
	public void ListeCommandesArticle(ArrayList<CommandeArt> ListeCommandeArt) {
		System.out.println("Liste des Commandes d'Articles");
   	 	for (int i = 0; i<ListeCommandeArt.size(); i++) {
			 System.out.println(ListeCommandeArt.get(i).toString());
		  }
	}
	
	
	
}
