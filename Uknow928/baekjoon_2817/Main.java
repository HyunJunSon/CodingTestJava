package baekjoon_2817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		List<Staff> staffList = new ArrayList<>();
		List<Double> everyScoreList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			Integer vote = Integer.parseInt(str[1]);
			if (vote >= 0.05 * x) {
				Staff newStaff = Staff.of(str[0], vote);
				staffList.add(newStaff);
				everyScoreList.addAll(newStaff.getScores());
			}
		}
		everyScoreList.sort(Comparator.comparingDouble(Double::doubleValue).reversed());

		for (int i = 0; i < 14; i++) {
			Double score = everyScoreList.get(i);
			staffList.stream().filter(staff -> staff.isMyScore(score)).forEach(Staff::addChip);
		}
		staffList.sort(Staff::compareTo);
		staffList.forEach(System.out::println);
	}

	static class Staff implements Comparable<Staff> {
		private String name;
		private int vote;
		private List<Double> scores;
		private int chip;

		public Staff(String name, int vote, List<Double> scores) {
			this.name = name;
			this.vote = vote;
			this.scores = scores;
		}

		public static Staff of(String name, int vote) {
			List<Double> scoreList = new ArrayList<>();
			 for (int i = 1; i <= 14; i++) {
				 scoreList.add((double) vote/i);
			 }
			 return new Staff(name, vote, scoreList);
		}

		public boolean isMyScore(Double thatScore) {
			return scores.stream().anyMatch(score->score.equals(thatScore));
		}

		public List<Double> getScores() {
			return scores;
		}

		public String getName() {
			return name;
		}

		@Override
		public String toString() {
			return name + " " + chip;
		}

		public void addChip() {
			chip++;
		}

		@Override
		public int compareTo(Staff o) {
			return this.name.compareTo(o.getName());
		}
	}
}
