package Tp1.Partie2EnSwing.ModelsDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Tp1.Partie2EnSwing.Models.Article;

public class ArticleDAO {
    private Connection conn;

    public ArticleDAO(Connection conn) {
        this.conn = conn;
    }

    public void ajouterArticle(Article article) throws SQLException {
        String query = "INSERT INTO articles (nom, description, prix, quantite,reference,marque) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, article.getNom());
            stmt.setString(2, article.getDescription());
            stmt.setDouble(3, article.getPrix());
            stmt.setInt(4, article.getQuantite());
            stmt.setString(5, article.getReference());
            stmt.setString(6, article.getMarque());
            stmt.executeUpdate();
        }
    }

    public void modifierArticle(Article article) throws SQLException {
        String query = "UPDATE articles SET nom=?, description=?, prix=?, quantite=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, article.getNom());
            stmt.setString(2, article.getDescription());
            stmt.setDouble(3, article.getPrix());
            stmt.setInt(4, article.getQuantite());
            stmt.setInt(5, article.getId());
            stmt.executeUpdate();
        }
    }

    public void supprimerArticle(int id) throws SQLException {
        String query = "DELETE FROM articles WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public Article trouverArticleParId(int id) throws SQLException {
        String query = "SELECT * FROM articles WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Article(rs.getInt("id"), rs.getString("nom"), rs.getString("description"), rs.getDouble("prix"), rs.getInt("quantite"),rs.getString("reference"),rs.getString("marque"));
                }
            }
        }
        return null;
    }

    public List<Article> trouverTousLesArticles() throws SQLException {
        String query = "SELECT * FROM articles";
        List<Article> articles = new ArrayList<>();
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                articles.add(new Article(rs.getInt("id"), rs.getString("nom"), rs.getString("description"), rs.getDouble("prix"), rs.getInt("quantite"),rs.getString("reference"),rs.getString("marque")));
                
            	}	}
		return articles;
		
 }

	public Article readArticle(int id) {
		// TODO Auto-generated method stub
		return null;
	}}