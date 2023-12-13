package baekjoon_11005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] nums = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        StringBuilder sb = getAnswer(nums);

        System.out.println(sb.reverse());
    }

    private static StringBuilder getAnswer(int[] nums) {
        StringBuilder sb = new StringBuilder();
        int n = nums[0];

        while (true) {
            if (n < nums[1]) {
                sb.append(getDigit(n));
                break;
            }

            int remain = n % nums[1];
            n /= nums[1];
            sb.append(getDigit(remain));
        }
        return sb;
    }

    private static String getDigit(int num) {
        if (num >= 10) {
            return String.valueOf((char) (num + ('A' - 10)));
        }

        return String.valueOf(num);
    }
}