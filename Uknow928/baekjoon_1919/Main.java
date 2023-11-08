package baekjoon_1919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String first = br.readLine();
		String second = br.readLine();

		char[] firstArray = first.toCharArray();
		char[] secondArray = second.toCharArray();

		int count =0;
		for (char a : firstArray) {
			for (int i=0; i < secondArray.length; i++) {
				if (a == secondArray[i]) {
					count++;
					secondArray[i] = 0;
					break;
				}
			}
		}

		int count2 =0;
		for (char a : secondArray) {
			if (a == 0) {
				count2++;
			}
		}

		System.out.println(firstArray.length-count+ secondArray.length-count2);
	}
}
