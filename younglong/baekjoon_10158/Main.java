package baekjoon_10158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] grid = br.readLine().split(" ");
        String[] position = br.readLine().split(" ");
        int time = Integer.parseInt(br.readLine());

        int width = Integer.parseInt(grid[0]);
        int height = Integer.parseInt(grid[1]);

        int x = Integer.parseInt(position[0]);
        int y = Integer.parseInt(position[1]);

        int posX = (x + time) % (2 * width);
        int posY = (y + time) % (2 * height);

        if(posX > width) {
            posX = 2 * width - posX;
        }

        if(posY > height) {
            posY = 2 * height - posY;
        }

        System.out.println(posX + " " + posY);
    }
}