package StringExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        Function<Character, Character> toggleCase = ch -> Character.isLowerCase(ch) ? Character.toUpperCase(ch) : Character.toLowerCase(ch);
        String convertedString = convertString(word, toggleCase);

        System.out.println(convertedString);
    }

    public static String convertString(String input, Function<Character, Character> converter) {
        return input.chars()
                .mapToObj(c -> (char) c)
                .map(converter)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}
