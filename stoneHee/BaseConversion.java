package stonehee.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;

public class BaseConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        System.out.println(convertNumToB(n, b));
    }

    static String convertNumToB(int num, int b) {
        return Integer.toString(num, b).toUpperCase();
    }
}
