package Tp1.Partie2EnSwing.ModelsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Tp1.partie2EnCmd.Models.LotArticle;

public class LotArticleDAO {
	private Connection conn;

    public LotArticleDAO(Connection conn) {
        this.conn = conn;
    }

    public void ajouterLotArticle(LotArticle lotarticle) throws SQLException {
        String query = "INSERT INTO lotarticle (qtArticle,prixLot,pourcentage,reference,marque,libelleLot) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, lotarticle.getQtArticle());
            stmt.setFloat(2, lotarticle.getPrixLot());
            stmt.setDouble(3, lotarticle.getPourcentage());
            stmt.setString(4, lotarticle.getReference());
            stmt.setString(5, lotarticle.getMarque());
            stmt.setString(6, lotarticle.getLibelleLot());
            stmt.executeUpdate();
        }
    }

    public void modifierLotArticle(LotArticle lotarticle) throws SQLException {
        String query = "UPDATE lotarticle SET qtArticle=?, prixLot=?, pourcentage=?, reference=? ,marque=?,libelleLot=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
        	   stmt.setInt(1, lotarticle.getQtArticle());
               stmt.setFloat(2, lotarticle.getPrixLot());
               stmt.setDouble(3, lotarticle.getPourcentage());
               stmt.setString(4, lotarticle.getReference());
               stmt.setString(5, lotarticle.getMarque());
               stmt.setString(6, lotarticle.getLibelleLot());
               stmt.setInt(6, lotarticle.getIdLot());
            stmt.executeUpdate();
        }
    }

    public void supprimerLotArticle(int id) throws SQLException {
        String query = "DELETE FROM lotarticle WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public LotArticle trouverLotArticleParId(int id) throws SQLException {
        String query = "SELECT * FROM lotarticle WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new LotArticle(rs.getInt("idLot"), rs.getInt("qtArticle"),rs.getFloat("prixLot"),rs.getFloat("pourcentage"),rs.getString("reference"),rs.getString("marque"), rs.getString("libelleLot"));
                }
            }
        }
        return null;
    }

    public List<LotArticle> trouverTousLesLotArticles() throws SQLException {
        String query = "SELECT * FROM lotarticle";
        List<LotArticle> articles = new ArrayList<>();
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                articles.add(new LotArticle(rs.getInt("idLot"), rs.getInt("qtArticle"),rs.getFloat("prixLot"),rs.getFloat("pourcentage"),rs.getString("reference"),rs.getString("marque"), rs.getString("libelleLot")));
                
            	}	}
		return articles;
		
 }

	public LotArticle readLotArticle(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
