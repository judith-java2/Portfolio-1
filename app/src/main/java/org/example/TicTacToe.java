import java.util.Scanner;

public class TicTacToe {

    private static final String[] board = new String[9];
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Tic-Tac-Toe!");
        boolean playAgain;
        do {
            resetBoard();
            playGame();
            playAgain = askPlayAgain();
        } while (playAgain);
        System.out.println("Goodbye!");
    }

    // Reset the board to default numbered state
    public static void resetBoard() {
        for (int i = 0; i < 9; i++) {
            board[i] = String.valueOf(i + 1);
        }
    }

    // Print the current board
    public static void printBoard() {
        System.out.println();
        System.out.printf("  %s  |  %s  |  %s%n", board[0], board[1], board[2]);
        System.out.println("-----+-----+-----");
        System.out.printf("  %s  |  %s  |  %s%n", board[3], board[4], board[5]);
        System.out.println("-----+-----+-----");
        System.out.printf("  %s  |  %s  |  %s%n%n", board[6], board[7], board[8]);
    }

    // Run the main game loop
    public static void playGame() {
        String currentPlayer = "X";
        int moves = 0;
        boolean gameEnded = false;

        while (!gameEnded) {
            printBoard();
            int move = getValidMove();
            board[move - 1] = currentPlayer;
            moves++;

            if (isWinner(currentPlayer)) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                gameEnded = true;
            } else if (moves == 9) {
                printBoard();
                System.out.println("It's a draw!");
                gameEnded = true;
            } else {
                currentPlayer = currentPlayer.equals("X") ? "O" : "X";
            }
        }
    }

    // Prompt the player and return a valid move (1–9)
    public static int getValidMove() {
        while (true) {
            System.out.print("What is your move? ");
            String input = scanner.nextLine().trim();

            try {
                int move = Integer.parseInt(input);
                if (move < 1 || move > 9) {
                    System.out.println("That is not a valid move! Try again.");
                } else if (!board[move - 1].equals(String.valueOf(move))) {
                    System.out.println("That is not a valid move! Try again.");
                } else {
                    return move;
                }
            } catch (NumberFormatException e) {
                System.out.println("That is not a valid move! Try again.");
            }
        }
    }

    // Check if the given player has won
    public static boolean isWinner(String player) {
        int[][] winConditions = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
            {0, 4, 8}, {2, 4, 6}             // Diagonals
        };
        for (int[] condition : winConditions) {
            if (board[condition[0]].equals(player) &&
                board[condition[1]].equals(player) &&
                board[condition[2]].equals(player)) {
                return true;
            }
        }
        return false;
    }

    // Ask the user if they want to play again
    public static boolean askPlayAgain() {
        while (true) {
            System.out.print("Would you like to play again (yes/no)? ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("yes")) return true;
            if (input.equals("no")) return false;
            System.out.println("That is not a valid entry!");
        }
    }

    // Getter for test access
    public static String[] getBoard() {
        return board.clone();
    }

    // Setter for test access — testing use only
    public static void setBoard(String[] newBoard) {
        for (int i = 0; i < 9; i++) {
            board[i] = newBoard[i];
        }
    }
}
