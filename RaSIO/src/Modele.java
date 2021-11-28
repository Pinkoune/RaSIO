/**
 * Page du modele
 * @author Jeremy
 */

import java.sql.*;
import java.util.ArrayList;

public class Modele {
    //Attributs
    private static Connection connexion;
    private static Statement st;
    private static ResultSet rs;
    private static int count;
    private static PreparedStatement ps;
    private ArrayList < ContenuCourse > listeCourse;
    private ArrayList < ContenuEcurie > listeEcurie;
    private ArrayList < ContenuCircuit > listeCircuit;

    public Modele() {
        this.listeCourse = new ArrayList < ContenuCourse > ();
        this.listeEcurie = new ArrayList < ContenuEcurie > ();
        this.listeCircuit = new ArrayList < ContenuCircuit > ();
    }

    /**
     * Connexion et Deconnexion
     * @return
     */

    public static void connexion() {
        //Methodes
        System.setProperty("file.encoding", "UTF-8");
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
            if (result == 1) {
                rep = true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur de suppression d'une course.");
            e.printStackTrace();
        }
        return rep;
    }

    public static String rechercheCourse(String unNomCourse) {
        //Attributs
        ArrayList < ContenuCourse > listeCourse = new ArrayList < ContenuCourse > ();
        String result = "\nCette course n'existe pas.";
        int index = 0;
        String req;
        //Selection
        try {
            st = connexion.createStatement();
            req = "SELECT * FROM course, circuit WHERE course.idCircuit = circuit.idCircuit;";
            rs = st.executeQuery(req);
            // Pour accéder à chacune des lignes du résultat de la requête :
            while (rs.next()) {
            	String nomCourse = rs.getString("nomCourse");
                String typeCourse = rs.getString("typeCourse");
                int nbSpec = rs.getInt("nbSpectateurs");
                String nomCircuit = rs.getString("nomCircuit");
                String paysCircuit = rs.getString("paysCircuit");
                float tailleCircuit = rs.getFloat("tailleCircuit");
                
                ContenuCircuit ptitCircuit = new ContenuCircuit(nomCircuit, tailleCircuit, paysCircuit);
                listeCourse.add(new ContenuCourse(nomCourse, typeCourse, nbSpec, ptitCircuit));
            }

            while (index < listeCourse.size() && !listeCourse.get(index).getNomCourse().equals(unNomCourse)) {
                index = index + 1;
            }
            if (index < listeCourse.size()) {
                result = "\nVoici la course : " + listeCourse.get(index).toString();
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList < ContenuCourse > affichageCourse() {
        ArrayList < ContenuCourse > listeCourse;
        listeCourse = new ArrayList < ContenuCourse > ();
        try {
            st = connexion.createStatement();
            rs = st.executeQuery("SELECT * FROM course, circuit WHERE course.idCircuit = circuit.idCircuit;");
            while (rs.next()) {
                String nomCourse = rs.getString("nomCourse");
                String typeCourse = rs.getString("typeCourse");
                int nbSpec = rs.getInt("nbSpectateurs");
                String nomCircuit = rs.getString("nomCircuit");
                String paysCircuit = rs.getString("paysCircuit");
                float tailleCircuit = rs.getFloat("tailleCircuit");
                
                ContenuCircuit ptitCircuit = new ContenuCircuit(nomCircuit, tailleCircuit, paysCircuit);
                listeCourse.add(new ContenuCourse(nomCourse, typeCourse, nbSpec, ptitCircuit));
            }
        } catch (Exception e) {
            System.out.println("Erreur dans l'affichage de la course.");
            e.printStackTrace();
        }
        return listeCourse;
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
            if (result == 1) {
                rep = true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur de suppression d'une ecurie.");
            e.printStackTrace();
        }
        return rep;
    }

    public static String rechercheEcurie(String unNomEcurie) {
        //Attributs
        ArrayList < ContenuEcurie > listeEcurie = new ArrayList < ContenuEcurie > ();
        String result = "\nCette ecurie n'existe pas.";
        int index = 0;
        String req;
        String nom;
        String sponsor;
        String motor;
        //Selection
        try {
            st = connexion.createStatement();
            req = "SELECT * FROM ecurie";
            rs = st.executeQuery(req);
            // Pour accéder à chacune des lignes du résultat de la requête :
            while (rs.next()) {
                nom = rs.getString(1);
                sponsor = rs.getString(2);
                motor = rs.getString(3);
                listeEcurie.add(new ContenuEcurie(nom, sponsor, motor));
            }

            while (index < listeEcurie.size() && !listeEcurie.get(index).getNomEcurie().equals(unNomEcurie)) {
                index = index + 1;
            }
            if (index < listeEcurie.size()) {
                result = "\nVoici l'ecurie : " + listeEcurie.get(index).toString();
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList < ContenuEcurie > affichageEcurie() {
        connexion();
        ArrayList < ContenuEcurie > listeEcurie;
        listeEcurie = new ArrayList < ContenuEcurie > ();
        try {
            st = connexion.createStatement();
            rs = st.executeQuery("SELECT * FROM ecurie");
            while (rs.next()) {
                String nomEcu = rs.getString(1);
                String sponsorEcu = rs.getString(2);
                String motorEcu = rs.getString(3);
                listeEcurie.add(new ContenuEcurie(nomEcu, sponsorEcu, motorEcu));
            }
        } catch (Exception e) {
            System.out.println("Erreur dans l'affichage des ecuries.");
            e.printStackTrace();
        }
        return listeEcurie;
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
            if (result == 1) {
                rep = true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur de suppression d'un circuit.");
            e.printStackTrace();
        }
        return rep;
    }

    public static String rechercheCircuit(String unNomCircuit) {
        //Attributs
        ArrayList < ContenuCircuit > listeCircuit = new ArrayList < ContenuCircuit > ();
        String result = "\nCe circuit n'existe pas.";
        int index = 0;
        String req;
        String nom;
        float taille;
        String pays;
        //Selection
        try {
            st = connexion.createStatement();
            req = "SELECT * FROM circuit";
            rs = st.executeQuery(req);
            // Pour accéder à chacune des lignes du résultat de la requête :
            while (rs.next()) {
                nom = rs.getString(1);
                taille = rs.getFloat(2);
                pays = rs.getString(3);
                listeCircuit.add(new ContenuCircuit(nom, taille, pays));
            }

            while (index < listeCircuit.size() && !listeCircuit.get(index).getNomCircuit().equals(unNomCircuit)) {
                index = index + 1;
            }
            if (index < listeCircuit.size()) {
                result = "\nVoici le circuit : " + listeCircuit.get(index).toString();
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList < ContenuCircuit > affichageCircuit() {
        ArrayList < ContenuCircuit > listeCircuit;
        listeCircuit = new ArrayList < ContenuCircuit > ();
        try {
            st = connexion.createStatement();
            rs = st.executeQuery("SELECT * FROM circuit");
            while (rs.next()) {
                String nomCircuit = rs.getString("nomCircuit");
                float tailleCircuit = rs.getFloat("tailleCircuit");
                String paysCircuit = rs.getString("paysCircuit");
                listeCircuit.add(new ContenuCircuit(nomCircuit, tailleCircuit, paysCircuit));
            }
        } catch (Exception e) {
            System.out.println("Erreur dans l'affichage des circuits.");
            e.printStackTrace();
        }
        return listeCircuit;
    }

    /**
     * Requete de la page connexion
     * @param unPseudo
     * @param unMdp
     * @return
     */

    public static boolean selectConnexion(String unPseudo, String unMdp) {
        boolean rep = false;
        int connect = 0;
        try {
            ps = connexion.prepareStatement("SELECT COUNT(*) AS connect FROM utilisateur WHERE pseudo = ? AND mdp = sha1(?) ;");
            ps.setString(1, unPseudo);
            ps.setString(2, unMdp);
            rs = ps.executeQuery();
            while (rs.next()) {
                connect = rs.getInt("connect");
            }
            rs.close();
            if (connect == 1) {
                rep = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Probleme de connexion, erreur dans le pseudo ou mot de passe.");
        }
        return rep;
    }
}