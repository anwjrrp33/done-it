package SH.ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quiz018 { // 삽입 정렬, 백준 11399
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < N; i++) {
            int target = A[i];
            int index = i - 1;

            while(index >= 0 && target < A[index]) {
                A[index + 1] = A[index];
                index--;
            }

            A[index + 1] = target;
        }
        // 합배열
        int result = A[0];
        for(int i = 1; i < N; i++) {
            A[i] = A[i - 1] + A[i];
            result += A[i];
        }
        System.out.println(result);
    }
}
