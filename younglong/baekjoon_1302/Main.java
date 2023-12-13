package baekjoon_1302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int max = 0;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            String title = br.readLine();
            int count = map.getOrDefault(title, 0) + 1;
            map.put(title, count);

            if(max < count) {
                max = count;
            }
        }

        List<String> list = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key) == max) {
                list.add(key);
            }
        }

        Collections.sort(list);
        System.out.println(list.get(0));
    }
}