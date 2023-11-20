package stonehee.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class findAnt {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        String[] grid = br.readLine().split(" ");
        String[] pos = br.readLine().split(" ");

        int w = Integer.parseInt(grid[0]);
        int h = Integer.parseInt(grid[1]);
        int p = Integer.parseInt(pos[0]);
        int q = Integer.parseInt(pos[1]);
        int t = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(findAnt(w, h, p, q, t));
        bw.flush();
    }

    private static String findAnt(int w, int h, int p, int q, int t) {
        int x = (p + t) % (2 * w);
        int y = (q + t) % (2 * h);

        x = x > w ? 2 * w - x : x;
        y = y > h ? 2 * h - y : y;

        return x + " " + y;
    }
}
