package bibliothequeAJS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Transfert {
	private Connection connection = null;
	private final static String URL = "jdbc:mysql://localhost/bibliothequeAJS";
	private final static String login = "root";
	private final static String password = "";

	private final static String GetLivresRequest = "SELECT * " + "FROM livre";
	private final static String DeleteLivreRequest = "DELETE FROM livre WHERE id =? ";

	public void deleteLivre(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// La connexion
			connection = DriverManager.getConnection(URL, login, password);
			System.out.println("connection à la base réussie");
			PreparedStatement stmtDelete = connection.prepareStatement(DeleteLivreRequest);
			stmtDelete.setInt(1, id);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// On ferme la connexion
			if (connection != null) {
				try {
					connection.close();
				} catch (final SQLException e) {
					e.printStackTrace();
				}
			}

		}

	}

	public ArrayList<Livre> getLivres() {
		ArrayList<Livre> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// La connexion
			connection = DriverManager.getConnection(URL, login, password);
			System.out.println("connection à la base réussie");
			Statement stmtEmprunts = connection.createStatement();
			// Remplir la requête
			ResultSet rs = stmtEmprunts.executeQuery(GetLivresRequest);
			while (rs.next()) {
				Livre livre = new Livre(rs.getInt("id"), rs.getString("titre"), rs.getInt("annee"),
						rs.getString("auteur"), rs.getString("editeur"));
				list.add(livre);
				System.out.println();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// On ferme la connexion
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
}
