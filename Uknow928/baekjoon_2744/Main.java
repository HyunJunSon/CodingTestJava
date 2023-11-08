package baekjoon_2744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		char[] charArray = word.toCharArray();
		for (int i=0;i<charArray.length; i++) {
			if (Character.isUpperCase(charArray[i])) {
				charArray[i] = Character.toLowerCase(charArray[i]);
			} else {
				charArray[i] = Character.toUpperCase(charArray[i]);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (char i : charArray) {
			sb.append(i);
		}
		System.out.println(sb);
	}
}
