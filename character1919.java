
import java.util.Scanner;


public class character1919 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫번째 문자열 입력:");
        String s1 = sc.nextLine();
        System.out.print("두번째 문자열 입력:");
        String s2 = sc.nextLine();

        int[] alpha1 = new int[26];
        for (char c : s1.toCharArray()) {
            alpha1[c - 'a']++;
        }

        int[] alpha2 = new int[26];
        for (char c : s2.toCharArray()) {
            alpha2[c - 'a']++;
        }

        int result = 0;
        for (int i = 0; i < 26; i++) {
            result += Math.abs(alpha1[i] - alpha2[i]);
        }

        System.out.println(result);


    }
}



