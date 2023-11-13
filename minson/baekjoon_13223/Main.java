import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static StringBuilder sb = new StringBuilder();
	public static int convertToSeconds(String[] input) {
		int hour = Integer.parseInt(input[0]);
		int min = Integer.parseInt(input[1]);
		int sec = Integer.parseInt(input[2]);

		return hour * 3600 + min * 60 + sec;
	}

	public static void convertToTime(int time) {
		if (time == 0){
			sb.append("00");
		} else if (time < 10) {
			sb.append("0");
			sb.append(time);
		} else {
			sb.append(time);
		}
	}

	public static void convertToHour(int input) {
		int time = 3600;
		for (int i = 0; i < 3; i++) {
			convertToTime(input / time);
			time /= 60;
			if (i != 2) sb.append(":");
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input1 = br.readLine();
		String input2 = br.readLine();

		String[] currentTime = input1.split(":");
		String[] activeTime = input2.split(":");

		int seconds1 = convertToSeconds(currentTime);
		int seconds2 = convertToSeconds(activeTime);

		if (seconds1 == seconds2) {
			System.out.println("24:00:00");
		} else if (seconds1 > seconds2){
			convertToHour(24 * 3600 - seconds1 + seconds2);
		} else {
			convertToHour(seconds2 - seconds1);
		}
		System.out.println(sb);
	}
}
