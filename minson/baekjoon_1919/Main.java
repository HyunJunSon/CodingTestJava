import java.io.*;
import java.util.*;

public class Main {
	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();
	static int[] originalCount;
	static int[] finderCount;
	static String strFirst;
	static String strSecond;
	static int count;

	static void input() {
		strFirst = scan.next();
		strSecond = scan.next();
	}

	static int findDuplicateContent(String original, String finder) {
		originalCount = new int[original.length()];
		finderCount = new int[finder.length()];

		Arrays.fill(originalCount, 1);
		Arrays.fill(finderCount, 1);

		for (int i = 0; i < original.length(); i++) {
			for (int j = 0; j < finder.length(); j++) {
				if (original.charAt(i) == finder.charAt(j) && finderCount[j] != 0) {
					originalCount[i] = 0;
					finderCount[j] = 0;
					count+=2;
					break;
				}
			}
		}
		return original.length() + finder.length() - count;
	}
	static void removeDuplicateContent() {
		System.out.println(findDuplicateContent(strFirst, strSecond));
	}

	static boolean checkWords() {
		if (strFirst.length() > 1000 && strSecond.length() > 1000) {
			return false;
		}
		for (int i = 0; i < strFirst.length(); i++) {
			if ((strFirst.toCharArray()[i] > 'z' ) || (strFirst.toCharArray()[i] < 'a')) {
				return false;
			}
		}
		for (int i = 0; i < strSecond.length(); i++) {
			if ((strSecond.toCharArray()[i] > 'z' ) || (strSecond.toCharArray()[i] < 'a')) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		input();
		if (checkWords()) {
			removeDuplicateContent();
		}
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
	}
}