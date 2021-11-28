/**
 * Affichage des courses
 * @author Jeremy
 */

import java.awt. * ;
import java.awt.event.ActionEvent;
import javax.swing. * ;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AffCourseXML extends JPanel implements ActionListener {
    
    //Attributs privés
	
	//Frame
    private JFrame framePrincipale;
	
    //Panel
    private JPanel panelCourse;
    private JPanel panelMessage;
    private JPanel panelTableau;
    private JPanel monPanelGlobal = new JPanel();
    
    //Label
      private JLabel lblMessage;
    
    //Texte
      private TextArea textListe;

    //Tableau
    private JTable tableau;
    
    //Scrollbar
    private JScrollPane scrollPane;

    //Constructeur
    public AffCourseXML(ArrayList<ContenuCourse> listeCourse) {
    	
    	//Instanciation de la liste
    	ArrayList<ContenuCourse> laListeCourse = Modele.affichageCourse();
    	
    	//Instanciation de la frame
    	this.framePrincipale = new JFrame();
    	
        //Instanciation des panels
        this.panelCourse = new JPanel();
        this.panelMessage = new JPanel();
        this.panelTableau = new JPanel();
        this.monPanelGlobal.setLayout(new BorderLayout());
        
        //Background des panels
        this.panelCourse.setBackground(Color.white);
        this.panelMessage.setBackground(Color.blue);
        this.panelTableau.setBackground(Color.white);

        //Disposition des panels
        this.panelCourse.setLayout(new BorderLayout());
        this.panelMessage.setLayout(new FlowLayout());
        this.panelTableau.setLayout(new FlowLayout());
        
        //Instanciation des messages
        this.lblMessage = new JLabel("Les courses");
        
         //Couleur de la police
        this.lblMessage.setForeground(Color.white);
      
        //Parcours liste
        String resultat = "";
        resultat += "<ListeCourse>";
        for (ContenuCourse maCourse: laListeCourse) {
        	resultat += maCourse.toXML();
        }
        resultat += "\n</ListeCourse>";
        
        //Ajout TextArea XML
        this.textListe = new TextArea(resultat);
        
        //Ajout des attributs aux panels
        
        this.panelCourse.add(textListe);
        this.panelCourse.add(panelMessage, BorderLayout.PAGE_START);
        this.panelMessage.add(lblMessage);
        

        //Toujours à la fin
          /**
           * Rendu visible de l'app etc.. toujours à la fin de la classe
           */
        this.framePrincipale.setAlwaysOnTop(true);
        this.framePrincipale.getContentPane().add(panelCourse);
        this.monPanelGlobal.add(panelCourse, BorderLayout.CENTER);
        this.framePrincipale.getContentPane().add(this.monPanelGlobal);
    }

  //les getter et setter
	  public JPanel getMonPanelGlobal() {
	    return monPanelGlobal;
	  }

    public void actionPerformed(ActionEvent e) {
    }
}