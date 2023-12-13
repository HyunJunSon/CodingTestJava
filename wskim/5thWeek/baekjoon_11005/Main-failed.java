package org.example.bj11005;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static char parseAlphabet(int number) {
        if (number >=0 && number < 10) {
            return Character.forDigit(number, 10);
        }
        return (char) (number + 55);
    }

    private static int getPower(int N, int power) {
        int result = 1;
        for (int i=0; i<power; i++) {
            result *= N;
        }
        return result;
    }

    private static int getMaximumDigit(int number, int notation) {
        int digit = 0;
        int currentNotation = notation;

        if (number < currentNotation) {
            return digit;
        }

        while (number >= currentNotation) {
            currentNotation *= notation;
            digit += 1;
        }

        return digit;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numberArray = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int number = numberArray[0];
        int notation = numberArray[1];
        int digit = getMaximumDigit(number, notation);
        int poweredDivisor = getPower(notation, digit + 1);

        char[] result = new char[digit + 1];

        for (int j=0; j<=digit; j++) {
            result[j] = parseAlphabet(number / poweredDivisor);
            number = number % poweredDivisor;
            poweredDivisor /= notation;
        }
        System.out.print(result);
    }
}
