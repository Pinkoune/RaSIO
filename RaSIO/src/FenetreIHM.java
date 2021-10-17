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
	private JPanel panelRep;
	private JTextField jtfUser;
	private JPasswordField jpfMdp;
	private JButton jbValider;
	private JLabel lblUser;
	private JLabel lblMdp;
	
	
	public FenetreIHM() {
		
		System.setProperty( "file.encoding", "UTF-8" );
        monPanel = new JPanel () ;
        
        this.setTitle("RaSIO");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 370);

        this.jtfUser = new JTextField("");
		this.jtfUser.setPreferredSize(new Dimension(250,30));

        this.jpfMdp = new JPasswordField("");
		this.jpfMdp.setPreferredSize(new Dimension(250,30));

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
			Modele unModele = new Modele();
			if(unModele.selectConnexion(pseudo, mdp)) {
				lblRep = new JLabel("Vous êtes connecté.");
			}
			monPanel.add(lblRep);
			monPanel.revalidate();
			monPanel.repaint();
		}
	}
}



