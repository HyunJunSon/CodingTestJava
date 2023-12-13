import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String[] str = new String[N];
		Arrays.fill(str, "0");
		int sum = -1;

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			sum += S;
			if (sum >= N) {
				sum -= N;
			}
			String tmp = st.nextToken();
			if (str[sum] == "0" || str[sum].equals(tmp)) {
				str[sum] = tmp;
			} else {
				str[sum] = "-1";
			}
			// for (String string : str) {
			// 	System.out.print(string + ", ");
			// }
			// System.out.println();
		}
		for (String string : str) {
			if (string == "-1") {
				System.out.println("!");
				return ;
			} else if (string == "0"){
				sb.append("?");
			} else {
				sb.append(string);
			}
		}
		System.out.println(sb);
	}
}
