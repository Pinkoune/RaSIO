import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AjoutCircuit extends JFrame implements ActionListener{

	//Attributs priv�s
	//Panel
	private JPanel panelAjoutCircuit;
	private JPanel panelMessage;
	private JPanel panelChamps;
	private JPanel panelBtnQuitter;
	private JPanel monPanelGlobal = new JPanel();
	
	//Label
	private JLabel lblMessage;
	private JLabel lblNomCourse;
	private JLabel lblTypeCourse;
	private JLabel lblNbSpectateur;
	private JLabel lblInsertion;
	
	//JTextField
	private JTextField jtfNomCourse;
	private JTextField jtfTypeCourse;
	private JTextField jtfNbSpectateur;
	
	//Bouton
	private JButton btnValider;
	private JButton btnRetour;
	
	private Liste laListe;
	
	//Constructeur
	public AjoutCircuit(Liste uneListe) {
		
		this.laListe = uneListe;
	
	    //Instanciation des panels
	    this.panelAjoutCircuit = new JPanel();
	    this.panelMessage = new JPanel();
	    this.panelBtnQuitter = new JPanel();
	    this.panelChamps = new JPanel();
	    monPanelGlobal.setLayout(new BorderLayout());

	    //Background des panels
	    this.panelAjoutCircuit.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.green);
	    this.panelBtnQuitter.setBackground(Color.white);
	    this.panelChamps.setBackground(Color.white);

	    //Disposition des panels
	    this.panelAjoutCircuit.setLayout(new BorderLayout());
	    this.panelMessage.setLayout(new FlowLayout());
	    this.panelBtnQuitter.setLayout(new FlowLayout());
	    this.panelChamps.setLayout(new FlowLayout());

	    //Instanciation des messages
	    this.lblMessage = new JLabel("Circuit - ajout");
	    this.lblNomCourse = new JLabel("Nom du circuit :");
	    this.lblTypeCourse = new JLabel("Taille du circuit :");
	    this.lblNbSpectateur = new JLabel("Pays du circuit :");
	    this.lblInsertion = new JLabel();
	    this.lblInsertion.setText("");

	    //Instanciation des entr�es
	    this.jtfNomCourse = new JTextField();
	    this.jtfNomCourse.setPreferredSize(new Dimension(150, 30));
	    this.jtfTypeCourse = new JTextField();
	    this.jtfTypeCourse.setPreferredSize(new Dimension(150, 30));
	    this.jtfNbSpectateur = new JTextField();
	    this.jtfNbSpectateur.setPreferredSize(new Dimension(150, 30));

	    //Couleur de la police
	    this.lblMessage.setForeground(Color.white);
	    this.lblNomCourse.setForeground(Color.black);
	    this.lblTypeCourse.setForeground(Color.black);
	    this.lblNbSpectateur.setForeground(Color.black);
	    
	    //Instanciation des boutons
	    this.btnValider = new JButton("Valider");
	    this.btnValider.addActionListener(this);
	    this.btnRetour = new JButton("Retour");
	    this.btnRetour.addActionListener(this);
	    
	    //Ajout des attributs aux panels
	    this.panelAjoutCircuit.add(panelMessage, BorderLayout.PAGE_START);
	    this.panelAjoutCircuit.add(panelChamps, BorderLayout.CENTER);
	    this.panelAjoutCircuit.add(panelBtnQuitter, BorderLayout.PAGE_END);
	    
	    this.panelMessage.add(lblMessage);
	    
	    this.panelChamps.add(lblNomCourse);
	    this.panelChamps.add(jtfNomCourse);
	    this.panelChamps.add(lblTypeCourse);
	    this.panelChamps.add(jtfTypeCourse);
	    this.panelChamps.add(lblNbSpectateur);
	    this.panelChamps.add(jtfNbSpectateur);
	    this.panelChamps.add(btnValider);
	    this.panelChamps.add(lblInsertion);
	
	    this.panelBtnQuitter.add(btnRetour);
	
	    //Toujours � la fin
  		this.setAlwaysOnTop(true);
  		this.getContentPane().add(panelAjoutCircuit);
  		this.monPanelGlobal.add(panelAjoutCircuit, BorderLayout.CENTER);
  		this.getContentPane().add(monPanelGlobal);
	}
	
	//les getter et setter
	  public JPanel getMonPanelGlobal() {
	    return monPanelGlobal;
	  }
	
	public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnValider) {
            String nomCircuit = jtfNomCourse.getText();
            float tailleCircuit = Integer.parseInt(jtfTypeCourse.getText());
            String paysCircuit = jtfNbSpectateur.getText();
            boolean rep = Modele.ajoutCircuit(nomCircuit, tailleCircuit, paysCircuit);
            if(rep) {
            	lblInsertion.setText("Un nouveau circuit a �t� ajout�");
            }
            else {
            	lblInsertion.setText("ERREUR, le circuit n'a pas pu �tre ajout�");
            }
        }
		if(e.getSource() == btnRetour) {
			panelAjoutCircuit.removeAll();
			panelAjoutCircuit.add(new Accueil(laListe).getMonPanelGlobal());
			panelAjoutCircuit.revalidate();
			panelAjoutCircuit.repaint();
		}
	}
}


