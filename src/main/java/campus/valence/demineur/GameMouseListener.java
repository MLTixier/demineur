package campus.valence.demineur;

import javax.swing.*;
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
            System.out.println("vous avez gagné !");
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
