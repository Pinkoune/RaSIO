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

public class AjoutEcurie extends JFrame implements ActionListener{

	//Attributs privés
	//Panel
	private JPanel panelAjoutEcurie;
	private JPanel panelMessage;
	private JPanel panelChamps;
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
	
	//Constructeur
	public AjoutEcurie() {
	
	    //Instanciation des panels
	    this.panelAjoutEcurie = new JPanel();
	    this.panelMessage = new JPanel();
	    this.panelChamps = new JPanel();
	    monPanelGlobal.setLayout(new BorderLayout());

	    //Background des panels
	    this.panelAjoutEcurie.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.orange);
	    this.panelChamps.setBackground(Color.white);

	    //Disposition des panels
	    this.panelAjoutEcurie.setLayout(new BorderLayout());
	    this.panelMessage.setLayout(new FlowLayout());
	    this.panelChamps.setLayout(new FlowLayout());

	    //Instanciation des messages
	    this.lblMessage = new JLabel("Ecurie - ajout");
	    this.lblNomCourse = new JLabel("Nom de l'ecurie :");
	    this.lblTypeCourse = new JLabel("Sponsor de l'ecurie :");
	    this.lblNbSpectateur = new JLabel("Motoriste de l'ecurie :");
	    this.lblInsertion = new JLabel();
	    this.lblInsertion.setText("");

	    //Instanciation des entrées
	    this.jtfNomCourse = new JTextField();
	    this.jtfNomCourse.setPreferredSize(new Dimension(150, 30));
	    this.jtfTypeCourse = new JTextField();
	    this.jtfTypeCourse.setPreferredSize(new Dimension(150, 30));
	    this.jtfNbSpectateur = new JTextField();
	    this.jtfNbSpectateur.setPreferredSize(new Dimension(150, 30));

	    //Couleur de la police
	    this.lblMessage.setForeground(Color.black);
	    this.lblNomCourse.setForeground(Color.black);
	    this.lblTypeCourse.setForeground(Color.black);
	    this.lblNbSpectateur.setForeground(Color.black);
	    
	    //Instanciation des boutons
	    this.btnValider = new JButton("Valider");
	    this.btnValider.addActionListener(this);
	    
	    //Ajout des attributs aux panels
	    this.panelAjoutEcurie.add(panelMessage, BorderLayout.PAGE_START);
	    this.panelAjoutEcurie.add(panelChamps, BorderLayout.CENTER);
	    
	    this.panelMessage.add(lblMessage);
	    
	    this.panelChamps.add(lblNomCourse);
	    this.panelChamps.add(jtfNomCourse);
	    this.panelChamps.add(lblTypeCourse);
	    this.panelChamps.add(jtfTypeCourse);
	    this.panelChamps.add(lblNbSpectateur);
	    this.panelChamps.add(jtfNbSpectateur);
	    this.panelChamps.add(btnValider);
	    this.panelChamps.add(lblInsertion);
	
	    //Toujours à la fin
	    this.getRootPane().setDefaultButton(btnValider);
  		this.setAlwaysOnTop(true);
  		this.getContentPane().add(panelAjoutEcurie);
  		this.monPanelGlobal.add(panelAjoutEcurie, BorderLayout.CENTER);
  		this.getContentPane().add(monPanelGlobal);
	}
	
	//les getter et setter
	  public JPanel getMonPanelGlobal() {
	    return monPanelGlobal;
	  }
	
	public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnValider) {
            String nomEcu = jtfNomCourse.getText();
            String sponsorEcu = jtfTypeCourse.getText();
            String motorEcu = jtfNbSpectateur.getText();
            boolean rep = Modele.ajoutEcurie(nomEcu, sponsorEcu, motorEcu);
            if(rep) {
            	lblInsertion.setText("Une nouvelle ecurie a été ajoutée");
            }
            else {
            	lblInsertion.setText("ERREUR, l'ecurie n'a pas pu être ajoutée");
            }
        }
	}
}


