import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int findSameSum(int arrayLength, int[] array, int sumResult) {
		int N = arrayLength - 1;
		int count = 0;

		Arrays.sort(array);
		for (int i = 0; i < N ;) {

			if (array[N] + array[i] == sumResult) {
				count++;
			}
			if (array[N] + array[i] < sumResult) {
				i++;
			} else {
				N--;
			}
		}
		return count;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int arrayLength = Integer.valueOf(st.nextToken());
		st = new StringTokenizer(br.readLine());

		int[] array = new int[arrayLength];
		for (int i = 0; i < arrayLength; i++) {
			array[i] = Integer.valueOf(st.nextToken());
		}

		int sumResult = Integer.valueOf(br.readLine());

		System.out.println(findSameSum(arrayLength , array, sumResult));
	}
}
