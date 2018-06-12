package bibliothequeAJS.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Transfert {
	private Connection connection = null;
	private final static String URL = "jdbc:mysql://192.168.1.28/bibliotheque";
	private final static String login = "user";
	private final static String password = "user";

	private final static String GetLivresRequest = "SELECT * " + "FROM livre";
	private final static String DeleteLivreRequest = "DELETE FROM livre WHERE id =? ";
	private final static String ExisteLivreRequest = "SELECT COUNT(id) FROM livre WHERE id=?";
	private final static String AddLivreRequest = "INSERT INTO livre (titre, annee, auteur, editeur)"
			+ "VALUES (?,?,?,?)";
	public final static int LIVRE_ABSENT = 1;
	public final static int LIVRE_EFFACE = 2;
	public final static int ERREUR_SQL = 3;

	public int deleteLivre(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection(URL, login, password);
			System.out.println("connexion à la base réussie");
			PreparedStatement stmtExiste = connection.prepareStatement(ExisteLivreRequest);
			stmtExiste.setInt(1, id);
			ResultSet resultSet = stmtExiste.executeQuery();

			if (resultSet.next() && resultSet.getInt(1) == 0) {
				connection.close();
				return LIVRE_ABSENT;

			} else {

				PreparedStatement stmtDelete = connection.prepareStatement(DeleteLivreRequest);
				stmtDelete.setInt(1, id);
				stmtDelete.executeUpdate();
				stmtDelete.close();
				connection.close();
				return LIVRE_EFFACE;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return ERREUR_SQL;
		}

	}

	public ArrayList<Livre> getLivres() {
		ArrayList<Livre> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection(URL, login, password);
			System.out.println("connexion à la base réussie");
			Statement stmtEmprunts = connection.createStatement();

			ResultSet rs = stmtEmprunts.executeQuery(GetLivresRequest);
			while (rs.next()) {
				Livre livre = new Livre(rs.getInt("id"), rs.getString("titre"), rs.getInt("annee"),
						rs.getString("auteur"), rs.getString("editeur"));
				list.add(livre);
				System.out.println();
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} finally {

			if (connection != null) {
				try {
					connection.close();
				} catch (final SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return list;

	}

	public void addLivre(Livre livre) {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection(URL, login, password);
			System.out.println("connection à la base réussie");

			PreparedStatement stmtLivre = connection.prepareStatement(AddLivreRequest);

			stmtLivre.setString(1, livre.getTitre());
			stmtLivre.setInt(2, livre.getAnnee());
			stmtLivre.setString(3, livre.getAuteur());
			stmtLivre.setString(4, livre.getEditeur());
			stmtLivre.executeUpdate();
			stmtLivre.close();

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} finally {

			if (connection != null) {
				try {
					connection.close();
				} catch (final SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
