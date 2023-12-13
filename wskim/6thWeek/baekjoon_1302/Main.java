package org.example.bj1302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    private static String findHighestKey(TreeMap<String, Integer> treeMap) {
        Map.Entry<String, Integer> highestEntry = null;
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            if (highestEntry == null || entry.getValue() > highestEntry.getValue()) {
                highestEntry = entry;
            }
        }
        return (highestEntry != null) ? highestEntry.getKey() : null;
    }

    private static void updateFrequency(TreeMap<String, Integer> frequencyMap, String word) {
        if (frequencyMap.containsKey(word)) {
            frequencyMap.put(word, frequencyMap.get(word) + 1);
        } else {
            frequencyMap.put(word, 1);
        }
    }

    public static void main(String[] args) throws IOException {

        // 이 문제는 트리맵을 적용하여 풀었음
        // 이유는 키 값이 오름차순으로 자동 정렬되므로 최대값 밸류 쌍을 찾을 때
        // 동점이 있을 경우 사전순으로 정렬된 값중 가장 우선인 책을 고를 수 있기 때문
        TreeMap<String, Integer> treeMapBook = new TreeMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int iterationCount = Integer.parseInt(br.readLine());

        for (int i=0; i < iterationCount; i++) {
            String inputBook = br.readLine();

            // 책 제목을 읽은 후 treeMapBook에 업데이트를 합니다.
            // 키 값에 없는 책 제목일 경우 밸류 쌍은 1로 초기화
            // 키 값에 있는 책 제목일 격우 밸류 쌍은 1을 더해줌
            updateFrequency(treeMapBook, inputBook);
        }

        // treeMapBook에서 가장 높은 밸류값을 지니는 책을 찾아 출력합니다.
        System.out.print(findHighestKey(treeMapBook));
    }
}
