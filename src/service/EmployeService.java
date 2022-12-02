package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Models.Employe;
import mysql.DatabaseConnexion;
import mysql.Requete;

public class EmployeService {

	DatabaseConnexion connection = new DatabaseConnexion();

	public void ajouterEmploye(Employe employe) throws SQLException {

		try (Connection con = (Connection) connection.getConnection();
				PreparedStatement preparedStatement = con.prepareStatement(Requete.ajouterEmployeRequete())) {

			preparedStatement.setString(1, employe.getNom());
			preparedStatement.setString(2, employe.getEmail());
			preparedStatement.setDouble(3, employe.getSalaire());

			int rows = preparedStatement.executeUpdate();

			if (rows > 0) {

				System.out.println("enregistrement éffectué avec succes !!");

			} else {
				System.out.println("echec de sauvegarde ..");
			}

		}

	}

	public void getAllEmploye() throws SQLException {

		try (Connection con = connection.getConnection();
				Statement statement = con.createStatement();
				ResultSet resultSet = statement.executeQuery(Requete.ListeAllEmployeRequete())) {

			while (resultSet.next()) {

				afficherEmploye(new Employe(resultSet.getInt("id"), resultSet.getString("nom"),
						resultSet.getString("email"), resultSet.getDouble("salaire")));

			}

		}

	}

	private void afficherEmploye(Employe employe) {

		System.out.println("id de l'employe " + employe.getId());
		System.out.println("nom de l'employe " + employe.getNom());
		System.out.println("email de l'employe " + employe.getEmail());
		System.out.println("salaire de l'employe " + employe.getSalaire());
	}

	public boolean getEmployeById(int id) throws SQLException {

		boolean isFound = false;

		try (Connection con = connection.getConnection();
				Statement statement = con.createStatement();
				ResultSet resultSet = statement.executeQuery(Requete.getEmployeByIdRequete(id))) {

			if (resultSet.next()) {
				isFound = true;
				afficherEmploye(new Employe(resultSet.getInt("id"), resultSet.getString("nom"),
						resultSet.getString("email"), resultSet.getDouble("salaire")));

			} else {
				System.out.println("aucun enployé retouvé avec l'id " + id);
			}
		}

		return isFound;

	}

	public void deleteEmploye(int id) throws SQLException {

		try (Connection con = connection.getConnection(); Statement statement = con.createStatement();) {

			int rows = statement.executeUpdate(Requete.deleteEmployeByIdRequete(id));

			if (rows > 0) {

				System.out.println("employé supprimé avec succées !!");
			} else {
				System.out.println("aucun employé retrouvé avec l'id " + id);
			}

		}

	}

	public void updateEmploye(Employe employe) throws SQLException {

		try (Connection con = (Connection) connection.getConnection();
				PreparedStatement preparedStatement = con
						.prepareStatement(Requete.updateEmployeByIdRequete(employe.getId()))) {

			preparedStatement.setString(1, employe.getNom());
			preparedStatement.setString(2, employe.getEmail());
			preparedStatement.setDouble(3, employe.getSalaire());

			int rows = preparedStatement.executeUpdate();

			if (rows > 0) {

				System.out.println("modification éffectuée avec succes !!");

			} else {
				System.out.println("echec de modification ..");
			}

		}

	}

}
