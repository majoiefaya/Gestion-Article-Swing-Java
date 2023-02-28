package Tp1.partie2EnCmd.Controllers;

import java.util.ArrayList;
import java.util.Scanner;

import Tp1.partie2EnCmd.Models.Client;

public class ClientController {

	

	public Client CreerClient() {
		Scanner entre=new Scanner(System.in);
		System.out.println("Entrez le nom du client");
		String nom=entre.next();
		System.out.println("Entrez le prenom du client");
		String prenom=entre.next();
		Client c=new Client(nom,prenom);
		System.out.println("\n-----------------------\nClient Bien enregistrée!!\n------------------------\n");
		return c;
	}
	
	public Client RechercherClient(ArrayList<Client> ListeClients) {
		Scanner entre=new Scanner(System.in);
		System.out.println("Entrez le nom du client qui veut faire la commande ");
		String nom=entre.next();
		Client client=new Client();
		for (int i = 0; i<ListeClients.size(); i++) {
			if(ListeClients.get(i).getNom()==nom){
				client=ListeClients.get(i);
				System.out.println("voici les informations du client selectionnées"+ client.toString());
				return client;
			}
		  }
		return client;
	}
	

	
	public void ListeClients(ArrayList<Client> ListeClients) {
		System.out.println("Liste des Clients");
   	 	for (int i = 0; i<ListeClients.size(); i++) {
			 System.out.println(ListeClients.get(i).toString());
		  }
	}
	
	
}
