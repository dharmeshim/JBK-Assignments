package vowels;

import java.util.Scanner;

public class VowelsCheck {

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("enter a word");
        String word = scanner.nextLine();

        boolean containsVowels = false;

        for (char c : word.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                containsVowels = true;
                break;
            }
        }

        if (containsVowels) {
            System.out.println("contains");
        } else {
            System.out.println("not contains");
        }
    }
}
																																																																																																																											