/**
 * Affichage des ecuries
 * @author Jeremy
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AffEcurie extends JPanel implements ActionListener {

    //Attributs privés

    //Frame
    private JFrame framePrincipale;

    //Panel
    private JPanel panelEcurie;
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
    public AffEcurie(ArrayList < ContenuEcurie > listeEcurie) {

        //Instanciation de la frame
        this.framePrincipale = new JFrame();

        //Instanciation des panels
        this.panelEcurie = new JPanel();
        this.panelMessage = new JPanel();
        this.panelTableau = new JPanel();
        this.monPanelGlobal.setLayout(new BorderLayout());

        //Background des panels
        this.panelEcurie.setBackground(Color.white);
        this.panelMessage.setBackground(Color.orange);
        this.panelTableau.setBackground(Color.white);

        //Disposition des panels
        this.panelEcurie.setLayout(new BorderLayout());
        this.panelMessage.setLayout(new FlowLayout());
        this.panelTableau.setLayout(new FlowLayout());

        //Instanciation des messages
        this.lblMessage = new JLabel("Les ecuries");

        //Couleur de la police
        this.lblMessage.setForeground(Color.black);

        //Tableau
        Object data[][] = new Object[5][5];
        int i = 0;
        for (ContenuEcurie maEcurie: listeEcurie) {
            data[i][0] = maEcurie.getNomEcurie();
            data[i][1] = maEcurie.getSponsorEcurie();
            data[i][2] = maEcurie.getMotoristeEcurie();
            i++;
        }
        String[] title = {
            "Nom de l'ecurie",
            "Sponsor de l'ecurie",
            "Motoriste de l'ecurie",
        };
        this.tableau = new JTable(data, title);
        this.tableau.setPreferredScrollableViewportSize(new Dimension(350, 300));

        //Taille
        this.tableau.setRowHeight(30);

        //Barre de scroll
        this.scrollPane = new JScrollPane(this.tableau);
        this.panelTableau.add(this.scrollPane);

        //Ajout des attributs aux panels
        this.panelEcurie.add(panelMessage, BorderLayout.PAGE_START);

        this.panelMessage.add(lblMessage);

        //Toujours à la fin
        /**
         * Rendu visible de l'app etc.. toujours à la fin de la classe
         */
        this.framePrincipale.setAlwaysOnTop(true);
        this.panelEcurie.add(this.scrollPane);
        this.framePrincipale.getContentPane().add(panelEcurie);
        this.monPanelGlobal.add(panelEcurie, BorderLayout.CENTER);
        this.framePrincipale.getContentPane().add(this.monPanelGlobal);
    }

    //les getter et setter
    public JPanel getMonPanelGlobal() {
        return monPanelGlobal;
    }

    public void actionPerformed(ActionEvent e) {}
}