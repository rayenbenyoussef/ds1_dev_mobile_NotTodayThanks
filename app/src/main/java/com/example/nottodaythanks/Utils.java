package com.example.nottodaythanks;

public class Utils {
    public static String  MARAM_NUMBER="587";
    public static String RAYEN_NUMBER="815";
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
