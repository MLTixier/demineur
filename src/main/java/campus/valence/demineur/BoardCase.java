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
    private boolean devoilee;
    private boolean cochee;
    private Game game;


    public BoardCase(int x, int y, String content, Board board, Game game) {
        this.game = game;
        this.board = board;
        this.content = content;
        this.panel = new JPanel(null);
        this.x = x;
        this.y = y;
        this.devoilee = false;
        this.cochee = false;
        panel.setBounds(x, y, 20, 20);
        panel.setBorder(BorderFactory.createRaisedBevelBorder());
        bgColor = Color.LIGHT_GRAY;
        panel.setBackground(bgColor);
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
            panel.setBackground(Color.RED);
            //Perdu !
            JLabel label = new JLabel("Vous avez perdu !",  SwingConstants.CENTER);
            label.setFont(new Font("Serif", Font.BOLD,20));
            label.setForeground(Color.RED);
            JFrame frame = new JFrame();
            frame.setLocation(200, 200);
            frame.add(label);
            frame.setSize(300,300);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        if (!this.isDevoilee()) {
            this.devoilee = true;
            panel.removeAll();
            JLabel label = new JLabel();
            label.setBounds(5, 0, 20, 20);
            panel.setBackground(Color.WHITE);
            if (this.getContent().equals("0")) {
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
            game.addNbCasesDevoilees(1);
        }
    }

    public void marquerCaseAvecBombe() {
        if (isDevoilee()){

        } else {
            if (isCochee()) {
                panel.removeAll();
                panel.setBackground(Color.LIGHT_GRAY);
                panel.repaint();
                game.addCompteurRestant(1);
                this.devoilee = false;
                this.cochee = false;
            } else {
                panel.removeAll();
                JLabel label = new JLabel("V");
                label.setBounds(5, 0, 20, 20);
                label.setForeground(Color.RED);
                panel.setBackground(Color.LIGHT_GRAY);
                panel.add(label);
                panel.add(label);
                panel.repaint();
                game.addCompteurRestant(-1);
                this.devoilee = true;
                this.cochee = true;
            }
        }
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


    public Game getGame() {
        return game;
    }


    public boolean isCochee() {
        return cochee;
    }

    public void setCochee(boolean cochee) {
        this.cochee = cochee;
    }

}