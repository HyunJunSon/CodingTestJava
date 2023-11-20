package HyunJun.character.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class backjoon10158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("격자크기(w,h):");
        int[] pixelSize = toIntArray(br.readLine());
        System.out.print("초기위치(x,y):");
        int[] location = toIntArray(br.readLine());
        System.out.print("움직일 시간:");


        int time = br.read();
        int width = pixelSize[0];
        int height = pixelSize[1];
        int x = location[0];
        int y = location[1];

        int xpos = (x + time) % (width*2);
        int ypos = (y + time) % (height*2);

        xpos = xpos > width ? width*2 - xpos : xpos;
        ypos = ypos > height ? height*2 - ypos : ypos;


        System.out.println(xpos+" "+ypos);

    }

    public static int[] toIntArray(String input){
        return
            Arrays.stream(input.split("\\s"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
