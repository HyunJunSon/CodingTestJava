package baekjoon_10431;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < totalCase; i++) {
            String[] testCase = br.readLine().split(" ");
            int[] heightArr = Arrays.stream(testCase).skip(1).mapToInt(Integer::parseInt).toArray();

            System.out.println((i + 1) + " " + lineUp(heightArr));
        }

    }

    private static int lineUp(int[] arr) {
        int moveBackCnt = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    moveBackCnt++;
                }
            }
        }

        return moveBackCnt;
    }
}