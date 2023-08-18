package eggproblem;

import java.math.BigInteger;

public class Egg {
    public static void main(String[] args) {
        BigInteger eggs = BigInteger.ONE;

        for (int i = 2; i <= 38; i++) {
            BigInteger power = BigInteger.valueOf(i - 1).pow(i);
            eggs = power.add(eggs);
        }

        System.out.println("38th person will have " + eggs);
    }
}
