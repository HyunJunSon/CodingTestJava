package baekjoon_10448;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arrSize = Integer.parseInt(br.readLine());

        for (int i = 0; i < arrSize; i++) {
            int targetNum = Integer.parseInt(br.readLine());
            Map<Integer, Integer> triSumMap = getTriSumMap(targetNum);

            System.out.println(isSumOfTriNum(targetNum, triSumMap));
        }
    }

    private static int isSumOfTriNum(int target, Map<Integer, Integer> map) {
        int mapSize = map.size();
        for (int i = 1; i <= mapSize; i++) {
            for (int j = 1; j <= mapSize; j++) {
                for (int k = 1; k <= mapSize; k++) {
                    if(map.get(i) + map.get(j) + map.get(k) == target) {
                        return 1;
                    }
                }
            }
        }

        return 0;
    }

    private static Map<Integer, Integer> getTriSumMap(int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 1;

        while(true) {
            int result = i * (i + 1) / 2;
            if(result > target) break;

            map.put(i, result);
            i++;
        }

        return map;
    }
}