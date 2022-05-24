package campus.valence.demineur;

import javax.swing.*;
import java.awt.*;

public class BoardCase {

    private JPanel panel;
    private String content;

    public BoardCase(int x, int y, String content) {
        this.content = content;
        this.panel = new JPanel();
        panel.setBounds(x, y, 20, 20);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setBackground(Color.LIGHT_GRAY);

        /*
        //pour afficher la carte :

        JLabel label = new JLabel();
        if (this.getContent().equals("X")) {
            //Perdu ! Modifier le code ci-dessous.
            label.setText(this.getContent());
            label.setForeground(Color.RED);
        } else {
            if (this.getContent().equals("1")) {
                label.setText(this.getContent());
                label.setForeground(Color.BLUE);
            } else if (this.getContent().equals("2")) {
                label.setText(this.getContent());
                label.setForeground(Color.MAGENTA);
            } else if (this.getContent().equals("0")) {
                panel.setBackground(Color.WHITE);
            } else {
                label.setText(this.getContent());
                label.setForeground(Color.BLACK);
            }
        }
        panel.add(label);



         */

    }

    public JPanel getPanel() {
        return panel;
    }

    public String getContent() {
        return content;
    }

    public void devoilerCase() {
        JLabel label = new JLabel(this.getContent());
        if (this.getContent().equals("X")) {
            //Perdu ! Modifier le code ci-dessous.
            label.setForeground(Color.RED);
        } else {
            if (this.getContent().equals("1")) {
                label.setText(this.getContent());
                label.setForeground(Color.BLUE);
            } else if (this.getContent().equals("2")) {
                label.setText(this.getContent());
                label.setForeground(Color.MAGENTA);
            } else if (this.getContent().equals("0")) {
                panel.setBackground(Color.WHITE);
            } else {
                label.setText(this.getContent());
                label.setForeground(Color.BLACK);
            }
        }
        panel.add(label);
    }

    public void marquerCaseAvecBombe() {
        JLabel label = new JLabel("V");
        label.setForeground(Color.RED);
        panel.add(label);
    }
}

