package Tp1.Partie2EnSwing.ModelsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import Tp1.Partie2EnSwing.Models.Client;
import Tp1.Partie2EnSwing.Models.CommandeLot;


public class CommandeLotDAO {
	private Connection conn;

    public CommandeLotDAO(Connection conn) {
        this.conn = conn;
    }

    public void ajouterCommandeLotDAO(CommandeLot cmd) throws SQLException {
        String query = "INSERT INTO CommandeLot (idLotArt,idClient,qtLot) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, cmd.getLot().getIdLot());
            stmt.setInt(2, cmd.getClient().getIdClient());
            stmt.setInt(3, cmd.getQtLot());
            stmt.executeUpdate();
        }
    }

    public void modifierCommandeLotDAO(CommandeLot cmd) throws SQLException {
        String query = "UPDATE CommandeLot SET idLotArt=?, idClient=? qtLot=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
        	  stmt.setInt(1, cmd.getLot().getIdLot());
              stmt.setInt(2, cmd.getClient().getIdClient());
              stmt.setInt(3, cmd.getQtLot());
              stmt.setInt(4, cmd.getIdCmdLot());
              stmt.executeUpdate();
        }
    }

    public void supprimerCommandeLotDAO(int id) throws SQLException {
        String query = "DELETE FROM  CommandeLot WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

   

	public Client readCommandeLotDAO(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
