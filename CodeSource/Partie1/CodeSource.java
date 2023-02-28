package Tp1.Partie1;

import javax.swing.*;
import java.awt.*;
//1)Programme
public class CodeSource {
    public static void main(String[] args) {
        JFrame frame = new JFrame("TP1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
       
        JPanel panelPrincipal = new JPanel();

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Panel Secondaire 1"));

        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Panel Secondaire 2"));

        JButton button1 = new JButton("cliquez-ici");


        JMenuBar myMenuBar=new JMenuBar();


		panelPrincipal.add(myMenuBar);

        panelPrincipal.add(panel1);
        panelPrincipal.add(panel2);
        panelPrincipal.add(button1);
		

		myMenuBar.setBounds(0, 0, 500, 30);

		JMenu menuFichier = new JMenu("Fichier");
		JMenuItem menuNouveau = new JMenuItem("Nouveau"); 
		JMenuItem menuOuvrir = new JMenuItem("Ouvrir"); 
		JMenuItem menuEnregistrer = new JMenuItem("Enregistrer");
		JMenuItem menuImprimer = new JMenuItem("Imprimer"); 
		JMenuItem menuQuitter = new JMenuItem("Quitter"); 
		

		menuFichier.add(menuNouveau);
		menuFichier.add(menuOuvrir);
		menuFichier.add(menuEnregistrer);
		menuFichier.add(menuImprimer);
		menuFichier.add(menuQuitter);

		myMenuBar.add(menuFichier);
		JMenu menuOptions = new JMenu("Options");


		myMenuBar.add(menuOptions);
		
        frame.add(panelPrincipal);
        frame.setVisible(true);
    }
}

//2)Le design pattern utilisé est le pattern Commande
//Roles:
//Command : Cette classe déclare une interface commune pour toutes les commandes qui doivent être exécutées. Elle peut avoir des méthodes pour exécuter la commande et pour annuler l'exécution de la commande.

//ConcreteCommand : Cette classe implémente l'interface de la classe Command et fournit une implémentation concrète pour chaque commande