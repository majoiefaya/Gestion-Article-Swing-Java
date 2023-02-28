package Tp1.Partie2EnSwing.ModelsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Tp1.Partie2EnSwing.Models.Client;

public class ClientDAO {
	private Connection conn;

    public ClientDAO(Connection conn) {
        this.conn = conn;
    }

    public void ajouterClient(Client client) throws SQLException {
        String query = "INSERT INTO Client (nom,prenom) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, client.getNom());
            stmt.setString(2, client.getPrenom());
            stmt.executeUpdate();
        }
    }

    public void modifierClient(Client client) throws SQLException {
        String query = "UPDATE Client SET nom=?, prenom=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, client.getNom());
            stmt.setString(2, client.getPrenom());
            stmt.setInt(3, client.getIdClient());
            stmt.executeUpdate();
        }
    }

    public void supprimerClient(int id) throws SQLException {
        String query = "DELETE FROM Client WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public Client trouverClientParId(int id) throws SQLException {
        String query = "SELECT * FROM Client WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Client(rs.getInt("idClient"), rs.getString("nom"), rs.getString("prenom"));
                }
            }
        }
        return null;
    }

    public List<Client> trouverTousLesClients() throws SQLException {
        String query = "SELECT * FROM articles";
        List<Client> clients = new ArrayList<>();
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                clients.add(new Client(rs.getInt("idClient"), rs.getString("nom"), rs.getString("prenom")));
                
            	}	}
		return clients;
		
 }

	public Client readClient(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
