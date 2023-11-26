package stonehee.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lineUp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int caseNum = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> lineMap = new HashMap<>();
        for(int i = 0; i < caseNum; i++) {
            String[] cases = br.readLine().split(" ");
            int key = Integer.parseInt(cases[0]);
            List<Integer> line = new ArrayList<>();
            for(int j = 1; j <= 20; j++) {
                line.add(Integer.parseInt(cases[j]));
            }
            lineMap.put(key, line);
        }

        System.out.println(lineUp(lineMap, caseNum));
    }

    private static String lineUp(Map<Integer, List<Integer>> lineMap, int caseNum) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= caseNum; i++) {
            int walkCnt = calculateLine(lineMap.get(i));
            sb.append(i).append(" ").append(walkCnt).append("\n");
        }
        return sb.toString();
    }

    private static int calculateLine(List<Integer> list) {
        int cnt = 0;
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < i; j++) {
                if(list.get(i) < list.get(j)) cnt++;
            }
        }
        return cnt;
    }
}
