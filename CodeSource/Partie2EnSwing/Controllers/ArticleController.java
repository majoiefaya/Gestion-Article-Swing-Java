package Tp1.Partie2EnSwing.Controllers;

import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import Tp1.Partie2EnSwing.Models.Article;
import Tp1.Partie2EnSwing.ModelsDAO.ArticleDAO;

public class ArticleController {
    private ArticleDAO articleDAO;
    private DefaultTableModel tableModel;
    
    public ArticleController(ArticleDAO articleDAO, DefaultTableModel tableModel) {
        this.articleDAO = articleDAO;
        this.tableModel = tableModel;
    }
    
    public void createArticle(String nom, String description, double prix, int quantite,String reference,String marque) {
        Article article = new Article(nom,description,prix,quantite, reference,marque);
        try {
			articleDAO.ajouterArticle(article);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        tableModel.addRow(new Object[]{article.getId(), article.getNom(), article.getDescription(), article.getPrix(), article.getQuantite(),article.getReference(),article.getMarque()});
    }
    
    public void readArticle(int id) {
        Article article = articleDAO.readArticle(id);
        // Afficher les propriétés de l'article dans la vue
    }
    
    public void updateArticle(int id, String nom, String description, double prix, int quantite,String reference,String marque) {
        Article article = new Article(id, nom, description, prix, quantite,reference,marque);
        try {
			articleDAO.modifierArticle(article);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        int rowIndex = tableModel.findColumn("id");
        tableModel.setValueAt(nom, rowIndex, 1);
        tableModel.setValueAt(description, rowIndex, 2);
        tableModel.setValueAt(prix, rowIndex, 3);
        tableModel.setValueAt(quantite, rowIndex, 4);
        tableModel.setValueAt(reference, rowIndex, 5);
        tableModel.setValueAt(marque, rowIndex, 6);
    }
    
    public void deleteArticle(int id) {
        try {
			articleDAO.supprimerArticle(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        int rowIndex = tableModel.findColumn("id");
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if ((int)tableModel.getValueAt(i, rowIndex) == id) {
                tableModel.removeRow(i);
         
            }
       }
    }
 }
