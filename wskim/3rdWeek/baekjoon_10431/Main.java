package org.example.bj10431;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    private static int switchCounts;
    private static int[] queueingArray;
    private static int[] childQueue;
    private static StringBuilder stringBuilder = new StringBuilder();
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static int getMoveCount(int insertValue) {
        int moveCount = 0;
        if (queueingArray == null) {
            queueingArray = new int[] {insertValue};
            return moveCount;
        }

        for (int i=queueingArray.length-1; i>=0; i--) {
            if (insertValue < queueingArray[i]) {
                moveCount += 1;
            }
        }

        switchCounts += moveCount;
        return moveCount;
    }

    public static void insertChild(int insertValue) {
        if(queueingArray == null) {
            getMoveCount(insertValue);
            return;
        }

        int moveCount = getMoveCount(insertValue);
        int insertIndex = queueingArray.length - moveCount;
        int[] tempQueue = new int[queueingArray.length + 1];

        for(int i=0; i < queueingArray.length + 1; i++) {
            if (i == insertIndex) {
                tempQueue[i] = insertValue;
                continue;
            }
            if (i > insertIndex) {
                tempQueue[i] = queueingArray[i - 1];
                continue;
            }
            tempQueue[i] = queueingArray[i];
        }
        queueingArray = tempQueue;
    }

    public static void main(String[] args) throws IOException {
        int iteration = Integer.parseInt(bufferedReader.readLine());
        for (int i=1; i<=iteration ; i++) {
            switchCounts = 0;
            queueingArray = null;
            childQueue = Arrays.stream(bufferedReader.readLine().split(" "))
                    .skip(1)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int child: childQueue) {
                insertChild(child);
            }

            stringBuilder.append(i).append(" ").append(switchCounts).append("\n");
            System.out.print(stringBuilder);
            stringBuilder.setLength(0);
        }
    }
}

