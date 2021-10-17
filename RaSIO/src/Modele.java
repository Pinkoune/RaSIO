import java.sql.*;
import java.util.ArrayList;

public class Modele {
	//Attributs
	private static Connection connexion;
	private static Statement st;
	private static ResultSet rs;
	private static int count;
	private static PreparedStatement ps;
	
	
	public Modele() {
		
	}
	
	public static void connexion()  {
		//Methodes
		System.setProperty( "file.encoding", "UTF-8" );
		try {
			//Import du driver mysql connector
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Connexion a la BDD
			connexion = DriverManager.getConnection("jdbc:mysql://localhost/rasio?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "root", "root");
		} catch (ClassNotFoundException erreur) { //Erreur du driver
			erreur.printStackTrace();
			System.out.println("Le Driver n'a pas pu etre chargé.");
			
		} catch (SQLException e) { //Erreur de la connexion BDD
			e.printStackTrace();
			System.out.println("Erreur de la connexion à la BDD.");
		}
	}
	
	public static void deconnexion() {
		//Fermeture de la connexion a la BDD
		try {
			connexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean inserer(int unNum, String unNom, String unPrenom, String unEmail, String unComm) {
		//Insertion
		boolean rep = false;
		try {
			st = connexion.createStatement();
			String req = ("INSERT INTO contacts (numero, nom, prenom, email, commentaire) VALUES("+ unNum +", '"+ unNom +"','"+ unPrenom +"', '"+ unEmail +"', '"+ unComm +"');");
			//System.out.println(req);
			st.executeUpdate(req);
			rep = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rep;
		
	}
	
	public static boolean supprimer(int unNum) {
		//Suppression
		System.setProperty( "file.encoding", "UTF-8" );
		boolean rep = false;
		try {
			st = connexion.createStatement();
			String req = ("DELETE FROM contacts WHERE numero = "+ unNum);
			count = st.executeUpdate(req);
			if(count == 1) {
				System.out.println(count + " ligne supprimée.");
			}
			rep = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rep;
	}
	
	public static boolean selectConnexion(String unPseudo, String unMdp) {
		boolean rep = false;
		int connect = 0;
		try {
			ps = connexion.prepareStatement("SELECT COUNT(*) AS connect FROM Utilisateur WHERE pseudo = ? AND mdp = ? ;");
			ps.setString(1, unPseudo);
			ps.setString(2, unMdp);
			rs = ps.executeQuery();
			while(rs.next()) {
				connect = rs.getInt("connect");
			}
			rs.close();
			if(connect == 1) {
				rep = true;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("fdp");
		}
		return rep;
	}
}
