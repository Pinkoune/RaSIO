/**
 * Page principale du programme
 * @author Jeremy
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Accueil extends JFrame implements ActionListener {
	
	//les panel classiques
  private JPanel monPanel = new JPanel();
  private JPanel monPanelGlobal = new JPanel();

  //La barre menu
  private JMenuBar jMenu;
  
  //Les menus
  private JMenu courses;
  private JMenu ecuries;
  private JMenu circuits;
  
  //Les boutons course
  private JMenuItem btnAjouterCourse;
  private JMenuItem btnSupprimerCourse;
  private JMenuItem btnRechercherCourse;
  
  //Les boutons ecuries
  private JMenuItem btnAjouterEcurie;
  private JMenuItem btnSupprimerEcurie;
  private JMenuItem btnRechercherEcurie;
  
  //Les boutons circuits
  private JMenuItem btnAjouterCircuit;
  private JMenuItem btnSupprimerCircuit;
  private JMenuItem btnRechercherCircuit;
  
  
  private JLabel lblMessage;
  private Liste uneListe;


  //CONSTRUCTEURS
  public Accueil(Liste uneListe) {
	  this.setTitle("RaSio");  
	  this.setLocationRelativeTo(null);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setSize(700, 500);
    
	  
	  this.uneListe = uneListe;

    
    
    //INSTANCIATION DU PANEL GLOBAL

    this.monPanel.setLayout(new FlowLayout(1, 4, 2));
    this.monPanel.setBackground(Color.pink);

    this.monPanelGlobal = new JPanel();
    this.monPanelGlobal.setLayout(new BorderLayout());
    
    // Creation des menus
    this.courses = new JMenu("Menu des courses");
    this.ecuries = new JMenu("Menu des ecuries");
    this.circuits = new JMenu("Menu des circuits");
    
    // Creation de la barre de menu
    JMenuBar jMenu = new JMenuBar();

    //Creation des elements du menu course
    this.btnAjouterCourse = new JMenuItem("Ajouter une course");
    this.btnSupprimerCourse = new JMenuItem("Supprimer une course");
    this.btnRechercherCourse = new JMenuItem("Rechercher une course");
    this.courses.add(btnAjouterCourse);
    this.courses.add(btnSupprimerCourse);
    this.courses.add(btnRechercherCourse);
    
    //Creation des elements du menu ecurie
    this.btnAjouterEcurie = new JMenuItem("Ajouter une ecurie");
    this.btnSupprimerEcurie = new JMenuItem("Supprimer une ecurie");
    this.btnRechercherEcurie = new JMenuItem("Rechercher une ecurie");
    this.ecuries.add(this.btnAjouterEcurie);
    this.ecuries.add(this.btnSupprimerEcurie);
    this.ecuries.add(this.btnRechercherEcurie);
    
    //Creation des elements du menu circuit
    this.btnAjouterCircuit = new JMenuItem("Ajouter une circuit");
    this.btnSupprimerCircuit = new JMenuItem("Supprimer une circuit");
    this.btnRechercherCircuit = new JMenuItem("Rechercher une circuit");
    this.circuits.add(this.btnAjouterCircuit);
    this.circuits.add(this.btnSupprimerCircuit);
    this.circuits.add(this.btnRechercherCircuit);

    
    
    //Ecoute des items du menu course
    this.btnAjouterCourse.addActionListener(this);
    this.btnSupprimerCourse.addActionListener(this);
    this.btnRechercherCourse.addActionListener(this);
    
    //Ecoute des items du menu course
    this.btnAjouterEcurie.addActionListener(this);
    this.btnSupprimerEcurie.addActionListener(this);
    this.btnRechercherEcurie.addActionListener(this);
    
    //Ecoute des items du menu course
    this.btnAjouterCircuit.addActionListener(this);
    this.btnSupprimerCircuit.addActionListener(this);
    this.btnRechercherCircuit.addActionListener(this);

    // Ajout de l'element au menu 
    jMenu.add(courses);
    jMenu.add(ecuries);
    jMenu.add(circuits);
    
    // Permet de definir le menu utilise dans la JFrame
    this.setJMenuBar(jMenu);

    //LABEL PERMETTANT D'AFFICHER UN TEXTE
    this.lblMessage = new JLabel();
    this.lblMessage.setText("La RaSIO");

    this.monPanel.add(lblMessage);

    this.monPanelGlobal.add(monPanel, BorderLayout.CENTER);

    this.getContentPane().add(this.monPanelGlobal);
    this.setVisible(true);

  }

  //les getter et setter
  public JPanel getMonPanelGlobal() {
    return monPanelGlobal;
  }

 

  //Lance le changement de panel
  public void actionPerformed(ActionEvent e) {

    if (e.getSource().equals(btnAjouterCourse)) {							//Panel d'Ajout si bouton cliqué.
    	this.getContentPane().removeAll();  			      			 //on va supprimer le panel
    	//this.getContentPane().add(new FenetreInstruments(uneListe).getMonPanelGlobal());       //on va ajouter un panel
    	this.getContentPane().revalidate();								//
    	this.getContentPane().repaint();
    	
    } else if (e.getSource().equals(btnAjouterCourse)) {					//Panel d'Affichage si bouton cliqué.
      
    	this.getContentPane().removeAll();      					     //on va supprimer le panel
		//this.getContentPane().add(new FenetreAffichage(uneListe).getMonPanelGlobal());       //on va ajouter un panel
		this.getContentPane().revalidate();
		this.getContentPane().repaint();
		
    } else if (e.getSource().equals(btnAjouterCourse)) {					//Panel de suppression si bouton cliqué.
        
    	this.getContentPane().removeAll();      					     //on va supprimer le panel
		//this.getContentPane().add(new FenetreRecherche(uneListe).getMonPanelGlobal());       //on va ajouter un panel
		this.getContentPane().revalidate();
		this.getContentPane().repaint();
		
    } else if (e.getSource().equals(btnAjouterCourse)) {				//Panel de suppression si bouton cliqué.
    	
      this.getContentPane().removeAll();       							//on va supprimer le panel
      //this.getContentPane().add(new FenetreSuppression(uneListe).getMonPanelGlobal());       //on va ajouter un panel
      this.getContentPane().revalidate();
      this.getContentPane().repaint();
    }

  }
  
} 