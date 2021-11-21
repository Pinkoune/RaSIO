/**
 * Suppression des ecuries
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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SuppEcurie extends JFrame implements ActionListener{

    //Attributs privés
    //Panel
    private JPanel panelSuppEcurie;
    private JPanel panelMessage;
    private JPanel panelChamps;
    private JPanel monPanelGlobal = new JPanel();
    
    //Label
      private JLabel lblMessage;
    private JLabel lblNomEcurie;
    private JLabel lblInsertion;
      
      //JTextField
      private JTextField jtfSuppression;
      
      //Bouton
      private JButton btnValider;
      
      public SuppEcurie() {
    
        //Instanciation des panels
        this.panelSuppEcurie = new JPanel();
        this.panelMessage = new JPanel();
        this.panelChamps = new JPanel();
        monPanelGlobal.setLayout(new BorderLayout());

        //Background des panels
        this.panelSuppEcurie.setBackground(Color.white);
        this.panelMessage.setBackground(Color.orange);
        this.panelChamps.setBackground(Color.white);

        //Disposition des panels
        this.panelSuppEcurie.setLayout(new BorderLayout());
        this.panelMessage.setLayout(new FlowLayout());
        this.panelChamps.setLayout(new FlowLayout());

        //Instanciation des messages
        this.lblMessage = new JLabel("Ecurie - suppression");
        this.lblNomEcurie = new JLabel("Entrez le nom :");
        this.lblInsertion = new JLabel("");

        //Instanciation des entrées
        this.jtfSuppression = new JTextField();
        this.jtfSuppression.setPreferredSize(new Dimension(150, 30));
        
        //Couleur de la police
        this.lblMessage.setForeground(Color.black);
        
        //Instanciation des boutons
        this.btnValider = new JButton("Valider");
        this.btnValider.addActionListener(this);
        
        //Ajout des attributs aux panels
        this.panelSuppEcurie.add(panelMessage, BorderLayout.PAGE_START);
        this.panelSuppEcurie.add(panelChamps, BorderLayout.CENTER);
        
        this.panelMessage.add(lblMessage);
        
        this.panelChamps.add(lblNomEcurie);
        this.panelChamps.add(jtfSuppression);
        this.panelChamps.add(btnValider);
        this.panelChamps.add(lblInsertion);

        //Toujours à la fin
        this.getRootPane().setDefaultButton(btnValider);
        this.setAlwaysOnTop(true);
        this.getContentPane().add(panelSuppEcurie);
        this.monPanelGlobal.add(panelSuppEcurie, BorderLayout.CENTER);
        this.getContentPane().add(this.monPanelGlobal);
      }
      
    //les getter et setter
	  public JPanel getMonPanelGlobal() {
	    return monPanelGlobal;
	  }

    public void actionPerformed(ActionEvent e) {
         //Si la source de l'évènement est le JButton appelé 
        if(e.getSource() == btnValider) {
            String nomEcurie = jtfSuppression.getText();
            if(Modele.suppressionEcurie(nomEcurie)) {
                lblInsertion.setText("Suppression effectuée."); 
            }
            else {
                lblInsertion.setText("Suppression non effectuée."); 
            }
        }
    }
    
}