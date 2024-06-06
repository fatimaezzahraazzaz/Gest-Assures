package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.CotisationDAO;
import model.Cotisation;

public class CotisationDAOImpl implements CotisationDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/gestassu";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String INSERT_COTISATION = "INSERT INTO cotisations (numeroSecSoc, montant, datePaiement, typeCotisation) VALUES (?, ?, ?, ?)";
    private static final String DELETE_COTISATION = "DELETE FROM cotisations WHERE id = ?";
    private static final String UPDATE_COTISATION = "UPDATE cotisations SET numeroSecSoc = ?, montant = ?, datePaiement = ?, typeCotisation = ? WHERE id = ?";
    private static final String SELECT_ALL_COTISATIONS = "SELECT id, numeroSecSoc, montant, datePaiement, typeCotisation FROM cotisations";
    private static final String SELECT_COTISATION_BY_ID = "SELECT id, numeroSecSoc, montant, datePaiement, typeCotisation FROM cotisations WHERE id = ?";


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
    public void addCotisation(Cotisation cotisation) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COTISATION)) {
            preparedStatement.setString(1, cotisation.getNumeroSecSoc());
            preparedStatement.setDouble(2, cotisation.getMontant());
            preparedStatement.setDate(3, new java.sql.Date(cotisation.getDatePaiement().getTime()));
            preparedStatement.setString(4, cotisation.getTypeCotisation());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error adding cotisation", e);
        }
    }

    @Override
    public void deleteCotisation(int cotisationId) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_COTISATION)) {
            preparedStatement.setInt(1, cotisationId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting cotisation", e);
        }
    }

    @Override
    public void updateCotisation(Cotisation cotisation) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COTISATION)) {
            preparedStatement.setString(1, cotisation.getNumeroSecSoc());
            preparedStatement.setDouble(2, cotisation.getMontant());
            preparedStatement.setDate(3, new java.sql.Date(cotisation.getDatePaiement().getTime()));
            preparedStatement.setString(4, cotisation.getTypeCotisation()); // Ajout du type de cotisation
            preparedStatement.setInt(5, cotisation.getId());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating cotisation", e);
        }
    }

    @Override
    public List<Cotisation> getAllCotisations() {
        List<Cotisation> cotisations = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COTISATIONS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Cotisation cotisation = new Cotisation();
                cotisation.setId(rs.getInt("id"));
                cotisation.setNumeroSecSoc(rs.getString("numeroSecSoc"));
                cotisation.setMontant(rs.getDouble("montant"));
                cotisation.setDatePaiement(rs.getDate("datePaiement"));
                cotisation.setTypeCotisation(rs.getString("typeCotisation"));
                cotisations.add(cotisation);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error getting all cotisations", e);
        }
        return cotisations;
    }
    public boolean numeroSecSocExists(String numeroSecSoc) {
        boolean exists = false;
        String sql = "SELECT 1 FROM assure WHERE numeroSecSoc = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, numeroSecSoc);
            try (ResultSet resultSet = statement.executeQuery()) {
                exists = resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }

    

    @Override
    public Cotisation getCotisationById(int cotisationId) {
        Cotisation cotisation = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COTISATION_BY_ID)) {
            preparedStatement.setInt(1, cotisationId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                cotisation = new Cotisation();
                cotisation.setId(rs.getInt("id"));
                cotisation.setNumeroSecSoc(rs.getString("numeroSecSoc"));
                cotisation.setMontant(rs.getDouble("montant"));
                cotisation.setDatePaiement(rs.getDate("datePaiement"));
                cotisation.setTypeCotisation(rs.getString("typeCotisation"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error getting cotisation by ID", e);
        }
        return cotisation;
    }
    @Override
    public List<Cotisation> getCotisationsByNumeroSecSoc(String numeroSecSoc) {
        List<Cotisation> cotisations = new ArrayList<>();
        String query = "SELECT * FROM Cotisations WHERE numeroSecSoc = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, numeroSecSoc);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    double montant = resultSet.getDouble("montant");
                    Date datePaiement = resultSet.getDate("datePaiement");
                    String typeCotisation = resultSet.getString("typeCotisation");
                    Cotisation cotisation = new Cotisation(id, numeroSecSoc, montant, datePaiement, typeCotisation);
                    cotisations.add(cotisation);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cotisations;
    }
    @Override
    public double getTotalCotisation() {
        String sql = "SELECT SUM(montant) AS total FROM cotisations";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getDouble("total");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors du calcul du total des cotisations", e);
        }
        return 0.0; // Retourne 0.0 si aucune cotisation trouvée
    }

    

}
