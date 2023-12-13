package baekjoon_2817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final int RANK_LIMIT = 14;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int totalVotes = Integer.parseInt(br.readLine());
        int staffs = Integer.parseInt(br.readLine());
        Map<String, Integer> staffMap = new HashMap<>();

        for (int i = 0; i < staffs; i++) {
            String[] voteInfo = br.readLine().split(" ");
            String staff = voteInfo[0];
            int votesByStaff = Integer.parseInt(voteInfo[1]);

            if (totalVotes * 0.05 <= votesByStaff) {
                staffMap.put(staff, votesByStaff);
            }
        }

        Map<String, Integer> votingResult = getVotingResult(staffMap);
        for (String key : staffMap.keySet()) {
            System.out.println(key + " " + votingResult.getOrDefault(key, 0));
        }
    }

    private static Map<String, Integer> getVotingResult(Map<String, Integer> staffMap) {
        Map<Double, String> scoreMap = getScoreMap(staffMap);
        List<Double> sortedScore = scoreMap.keySet().stream().sorted(Comparator.reverseOrder())
                    .limit(RANK_LIMIT).collect(Collectors.toList());

        Map<String, Integer> resultMap = new HashMap<>();
        for (double score : sortedScore) {
            String staff = scoreMap.get(score);
            int currentChip = resultMap.getOrDefault(staff, 0) + 1;

            resultMap.put(staff, currentChip);
        }

        return resultMap;
    }

    private static Map<Double, String> getScoreMap(Map<String, Integer> staffMap) {
        Map<Double, String> scoreMap = new HashMap<>();

        for (String key : staffMap.keySet()) {
            for (int i = 1; i <= RANK_LIMIT; i++) {
                scoreMap.put((double) staffMap.get(key) / i, key);
            }
        }

        return scoreMap;
    }
}