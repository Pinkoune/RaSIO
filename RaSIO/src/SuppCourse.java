/**
 * Suppression des courses
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

public class SuppCourse extends JFrame implements ActionListener{

    //Attributs privés
    //Panel
    private JPanel panelSuppCourse;
    private JPanel panelMessage;
    private JPanel panelChamps;
    private JPanel panelBtnQuitter;
    private JPanel monPanelGlobal = new JPanel();
    
    //Label
      private JLabel lblMessage;
    private JLabel lblNomCourse;
    private JLabel lblInsertion;
      
      //JTextField
      private JTextField jtfSuppression;
      
      //Bouton
      private JButton btnValider;
      
      public SuppCourse() {
    
        //Instanciation des panels
        this.panelSuppCourse = new JPanel();
        this.panelMessage = new JPanel();
        this.panelChamps = new JPanel();
        this.panelBtnQuitter = new JPanel();
        this.monPanelGlobal.setLayout(new BorderLayout());

        //Background des panels
        this.panelSuppCourse.setBackground(Color.white);
        this.panelMessage.setBackground(Color.blue);
        this.panelChamps.setBackground(Color.white);
        this.panelBtnQuitter.setBackground(Color.white);

        //Disposition des panels
        this.panelSuppCourse.setLayout(new BorderLayout());
        this.panelMessage.setLayout(new FlowLayout());
        this.panelChamps.setLayout(new FlowLayout());
        this.panelBtnQuitter.setLayout(new FlowLayout());

        //Instanciation des messages
        this.lblMessage = new JLabel("Course - suppression");
        this.lblNomCourse = new JLabel("Entrez le nom :");
        this.lblInsertion = new JLabel("");

        //Instanciation des entrées
        this.jtfSuppression = new JTextField();
        this.jtfSuppression.setPreferredSize(new Dimension(150, 30));
        
        //Couleur de la police
        this.lblMessage.setForeground(Color.white);
        
        //Instanciation des boutons
        this.btnValider = new JButton("Valider");
        this.btnValider.addActionListener(this);
        
        //Ajout des attributs aux panels
        this.panelSuppCourse.add(panelMessage, BorderLayout.PAGE_START);
        this.panelSuppCourse.add(panelChamps, BorderLayout.CENTER);
        this.panelSuppCourse.add(panelBtnQuitter, BorderLayout.PAGE_END);
        
        this.panelMessage.add(lblMessage);
        
        this.panelChamps.add(lblNomCourse);
        this.panelChamps.add(jtfSuppression);
        this.panelChamps.add(btnValider);
        this.panelChamps.add(lblInsertion);

        //Toujours à la fin
        this.getRootPane().setDefaultButton(btnValider);
        this.setAlwaysOnTop(true);
        this.getContentPane().add(panelSuppCourse);
        this.monPanelGlobal.add(panelSuppCourse, BorderLayout.CENTER);
        this.getContentPane().add(this.monPanelGlobal);
      }
      
    //les getter et setter
	  public JPanel getMonPanelGlobal() {
	    return monPanelGlobal;
	  }

    public void actionPerformed(ActionEvent e) {
         //Si la source de l'évènement est le JButton appelé 
        if(e.getSource() == btnValider) {
            String nomCourse = jtfSuppression.getText();
            if(Modele.suppressionCourse(nomCourse)) {
                lblInsertion.setText("Suppression effectuée."); 
            }
            else {
                lblInsertion.setText("Suppression non effectuée."); 
            }
        }
    }
    
}