package dao.impl;

import dao.DossierMedicalDAO;
import model.DossierMedical;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DossierMedicalDAOImpl implements DossierMedicalDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/gestassu";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String INSERT_DOSSIER_MEDICAL_SQL = "INSERT INTO DossierMedical (numeroSecu, GroupeSanguin, Allergies, AntecedentsMedicaux, ListeMedicamentsPrescrits) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_DOSSIER_MEDICAL_BY_ID_SQL = "SELECT * FROM DossierMedical WHERE ID = ?";
    private static final String SELECT_DOSSIER_MEDICAL_BY_NUMERO_SECU_SQL = "SELECT * FROM DossierMedical WHERE numeroSecu = ?";
    private static final String SELECT_ALL_DOSSIERS_MEDICAUX_SQL = "SELECT * FROM DossierMedical";
    private static final String DELETE_DOSSIER_MEDICAL_SQL = "DELETE FROM DossierMedical WHERE ID = ?";
    private static final String UPDATE_DOSSIER_MEDICAL_SQL = "UPDATE DossierMedical SET GroupeSanguin = ?, Allergies = ?, AntecedentsMedicaux = ?, ListeMedicamentsPrescrits = ? WHERE ID = ?";

    protected Connection getConnection() {
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
    public DossierMedical getById(int id) {
        DossierMedical dossierMedical = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DOSSIER_MEDICAL_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    dossierMedical = new DossierMedical(
                        resultSet.getInt("ID"),
                        resultSet.getString("numeroSecu"),
                        resultSet.getString("GroupeSanguin"),
                        resultSet.getString("Allergies"),
                        resultSet.getString("AntecedentsMedicaux"),
                        resultSet.getString("ListeMedicamentsPrescrits")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while fetching dossier by ID: " + e.getMessage());
        }
        return dossierMedical;
    }

    @Override
    public List<DossierMedical> getByNumeroSecu(String numeroSecu) {
        List<DossierMedical> dossierMedicalList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DOSSIER_MEDICAL_BY_NUMERO_SECU_SQL)) {
            preparedStatement.setString(1, numeroSecu);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    DossierMedical dossierMedical = new DossierMedical(
                        resultSet.getInt("ID"),
                        resultSet.getString("numeroSecu"),
                        resultSet.getString("GroupeSanguin"),
                        resultSet.getString("Allergies"),
                        resultSet.getString("AntecedentsMedicaux"),
                        resultSet.getString("ListeMedicamentsPrescrits")
                    );
                    dossierMedicalList.add(dossierMedical);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while fetching dossier by numeroSecu: " + e.getMessage());
        }
        return dossierMedicalList;
    }

    @Override
    public List<DossierMedical> getAllDossiersMedicaux() {
        List<DossierMedical> dossierMedicalList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DOSSIERS_MEDICAUX_SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                DossierMedical dossierMedical = new DossierMedical(
                    resultSet.getInt("ID"),
                    resultSet.getString("numeroSecu"),
                    resultSet.getString("GroupeSanguin"),
                    resultSet.getString("Allergies"),
                    resultSet.getString("AntecedentsMedicaux"),
                    resultSet.getString("ListeMedicamentsPrescrits")
                );
                dossierMedicalList.add(dossierMedical);
            }
        } catch (SQLException e) {
            System.out.println("Error while fetching all dossiers: " + e.getMessage());
        }
        return dossierMedicalList;
    }

    @Override
    public void insertDossierMedical(DossierMedical dossierMedical) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DOSSIER_MEDICAL_SQL)) {
            preparedStatement.setString(1, dossierMedical.getNumeroSecu());
            preparedStatement.setString(2, dossierMedical.getGroupeSanguin());
            preparedStatement.setString(3, dossierMedical.getAllergies());
            preparedStatement.setString(4, dossierMedical.getAntecedentsMedicaux());
            preparedStatement.setString(5, dossierMedical.getListeMedicamentsPrescrits());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error while inserting dossier: " + e.getMessage());
        }
    }

    @Override
    public void updateDossierMedical(DossierMedical dossierMedical) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DOSSIER_MEDICAL_SQL)) {
            preparedStatement.setString(1, dossierMedical.getGroupeSanguin());
            preparedStatement.setString(2, dossierMedical.getAllergies());
            preparedStatement.setString(3, dossierMedical.getAntecedentsMedicaux());
            preparedStatement.setString(4, dossierMedical.getListeMedicamentsPrescrits());
            preparedStatement.setInt(5, dossierMedical.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error while updating dossier: " + e.getMessage());
        }
    }

    @Override
    public void deleteDossierMedical(int id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DOSSIER_MEDICAL_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error while deleting dossier: " + e.getMessage());
        }
    }

}
