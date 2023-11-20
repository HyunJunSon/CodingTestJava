package org.example.bj3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static StringBuilder stringBuilder = new StringBuilder();
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int numberCount = Integer.parseInt(bufferedReader.readLine());

        int[] numberArray = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(numberArray);

        int sumResult = Integer.parseInt(bufferedReader.readLine());
        int result = 0;

        for(int i=0; i<numberCount-1; i++) {
            for(int j=i+1; j<numberCount; j++) {
                if (numberArray[i] + numberArray[j] == sumResult) {
                    result += 1;
                }
                if (sumResult - numberArray[i] < numberArray[j]) {
                    break;
                }

            }
        }
        stringBuilder.append(result);
        System.out.print(stringBuilder);
    }
}

