package Tp1.partie2EnCmd.Views;

import java.util.*;

import Tp1.partie2EnCmd.Controllers.*;
import Tp1.partie2EnCmd.Models.Article;
import Tp1.partie2EnCmd.Models.Client;
import Tp1.partie2EnCmd.Models.CommandeArt;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner entre=new Scanner(System.in);
		ArticleController a=new ArticleController();
		ClientController c= new ClientController();
		Commande cmd=new Commande();
		
		ArticleCommandeController cmdArt=new ArticleCommandeController();
		ArrayList<Client> ListeClients=new ArrayList<>();
		ArrayList<CommandeArt> ListeCommandeArt=new ArrayList<>();
		ArrayList<Article> ListeArticles=new ArrayList<>();
		
		while(true) {
			int choix=cmd.nombreUser();
			switch (choix){
			case 1:
				ListeClients.add(c.CreerClient());
				break;
			case 2:
				ListeArticles.add(a.CreerArticle());
				break;
			case 3:
			    c.ListeClients(ListeClients);
		    	break;
			case 4:
				a.ListeArticles(ListeArticles);
		    	break;
			case 5:
				ListeCommandeArt.add(cmdArt.CreerCommandeArticle(ListeClients, ListeArticles));
				break;
			case 6:
				cmdArt.ListeCommandesArticle(ListeCommandeArt);
				break;
			}
		
		}
		
		
	}

}
