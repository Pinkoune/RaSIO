/**
 * Affichage des courses
 * @author Jeremy
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AffCourse extends JPanel implements ActionListener {

    //Attributs priv�s

    //Frame
    private JFrame framePrincipale;

    //Panel
    private JPanel panelCourse;
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
    public AffCourse(ArrayList < ContenuCourse > listeCourse) {

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

        //Tableau
        Object data[][] = new Object[5][5];
        int i = 0;
        for (ContenuCourse maCourse: listeCourse) {
            data[i][0] = maCourse.getNomCourse();
            data[i][1] = maCourse.getTypeCourse();
            data[i][2] = maCourse.getNbSpec();
            data[i][3] = maCourse.getUnCircuit().getNomCircuit();
            i++;
        }
        String[] title = {
            "Nom de la course",
            "Type du circuit",
            "Nombre de spectateurs",
            "Nom du circuit",
        };
        this.tableau = new JTable(data, title);
        this.tableau.setPreferredScrollableViewportSize(new Dimension(350, 300));

        //Taille
        this.tableau.setRowHeight(30);

        //Barre de scroll
        this.scrollPane = new JScrollPane(this.tableau);
        this.panelTableau.add(this.scrollPane);

        //Ajout des attributs aux panels
        this.panelCourse.add(panelMessage, BorderLayout.PAGE_START);

        this.panelMessage.add(lblMessage);

        //Toujours � la fin
        /**
         * Rendu visible de l'app etc.. toujours � la fin de la classe
         */
        this.framePrincipale.setAlwaysOnTop(true);
        this.panelCourse.add(this.scrollPane);
        this.framePrincipale.getContentPane().add(panelCourse);
        this.monPanelGlobal.add(panelCourse, BorderLayout.CENTER);
        this.framePrincipale.getContentPane().add(this.monPanelGlobal);
    }

    //les getter et setter
    public JPanel getMonPanelGlobal() {
        return monPanelGlobal;
    }

    public void actionPerformed(ActionEvent e) {}
}