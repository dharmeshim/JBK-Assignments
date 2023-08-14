package looping;

import java.util.Scanner;

public class DoWhileLoop {
	Scanner scan = new Scanner(System.in);

	public void dowhileOne() {
		System.out.println("Printing 1 to 25");
		int i = 1;

		do {
			System.out.println(i);
			i++;
		} while (i <= 25);
	}

	public void dowhileTwo() {
		System.out.println("Printing 25 to 1");

		int i = 25;
		do {
			System.out.println(i);
			i--;
		} while (i >= 1);
	}

	public void dowhileThree() {
		System.out.println("print 1 to 100 Odd nos");
		int i = 1;
		do {
			if (i % 2 != 0)
				System.out.println(i);
			i++;

		} while (i <= 100);
	}

	public void dowhileThree(int limit) {
		System.out.println("print 1 to " + limit + " Odd nos");
		int i = 1;
		do {
			if (i % 2 != 0)
				System.out.println(i);
			i++;

		} while (i <= 100);
	}

	public void dowhileFour() {
		System.out.println("To print 1 to 100 even nos\n");
		int i = 1;
		do {
			if (i % 2 == 0)
				System.out.println(i);
			i++;

		} while (i <= 100);

	}

	public void dowhileFour(int limit) {
		System.out.println("To print 1 to " + limit + " even nos\n");
		int i = 1;
		do {
			if (i % 2 == 0)
				System.out.println(i);
			i++;

		} while (i <= limit);

	}

	public void dowhileFive() {
		int sumOfOdd = 0;
		int i = 0;
		do {
			if (i % 2 != 0) {
				sumOfOdd += i;
			}
			i++;

		} while (i <= 50);
		System.out.println("sum of 1 to 50 Odd nos :" + sumOfOdd);
	}

	public void dowhileSix() {
		int sumOfEven = 0;
		int i = 1;
		do {
			if (i % 2 == 0) {
				sumOfEven += i;
			}
			i++;
		} while (i <= 50);
		System.out.println("sum of 1 to 50 Odd nos :" + sumOfEven);

	}

	public void dowhileFive(int limit) {
		int sumOfOdd = 0;
		int i = 1;
		do {
			if (i % 2 != 0) {
				sumOfOdd += i;
			}
			i++;

		} while (i <= limit);
		System.out.println("sum of 1 to " + limit + " Odd nos :" + sumOfOdd);

	}

	public void dowhileSix(int limit) {
		int sumOfEven = 0;
		int i = 1;
		do {
			if (i % 2 == 0) {
				sumOfEven += i;
			}
			i++;

		} while (i <= limit);
		System.out.println("sum of 1 to " + limit + " Even nos :" + sumOfEven);

	}

	public void dowhileSeven() {
		System.out.println("printing 145 to 45/n");
		int i = -45;
		do {
			System.out.println(i);
			i++;

		} while (i <= 45);

	}

	public void dowhileEight() {
		System.out.println("printing 50 to 100");
		int i = 50;
		do {
			System.out.println(i);
			i++;
		} while (i <= 100);
	}

	public void dowhileNine() {
		System.out.println("print sum of odd and even no");

		System.out.println("enter limit");
		int limit = scan.nextInt();
		dowhileFive(limit);
		dowhileSix(limit);

	}

	public void dowhileTen() {
		System.out.println("To print even and odd No");

		System.out.println("enter limit");
		int limit = scan.nextInt();
		dowhileFour(limit);
		dowhileThree(limit);

	}

	public void dowhileEleven() {
		System.out.println("Printing 1 to 100 no\n");
		int i = 1;
		do {
			System.out.println(i);
			i++;
		} while (i <= 100);
	}

	public void dowhileTwelve() {
		System.out.println("Printing 100 to 1 no\n");
		int i = 100;
		do {
			System.out.println(i);
			i--;
		} while (i >= 1);

	}

	public void dowhileThirteen() {
		System.out.println("Printing 30 to 50 numbers\n");
		int i = 30;
		do {
			System.out.println(i);
			i++;
		} while (i <= 50);
	}

	public void dowhileFourteen() {

		int countOfEven = 0;
		int i = 1;
		do {
			if (i % 2 == 0) {
				countOfEven++;
			}
			i++;

		} while (i <= 25);
		System.out.println("count of even No 1 to 25 no :" + countOfEven);

	}

	public void dowhileFifteen() {

		int countOfOdd = 0;
		int i = 1;
		do {
			if (i % 2 != 0) {
				countOfOdd++;
			}
			i++;

		} while (i <= 25);
		System.out.println("count of odd No 1 to 25 no :" + countOfOdd);
	}

	public void dowhileSixteen() {
		System.out.println("the Series... 2 4 6 8 10 12 14 16 18 20\n");
		System.out.println("Enter the limit :");
		int limit = scan.nextInt();
		int i = 2;
		do {
			System.out.print(i + " ");
			i += 2;

		} while (i <= limit);
	}

	public void dowhileSeventeen() {
		System.out.println("the Series... 9 18 27 36 45 54 63 72 81 90\n");
		System.out.println("Enter the limit :");
		int limit = scan.nextInt();
		int i = 9;
		do {
			System.out.print(i + " ");
			i += 9;

		} while (i <= limit);
	}

	public void dowhileEightteen() {
		System.out.println("the Series... 1 -2 3 -4 5 -6 7 -8 9 -10");
		System.out.println("Enter the limit :");
		int limit = scan.nextInt();
		int i = 1;
		do {
			if (i % 2 == 0) {
				System.out.print(i * (-1) + " ");
			} else {
				System.out.print(i + " ");
			}
			i++;

		} while (i <= limit);
	}

	public void dowhileNineteen() {
		System.out.println("the Series... 5 10 15 20 25 30 35 40 45 50\n");
		System.out.println("Enter the limit :");
		int limit = scan.nextInt();
		int i = 5;
		do {
			System.out.print(i + " ");
			i += 5;
		} while (i <= limit);
	}

	public void dowhileTwenty() {
		System.out.println("the Series... 1 10 100 1000\n");
		System.out.println("Enter the limit :");
		int limit = scan.nextInt();
		int i = 1;
		do {
			System.out.print(i + " ");
			i *= 10;

		} while (i <= limit);
	}

	public void dowhileTwentyOne() {
		System.out.println("the Series... 1  3  6  10  15  21  28  36  45\n");
		System.out.println("Enter the limit :");
		int limit = scan.nextInt();
		int j = 1;
		int i = 1;
		do {
			System.out.print(i + " ");
			j++;
			i = i + j;

		} while (i <= limit);
	}

	public void dowhileTwentyTwo() {
		System.out.println("the Series... 8 16 24 32 40 48 56 64 72 80\n");
		System.out.println("Enter the limit :");
		int limit = scan.nextInt();
		int i = 8;
		do {
			System.out.print(i + " ");
			i = i + 8;
		} while (i <= limit);
	}

	public void dowhileTwentyThree() {

		System.out.println("the Series... 0 1 1 2 3 5 8 13 21\n");
		System.out.println("Enter the limit :");
		int limit = scan.nextInt();
		int firstNumber = 0;

		int secondNumber = 1;

		int i = 1;
		do {
			System.out.print(firstNumber + " ");
			int next = firstNumber + secondNumber;
			firstNumber = secondNumber;
			secondNumber = next;
			i++;

		} while (i < limit);

	}

	public void dowhileTwentyFour() {
		System.out.println("the series... 1 4 9 16 25 36 49 64 81 100\n");
		System.out.println("Enter the limit :");
		int limit = scan.nextInt();
		int j = 1;
		int i = 1;
		do {
			System.out.print(i + " ");
			j += 2;
			i = i + j;

		} while (i <= limit);

	}

	public void dowhileTwentyFive() {
		System.out.println("the series... 3 6 9 12 15 18 21 24 27 30\n");
		System.out.println("Enter the limit :");
		int limit = scan.nextInt();
		int i = 3;
		do {
			System.out.print(i + " ");
			i = i + 3;
		} while (i <= limit);
	}

	public void dowhileTwentySix() {
		System.out.println("the Series... 7 14 21 28 35 42 49 56 63 70\n");
		System.out.println("Enter the limit :");
		int limit = scan.nextInt();
		int i = 7;
		do {
			System.out.print(i + " ");
			i = i + 7;
		} while (i <= limit);

	}

	public void dowhileTwentySeven() {
		System.out.println("the Series... 4 8 12 16 20 24 28 32 36 40\n");
		System.out.println("Enter the limit :");
		int limit = scan.nextInt();
		int i = 4;
		do {
			System.out.print(i + " ");
			i = i + 4;
		} while (i <= limit);

	}

	public void dowhileTwentyEight() {
		System.out.println("the Series... 10 20 30 40 50 60 70 80 90 100\n");
		System.out.println("Enter the limit :");
		int limit = scan.nextInt();
		int i = 10;
		do {
			System.out.print(i + " ");
			i = i + 10;

		} while (i <= limit);

	}

	public void dowhileTwentyNine() {
		System.out.println("the Series... 1 2 3 4 5 4 3 2 1\n");
		System.out.println("Enter the Transaction point :");
		int limit = scan.nextInt();
		int i = 1;

		do {
			System.out.print(i + " ");
			i++;

		} while (i <= limit);
		i = limit - 1;
		do {
			System.out.print(i + " ");
			i--;
		} while (i >= 1);

	}

	public void dowhileThirty() {
		System.out.println("the Series... 6 12 18 24 30 36 42 48 54 60\n");
		System.out.println("Enter the limit :");
		int limit = scan.nextInt();
		int i = 6;
		do {
			System.out.print(i + " ");
			i = i + 6;

		} while (i <= limit);

	}

	

}
