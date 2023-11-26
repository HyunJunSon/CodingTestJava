package baekjoon_3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int arrSize = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int sum = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0, j = 1; i < arrSize; i++) {
            if (i >= arrSize - j) break;

            if (arr[i] + arr[arrSize - j] > sum) {
                j++;
                i--;
                continue;
            }

            if (arr[i] + arr[arrSize - j] == sum) {
                answer++;
                j++;
            }
        }

        System.out.println(answer);
    }
}