package StringExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word1 = br.readLine();
        String word2 = br.readLine();

        int cnt = 0;
        char[] wordToken1 = new char[26];
        char[] wordToken2 = new char[26];

        word1.chars()
                .mapToObj(c -> (char) c)
                .forEach(ch -> {
                    if (Character.isAlphabetic(ch)) {
                        wordToken1[ch - 'a']++;
                    }
                });

        word2.chars()
                .mapToObj(c -> (char) c)
                .forEach(ch -> {
                    if (Character.isAlphabetic(ch)) {
                        wordToken2[ch - 'a']++;
                    }
                });

        for (int i = 0; i < 26; i++) {
            cnt += Math.abs(wordToken1[i] - wordToken2[i]);
        }
        System.out.println(cnt);
    }
}
