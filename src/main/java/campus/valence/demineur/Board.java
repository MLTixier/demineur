package campus.valence.demineur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board {

    private final JPanel panel;
    private BoardCase[][] board;

    public Board(int size) {
        this.panel = new JPanel();
        panel.setBounds(100, 150, size, size);
        panel.setBackground(Color.darkGray);
        panel.setLayout(null);
        Demineur demineur = Demineur.create(40, 20, 0, 0);
        board = new BoardCase[20][20];
        for (int i = 0; i < (size/20); i++) {
            for (int j = 0; j < (size/20); j++) {
                BoardCase boardCase = new BoardCase(i * 20, j * 20, demineur.giveContent(i, j), this);
                board[i][j] = boardCase;
                panel.add(boardCase.getPanel());
                boardCase.getPanel().addMouseListener(new GameMouseListener(boardCase));
            }
        }
        //je donne à toutes les cases la "connaissance" du board complet une fois qu'il est terminé :
        for (BoardCase[] row : board) {
            for (BoardCase Case : row) {
                Case.setBoard(this);
            }
        }
    }

    public JPanel getPanel() {
        return panel;
    }

    public BoardCase getBoardCase(int i, int j) {
        return board[i][j];
    }

}
