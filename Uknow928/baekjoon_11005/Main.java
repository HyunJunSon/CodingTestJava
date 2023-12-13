package baekjoon_11005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = array[0];
		int b = array[1];
		List<Character> result = new ArrayList<>();
		while (n > 0) {
			if (n % b >=10) {
				result.add((char)(n%b -10 + 'A'));
			} else {
				result.add((char)(n%b+ '0'));
			}
			n /= b;

		}
		StringBuilder sb = new StringBuilder();
		for (int i=0; i < result.size(); i++) {
			sb.append(result.get(result.size() - i-1));
		}
		System.out.println(sb);

	}
}
