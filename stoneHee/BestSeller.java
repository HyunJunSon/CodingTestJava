package stonehee.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class BestSeller {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfBooksSold = Integer.parseInt(br.readLine());

        TreeMap<String, Integer> bookMap = new TreeMap<>();

        for(int i = 0 ; i < numberOfBooksSold; i++) {
            addOrUpdateKeyValue(bookMap, br.readLine());
        }

        String bestSeller = Collections.max(bookMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println(bestSeller);
    }

    private static void addOrUpdateKeyValue(TreeMap<String, Integer> map, String bookName) {
        map.compute(bookName, (k, v) -> (v == null) ? 1 : v + 1);
    }
}
