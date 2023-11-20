package stonehee.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;

public class SaltBomb {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        System.out.println(calculateThrowingTime(str1, str2));
    }

    private static String calculateThrowingTime(String now, String executeTime) {
        int nowSec = convertTimeStringToInt(now);
        int executeTimeSec = convertTimeStringToInt(executeTime) > nowSec ? convertTimeStringToInt(executeTime) : convertTimeStringToInt(executeTime) + (24 * 60 * 60);
        return convertSecToTimeString(executeTimeSec - nowSec);
    }

    private static int convertTimeStringToInt(String time) {
        String[] timeArr = time.split(":");
        return (Integer.parseInt(timeArr[0]) * 3600) + (Integer.parseInt(timeArr[1]) * 60) + Integer.parseInt(timeArr[2]);
    }

    private static String convertSecToTimeString(int sec) {
        int hours = 0;
        int minutes = 0;

        if(sec > 3600) {
            hours = sec / 3600;
            sec = sec - (hours * 3600);
        }

        if(sec > 60) {
            minutes = sec / 60;
            sec = sec - (minutes * 60);
        }

        return convertIntToTimeFormat(hours) + ":" + convertIntToTimeFormat(minutes) + ":" + convertIntToTimeFormat(sec);
    }

    private static String convertIntToTimeFormat(int time) {
        return String.format("%02d", time);
    }
}
