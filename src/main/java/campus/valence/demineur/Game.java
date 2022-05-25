package campus.valence.demineur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    private Color BGCOLOR;
    private JFrame frame;
    private JPanel panel;
    private Board board;
    private int NB_BOMBES;
    private int compteurRestant ;
    private JLabel labelCompteur ;
    private int nbCasesDevoilees ;


    public Game(int NB_BOMBES) {
        this.NB_BOMBES = NB_BOMBES;
        this.compteurRestant = NB_BOMBES;
        this.nbCasesDevoilees = 0;
        this.BGCOLOR = Color.LIGHT_GRAY;
        panel = new JPanel();
        panel.setFocusable(true);
        panel.setLayout(null);
        panel.setBackground(BGCOLOR);

        frame = new JFrame();
        frame.setTitle("demineur");
        frame.setSize(600, 700);
        //frame.setResizable(false);
        frame.setLayout(null);
        frame.setContentPane(panel);
    }

    public void launch(Game game) {
        board = new Board(400, NB_BOMBES, game);
        ImageIcon imageBombe = new ImageIcon("bombe.png");
        labelCompteur = new JLabel(String.valueOf(compteurRestant));
        labelCompteur.setFont(new Font("Serif", Font.BOLD, 20));
        labelCompteur.setBounds(100,30,100,100);
        labelCompteur.setForeground(Color.BLACK);
        labelCompteur.setIcon(imageBombe);
        labelCompteur.setIconTextGap(7);
        //labelCompteur.setBackground(Color.BLUE);
        //labelCompteur.setOpaque(true);
        this.panel.add(labelCompteur);
        this.panel.add(board.getPanel());
        //frame.repaint();
        this.frame.setVisible(true);
    }

    public int getCompteurRestant() {
        return compteurRestant;
    }

    public void addCompteurRestant(int nombre) {
        this.compteurRestant = compteurRestant + nombre;
        nbCasesDevoilees -= nombre ;
        if (compteurRestant == 0 && nbCasesDevoilees==400){
            //fin de la partie !
            JLabel label = new JLabel("Vous avez gagné !",  SwingConstants.CENTER);
            label.setFont(new Font("Serif", Font.BOLD,20));
            label.setForeground(Color.BLUE);
            JFrame frame = new JFrame();
            frame.setLocation(200, 200);
            frame.add(label);
            frame.setSize(300,300);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else {
            this.getLabelCompteur().setText(String.valueOf(compteurRestant));
        }
        }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }


    public JLabel getLabelCompteur() {
        return labelCompteur;
    }

    public void setLabelCompteur(JLabel labelCompteur) {
        this.labelCompteur = labelCompteur;
    }

    public int getNbCasesDevoilees() {
        return nbCasesDevoilees;
    }

    public void addNbCasesDevoilees(int nb) {
        this.nbCasesDevoilees = nbCasesDevoilees + nb;
    }
}
