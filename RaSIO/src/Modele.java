import java.sql.*;
import java.util.ArrayList;

public class Modele {
	//Attributs
	private Connection connexion;
	private Statement st;
	private ResultSet rs;
	private int count;
	private PreparedStatement ps;
	
	public Modele() {
		
	}
	
	public void connexion()  {
		//Methodes
		try {
			//Import du driver mysql connector
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Connexion a la BDD
			connexion = DriverManager.getConnection("jdbc:mysql://localhost/rasio?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "root", "root");
		} catch (ClassNotFoundException erreur) { //Erreur du driver
			erreur.printStackTrace();
			System.out.println("Le Driver n'a pas pu etre charge.");
			
		} catch (SQLException e) { //Erreur de la connexion BDD
			System.out.println("Erreur de la connexion a la BDD.");
			e.printStackTrace();
		}
	}
	
	public void deconnexion() {
		//Fermeture de la connexion a la BDD
		try {
			connexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean inserer(int unNum, String unNom, String unPrenom, String unEmail, String unComm) {
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
	
	public boolean supprimer(int unNum) {
		//Suppression
		boolean rep = false;
		try {
			st = connexion.createStatement();
			String req = ("DELETE FROM contacts WHERE numero = "+ unNum);
			count = st.executeUpdate(req);
			if(count == 1) {
				System.out.println(count + " ligne supprimee.");
			}
			rep = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rep;
	}
	
	public boolean selectConnexion(String unPseudo, String unMdp) {
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
		}
		return rep;
	}
}
