import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input1 = br.readLine();
        String input2 = br.readLine();

        Map<Character, Integer> map = new HashMap<>();
        int matchCount = 0;

        for (char c : input1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : input2.toCharArray()) {
            if(map.containsKey(c) && map.get(c) > 0) {
                matchCount++;
                map.put(c, map.get(c) - 1);
            }
        }

        System.out.println(input1.length() + input2.length() - matchCount * 2);
    }
}