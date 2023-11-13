package org.example.bj13223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Main {

    public static int parseStringSecond(String input) {
        if (input.equals("24:00:00")) {
            return 86400;
        }
        return LocalTime.parse(input).toSecondOfDay();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int currentTimeSecond = parseStringSecond(br.readLine());
        int nextTimeSecond = parseStringSecond(br.readLine());

        if (currentTimeSecond == nextTimeSecond) {
            System.out.println("24:00:00");
            System.exit(0);
        }

        if (currentTimeSecond < nextTimeSecond) {
            LocalTime time = LocalTime.ofSecondOfDay(nextTimeSecond - currentTimeSecond);
            String timeString = time.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            System.out.println(timeString);
            System.exit(0);
        }

        System.out.println(
                LocalTime.ofSecondOfDay(
                        (LocalTime.MAX.toSecondOfDay() + 1 - currentTimeSecond) + nextTimeSecond
                ).format(DateTimeFormatter.ofPattern("HH:mm:ss"))
        );
    }
}
