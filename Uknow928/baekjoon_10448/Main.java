package baekjoon_10448;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] triNumArray = new int[45];
		for (int i = 0; i < 44; i++) {
			triNumArray[i] = (i+1)*(i+2)/2;
		}
		int count = Integer.parseInt(br.readLine());
		for (int i = 0; i < count; i++) {
			int num = Integer.parseInt(br.readLine());
			System.out.println(able(num, triNumArray));
		}
	}
	public static int able(int num, int[] triNumArray) {
		for (int a = 0; a < 44; a++) {
			for (int b = a; b < 44; b++) {
				for (int c = b; c < 44; c++) {
					if (num == (triNumArray[a] + triNumArray[b] + triNumArray[c])) {
						return 1;
					}
				}
			}
		}
		return 0;
	}
}

