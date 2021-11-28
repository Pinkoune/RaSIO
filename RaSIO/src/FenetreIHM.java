/**
 * Fenetre de connexion
 *@author jeremy 
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class FenetreIHM extends JFrame implements ActionListener {

    //Panel
    private JPanel monPanel;
    private JPanel monPanelGlobal = new JPanel();

    //TextField
    private JTextField jtfUser;

    //Password
    private JPasswordField jpfMdp;

    //Bouton
    private JButton jbValider;

    //Label
    private JLabel lblUser;
    private JLabel lblMdp;
    private JLabel lblErreur;

    public FenetreIHM() {

        System.setProperty("file.encoding", "UTF-8");

        //Instanciation des panels
        this.monPanel = new JPanel();
        this.monPanelGlobal = new JPanel();

        //Disposition des panels
        this.monPanel.setLayout(new GridBagLayout());
        this.monPanelGlobal.setLayout(new BorderLayout());

        // Cree un objet de contraintes
        GridBagConstraints c = new GridBagConstraints();

        // Specifie le padding externe de tous les composants
        c.insets = new Insets(1, 1, 1, 1);

        // colonne 0
        c.gridx = 0;

        // ligne 0
        c.gridy = 0;

        // augmente la largeur des composants de 10 pixels
        c.ipadx = 100;

        // augmente la hauteur des composants de 50 pixels
        c.ipady = 100;

        this.setTitle("RaSIO");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 370);

        this.jtfUser = new JTextField("");
        this.jtfUser.setPreferredSize(new Dimension(120, 25));

        this.jpfMdp = new JPasswordField("");
        this.jpfMdp.setPreferredSize(new Dimension(120, 25));

        this.lblUser = new JLabel("Pseudo : ");
        this.lblMdp = new JLabel("Mot de passe :");
        this.jbValider = new JButton("Valider");
        this.lblErreur = new JLabel("");

        monPanel.add(lblUser);
        monPanel.add(jtfUser);

        monPanel.add(lblMdp);
        monPanel.add(jpfMdp);

        jbValider.addActionListener(this);
        monPanel.add(jbValider);

        monPanel.add(lblErreur);

        this.getRootPane().setDefaultButton(jbValider);
        this.setAlwaysOnTop(true);
        this.monPanelGlobal.add(this.monPanel);
        this.getContentPane().add(monPanelGlobal);
        this.setVisible(true);
    }

    //les getter et setter
    public JPanel getMonPanelGlobal() {
        return monPanelGlobal;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbValider) {
            String pseudo = jtfUser.getText();
            String mdp = jpfMdp.getText();
            if (Modele.selectConnexion(pseudo, mdp)) {
                this.dispose();
                new Accueil().getMonPanelGlobal();

            }
            this.lblErreur.setText("Identifiant incorrect.");
        }
    }
}