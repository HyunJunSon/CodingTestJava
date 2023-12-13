package baekjoon_1302_bestseller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int i =0;
		HashMap<String, Integer> map = new HashMap<>();
		int max = 0;
		while (i < N) {
			String s = br.readLine();
			if (map.containsKey(s)) {
				Integer val = map.get(s);
				map.replace(s, val + 1);
			} else {
				map.put(s,1);
			}
			max = Math.max(max, map.get(s));
			i++;
		}

		List<String> list = new ArrayList<>();
		for (Map.Entry<String, Integer> entry: map.entrySet()) {
			if (entry.getValue() == max) {
				list.add(entry.getKey());
			}
		}
		Collections.sort(list);
		System.out.println(list.get(0));


	}
}