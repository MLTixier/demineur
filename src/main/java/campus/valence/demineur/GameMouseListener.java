package campus.valence.demineur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameMouseListener implements MouseListener {

    private BoardCase boardCase;

    public GameMouseListener(BoardCase boardCase) {
        this.boardCase = boardCase;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (this.boardCase.getGame().getNbCasesDevoilees() == 399 && this.boardCase.getGame().getCompteurRestant() == 0) {
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
        } else if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
            boardCase.devoilerCase();
        } else if (mouseEvent.getButton() == 3) {
            boardCase.marquerCaseAvecBombe();
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

}
