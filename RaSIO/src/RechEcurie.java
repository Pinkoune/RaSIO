/**
 * Fenetre de recherche
 * @author Jeremy
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
public class RechEcurie extends JFrame implements ActionListener {
	private JPanel monPanel;
	private JPanel monPanelGlobal = new JPanel();
	private JPanel panelHaut;
	private JPanel panelMil;
	private JPanel panelRech;
	private JLabel lblSupp1;
	private JTextField jtfSupp1;
	private JButton btnValider1;
	
	public RechEcurie() {

        
        monPanel = new JPanel ( ) ;
        panelHaut = new JPanel ( ) ;
        panelMil = new JPanel ();
        panelRech = new JPanel ();
        monPanel.setLayout(new BorderLayout());
        panelMil.setLayout(new FlowLayout());
        panelHaut.setLayout(new FlowLayout());
        monPanelGlobal.setLayout(new BorderLayout());
        
        lblSupp1 = new JLabel("Entrez le nom de l'ecurie : ");
        jtfSupp1 = new JTextField("");
        jtfSupp1.setPreferredSize(new Dimension(150, 30));

        btnValider1 = new JButton("Valider");
        btnValider1.addActionListener(new ActionListener() {
        public void actionPerformed (ActionEvent e) {
    		String nomEcurie = jtfSupp1.getText();
    		JLabel result = new JLabel (Modele.rechercheEcurie(nomEcurie));
    		panelRech.removeAll();
    		panelRech.add(result);
    		panelRech.revalidate();
    		panelRech.repaint();
    	}
        
	});

        
        panelMil.add(lblSupp1);
        panelMil.add(jtfSupp1);
        panelMil.add(btnValider1);
        
        monPanel.add(panelMil, BorderLayout.NORTH);
        monPanel.add(panelRech, BorderLayout.CENTER);

        
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



