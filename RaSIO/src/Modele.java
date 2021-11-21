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
	
	/**
	 * Connexion et Deconnexion
	 * @return
	 */
	
	public static void connexion()  {
		//Methodes
		System.setProperty( "file.encoding", "UTF-8" );
		try {
			//Import du driver mysql connector
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Connexion a la BDD
			connexion = DriverManager.getConnection("jdbc:mysql://localhost/rasio?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "root", "");
		} catch (ClassNotFoundException erreur) { //Erreur du driver
			erreur.printStackTrace();
			System.out.println("Le Driver n'a pas pu etre charge.");
			
		} catch (SQLException e) { //Erreur de la connexion BDD
			e.printStackTrace();
			System.out.println("Erreur de la connexion a la BDD.");
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
	
	/**
	 * Requetes des courses
	 * @param unNomCourse
	 * @param unTypeCourse
	 * @param unNbSpec
	 * @return
	 */
	
	public static boolean ajoutCourse(String unNomCourse, String unTypeCourse, int unNbSpec) {
		//Insertion d'une course
		boolean rep = false;
		int result = 0;
		try {
			ps = connexion.prepareStatement("INSERT INTO course (nomCourse, typeCourse, nbSpectateurs) VALUES (?,?,?);");
			ps.setString(1, unNomCourse);
			ps.setString(2, unTypeCourse);
			ps.setInt(3, unNbSpec);
			result = ps.executeUpdate();
			if (result == 1) {
				rep = true;
			}
		} catch (SQLException e) {
			System.out.println("Erreur d'insertion d'une course.");
			e.printStackTrace();
		}
		return rep;
		
	}
	
	public static boolean suppressionCourse(String unNomCourse) {
		//Suppression d'une course
		boolean rep = false;
		int result = 0;
		try {
			ps = connexion.prepareStatement("DELETE FROM course WHERE nomCourse = ?;");
			ps.setString(1, unNomCourse);
			result = ps.executeUpdate();
			if(result == 1) {
				rep = true;
			}
		} catch (SQLException e) {
			System.out.println("Erreur de suppression d'une course.");
			e.printStackTrace();
		}
		return rep;
	}
	
	/**
	 * Requetes des Ecuries
	 * @param unNomEcu
	 * @param unSponsorEcu
	 * @param unMotorEcu
	 * @return
	 */
	
	public static boolean ajoutEcurie(String unNomEcu, String unSponsorEcu, String unMotorEcu) {
		//Insertion d'une ecurie
		boolean rep = false;
		int result = 0;
		try {
			ps = connexion.prepareStatement("INSERT INTO ecurie (nomEcurie, sponsorEcurie, motoristeEcurie) VALUES (?,?,?);");
			ps.setString(1, unNomEcu);
			ps.setString(2, unSponsorEcu);
			ps.setString(3, unMotorEcu);
			result = ps.executeUpdate();
			if (result == 1) {
				rep = true;
			}
		} catch (SQLException e) {
			System.out.println("Erreur d'insertion d'une ecurie.");
			e.printStackTrace();
		}
		return rep;
		
	}
	
	public static boolean suppressionEcurie(String unNomEcu) {
		//Suppression d'une ecurie
		boolean rep = false;
		int result = 0;
		try {
			ps = connexion.prepareStatement("DELETE FROM ecurie WHERE nomEcurie = ?;");
			ps.setString(1, unNomEcu);
			result = ps.executeUpdate();
			if(result == 1) {
				rep = true;
			}
		} catch (SQLException e) {
			System.out.println("Erreur de suppression d'une ecurie.");
			e.printStackTrace();
		}
		return rep;
	}
	
	/**
	 * Requetes des circuits
	 * @param unNomCircuit
	 * @param uneTailleCircuit
	 * @param unPaysCircuit
	 * @return
	 */
	
	public static boolean ajoutCircuit(String unNomCircuit, float uneTailleCircuit, String unPaysCircuit) {
		//Insertion d'une ecurie
		boolean rep = false;
		int result = 0;
		try {
			ps = connexion.prepareStatement("INSERT INTO circuit (nomCircuit, tailleCircuit, paysCircuit) VALUES (?,?,?);");
			ps.setString(1, unNomCircuit);
			ps.setFloat(2, uneTailleCircuit);
			ps.setString(3, unPaysCircuit);
			result = ps.executeUpdate();
			if (result == 1) {
				rep = true;
			}
		} catch (SQLException e) {
			System.out.println("Erreur d'insertion d'un circuit.");
			e.printStackTrace();
		}
		return rep;
		
	}
	
	public static boolean suppressionCircuit(String unNomCircuit) {
		//Suppression d'une ecurie
		boolean rep = false;
		int result = 0;
		try {
			ps = connexion.prepareStatement("DELETE FROM circuit WHERE nomCircuit = ?;");
			ps.setString(1, unNomCircuit);
			result = ps.executeUpdate();
			if(result == 1) {
				rep = true;
			}
		} catch (SQLException e) {
			System.out.println("Erreur de suppression d'un circuit.");
			e.printStackTrace();
		}
		return rep;
	}
	
	
	public static boolean selectConnexion(String unPseudo, String unMdp) {
		boolean rep = false;
		int connect = 0;
		try {
			ps = connexion.prepareStatement("SELECT COUNT(*) AS connect FROM utilisateur WHERE pseudo = ? AND mdp = ? ;");
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
