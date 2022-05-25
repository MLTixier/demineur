package campus.valence.demineur;

import javax.swing.*;
import java.awt.*;

public class BoardCase {

    private JPanel panel;
    private String content;
    private int x;
    private int y;
    private Board board;
    private Color bgColor;
    private boolean devoilee ;

    public BoardCase(int x, int y, String content, Board board) {
        this.board = board;
        this.content = content;
        this.panel = new JPanel(null);
        this.x = x;
        this.y = y;
        this.devoilee = false ;
        panel.setBounds(x, y, 20, 20);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bgColor = Color.LIGHT_GRAY;
        panel.setBackground(bgColor);

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
        panel.removeAll();
        if (this.getContent().equals("X")) {
            //Perdu ! Modifier le code ci-dessous.
            panel.setBackground(Color.RED);
        } else {
            devoilerCaseVide();
        }
    }

    public void devoilerCasesVoisines() {
        int i = this.getX() / 20;
        int j = this.getY() / 20;
        for (int a = (i - 1); a < (i + 2); a += 1) {
            for (int b = (j - 1); b < (j + 2); b += 1) {
                if (((a >= 0) && (a < 20)) && ((b >= 0) && (b < 20))) {
                    if (!board.getBoardCase(a, b).getContent().equals("X") && !board.getBoardCase(a, b).isDevoilee()) {
                        board.getBoardCase(a, b).devoilerCaseVide();
                        panel.repaint();
                    }
                }
            }
        }
    }

    public void devoilerCaseVide() {
        this.devoilee = true;
        panel.removeAll();
        JLabel label = new JLabel();
        label.setBounds(5, 0, 20, 20);
        panel.setBackground(Color.LIGHT_GRAY);
        if (this.getContent().equals("0")) {
            panel.setBackground(Color.WHITE);
            this.devoilerCasesVoisines();
        } else if (this.getContent().equals("1")) {
            label.setText(this.getContent());
            label.setForeground(Color.BLUE);
        } else if (this.getContent().equals("2")) {
            label.setText(this.getContent());
            label.setForeground(Color.MAGENTA);
        } else {
            label.setText(this.getContent());
            label.setForeground(Color.BLACK);
        }
        panel.add(label);
        panel.repaint();
    }

    public void marquerCaseAvecBombe() {
        panel.removeAll();
        JLabel label = new JLabel("V");
        label.setBounds(5, 0, 20, 20);
        label.setForeground(Color.RED);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.add(label);
        panel.add(label);
        panel.repaint();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Color getBgColor() {
        return bgColor;
    }

    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
    }

    public boolean isDevoilee() {
        return devoilee;
    }

}