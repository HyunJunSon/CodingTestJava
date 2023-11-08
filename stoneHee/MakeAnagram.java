package stonehee.baekjoon.stoneHee;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeMap;

// 백준 1919번 문제: 애너그램 만들기
public class MakeAnagram {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int cnt = 0;

        TreeMap<Character, Integer> str1Map = getStrMap(str1);
        TreeMap<Character, Integer> str2Map = getStrMap(str2);

        for (char ch = 'a'; ch <= 'z'; ch++) {
            int cnt1 = str1Map.getOrDefault(ch, 0);
            int cnt2 = str2Map.getOrDefault(ch, 0);
            cnt += Math.abs(cnt1 - cnt2);
        }

        System.out.println(cnt);
    }

    private static TreeMap<Character, Integer> getStrMap(String str) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for(char ch : str.toCharArray()) {
            addOrUpdateKeyValue(map, ch);
        }
        return map;
    }

    private static void addOrUpdateKeyValue(TreeMap<Character, Integer> map, char key) {
        map.compute(key, (k, v) -> (v == null) ? 1 : v + 1);
    }


}
