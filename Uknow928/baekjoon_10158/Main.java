package baekjoon_10158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] space = br.readLine().split(" ");
		String[] ant = br.readLine().split(" ");
		int time = Integer.parseInt(br.readLine());
		int width = Integer.parseInt(space[0]);
		int height = Integer.parseInt(space[1]);
		int xAnt = Integer.parseInt(ant[0]);
		int yAnt = Integer.parseInt(ant[1]);

		xAnt = (time + xAnt) % (2 * width);
		yAnt = (time + yAnt) % (2 * height);

		if (xAnt > width) {
			xAnt = 2 * width - xAnt;
		}
		if (yAnt > height) {
			yAnt = 2 * height - yAnt;
		}
		System.out.println(xAnt + " " + yAnt);


	}
}
