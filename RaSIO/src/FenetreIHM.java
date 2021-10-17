/**
 * Fenetre de connexion
 *@author jeremy 
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FenetreIHM extends JFrame implements ActionListener {
	
	private JPanel monPanel;
	private JTextField jtfUser;
	private JPasswordField jpfMdp;
	private JButton jbValider;
	private JLabel lblUser;
	private JLabel lblMdp;
	
	
	public FenetreIHM() {
		System.setProperty( "file.encoding", "UTF-8" );

	    monPanel = new JPanel();
	    monPanel.setLayout(new GridBagLayout()); 
	    
	    // Crée un objet de contraintes
        GridBagConstraints c = new GridBagConstraints(); 
        
        // Spécifie le padding externe de tous les composants
        c.insets = new Insets(1, 1, 1, 1); 
        
        // colonne 0
        c.gridx = 0; 
  
        // ligne 0
        c.gridy = 0; 
  
        // augmente la largeur des composants de 10 pixels
        c.ipadx = 100; 
  
        // augmente la hauteur des composants de 50 pixels
        c.ipady = 100; 
        
        this.setTitle("RaSIO");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 370);

        this.jtfUser = new JTextField("");
		this.jtfUser.setPreferredSize(new Dimension(120,25));

        this.jpfMdp = new JPasswordField("");
		this.jpfMdp.setPreferredSize(new Dimension(120,25));

        this.lblUser = new JLabel("Pseudo : ");
        this.lblMdp = new JLabel("Mot de passe :");
        this.jbValider = new JButton("Valider");
        
        
        monPanel.add(lblUser);
        monPanel.add(jtfUser);
        
        monPanel.add(lblMdp);
        monPanel.add(jpfMdp);
        
        jbValider.addActionListener(this);
        monPanel.add(jbValider);
        
        
        this.setAlwaysOnTop(true);
        this.getContentPane().add(monPanel);
        this.setVisible(true);
	}
	
	
	public void actionPerformed (ActionEvent e) {
		if(e.getSource() == jbValider) {
			String pseudo = jtfUser.getText();
			String mdp = jpfMdp.getText();
			JLabel lblRep = new JLabel("Identifiant incorrect.");
			if(Modele.selectConnexion(pseudo, mdp)) {
				lblRep = new JLabel("Vous etes connecte.");
			}
			monPanel.add(lblRep);
			monPanel.revalidate();
			monPanel.repaint();
		}
	}
}



