import java.util.Scanner;

public class TicTacToe {

    static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    public static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public static boolean checkWin(char player) {
        // Rows & Columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player)
                return true;
        }

        // Diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
            return true;

        return false;
    }

    public static boolean isDraw() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ')
                    return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char player = 'X';

        while (true) {
            printBoard();

            System.out.println("Player " + player + ", enter row (0-2): ");
            int row = sc.nextInt();

            System.out.println("Player " + player + ", enter column (0-2): ");
            int col = sc.nextInt();

            // Check valid move
            if (board[row][col] != ' ') {
                System.out.println("Cell already taken! Try again.");
                continue;
            }

            board[row][col] = player;

            // Check win
            if (checkWin(player)) {
                printBoard();
                System.out.println("Player " + player + " wins!");
                break;
            }

            // Check draw
            if (isDraw()) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }

            // Switch player
            player = (player == 'X') ? 'O' : 'X';
        }

        sc.close();
    }
}