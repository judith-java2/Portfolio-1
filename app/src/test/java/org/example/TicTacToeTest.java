import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    @BeforeEach
    public void setUp() {
        TicTacToe.resetBoard();
    }

    @Test
    public void testInitialBoardSetup() {
        String[] board = TicTacToe.getBoard();
        for (int i = 0; i < 9; i++) {
            assertEquals(String.valueOf(i + 1), board[i]);
        }
    }

    @Test
    public void testIsWinnerHorizontal() {
        String[] testBoard = {
            "X", "X", "X",
            "4", "5", "6",
            "7", "8", "9"
        };
        TicTacToe.setBoard(testBoard);
        assertTrue(TicTacToe.isWinner("X"));
    }

    @Test
    public void testIsWinnerVertical() {
        String[] testBoard = {
            "1", "O", "3",
            "4", "O", "6",
            "7", "O", "9"
        };
        TicTacToe.setBoard(testBoard);
        assertTrue(TicTacToe.isWinner("O"));
    }

    @Test
    public void testIsWinnerDiagonal() {
        String[] testBoard = {
            "X", "2", "3",
            "4", "X", "6",
            "7", "8", "X"
        };
        TicTacToe.setBoard(testBoard);
        assertTrue(TicTacToe.isWinner("X"));
    }

    @Test
    public void testNoWinner() {
        String[] testBoard = {
            "X", "O", "X",
            "X", "O", "O",
            "O", "X", "X"
        };
        TicTacToe.setBoard(testBoard);
        assertFalse(TicTacToe.isWinner("X"));
        assertFalse(TicTacToe.isWinner("O"));
    }
}
