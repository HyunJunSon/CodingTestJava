import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int[] oneCaseInt;
	public static int countSort(int find, int std, int[] oneCaseInt) {
		int tmp = oneCaseInt[std];
		int count = 0;

		for (int i = std; i > find; i--) {
			oneCaseInt[i] = oneCaseInt[i - 1];
			count++;
		}

		oneCaseInt[find] = tmp;
		return count;
	}
	public static int findFirstOver(int range, int std, int[] oneCase) {
		for (int i = 0; i < range; i++) {
			if (std < oneCase[i]) {
				return i;
			}
		}
		return -1;
	}

	public static int Sort(String[] oneCase) {
		oneCaseInt = new int[oneCase.length - 1];
		int count = 0;

		for (int i = 1; i < oneCase.length; i++) {
			oneCaseInt[i - 1] = Integer.parseInt(oneCase[i]);
		}

		for (int i = 0; i < oneCaseInt.length; i++) {
			int std = oneCaseInt[i];
			if (findFirstOver(i, std, oneCaseInt) >= 0) {
				count += countSort(findFirstOver(i, std, oneCaseInt), i, oneCaseInt);
			}
		}
		return count;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int totalCases = Integer.parseInt(br.readLine());
		String[] testCases = new String[totalCases];

		for (int i = 0; i < totalCases; i++) {
			testCases[i] = br.readLine();
		}
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < totalCases; i++) {
			String[] oneCase = testCases[i].split(" ");
			sb.append(i + " " + Sort(oneCase) + "\n");
		}

		System.out.println(sb);
	}
}
