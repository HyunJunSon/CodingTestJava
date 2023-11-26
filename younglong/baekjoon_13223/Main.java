package baekjoon_13223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] beginTime = br.readLine().split(":");
        String[] endTime = br.readLine().split(":");

        int secondDiff = getSecondDiff(endTime, beginTime);

        System.out.println(getResult(secondDiff));
    }

    private static String getResult(int secondDiff) {
        String result = LocalTime.ofSecondOfDay(secondDiff).toString();

        if (result.length() < 8) {
            result += ":00";
        }

        if(result.equals("00:00:00")) {
            result = "24:00:00";
        }

        return result;
    }

    private static int getSecondDiff(String[] endTime, String[] beginTime) {
        int secondDiff = calculateSecond(endTime) - calculateSecond(beginTime);

        if(secondDiff < 0) {
            secondDiff += 24 * 60 * 60;
        }

        return secondDiff;
    }

    private static int calculateSecond(String[] time) {
        int stnd = 3600;
        int second = 0;

        for (int i = 0; i < time.length; i++) {
            second += Integer.parseInt(time[i]) * stnd;
            stnd /= 60;
        }

        return second;
    }
}