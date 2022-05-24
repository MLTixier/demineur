package campus.valence.demineur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board {

    private final JPanel panel;

    public Board(int size) {
        this.panel = new JPanel();
        panel.setBounds(50, 80, size, size);
        panel.setBackground(Color.darkGray);
        panel.setLayout(null);
        Demineur demineur = Demineur.create(15, 16, 0,0);

        for (int i = 0; i < size/20; i++) {
            for (int j = 0 ; j<size/20; j++){
                BoardCase boardCase = new BoardCase(i*20,j*20, demineur.giveContent(i,j));
                panel.add(boardCase.getPanel());
                boardCase.getPanel().addMouseListener(new GameMouseListener(boardCase));
            }
        }
    }

    public JPanel getPanel() {
        return panel;
    }

}
