package HS.ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 11399 ATM 인출 시간 계산하기
// 맞았다
public class Quiz018 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n - 1; i++) {
            int choice = arr[i+1];
            for (int j = 0; j < i+1; j++) {
                if (arr[j] >= choice) {
                    for (int k = i+1; k >= j+1; k--) {
                        arr[k] = arr[k-1];
                    }
                    arr[j] = choice;
                    break;
                }

            }
        }

        for (int i = 0; i < n - 1; i++) {
            arr[i+1] += arr[i];
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += arr[i];
        }

        System.out.println(result);
    }
}
