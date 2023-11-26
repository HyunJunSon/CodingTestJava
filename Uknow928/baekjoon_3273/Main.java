package baekjoon_3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int x = Integer.parseInt(br.readLine());
		int count =0;
		for (int i=0; i<n-1; i++) {
			for (int j = i+1; j < n; j++) {
				if (arr[i] + arr[j] == x) {
					count++;
					break;
				}
			}
		}
		System.out.println(count);
	}
}
