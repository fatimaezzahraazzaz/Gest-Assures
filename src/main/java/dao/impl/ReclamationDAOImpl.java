package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ReclamationDAO;
import model.Reclamation;

public class ReclamationDAOImpl implements ReclamationDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/gestassu";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    // Méthode pour obtenir une connexion à la base de données
    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error while establishing connection: " + e.getMessage());
        }
        return connection;
    }

    @Override
    public void ajouterReclamation(Reclamation reclamation) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO Reclamation(numeroSecSoc, nom, prenom, description, dateReclamation) VALUES (?, ?, ?, ?, ?)")) {
            // Set values for parameters
            preparedStatement.setString(1, reclamation.getNumeroSecSoc());
            preparedStatement.setString(2, reclamation.getNom());
            preparedStatement.setString(3, reclamation.getPrenom());
            preparedStatement.setString(4, reclamation.getDescription());
            preparedStatement.setDate(5, reclamation.getDateReclamation());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        @Override
        public void modifierReclamation(Reclamation reclamation) {
            try {Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Reclamation SET numeroSecSoc=?, nom=?, prenom=?, description=?, dateReclamation=? WHERE id=?");
                // Set values for parameters
                preparedStatement.setString(1, reclamation.getNumeroSecSoc());
                preparedStatement.setString(2, reclamation.getNom());
                preparedStatement.setString(3, reclamation.getPrenom());
                preparedStatement.setString(4, reclamation.getDescription());
                preparedStatement.setDate(5, reclamation.getDateReclamation());
                preparedStatement.setInt(6, reclamation.getId());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void supprimerReclamation(int id) {
            try {Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Reclamation WHERE id=?");
                // Set value for parameter
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public List<Reclamation> getReclamationsParNumeroSecSoc(String numeroSecSoc) {
            List<Reclamation> reclamations = new ArrayList<>();
            try {Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Reclamation WHERE numeroSecSoc=?");
                // Set value for parameter
                preparedStatement.setString(1, numeroSecSoc);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    Reclamation reclamation = new Reclamation();
                    reclamation.setId(rs.getInt("id"));
                    reclamation.setNumeroSecSoc(rs.getString("numeroSecSoc"));
                    reclamation.setNom(rs.getString("nom"));
                    reclamation.setPrenom(rs.getString("prenom"));
                    reclamation.setDescription(rs.getString("description"));
                    reclamation.setDateReclamation(rs.getDate("dateReclamation"));
                    reclamations.add(reclamation);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return reclamations;
        }

        @Override
        public List<Reclamation> getAllReclamations() {
            List<Reclamation> reclamations = new ArrayList<>();
            try {Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Reclamation");
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    Reclamation reclamation = new Reclamation();
                    reclamation.setId(rs.getInt("id"));
                    reclamation.setNumeroSecSoc(rs.getString("numeroSecSoc"));
                    reclamation.setNom(rs.getString("nom"));
                    reclamation.setPrenom(rs.getString("prenom"));
                    reclamation.setDescription(rs.getString("description"));
                    reclamation.setDateReclamation(rs.getDate("dateReclamation"));
                    reclamations.add(reclamation);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return reclamations;
        }
        @Override
        public Reclamation getReclamationById(int id) {
            Reclamation reclamation = null;
            try {Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Reclamation WHERE id=?");
                // Set value for parameter
                preparedStatement.setInt(1, id);
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    reclamation = new Reclamation();
                    reclamation.setId(rs.getInt("id"));
                    reclamation.setNumeroSecSoc(rs.getString("numeroSecSoc"));
                    reclamation.setNom(rs.getString("nom"));
                    reclamation.setPrenom(rs.getString("prenom"));
                    reclamation.setDescription(rs.getString("description"));
                    reclamation.setDateReclamation(rs.getDate("dateReclamation"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return reclamation;
        }
        @Override
	    public int getTotalReclamation() {
	        String sql = "SELECT COUNT(*) AS total FROM reclamation";
	        try (Connection connection = getConnection();
	             PreparedStatement statement = connection.prepareStatement(sql)) {
	            ResultSet resultSet = statement.executeQuery();
	            if (resultSet.next()) {
	                return resultSet.getInt("total");
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException("Erreur lors de la récupération du nombre total d'assurés", e);
	        }
	        return 0;
	    }

    }
