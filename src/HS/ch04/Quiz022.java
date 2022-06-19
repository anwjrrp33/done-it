package HS.ch04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 백준 10989 수정렬하기3
public class Quiz022 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt (br.readLine());
        }
        radixSort(arr, 5);

        for (int i = 0; i < n; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void radixSort(int[] arr, int maxSize) {
        int[] output = new int[arr.length];
        int jarisu = 1;
        int count = 0;
        // 최대 자리수만큼 반복하기
        while (count != maxSize) {
            int[] bucket = new int[10];
            for (int i = 0; i < arr.length; i++) {
                bucket[(arr[i] / jarisu) % 10] ++; // 일의 자리부터 시작하기
            }
            for (int i = 1; i < 10; i++) { // 합 배열을 이용해 index 계산하기
                bucket[i] += bucket[i-1];
            }
            for (int i = arr.length - 1; i >= 0 ; i--) {
                // 현재 자릿수를 기준으로 정렬하기
                output[bucket[(arr[i] / jarisu % 10)] - 1] = arr[i];
                bucket[(arr[i] / jarisu) % 10] --;
            }
            for (int i = 0; i < arr.length; i++) {
                arr[i] = output[i];
            }
            jarisu = jarisu * 10;
            count++;
        }
    }
// 일반적인 기수 정렬은 우선순위 큐를 사용해
// 비교적 간단하게 구하는 방법이 있지만,
// 시간 복잡도를 느리 게 하는 요소가 있으므로
// 위 코드와 같이 구간 합을 이용하는 방법으로 구현
}
