package dao.impl;

import dao.AssureDAO;
import model.Assure;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AssureDAOImpl implements AssureDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/gestassu";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";


    private static final String INSERT_ASSURE_SQL = "INSERT INTO Assure (nom, prenom, numeroSecSoc, adresse, dateNaissance) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ASSURE_BY_ID = "SELECT id, nom, prenom, numeroSecSoc, adresse, dateNaissance FROM Assure WHERE id = ?";
    private static final String SELECT_ALL_ASSURES = "SELECT * FROM Assure";
    private static final String DELETE_ASSURE_SQL = "DELETE FROM Assure WHERE id = ?";
    private static final String UPDATE_ASSURE_SQL = "UPDATE assure SET nom = ?, prenom = ?, numeroSecSoc = ?, adresse = ?, dateNaissance = ? WHERE id = ?";
    private static final String SELECT_COUNT_ASSURE_BY_NUMERO_SECSOC_SQL = "SELECT COUNT(*) FROM assure WHERE numeroSecSoc = ?";
    private static final String SELECT_COUNT_ASSURE_BY_NUMERO_SECSOC_AND_ID_SQL = "SELECT COUNT(*) FROM Assure WHERE numeroSecSoc = ? AND id != ?";
	private static final String SELECT_ASSURE_BY_NUMERO_SECSOC = "SELECT * FROM Assure WHERE numeroSecSoc = ?";


    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void ajouterAssure(Assure assure) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ASSURE_SQL)) {
            preparedStatement.setString(1, assure.getNom());
            preparedStatement.setString(2, assure.getPrenom());
            preparedStatement.setString(3, assure.getNumeroSecSoc());
            preparedStatement.setString(4, assure.getAdresse());
            preparedStatement.setDate(5, new java.sql.Date(assure.getDateNaissance().getTime()));
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);  // Log the number of rows affected
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void modifierAssure(Assure assure) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ASSURE_SQL)) {
            preparedStatement.setString(1, assure.getNom());
            preparedStatement.setString(2, assure.getPrenom());
            preparedStatement.setString(3, assure.getNumeroSecSoc());
            preparedStatement.setString(4, assure.getAdresse());
            preparedStatement.setDate(5, assure.getDateNaissance());
            preparedStatement.setInt(6, assure.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void supprimerAssure(int id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ASSURE_SQL)) {
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected (delete): " + rowsAffected);  // Log the number of rows affected
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean isNumeroSecuriteSocialeUnique(String numeroSecuriteSociale) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COUNT_ASSURE_BY_NUMERO_SECSOC_SQL)) {
            preparedStatement.setString(1, numeroSecuriteSociale);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) == 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isNumeroSecSocUniqueForUpdate(int id, String numeroSecSoc) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COUNT_ASSURE_BY_NUMERO_SECSOC_AND_ID_SQL)) {
            preparedStatement.setString(1, numeroSecSoc);
            preparedStatement.setInt(2, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) == 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean isNumeroSecuriteSocialeExiste(String numeroSecuriteSociale) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COUNT_ASSURE_BY_NUMERO_SECSOC_SQL)) {
            preparedStatement.setString(1, numeroSecuriteSociale);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    @Override
    public Assure getAssureById(int id) {
        Assure assure = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ASSURE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String numeroSecSoc = rs.getString("numeroSecSoc");
                String adresse = rs.getString("adresse");
                Date dateNaissance = rs.getDate("dateNaissance"); // Récupérer la date de naissance depuis la base de données
                assure = new Assure();
                assure.setId(id);
                assure.setNom(nom);
                assure.setPrenom(prenom);
                assure.setNumeroSecSoc(numeroSecSoc);
                assure.setAdresse(adresse);
                assure.setDateNaissance(dateNaissance); // Définir la date de naissance dans l'objet Assure
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assure;
    }
    @Override
    public Assure getByNumeroSecSoc(String numeroSecSoc) {
        Assure assure = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ASSURE_BY_NUMERO_SECSOC)) {
            preparedStatement.setString(1, numeroSecSoc);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    assure = extractAssureFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assure;
    }


    // Méthode utilitaire pour extraire un objet Assure à partir d'un ResultSet
    private Assure extractAssureFromResultSet(ResultSet rs) throws SQLException {
        Assure assure = new Assure();
        assure.setId(rs.getInt("id"));
        assure.setNom(rs.getString("nom"));
        assure.setPrenom(rs.getString("prenom"));
        assure.setNumeroSecSoc(rs.getString("numeroSecSoc"));
        assure.setAdresse(rs.getString("adresse"));
        assure.setDateNaissance(rs.getDate("dateNaissance"));
        return assure;
    }

    @Override
    public List<Assure> getAllAssures() {
        List<Assure> assures = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ASSURES)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String numeroSecSoc = rs.getString("numeroSecSoc");
                String adresse = rs.getString("adresse");
                Date dateNaissance = rs.getDate("dateNaissance");
                Assure assure = new Assure();
                assure.setId(id);
                assure.setNom(nom);
                assure.setPrenom(prenom);
                assure.setNumeroSecSoc(numeroSecSoc);
                assure.setAdresse(adresse);
                assure.setDateNaissance(dateNaissance);
                assures.add(assure);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assures;
    }

		 @Override
	    public int getTotalAssures() {
	        String sql = "SELECT COUNT(*) AS total FROM assure";
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
		 public Assure getAssureDetails(String numeroSecSoc) {
			    Assure assure = null;
			    String query = "SELECT * FROM assure WHERE numeroSecSoc = ?";
			    try (Connection connection = getConnection();
			         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			        preparedStatement.setString(1, numeroSecSoc);
			        try (ResultSet resultSet = preparedStatement.executeQuery()) {
			            if (resultSet.next()) {
			                assure = new Assure();
			                assure.setNumeroSecSoc(resultSet.getString("numeroSecSoc"));
			                assure.setNom(resultSet.getString("nom"));
			                assure.setPrenom(resultSet.getString("prenom"));
			                assure.setAdresse(resultSet.getString("adresse"));
			                assure.setDateNaissance(resultSet.getDate("dateNaissance"));
			                // Ajoutez d'autres propriétés de l'assuré en fonction de votre modèle de données
			            }
			        }
			    } catch (SQLException e) {
			        e.printStackTrace();
			        // Gérer les exceptions SQL ici
			    }
			    return assure;
			}



}
