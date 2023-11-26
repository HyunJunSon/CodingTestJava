package stonehee.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class SumForTwoNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int arrLen = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int x = Integer.parseInt(br.readLine());
        System.out.println(findPair(arr, x));
    }

    private static int findPair(int[] arr, int x) {
        Arrays.parallelSort(arr);

        int cnt = 0;
        int start = 0;
        int end = arr.length - 1;
        int sum = 0;

        while(start < end) {
            sum = arr[start] + arr[end];
            if(sum == x) cnt++;
            if(sum <= x) start++;
            else end--;
        }
        return cnt;
    }
}
