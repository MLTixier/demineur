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

    Game() {
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

    public void launch() {
        board = new Board(400);
        this.panel.add(board.getPanel());
        //frame.repaint();
        this.frame.setVisible(true);
    }




}
