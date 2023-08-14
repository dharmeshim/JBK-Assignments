package looping;

import java.util.Scanner;

public class ForLoop {

	Scanner scan = new Scanner(System.in);

	public void forOne() {
		System.out.println("print 1 to 25 nos");
		for (int i = 1; i <= 25; i++) {
			System.out.println(i);
		}
	}

	public void forTwo() {
		System.out.println("print 25 to 1 nos");
		for (int i = 25; i >= 1; i--) {
			System.out.println(i);
		}
	}

	public void forThree() {
		System.out.println("print 1 to 100 Odd nos");
		for (int i = 1; i <= 100; i++) {
			if (i % 2 != 0)
				System.out.println(i);
		}

	}
	
	public void forThree(int limit) {
		System.out.println("print 1 to "+limit+" Odd nos");
		for (int i = 1; i <= limit; i++) {
			if (i % 2 != 0)
				System.out.println(i);
		}

	}

	public void forFour() {
		System.out.println("print 1 to 100 even nos");
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0)
				System.out.println(i);
		}

	}
	
	public void forFour(int limit) {
		System.out.println("print 1 to "+limit+" even nos");
		for (int i = 1; i <= limit; i++) {
			if (i % 2 == 0)
				System.out.println(i);
		}

	}

	public void forFive() {
		int sumOfOdd = 0;
		for (int i = 1; i <= 50; i++) {
			if (i % 2 != 0) {
				sumOfOdd += i;
			}

		}
		System.out.println("sum of 1 to 50 Odd nos :" + sumOfOdd);
	}

	public void forSix() {
		int sumOfEven = 0;
		for (int i = 1; i <= 50; i++) {
			if (i % 2 == 0) {
				sumOfEven += i;
			}

		}
		System.out.println("sum of 1 to 50 Odd nos :" + sumOfEven);

	}

	public void forFive(int limit) {
		int sumOfOdd = 0;
		for (int i = 1; i <= limit; i++) {
			if (i % 2 != 0) {
				sumOfOdd += i;
			}

		}
		System.out.println("sum of 1 to " + limit + " Odd nos :" + sumOfOdd);
	}

	public void forSix(int limit) {
		int sumOfEven = 0;
		for (int i = 1; i <= limit; i++) {
			if (i % 2 == 0) {
				sumOfEven += i;
			}

		}
		System.out.println("sum of 1 to " + limit + " Even nos :" + sumOfEven);

	}

	public void forSeven() {
		System.out.println("To print -45 to +45 nos");
		for (int i = -45; i <= 45; i++) {
			System.out.println(i);
		}

	}

	public void forEight() {
		System.out.println("print 50 to 100 nos");
		for (int i = 50; i <= 100; i++) {
			System.out.println(i);
		}

	}

	public void forNine() {
		System.out.println("print sum of odd and even no");

		System.out.println("enter limit");
		int limit = scan.nextInt();
		forFive(limit);
		forSix(limit);

	}

	public void forTen() {
		System.out.println("print even and odd No");

		System.out.println("enter limit");
		int limit = scan.nextInt();
		forFour(limit);
		forThree(limit);

	}

	public void forEleven() {
		System.out.println("Printing 1 to 100 no\n");
		for (int i = 1; i <= 100; i++) {
			System.out.println(i);
		}

	}

	public void forTwelve() {
		System.out.println("Printing 100 to 1 no\n");
		for (int i = 100; i >= 1; i--) {
			System.out.println(i);
		}

	}

	public void forThirteen() {
		System.out.println("Printing 30 to 50 numbers\n");
		for (int i = 30; i <= 50; i++) {
			System.out.println(i);
		}

	}

	public void forFourteen() {

		int countOfEven = 0;
		for (int i = 1; i <= 25; i++) {
			if (i % 2 == 0) {
				countOfEven++;
			}
		}
		System.out.println("count of even No 1 to 25 no :" + countOfEven);

	}

	public void forFifteen() {

		int countOfOdd = 0;
		for (int i = 1; i <= 25; i++) {
			if (i % 2 != 0) {
				countOfOdd++;
			}
		}
		System.out.println("count of odd No 1 to 25 no :" + countOfOdd);
	}

	public void forSixteen() {
		System.out.println("the Series... 2 4 6 8 10 12 14 16 18 20\n");
		System.out.println("Enter the limit :");
		int limit = scan.nextInt();
		for (int i = 2; i <= limit; i += 2) {
			System.out.print(i + " ");
		}
	}

	public void forSeventeen() {
		System.out.println("the Series... 9 18 27 36 45 54 63 72 81 90\n");
		System.out.println("Enter the limit :");
		int limit = scan.nextInt();
		for (int i = 9; i <= limit; i += 9) {
			System.out.print(i + " ");
		}
	}

	public void forEightteen() {
		System.out.println("the Series... 1 -2 3 -4 5 -6 7 -8 9 -10");
		System.out.println("Enter the limit :");
		int limit = scan.nextInt();
		for (int i = 1; i <= limit; i++) {
			if (i % 2 == 0) {
				System.out.print(i * (-1) + " ");
			} else {
				System.out.print(i + " ");
			}
		}
	}
	
	public void forNineteen() {
		System.out.println("the Series... 5 10 15 20 25 30 35 40 45 50\n");
		System.out.println("Enter the limit :");
		int limit = scan.nextInt();
		for (int i = 5; i <= limit; i += 5) {
			System.out.print(i + " ");
		}
	}
	
	public void forTwenty() {
		System.out.println("the Series... 1 10 100 1000\n");
		System.out.println("Enter the limit :");
		int limit = scan.nextInt();
		for (int i = 1; i <= limit; i *= 10) {
			System.out.print(i + " ");
		}
	}
	
	public void forTwentyOne() {
		System.out.println("the Series... 1  3  6  10  15  21  28  36  45\n");
		System.out.println("Enter the limit :");
		int limit = scan.nextInt();
		int j=1;
		for (int i = 1; i <= limit; i = i+j) {
			System.out.print(i + " ");
			j++;
		}
	}
	
	public void forTwentyTwo() {
		System.out.println("the Series... 8 16 24 32 40 48 56 64 72 80\n");
		System.out.println("Enter the limit :");
		int limit = scan.nextInt();
		for (int i = 8; i <= limit; i = i+8) {
			System.out.print(i + " ");
		}
	}
	
	public void forTwentyThree() {
		System.out.println("the Series... 0 1 1 2 3 5 8 13 21\n");
		System.out.println("Enter the limit :");
		int limit = scan.nextInt();
		int firstNumber = 0;
		
		int secondNumber =1;
		for (int i = 1; i < limit; i++) {
			System.out.print(firstNumber + " ");
			int next = firstNumber + secondNumber;
			firstNumber = secondNumber;
			secondNumber = next;
		}
	}
	
	public void forTwentyFour() {
		System.out.println("the series... 1 4 9 16 25 36 49 64 81 100\n");
		System.out.println("Enter the limit :");
		int limit = scan.nextInt();
		int j=1;
		for (int i = 1; i <= limit; i = i+j) {
			System.out.print(i + " ");
			j+=2;
		}
	}
	
	public void forTwentyFive() {
		System.out.println("the series... 3 6 9 12 15 18 21 24 27 30\n");
		System.out.println("Enter the limit :");
		int limit = scan.nextInt();
		for (int i = 3; i <= limit; i = i+3) {
			System.out.print(i + " ");
		}
	}
	
	public void forTwentySix() {
		System.out.println("the Series... 7 14 21 28 35 42 49 56 63 70\n");
		System.out.println("Enter the limit :");
		int limit = scan.nextInt();
		for (int i = 7; i <= limit; i = i+7) {
			System.out.print(i + " ");
		}
	}
	
	public void forTwentySeven() {
		System.out.println("the Series... 4 8 12 16 20 24 28 32 36 40\n");
		System.out.println("Enter the limit :");
		int limit = scan.nextInt();
		for (int i = 4; i <= limit; i = i+4) {
			System.out.print(i + " ");
		}
	}
	
	public void forTwentyEight() {
		System.out.println("the Series... 10 20 30 40 50 60 70 80 90 100\n");
		System.out.println("Enter the limit :");
		int limit = scan.nextInt();
		for (int i = 10; i <= limit; i = i+10) {
			System.out.print(i + " ");
		}
	}
	
	public void forTwentyNine() {
		System.out.println("the Series... 1 2 3 4 5 4 3 2 1\n");
		System.out.println("Enter the Transaction point :");
		int limit = scan.nextInt();
        for (int i = 1; i <= limit; i++) {
            System.out.print(i + " ");
        }

        for (int i = limit - 1; i >= 1; i--) {
            System.out.print(i + " ");
        }
    }
	
	public void forThirty() {
		System.out.println("the Series... 6 12 18 24 30 36 42 48 54 60\n");
		System.out.println("Enter the limit :");
		int limit = scan.nextInt();
		for (int i = 6; i <= limit; i = i+6) {
			System.out.print(i + " ");
		}
	}
	
	
	
	

}
