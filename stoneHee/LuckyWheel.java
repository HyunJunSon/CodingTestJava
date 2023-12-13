package stonehee.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;

public class LuckyWheel {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        char[] wheel = new char[n];
        int currentIdx =  0;

        for(int i = 0; i < k; i++) {
            String[] ex = br.readLine().split(" ");
            int s = Integer.parseInt(ex[0]);
            char alphabet = ex[1].charAt(0);
            currentIdx = (currentIdx + s) % n;
            if(wheel[currentIdx] != 0 && wheel[currentIdx] != alphabet) {
                System.out.println("!");
                return;
            }
            wheel[currentIdx] = alphabet;
        }

        printWheelAlphabet(currentIdx, wheel);
    }

    static void printWheelAlphabet(int currentIdx, char[] wheel) {
        String result = "";
        for(int i = currentIdx; i >= 0; i--) {
            if(result.contains(Character.toString(wheel[i]))){
                System.out.println("!");
                return;
            }
            result += wheel[i] == 0 ? "?" : wheel[i];
        }
        for(int j = wheel.length - 1; j > currentIdx; j--) {
            if(result.contains(Character.toString(wheel[j]))){
                System.out.println("!");
                return;
            }
            result += wheel[j] == 0 ? "?" : wheel[j];
        }
        System.out.println(result);
    }

}
