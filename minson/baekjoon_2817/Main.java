import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static Map<String, Integer> compareCount(Map<String, Integer> voteCount, Map<String, Integer> winnerCount) {
		Map<String, Integer> originMap = new HashMap<>();
		originMap.putAll(voteCount);
		for (int i = 0; i < 14; i++) {
			List<Map.Entry<String, Integer>> entryList = new LinkedList<>(voteCount.entrySet());
			entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
			String key = entryList.get(0).getKey();
			//System.out.print("key = " + key + ", ");
			if (winnerCount.get(key) == 0) {
				winnerCount.put(key, 1);
			}
			winnerCount.put(key, winnerCount.get(key) + 1);
			//System.out.print("before value = " + entryList.get(0).getValue() + ", ");
			voteCount.put(key, originMap.get(key) / winnerCount.get(key));
			//System.out.println("after value = " + entryList.get(0).getValue());
		}
		for (Map.Entry<String, Integer> entry : winnerCount.entrySet()) {
			if (entry.getValue() != 0) {
				winnerCount.put(entry.getKey(), entry.getValue() - 1);
			}
		}
		return winnerCount;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<String, Integer> voteCount = new HashMap<>();

		int excludedStaffCount = 0;
		int participants = Integer.valueOf(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int staff = Integer.valueOf(st.nextToken());
		for (int i = 0; i < staff; i++) {
			st = new StringTokenizer(br.readLine());
			String staffName = st.nextToken();
			int candidateVoteCount = Integer.valueOf(st.nextToken());
			if (participants * 0.05 <= candidateVoteCount) {
				voteCount.put(staffName, candidateVoteCount);
				excludedStaffCount++;
			}
		}
		Map<String, Integer> winnerCount = new HashMap<>();
		for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
			winnerCount.put(entry.getKey(), 0);
		}
		List<String> keyList = new ArrayList<>(winnerCount.keySet());
		keyList.sort(String::compareTo);
		Map<String, Integer> scoreMap = compareCount(voteCount, winnerCount);
		for (String key: scoreMap.keySet()) {
			Integer value = scoreMap.get(key);
			System.out.println(key + " " + value);
		}
		br.close();
	}
}
