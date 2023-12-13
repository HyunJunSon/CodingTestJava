package stonehee.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CompressCoordinate {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] arr = br.readLine().split(" ");
        int[] coordinates = convertStirngArrayToIntegerArray(arr);
        int[] temp = coordinates.clone();
        Arrays.sort(coordinates);

        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int coordinate : coordinates) {
            if(!map.containsKey(coordinate)) map.put(coordinate, cnt++);
        }

        StringBuilder sb = new StringBuilder();
        for(int num : temp) {
            sb.append(map.get(num)).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static int[] convertStirngArrayToIntegerArray(String[] arr) {
        int[] result = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            result[i] = Integer.parseInt(arr[i]);
        }

        return result;
    }

}
