package baekjoon_2744;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] cArr = sc.nextLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        int diff = 'a' - 'A';

        for(char c : cArr) {
            int num = c < 'a' ? c + diff : c - diff;
            sb.append((char) num);
        }

        System.out.println(sb);
    }
}