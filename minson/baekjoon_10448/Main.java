import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int Eureka(int[] gausNum, int testCase) {
		for (int i = 1; i < 45; i++) {
			for (int j = 1; j < 45; j++) {
				for (int k = 1; k < 45; k++) {
					if (gausNum[i] + gausNum[j] + gausNum[k] == testCase) {
						return 1;
					}
				}
			}
		}
		return 0;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int testCaseCount = Integer.valueOf(st.nextToken());
		int[] testCase = new int[testCaseCount];
		for (int i = 0; i < testCaseCount; i++) {
			st = new StringTokenizer(br.readLine());
			testCase[i] = Integer.valueOf(st.nextToken());
		}

		int[] gausNum = new int[45];
		for (int i = 0; i < 45; i++) {
			gausNum[i] = i * (i + 1) / 2;
		}

		for (int i = 0; i < testCaseCount; i++) {
			sb.append(Eureka(gausNum, testCase[i]) + "\n");
		}
		System.out.println(sb);
	}
}
