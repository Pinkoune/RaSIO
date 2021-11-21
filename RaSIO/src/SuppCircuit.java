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

public class SuppCircuit extends JFrame implements ActionListener{

    //Attributs privés
    //Panel
    private JPanel panelSuppCircuit;
    private JPanel panelMessage;
    private JPanel panelChamps;
    private JPanel panelBtnQuitter;
    private JPanel monPanelGlobal = new JPanel();
    
    //Label
      private JLabel lblMessage;
    private JLabel lblNomCircuit;
    private JLabel lblInsertion;
      
      //JTextField
      private JTextField jtfSuppression;
      
      //Bouton
      private JButton btnValider;
      private JButton btnRetour;
      
      private Liste laListe;
      
      public SuppCircuit(Liste uneListe) {
    	  
    	this.laListe = uneListe;
    
        //Instanciation des panels
        this.panelSuppCircuit = new JPanel();
        this.panelMessage = new JPanel();
        this.panelChamps = new JPanel();
        this.panelBtnQuitter = new JPanel();
        monPanelGlobal.setLayout(new BorderLayout());

        //Background des panels
        this.panelSuppCircuit.setBackground(Color.white);
        this.panelMessage.setBackground(Color.green);
        this.panelChamps.setBackground(Color.white);
        this.panelBtnQuitter.setBackground(Color.white);

        //Disposition des panels
        this.panelSuppCircuit.setLayout(new BorderLayout());
        this.panelMessage.setLayout(new FlowLayout());
        this.panelChamps.setLayout(new FlowLayout());
        this.panelBtnQuitter.setLayout(new FlowLayout());

        //Instanciation des messages
        this.lblMessage = new JLabel("Circuit - suppression");
        this.lblNomCircuit = new JLabel("Entrez le nom :");
        this.lblInsertion = new JLabel("");

        //Instanciation des entrées
        this.jtfSuppression = new JTextField();
        this.jtfSuppression.setPreferredSize(new Dimension(150, 30));
        
        //Couleur de la police
        this.lblMessage.setForeground(Color.white);
        
        //Instanciation des boutons
        this.btnValider = new JButton("Valider");
        this.btnValider.addActionListener(this);
        this.btnRetour = new JButton("Retour");
        this.btnRetour.addActionListener(this);
        
        //Ajout des attributs aux panels
        this.panelSuppCircuit.add(panelMessage, BorderLayout.PAGE_START);
        this.panelSuppCircuit.add(panelChamps, BorderLayout.CENTER);
        this.panelSuppCircuit.add(panelBtnQuitter, BorderLayout.PAGE_END);
        
        this.panelMessage.add(lblMessage);
        
        this.panelChamps.add(lblNomCircuit);
        this.panelChamps.add(jtfSuppression);
        this.panelChamps.add(btnValider);
        this.panelChamps.add(lblInsertion);

        this.panelBtnQuitter.add(btnRetour);

        //Toujours à la fin
        this.setAlwaysOnTop(true);
        this.getContentPane().add(panelSuppCircuit);
        this.monPanelGlobal.add(panelSuppCircuit, BorderLayout.CENTER);
        this.getContentPane().add(this.monPanelGlobal);
      }
      
    //les getter et setter
	  public JPanel getMonPanelGlobal() {
	    return monPanelGlobal;
	  }

    public void actionPerformed(ActionEvent e) {
         //Si la source de l'évènement est le JButton appelé 
        if(e.getSource() == btnValider) {
            String nomCircuit = jtfSuppression.getText();
            if(Modele.suppressionCircuit(nomCircuit)) {
                lblInsertion.setText("Suppression effectuée."); 
            }
            else {
                lblInsertion.setText("Suppression non effectuée."); 
            }
        }
        if(e.getSource() == btnRetour) {
        	panelSuppCircuit.removeAll();
        	panelSuppCircuit.add(new Accueil(laListe).getMonPanelGlobal());
        	panelSuppCircuit.revalidate();
        	panelSuppCircuit.repaint();
		}
    }
    
}