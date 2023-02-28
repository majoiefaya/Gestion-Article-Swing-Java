package Tp1.Partie2EnSwing;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Tp1.Partie2EnSwing.Controllers.ArticleController;
import Tp1.Partie2EnSwing.Models.Article;
import Tp1.Partie2EnSwing.ModelsDAO.ArticleDAO;

import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JButton addButton, updateButton, deleteButton;
    private JTextField nomField, descriptionField, prixField, quantiteField, idField,referenceField,marqueField;
    private JTable table;
    private DefaultTableModel tableModel;
    private ArticleController articleController;
    private Connection conn;

    public static void main(String[] args) {
        Main frame = new Main();
        frame.setVisible(true);
    }
    
    public Main() {
        setTitle("Gestion d'articles");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null);
        
        // Connexion à la base de données MySQL
        String url = "jdbc:mysql://localhost:3306/GestionDAOArticle";
        String user = "root";
        String password = "";
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
        
        // Créer les composants de la vue
        addButton = new JButton("Ajouter");
        updateButton = new JButton("Modifier");
        deleteButton = new JButton("Supprimer");
        nomField = new JTextField(20);
        descriptionField = new JTextField(20);
        prixField = new JTextField(10);
        quantiteField = new JTextField(10);
        idField = new JTextField(10);
        referenceField = new JTextField(10);
		marqueField = new JTextField(10);
        tableModel = new DefaultTableModel(new Object[]{"id", "Nom", "Description", "Prix", "Quantité","reference","marque"}, 0);
        table = new JTable(tableModel);
        
        // Ajouter les composants à la vue
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        inputPanel.add(new JLabel("Nom : "));
        inputPanel.add(nomField);
        inputPanel.add(new JLabel("Description : "));
        inputPanel.add(descriptionField);
        inputPanel.add(new JLabel("Prix : "));
        inputPanel.add(prixField);
        inputPanel.add(new JLabel("Quantité : "));
        inputPanel.add(quantiteField);
        inputPanel.add(new JLabel("ID : "));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Reference : "));
        inputPanel.add(referenceField);
        inputPanel.add(new JLabel("Marque : "));
        inputPanel.add(marqueField);
        inputPanel.add(addButton);
        inputPanel.add(updateButton);
        inputPanel.add(deleteButton);
        
        JScrollPane scrollPane = new JScrollPane(table);
        
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(inputPanel, BorderLayout.NORTH);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        // Créer le contrôleur et ajouter les écouteurs d'événements
        ArticleDAO articleDAO = new ArticleDAO(conn);
        articleController = new ArticleController(articleDAO, tableModel);
        addButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int rowIndex = table.getSelectedRow();
                idField.setText(tableModel.getValueAt(rowIndex, 0).toString());
                nomField.setText(tableModel.getValueAt(rowIndex, 1).toString());
                descriptionField.setText(tableModel.getValueAt(rowIndex, 2).toString());
                referenceField.setText(tableModel.getValueAt(rowIndex,3).toString());
                marqueField.setText(tableModel.getValueAt(rowIndex, 4).toString());
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == addButton) {
        	String nom = nomField.getText();
            String description = descriptionField.getText();
            double prix = Double.parseDouble(prixField.getText());
            int quantite = Integer.parseInt(quantiteField.getText());
            String reference=referenceField.getText();
            String marque=marqueField.getText();
            articleController.createArticle(nom,description,prix,quantite, reference,marque);
        } else if (source == updateButton) {
            int id = Integer.parseInt(idField.getText());
            String nom = nomField.getText();
            String description = descriptionField.getText();
            double prix = Double.parseDouble(prixField.getText());
            int quantite = Integer.parseInt(quantiteField.getText());
            String reference=referenceField.getText();
            String marque=marqueField.getText();
            Article article = new Article(id,nom,description,prix,quantite, reference,marque);
            articleController.updateArticle(id,nom,description,prix,quantite, reference,marque);
        } else if (source == deleteButton) {
            int id = Integer.parseInt(idField.getText());
            articleController.deleteArticle(id);
        }
        clearFields();
    }

    private void clearFields() {
        idField.setText("");
        nomField.setText("");
        descriptionField.setText("");
        prixField.setText("");
        quantiteField.setText("");
        referenceField.setText("");
        marqueField.setText("");
        
    }
}
