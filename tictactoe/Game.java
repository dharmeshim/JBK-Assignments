package tictactoe;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (true) {
            char[][] board = new char[3][3];
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    board[row][col] = '.';
                }
            }

            char player = 'X';
            boolean isGameOver = false;

            while (!isGameOver) {

                printBoard(board);
                System.out.println("Player " + player + " turn:");
                System.out.print("row:");
                int row = scan.nextInt() - 1;
                if (row < 0 || row > 2) {
                    System.out.println("Invalid! Try again");
                    continue;
                }
                System.out.println();
                System.out.print("col:");
                int col = scan.nextInt() - 1;
                if (col < 0 || col > 2) {
                    System.out.println("Invalid! Try again");
                    continue;
                }
                System.out.println();

                if (board[row][col] == '.') {
                    board[row][col] = player;
                    isGameOver = playerWon(board, player);
                    if (isGameOver) {
                        printBoard(board);
                        System.out.println("Player " + player + " has won: ");
                    } else if (isBoardFull(board)) {
                        printBoard(board);
                        System.out.println("It's a draw!");
                        break;
                    } else {
                        player = (player == 'X') ? 'O' : 'X';
                    }
                } else {
                    System.out.println("Invalid! Try again");
                }
            }

          
        }
    }

    private static boolean playerWon(char[][] board, char player) {
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    public static boolean isBoardFull(char board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printBoard(char[][] board) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}
