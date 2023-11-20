package baekjoon_13223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		String[] aSplit = a.split(":");
		String[] bSplit = b.split(":");

		int[] aIntArray = new int[3];
		int[] bIntArray = new int[3];
		int[] subtractArray = new int[3];

		for (int i = 0; i < 3; i++) {
			aIntArray[i] = Integer.parseInt(aSplit[i]);
			bIntArray[i] = Integer.parseInt(bSplit[i]);
			subtractArray[i] = bIntArray[i] - aIntArray[i];
		}

		if (subtractArray[2] < 0) {
			subtractArray[2] += 60;
			subtractArray[1] -= 1;
		}

		if (subtractArray[1] < 0) {
			subtractArray[1] += 60;
			subtractArray[0] -= 1;
		}

		if (subtractArray[0] <= 0) {
			subtractArray[0] += 24;
		}

		String[] result = new String[3];
		for (int i = 0; i < 3; i++) {

			if (subtractArray[i]<10 && subtractArray[i]>0) {
				result[i] = "0"+ subtractArray[i];
			} else if (subtractArray[i] == 0) {
				result[i] = "00";
			} else {
				result[i] = String.valueOf(subtractArray[i]);
			}
		}
		System.out.println(String.join(":", result));

	}
}
