package stonehee.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EurekaTheory {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> triNum = makeTriNumArr();
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(canEureka(num, triNum));
        }
    }

    static List<Integer> makeTriNumArr() {
        List<Integer> list = new ArrayList<>();
        int i = 1;
        list.add(i);
        while(true) {
            i++;
            int next = list.get(list.size() - 1) + i;
            if(next > 1000) break;
            list.add(next);
        }
        return list;
    }

    static int canEureka(int n, List<Integer> list) {
        for(int i = 0; i < list.size(); i++) {
            for(int j = 0; j < list.size(); j++) {
                for(int k = 0; k < list.size(); k++) {
                    if(list.get(i) + list.get(j) + list.get(k) == n) return 1;
                }
            }
        }
        return 0;
    }
}
