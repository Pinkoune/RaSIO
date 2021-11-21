/**
 * Affichage des circuits
 * @author Jeremy
 */

import java.awt. * ;
import java.awt.event.ActionEvent;
import javax.swing. * ;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AffCircuit extends JFrame implements ActionListener {
    
    //Attributs privés
    //Panel
    private JPanel panelCircuit;
    private JPanel panelMessage;
    private JPanel panelTableau;
    private JPanel monPanelGlobal = new JPanel();
    
    //Label
      private JLabel lblMessage;

    //Tableau
    private JTable tableau;
    
    //Scrollbar
    private JScrollPane scrollPane;

    //Constructeur
    public AffCircuit(ArrayList<ContenuCircuit> listeCircuit) {
        //Instanciation des panels
        this.panelCircuit = new JPanel();
        this.panelMessage = new JPanel();
        this.panelTableau = new JPanel();
        this.monPanelGlobal.setLayout(new BorderLayout());
        
        //Background des panels
        this.panelCircuit.setBackground(Color.white);
        this.panelMessage.setBackground(Color.green);
        this.panelTableau.setBackground(Color.white);

        //Disposition des panels
        this.panelCircuit.setLayout(new BorderLayout());
        this.panelMessage.setLayout(new FlowLayout());
        this.panelTableau.setLayout(new FlowLayout());
        
        //Instanciation des messages
        this.lblMessage = new JLabel("Les circuits");
        
         //Couleur de la police
        this.lblMessage.setForeground(Color.black);
      
        //Tableau
        Object data[][] = new Object[5][5];
        int i = 0;
        for (ContenuCircuit maCircuit: listeCircuit) {
            data[i][0] = maCircuit.getNomCircuit();
            data[i][1] = maCircuit.getTailleCircuit();
            data[i][2] = maCircuit.getPaysCircuit();
            i++;
        }
        String[] title = {
            "Nom du circuit",
            "Taille du circuit",
            "Pays du circuit",
        };
        this.tableau = new JTable(data, title);
        this.tableau.setPreferredScrollableViewportSize(new Dimension(350, 300));

        //Taille
        this.tableau.setRowHeight(30);

        //Barre de scroll
        this.scrollPane = new JScrollPane(this.tableau);
        this.panelTableau.add(this.scrollPane);

        //Ajout des attributs aux panels
        this.panelCircuit.add(panelMessage, BorderLayout.PAGE_START);
        
        this.panelMessage.add(lblMessage);
        

        //Toujours à la fin
          /**
           * Rendu visible de l'app etc.. toujours à la fin de la classe
           */
        this.setAlwaysOnTop(true);
        this.panelCircuit.add(this.scrollPane);
        this.getContentPane().add(panelCircuit);
        this.monPanelGlobal.add(panelCircuit, BorderLayout.CENTER);
        this.getContentPane().add(this.monPanelGlobal);
    }

  //les getter et setter
	  public JPanel getMonPanelGlobal() {
	    return monPanelGlobal;
	  }

    public void actionPerformed(ActionEvent e) {
    }
}