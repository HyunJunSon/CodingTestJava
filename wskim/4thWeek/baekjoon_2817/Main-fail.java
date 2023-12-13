import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int population = Integer.parseInt(br.readLine());
        int numStaff = Integer.parseInt(br.readLine());
        List<List<Object>> aplsResultLists = new ArrayList<>();

        for (int i = 0; i < numStaff; i++) {
            String[] lengthList = br.readLine().split(" ");
            String staff = lengthList[0];
            int numVote = Integer.parseInt(lengthList[1]);

            if ((double) numVote / population < 0.05) continue;

            for (int j = 1; j < 15; j++) {
                aplsResultLists.add(List.of(staff, (double) numVote / j));
            }
        }
        Collections.sort(aplsResultLists, new Comparator<List<Object>>() {
            @Override
            public int compare(List<Object> list1, List<Object> list2) {
                float intValue1 = (float) list1.get(1);
                float intValue2 = (float) list2.get(1);
                return Float.compare(intValue2, intValue1);
            }
        });
        List<String> aplsResultListAlpha = new ArrayList<>();
        for (int k = 0; k < 14; k++) {
            aplsResultListAlpha.add(aplsResultLists.get(k).get(0).toString());
        }
        Collections.sort(aplsResultListAlpha);
        Map<String, Float> result = countOccurrences(aplsResultListAlpha);
        for (Map.Entry<String, Float> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private static Map<String, Float> countOccurrences(List<String> list) {
        Map<String, Float> occurrences = new HashMap<>();
        for (String element : list) {
            occurrences.put(element, occurrences.getOrDefault(element, (float)0) + 1);
        }
        return occurrences;
    }
}

