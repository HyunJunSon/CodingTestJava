package baekjoon_18870_coordinateCompression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] copy = Arrays.copyOf(list, list.length);
		Arrays.sort(copy);
		HashMap<Integer, Integer> map = new HashMap<>();

		int order = 0;

		for (int i = 0; i < copy.length; i++) {
			if (!map.containsKey(copy[i])) {
				map.put(copy[i], order);
				order ++;
			}
		}

		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < list.length; i++) {
			stringBuilder.append(map.get(list[i])).append(" ");
		}

		System.out.println(stringBuilder);
	}
}
