package org.example.bj10158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 교훈1. 입출력은 한번에 처리하자.
// 교훈2. 출력할때는 println이 아니라 print를 쓰고, StringBuilder를 써서 문자열을 만들자.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] lengthList = br.readLine().split(" ");
        String[] coordinationList = br.readLine().split(" ");
        int iteration = Integer.parseInt(br.readLine());

        int lengthX = Integer.parseInt(lengthList[0]);
        int lengthY = Integer.parseInt(lengthList[1]);

        int currentCoordinateX = Integer.parseInt(coordinationList[0]);
        int currentCoordinateY = Integer.parseInt(coordinationList[1]);

        int finalX = (((iteration + currentCoordinateX) / lengthX) % 2 == 0) ? (iteration + currentCoordinateX) % lengthX : lengthX - ((iteration + currentCoordinateX) % lengthX);
        int finalY = (((iteration + currentCoordinateY) / lengthY) % 2 == 0) ? (iteration + currentCoordinateY) % lengthY : lengthY - ((iteration + currentCoordinateY) % lengthY);

        sb.append(finalX);
        sb.append(" ");
        sb.append(finalY);
        System.out.print(sb);
    }
}
