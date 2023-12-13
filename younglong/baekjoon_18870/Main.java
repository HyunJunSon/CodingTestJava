package baekjoon_18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int[] sorted = Arrays.stream(inputs).mapToInt(Integer::parseInt).sorted().toArray();

        Map<Integer, Integer> map = new HashMap<>();
        int order = 0;
        for (int i = 0; i < sorted.length; i++) {
            if (!map.containsKey(sorted[i])) {
                map.put(sorted[i], order++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(map.get(Integer.parseInt(inputs[i])));
            if (i != size - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}