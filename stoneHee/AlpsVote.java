package stonehee.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class AlpsVote {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int totalVote = Integer.parseInt(br.readLine());
        int staffNum = Integer.parseInt(br.readLine());

        List<Staff> staffList = new ArrayList<>();
        for(int i = 0; i < staffNum; i++) {
            String[] input = br.readLine().split(" ");
            int votes = Integer.parseInt(input[1]);
            if(votes * 20 < totalVote) continue;
            staffList.add(new Staff(input[0], votes));
        }

        sortStaffByName(staffList);
        distributeChips(staffList);
        printChipResult(staffList);
    }

    static class Staff {
        String name;
        int votesCast;
        int chipCast;
        Queue<Integer> scoreArr = new LinkedList<>();

        public Staff(String name, int votes) {
            this.name = name;
            votesCast = votes;
            setScore();
        }

        void setScore() {
            for(int i = 1; i <= 14; i++) {
                scoreArr.offer(votesCast / i);
            }
        }
    }

    static void sortStaffByName(List<Staff> staffList) {
        staffList.sort(Comparator.comparing(staff -> staff.name));
    }

    static void distributeChips(List<Staff> staffList) {
        for(int i = 1; i <= 14; i++) {
            int max = 0;
            int num = 0;
            for (int j = 0; j < staffList.size(); j++) {
                Staff staff = staffList.get(j);
                int peek = staff.scoreArr.peek();
                if(peek > max) {
                    max = peek;
                    num = j;
                }
            }
            Staff staff = staffList.get(num);
            staff.scoreArr.poll();
            staff.chipCast++;
        }
    }

    static void printChipResult(List<Staff> staffList) {
        for (Staff staff : staffList) {
            System.out.println(staff.name + " " + staff.chipCast);
        }
    }
}
