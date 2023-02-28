package Tp1.Partie2EnSwing.Controllers;

import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import Tp1.Partie2EnSwing.Models.Client;
import Tp1.Partie2EnSwing.ModelsDAO.ClientDAO;

public class ClientController {
	 private ClientDAO clientDAO;
	    private DefaultTableModel clientTable;
	    
	    public ClientController(ClientDAO clientDAO, DefaultTableModel tableModel) {
	        this.clientDAO = clientDAO;
	        this.clientTable = tableModel;
	    }
	    
	    public void createClient(String nom, String prenom) {
	        Client client = new Client(nom,prenom);
	        try {
				clientDAO.ajouterClient(client);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        clientTable.addRow(new Object[]{client.getIdClient(), client.getNom(), client.getPrenom()});
	    }
	    
	    public void readClient(int id) {
	        Client client = clientDAO.readClient(id);
	        // Afficher les propriétés de l'article dans la vue
	    }
	    
	    public void updateClient(int id, String nom, String prenom) {
	        Client client = new Client(id, nom,prenom);
	        try {
				clientDAO.modifierClient(client);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        int rowIndex = clientTable.findColumn("id");
	        clientTable.setValueAt(nom, rowIndex, 1);
	        clientTable.setValueAt(prenom, rowIndex, 2);

	    }
	    
	    public void deleteClient(int id) {
	        try {
				clientDAO.supprimerClient(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        int rowIndex = clientTable.findColumn("id");
	        for (int i = 0; i < clientTable.getRowCount(); i++) {
	            if ((int)clientTable.getValueAt(i, rowIndex) == id) {
	            	clientTable.removeRow(i);
	         
	            }
	       }
	    }
}
