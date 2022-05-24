package campus.valence.demineur;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class DemineurTest {

    @Test
    public void shouldHaveNoBombWhenGeneratedWithZero() {
        // Given
        int bombCount = 0;
        int boardSize = 10;
        int startX = 3;
        int startY = 3;

        // When
        Demineur demineur = Demineur.create(bombCount, boardSize, startX, startY);

        // Then
        int count = countBombCases(demineur);
        assertEquals(0, count);
    }

    @Test
    public void shouldHaveFewBombWhenGenerated() {
        // Given
        int bombCount = 12;
        int boardSize = 10;
        int startX = 3;
        int startY = 3;

        // When
        Demineur demineur = Demineur.create(bombCount, boardSize, startX, startY);

        // Then
        int count = countBombCases(demineur);
        assertEquals(12, count);
    }

    @Test
    public void shouldHaveAllBombsWhenFull() {
        // Given
        int bombCount = 70;
        int boardSize = 10;
        int startX = 0;
        int startY = 0;

        // When
        Demineur demineur = Demineur.create(bombCount, boardSize, startX, startY);

        // Then
        int count = countBombCases(demineur);
        assertEquals(70, count);
    }

    @Test
    public void shouldCountAllBombsAroundWhenNone() {
        // Given
        Demineur demineur = new Demineur(new Case[][]{
            new Case[]{new Case.ClearCase(0, 0), new Case.ClearCase(1, 0), new Case.ClearCase(2, 0),},
            new Case[]{new Case.ClearCase(0, 1), new Case.ClearCase(1, 1), new Case.ClearCase(2, 1),},
            new Case[]{new Case.ClearCase(0, 2), new Case.ClearCase(1, 2), new Case.ClearCase(2, 2),}
        });

        // When
        int count = demineur.countBombsAround(1, 1);

        // Then
        assertEquals(0, count);
    }

    @Test
    public void shouldCountAllBombsAroundWhenSome() {
        // Given
        Demineur demineur = new Demineur(new Case[][]{
            new Case[]{new Case.ClearCase(0, 0), new Case.ClearCase(1, 0), new Case.ClearCase(2, 0),},
            new Case[]{new Case.BombCase(0, 1), new Case.ClearCase(1, 1), new Case.ClearCase(2, 1),},
            new Case[]{new Case.ClearCase(0, 2), new Case.ClearCase(1, 2), new Case.BombCase(2, 2),}
        });

        // When
        int count = demineur.countBombsAround(1, 1);

        // Then
        assertEquals(2, count);
    }

    @Test
    public void shouldDisplayTheBoardWithBombsAndCount() {
        // Given
        Demineur demineur = new Demineur(new Case[][]{
                new Case[]{new Case.ClearCase(0, 0), new Case.ClearCase(1, 0), new Case.ClearCase(2, 0),},
                new Case[]{new Case.BombCase(0, 1), new Case.ClearCase(1, 1), new Case.ClearCase(2, 1),},
                new Case[]{new Case.ClearCase(0, 2), new Case.ClearCase(1, 2), new Case.BombCase(2, 2),}
        });

        // When
        String boardAsString = demineur.boardAsString();

        // Then
        assertEquals(boardAsString,
        "|110|\n" +
            "|X21|\n" +
            "|12X|\n"
        );
    }

    private int countBombCases(Demineur demineur) {
        int count= 0;
        for (Case[] row: demineur.getBoard()) {
            for (Case oneCase: row) {
                if (oneCase instanceof Case.BombCase) {
                    count++;
                }
            }
        }
        return count;
    }

}