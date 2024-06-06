package dao.impl;

import dao.UtilisateurDAO;
import model.Utilisateur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurDAOImpl implements UtilisateurDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/gestassu";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String INSERT_UTILISATEUR_SQL = "INSERT INTO utilisateurs (username, password, role, numeroSecSoc) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_UTILISATEUR_SQL = "UPDATE utilisateurs SET username = ?, password = ?, role = ? WHERE id = ?";
    private static final String DELETE_UTILISATEUR_SQL = "DELETE FROM utilisateurs WHERE id = ?";
    private static final String SELECT_UTILISATEUR_BY_ID = "SELECT id, username, password, role, numeroSecSoc FROM utilisateurs WHERE id = ?";
    private static final String SELECT_ALL_UTILISATEURS = "SELECT * FROM utilisateurs";
    private static final String SELECT_UTILISATEUR_BY_USERNAME = "SELECT * FROM utilisateurs WHERE username = ?";
    private static final String SELECT_UTILISATEUR_BY_NUMERO_SECU_SOC = "SELECT * FROM utilisateurs WHERE numeroSecSoc = ?";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
        return connection;
    }

    @Override
    public void addUtilisateur(Utilisateur utilisateur) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_UTILISATEUR_SQL)) {
            preparedStatement.setString(1, utilisateur.getUsername());
            preparedStatement.setString(2, utilisateur.getPassword());
            preparedStatement.setString(3, utilisateur.getRole());
            preparedStatement.setString(4, utilisateur.getNumeroSecSoc());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error adding utilisateur", e);
        }
    }

    @Override
    public void updateUtilisateur(Utilisateur utilisateur) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_UTILISATEUR_SQL)) {
            preparedStatement.setString(1, utilisateur.getUsername());
            preparedStatement.setString(2, utilisateur.getPassword());
            preparedStatement.setString(3, utilisateur.getRole());
            preparedStatement.setInt(4, utilisateur.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating utilisateur", e);
        }
    }

    @Override
    public void deleteUtilisateur(int id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_UTILISATEUR_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting utilisateur", e);
        }
    }

    @Override
    public Utilisateur getUtilisateurById(int id) {
        Utilisateur utilisateur = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_UTILISATEUR_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                utilisateur = new Utilisateur(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("role"), rs.getString("numeroSecSoc"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error getting utilisateur by ID", e);
        }
        return utilisateur;
    }

    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_UTILISATEURS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Utilisateur utilisateur = new Utilisateur(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("role"), rs.getString("numeroSecSoc"));
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error getting all utilisateurs", e);
        }
        return utilisateurs;
    }

    @Override
    public Utilisateur getUtilisateurByUsername(String username) {
        Utilisateur utilisateur = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_UTILISATEUR_BY_USERNAME)) {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                utilisateur = new Utilisateur(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("role"), rs.getString("numeroSecSoc"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error getting utilisateur by username", e);
        }
        return utilisateur;
    }

    @Override
    public Utilisateur getUtilisateurByNumeroSecSoc(String numeroSecSoc) {
        Utilisateur utilisateur = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_UTILISATEUR_BY_NUMERO_SECU_SOC)) {
            preparedStatement.setString(1, numeroSecSoc);
            ResultSet rs = preparedStatement.executeQuery();
	            if (rs.next()) {
	                utilisateur = new Utilisateur(
	                        rs.getInt("id"),
	                        rs.getString("username"),
	                        rs.getString("password"),
	                        rs.getString("role"),
	                        rs.getString("numeroSecSoc")
	                );
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException("Error getting utilisateur by numeroSecSoc", e);
	        }
	        return utilisateur;
    }

	@Override
	public boolean isNumeroSecuExists(String numeroSecu) throws SQLException {
		 boolean exists = false;
	        String query = "SELECT COUNT(*) FROM utilisateurs WHERE numeroSecSoc  = ?";

	        try (Connection connection = getConnection();
	        		PreparedStatement statement = connection.prepareStatement(query)) {
	            statement.setString(1, numeroSecu);
	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                    int count = resultSet.getInt(1);
	                    exists = count > 0;
	                }
	            }
	        }

	        return exists;
	}

   
}
            
