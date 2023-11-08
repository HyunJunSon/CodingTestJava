package stonehee.baekjoon.stoneHee;

import java.io.BufferedReader;
import java.io.IOException;

// 백준 2744번 문제: 대소문자 바꾸기
public class SwitchUpperWithLower {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(switchUpperWithLower(str));
    }

    public static String switchUpperWithLower(String str) {
        StringBuilder sb = new StringBuilder();
        for(char ch : str.toCharArray()) {
            sb.append(Character.isLowerCase(ch) ? Character.toUpperCase(ch) : Character.toLowerCase(ch));
        }
        return sb.toString();
    }
}
