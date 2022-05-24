package campus.valence.demineur;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static java.lang.Math.random;

public class Demineur {

    public static Demineur create(int bombCount, int boardSize, int startX, int startY) {
        if ((startX >= boardSize) || (startX >= boardSize)) {
            throw new RuntimeException("position de départ out of bounds");
        }
        Set<Case.BombCase> bombes = generateBombsSet(bombCount, boardSize, startX, startY);
        Demineur demineur = generateDemineurBoard(bombes, boardSize);
        return demineur;
    }

    private static Demineur generateDemineurBoard(Set<Case.BombCase> bombes, int boardSize) {
        Case[][] board = new Case[boardSize][boardSize];
        //on remplit le tableau board avec les bombes données dans le set bombes :
        for (Case.BombCase bomb : bombes) {
            board[bomb.getX()][bomb.getY()] = bomb;
        }
        //on remplit le tableau board avec des cases vides en-dehors des bombes :
        int i = 0;
        int j = 0;
        for (Case[] row : board) {
            for (Case oneCase : row) {
                if (oneCase == null) {
                    oneCase = new Case.ClearCase(i, j);
                }
                j++;
            }
            j = 0;
            i++;
        }
        Demineur demineur = new Demineur(board);
        return demineur;
    }

    private static Set<Case.BombCase> generateBombsSet(int bombCount, int boardSize, int startX, int startY) {
        Set<Case.BombCase> bombes = new HashSet<>();
        while (bombes.size() < bombCount) {
            Random randX = new Random();
            int x = randX.nextInt(boardSize);
            Random randY = new Random();
            int y = randY.nextInt(boardSize);
            if (((x < startX + 3) && (x > startX - 3)) && ((y < startY + 3) && (y > startY - 3))) {
                //pas d'ajout de bombe à cet endroit "start"
            } else {
                Case.BombCase bomb = new Case.BombCase(x, y);
                bombes.add(bomb);
            }
        }
        return bombes;
    }

    private Case[][] board;

    protected Demineur(Case[][] board) {
        this.board = board;
    }

    String boardAsString() {
        String result = "";
        for (int i = 0; i < this.getBoard().length; i++) {
            result += "|";
            for (int j = 0; j < getBoard().length; j++) {
                if (this.board[i][j] instanceof Case.BombCase) {
                    result += "X";
                } else {
                    int count = countBombsAround(i, j);
                    result += count;
                }
            }
            result += "|\n";
        }
        return result.toString();
    }

    public Case[][] getBoard() {
        return board;
    }

    public int countBombsAround(int i, int j) {
        int count = 0;
        //parcourt toutes les cases autour de cette case :
        for (int a = i - 1; a < i + 2; a++) {
            for (int b = j - 1; b < j + 2; b++) {
                if ((b < 0) || (a < 0) || (a >= getBoard().length) || (b >= getBoard().length)) {
                    //pas de décompte : on touche le bord du plateau"
                } else {
                    if (this.board[a][b] instanceof Case.BombCase) {
                        count += 1;
                    }
                }
            }
        }
        return count;
    }

    public String giveContent(int x, int y) {
        String result = "";
        if (this.board[x][y] instanceof Case.BombCase) {
            result = "X";
        } else {
            int count = countBombsAround(x, y);
            result = String.valueOf(count);
        }
        return result;
    }
}
