package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.DemandeRemboursementDAO;
import model.DemandeRemboursement;
import model.Statut;

public class DemandeRemboursementDAOImpl implements DemandeRemboursementDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/gestassu";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String INSERT_DEMANDE_REMBOURSEMENT_SQL = "INSERT INTO demanderemboursement(nss, montant, motif, statut, date_demande) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_DEMANDE_REMBOURSEMENT_BY_ID = "SELECT id, nss, montant, motif, statut, date_demande FROM demandeRemboursement WHERE id = ?";
    private static final String SELECT_ALL_DEMANDES_REMBOURSEMENT = "SELECT id, nss, montant, motif, statut, date_demande FROM demanderemboursement";
    private static final String DELETE_DEMANDE_REMBOURSEMENT_SQL = "DELETE FROM demanderemboursement WHERE id = ?";
    private static final String UPDATE_DEMANDE_REMBOURSEMENT_SQL = "UPDATE demanderemboursement SET nss = ?, montant = ?, motif = ?, statut = ?, date_demande = ? WHERE id = ?";
    private static final String SELECT_DEMANDES_REMBOURSEMENT_BY_NSS = "SELECT * FROM demanderemboursement WHERE nss =?";


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
    public void addDemandeRemboursement(DemandeRemboursement demandeRemboursement) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_DEMANDE_REMBOURSEMENT_SQL)) {
            statement.setString(1, demandeRemboursement.getNss());
            statement.setDouble(2, demandeRemboursement.getMontant());
            statement.setString(3, demandeRemboursement.getMotif());
            statement.setString(4, demandeRemboursement.getStatut().toString());
            statement.setDate(5, demandeRemboursement.getDateDemande());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<DemandeRemboursement> getAllDemandeRemboursement() {
        List<DemandeRemboursement> demandesRemboursement = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_DEMANDES_REMBOURSEMENT);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                DemandeRemboursement demandeRemboursement = extractDemandeRemboursementFromResultSet(resultSet);
                demandesRemboursement.add(demandeRemboursement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return demandesRemboursement;
    }
    @Override
    public List<DemandeRemboursement> getDemandesRemboursementByNSS(String nss) {
        List<DemandeRemboursement> result = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_DEMANDES_REMBOURSEMENT_BY_NSS)) {
            statement.setString(1, nss);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    DemandeRemboursement demandeRemboursement = extractDemandeRemboursementFromResultSet(resultSet);
                    result.add(demandeRemboursement);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public DemandeRemboursement getDemandeRemboursementById(int id) {
        DemandeRemboursement demandeRemboursement = null;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_DEMANDE_REMBOURSEMENT_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    demandeRemboursement = extractDemandeRemboursementFromResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return demandeRemboursement;
    }

    @Override
    public void updateDemandeRemboursement(DemandeRemboursement demandeRemboursement) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_DEMANDE_REMBOURSEMENT_SQL)) {
            statement.setString(1, demandeRemboursement.getNss());
            statement.setDouble(2, demandeRemboursement.getMontant());
            statement.setString(3, demandeRemboursement.getMotif());
            statement.setString(4, demandeRemboursement.getStatut().name());
            statement.setDate(5, demandeRemboursement.getDateDemande());
            statement.setInt(6, demandeRemboursement.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDemandeRemboursement(int id) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_DEMANDE_REMBOURSEMENT_SQL)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private DemandeRemboursement extractDemandeRemboursementFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String nss = resultSet.getString("nss");
        double montant = resultSet.getDouble("montant");
        String motif = resultSet.getString("motif");
        String statutStr = resultSet.getString("statut");
        Statut statut = Statut.valueOf(statutStr);
        java.sql.Date dateDemande = resultSet.getDate("date_demande");
        return new DemandeRemboursement(id, nss, montant, motif, statut, dateDemande);
    }

    public boolean isNssExists(String nss) {
        boolean exists = false;
        String sql = "SELECT 1 FROM assure WHERE numeroSecSoc = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nss);
            try (ResultSet resultSet = statement.executeQuery()) {
                exists = resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }

	@Override
	public int getTotalDemande() {
		String sql = "SELECT COUNT(*) AS total FROM demanderemboursement";
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

   
