package Tp1.Partie2EnSwing.ModelsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Tp1.Partie2EnSwing.Models.Article;
import Tp1.Partie2EnSwing.Models.Ramette;




public class RametteDAO {
    private Connection conn;

    public RametteDAO(Connection conn) {
        this.conn = conn;
    }

    public void ajouterArticle(Ramette article) throws SQLException {
        String query = "INSERT INTO articles (nom, description, prix, quantite,reference,marque,grammage) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, article.getNom());
            stmt.setString(2, article.getDescription());
            stmt.setDouble(3, article.getPrix());
            stmt.setInt(4, article.getQuantite());
            stmt.setString(5, article.getReference());
            stmt.setString(6, article.getMarque());
            stmt.setDouble(7, article.getGrammage());
            stmt.executeUpdate();
        }
    }

    public void modifierArticle(Ramette article) throws SQLException {
        String query = "UPDATE articles SET nom=?, description=?, prix=?, quantite=?,reference=?,marque=?, grammage=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, article.getNom());
            stmt.setString(2, article.getDescription());
            stmt.setDouble(3, article.getPrix());
            stmt.setInt(4, article.getQuantite());
            stmt.setString(5, article.getReference());
            stmt.setString(6, article.getMarque());
            stmt.setDouble(7, article.getGrammage());
            stmt.setInt(8, article.getId());
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

    public Ramette trouverArticleParId(int id) throws SQLException {
        String query = "SELECT * FROM articles WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return (Ramette) new Article(rs.getInt("id"), rs.getString("nom"), rs.getString("description"), rs.getDouble("prix"), rs.getInt("quantite"),rs.getString("reference"),rs.getString("marque"));
                }
            }
        }
        return null;
    }

    public List<Ramette> trouverTousLesArticles() throws SQLException {
        String query = "SELECT * FROM articles";
        List<Ramette> articles = new ArrayList<>();
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
            	 articles.add((Ramette) new Article(rs.getInt("id"), rs.getString("nom"), rs.getString("description"), rs.getDouble("prix"), rs.getInt("quantite"),rs.getString("reference"),rs.getString("marque")));
                 
            	}	}
		return articles;
		
 }

	public Ramette readArticle(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
