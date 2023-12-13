package org.example.bj2840;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numberArray = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        char[] resultCharArray = new char[numberArray[0]];

        char[] inputCharArray = new char[numberArray[1]];
        int[] rotationArray = new int[numberArray[1]];

        for(int i=0; i<numberArray[0]; i++) {
            resultCharArray[i] = '?';
        }

        for(int j=0; j<numberArray[1]; j++) {
            Object[] rotationInput = Arrays.stream(br.readLine().split(" "))
                    .toArray();
            rotationArray[j] = Integer.parseInt(rotationInput[0].toString());
            inputCharArray[j] = rotationInput[1].toString().charAt(0);
        }

        int curLocation = 0;
        for (int k=numberArray[1]-1; k>=0; k--) {
            if (curLocation >= numberArray[0]) {
                curLocation %= numberArray[0];
            }

            if (resultCharArray[curLocation] == '?') {
                resultCharArray[curLocation] = inputCharArray[k];
            }

            if (resultCharArray[curLocation] != '?' && (resultCharArray[curLocation] != inputCharArray[k])) {
                System.out.print("!");
                System.exit(0);
            }

            curLocation += rotationArray[k];
        }

        int uniqueChar = 0;
        for (char ch: resultCharArray) {
            if (ch != '?') {
                uniqueChar += 1;
            }
        }

        Set<Character> uniqueCharSet = new HashSet<>();
        for (char c : resultCharArray) {
            uniqueCharSet.add(c);
        }
        uniqueCharSet.remove('?');
        if(uniqueCharSet.size() != uniqueChar) {
            System.out.print("!");
            System.exit(0);
        }
        System.out.print(resultCharArray);
    }
}

