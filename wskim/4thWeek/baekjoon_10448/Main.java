import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    private static Set<Integer> numberCases = new HashSet<>();
    private static List<Integer> triangleNumbers = getTriangularNumbers();

    public static List<Integer> getTriangularNumbers() {
        int index = 1;
        int current = 1;
        List<Integer> result = new ArrayList<>();
        while (current <= 1000) {
            numberCases.add(current);
            result.add(current);
            index += 1;
            current = (index + 1) * index / 2;
        }
        return result;
    }

    public static void getTriangleSum() {
        for (int i=0; i<2; i++) {
            Set<Integer> updatedNumberCases = new HashSet<>();
            for (int num: numberCases) {
                for (int triNum: triangleNumbers) {
                    int res = num + triNum;
                    if (res <= 1000) {
                        updatedNumberCases.add(res);
                    }
                }
            }
            numberCases = new HashSet<>(updatedNumberCases);
        }
    }

    public static void main(String[] args) throws IOException {
        getTriangleSum();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        for(int j = 0; j < number; j++) {
            if (numberCases.contains(Integer.parseInt(br.readLine()))) {
                System.out.println(1);
                System.out.println(numberCases);
                continue;
            }
            System.out.println(0);
        }
    }
}

