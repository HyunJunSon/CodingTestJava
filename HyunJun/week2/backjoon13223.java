package HyunJun.character.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Calendar;


public class backjoon13223 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("현재시각(hh:mm:ss):");
        int[] nowTime = Arrays.stream(br.readLine().split((":")))
                .mapToInt(Integer::parseInt).toArray();

        System.out.print("소금투하시각(hh:mm:ss):");
        int[] saltInputTime = Arrays.stream(br.readLine().split((":")))
                .mapToInt(Integer::parseInt).toArray();


        if (saltInputTime[0] > 0 )
            saltInputTime[0] += 24;


        Calendar start = Calendar.getInstance();
        start.set(2023, 11, 14, nowTime[0], nowTime[1], nowTime[2]);

        // 종료 시각
        Calendar end = Calendar.getInstance();
        end.set(2023, 11, 14, saltInputTime[0], saltInputTime[1], saltInputTime[2]);

        // 밀리초 차이
        long milliseconds = end.getTimeInMillis() - start.getTimeInMillis();


        // 시각 차이
        long hours = milliseconds / (60 * 60 * 1000);
        long minutes = (milliseconds % (60 * 60 * 1000)) / (60 * 1000);
        long seconds = (milliseconds % (60 * 60 * 1000)) / (60 *1000);

        System.out.println("시각 차이: " + hours + "시간 " + minutes + "분 " + seconds + "초");

    }
}


