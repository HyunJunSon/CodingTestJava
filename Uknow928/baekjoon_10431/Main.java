package baekjoon_10431;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int caseCount = Integer.parseInt(br.readLine());
		for (int i = 0; i < caseCount; i++) {
			int[] test = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int sum =0;
			for (int j = 1; j < 21; j++) {
				for (int k = j - 1; k >= 1; k--) {
					if (test[k] > test[j]) {
						sum ++;
					}
				}
			}
			sb.append(test[0] + " " + sum + "\n");
		}
		System.out.println(sb);


	}
}
