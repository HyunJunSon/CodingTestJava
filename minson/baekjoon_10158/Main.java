import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String[] input1 = br.readLine().split(" ");
			int width = Integer.parseInt(input1[0]);
			int height = Integer.parseInt(input1[1]);

			String[] input2 = br.readLine().split(" ");
			int x = Integer.parseInt(input2[0]);
			int y = Integer.parseInt(input2[1]);

			int time = Integer.parseInt(br.readLine());

			x = (x + time) % (2 * width);
			y = (y + time) % (2 * height);

			if (x > width) {
				x = 2 * width - x;
			}

			if (y > height) {
				y = 2 * height - y;
			}

			StringBuilder sb = new StringBuilder();
			sb.append(x).append(" ").append(y);
			System.out.println(sb);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
// public class Main {
// 	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 	static int[] field = new int[2];
// 	static int[] location = new int[2];
// 	static int time;
// 	static int[] direction = {1, 1};
// 	public static void input() throws IOException {
// 		String input1 = br.readLine();
// 		String input2 = br.readLine();
// 		String input3 = br.readLine();
//
// 		String[] board = input1.split(" ");
// 		String[] current = input2.split(" ");
//
// 		for (int i = 0; i < 2; i++) {
// 			field[i] = Integer.parseInt(board[i]);
// 			location[i] = Integer.parseInt(current[i]);
//
// 		}
// 		time = Integer.parseInt(input3);
// 	}
// 	public static void changeDirection() {
// 		if (location[0] + direction[0] < 0 || location[0] + direction[0] > field[0]) {
// 			direction[0] *= -1;
// 		}
// 		if (location[1] + direction[1] < 0 || location[1] + direction[1] > field[1]) {
// 			direction[1] *= -1;
// 		}
// 	}
//
// 	public static void main(String[] args) throws IOException {
// 		input();
//
// 		for (int i = 0; i < time; i++) {
// 			changeDirection();
// 			location[0] += direction[0];
// 			location[1] += direction[1];
// 		}
//
// 		System.out.println(location[0] + " " + location[1]);
// 	}
// }
