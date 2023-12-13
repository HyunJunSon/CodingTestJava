package org.example.bj18870;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // 1. 버퍼된 인풋과 아웃풋
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. 첫째줄 주어지는 정수의 개수는 사용하지 않음
        int __ = Integer.parseInt(br.readLine());

        // 3. HashMap 을 만들때 사용할 인덱스 초기화
        int hashIndex = 0;

        // 4. 띄어쓰기 기준으로 정수를 파싱하여 numberArray에 저장
        int[] numberArray = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 5. HashMap
        Map<Integer, Integer> numberHash = new HashMap<>();

        // 6. numberArray에 있는 정수를 TreeSet에 저장, 두가지 효과가 있음
        // (1) 중복제거
        // (2) 오름차순 정렬
        Set<Integer> numberSet = Arrays.stream(numberArray)
                .boxed() // int를 Integer로 변환
                .collect(TreeSet::new, // TreeSet 생성
                        Set::add, // 요소를 TreeSet에 추가
                        Set::addAll  // 병렬 스트림을 사용할 때 병합
                );

        // 7. HashMap에 입력된 정수를 키 값, 인덱스를 밸류 값으로 가지도록 함
        for (int key: numberSet) {
            numberHash.put(key, hashIndex++);
        }

        // 8. BufferedWriter를 활용한 출력
        for (int key: numberArray) {
            bw.write(numberHash.get(key) + " ");
        }
        bw.flush();
        bw.close();
    }
}
