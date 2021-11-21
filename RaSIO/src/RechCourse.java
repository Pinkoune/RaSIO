/**
 * Fenetre de recherche des courses
 * @author Jeremy
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
public class RechCourse extends JFrame implements ActionListener {
	
	//Attributs privés
	//Panel
	private JPanel monPanel;
	private JPanel monPanelGlobal = new JPanel();
	private JPanel panelHaut;
	private JPanel panelMil;
	private JLabel lblInsertion;
	
	//Lebel
	private JLabel lblSupp1;
	private JLabel lblMessage;
	
	//TextField
	private JTextField jtfSupp1;
	
	//Bouton
	private JButton btnValider1;
	
	public RechCourse() {

		//Instanciation des panels
        this.monPanel = new JPanel();
        this.panelHaut = new JPanel();
        this.panelMil = new JPanel();
        
        //Background et disposition des panels
        this.panelHaut.setBackground(Color.blue);
        this.panelMil.setBackground(Color.white);
        
        this.monPanel.setLayout(new BorderLayout());
        this.panelMil.setLayout(new FlowLayout());
        this.panelHaut.setLayout(new FlowLayout());
        this.monPanelGlobal.setLayout(new BorderLayout());
        
        //Instanciation des messages
        this.lblMessage = new JLabel("Course - recherche");
        this.lblSupp1 = new JLabel("Entrez le nom de la course : ");
        this.jtfSupp1 = new JTextField("");
        this.jtfSupp1.setPreferredSize(new Dimension(150, 30));
        this.lblInsertion = new JLabel();
	    this.lblInsertion.setText("");

        //Instanciation du bouton
        this.btnValider1 = new JButton("Valider");
        this.btnValider1.addActionListener(new ActionListener() {
        	//Recherche de la course
        	public void actionPerformed (ActionEvent e) {
	    		String nomCourse = jtfSupp1.getText();
	    		String result = Modele.rechercheCourse(nomCourse);
	    		lblInsertion.setText(result);
        	}
        });
        
        //Couleur de la police
        this.lblMessage.setForeground(Color.white);

        //Ajout des attributs aux panels
        this.monPanel.add(panelHaut, BorderLayout.PAGE_START);
        this.monPanel.add(panelMil, BorderLayout.CENTER);
        
        this.panelHaut.add(lblMessage);
        this.panelMil.add(lblSupp1);
        this.panelMil.add(jtfSupp1);
        this.panelMil.add(btnValider1);
        this.panelMil.add(lblInsertion);
        
        //Toujours à la fin
        this.getRootPane().setDefaultButton(btnValider1);
        this.setAlwaysOnTop(true);
        this.getContentPane().add(monPanel);
        this.monPanelGlobal.add(monPanel, BorderLayout.CENTER);
        this.getContentPane().add(this.monPanelGlobal);
	}
	
	//les getter et setter
	  public JPanel getMonPanelGlobal() {
	    return monPanelGlobal;
	  }
	
	public void actionPerformed (ActionEvent e) {

	}
}



