package HorseChess;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Horse {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the horse position:");
		System.out.print("Row: ");
		int y = scanner.nextInt();
		System.out.print("Col: ");
		int x = scanner.nextInt();

		List<String> possibleMoves = calculatePossibleKnightMoves(x, y);

		while (true) {
			System.out.println("Possible knight moves:");
			printChessboard(x, y, possibleMoves);

			scanner.nextLine();

			boolean validMove = false;
			int nextX = 0, nextY = 0;

			while (!validMove) {
				System.out.println("Enter your next move:");

				System.out.print("Row: ");
				nextY = scanner.nextInt();
				System.out.print("Col: ");
				nextX = scanner.nextInt();

				String move = "(" + nextX + "," + nextY + ")";
				if (possibleMoves.contains(move)) {
					validMove = true;
				} else {
					System.out.println("Invalid move! Try again.");
				}
			}

			possibleMoves = calculatePossibleKnightMoves(nextX, nextY);
			x = nextX;
			y = nextY;
		}
	}

	public static List<String> calculatePossibleKnightMoves(int x, int y) {
		List<String> possibleMoves = new ArrayList<>();
		int[] horseindirectionx = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int[] horseindirectionY = { 1, 2, 2, 1, -1, -2, -2, -1 };

		for (int i = 0; i < horseindirectionx.length; i++) {
			int newX = x + horseindirectionx[i];
			int newY = y + horseindirectionY[i];

			if (newX >= 1 && newX <= 8 && newY >= 1 && newY <= 8) {
				possibleMoves.add("(" + newX + "," + newY + ")");
			}
		}

		return possibleMoves;
	}

	public static void printChessboard(int x, int y, List<String> moves) {
		char[][] board = new char[8][8];
		x--;
		y--;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				board[i][j] = '.';
			}
		}

		// Place the horse 
		board[y][x] = 'H';

		// Place moves 
		for (String move : moves) {
			int moveX = Integer.parseInt(move.substring(1, move.indexOf(","))) - 1;
			int moveY = Integer.parseInt(move.substring(move.indexOf(",") + 1, move.indexOf(")"))) - 1;
			board[moveY][moveX] = 'M';
		}

	
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
