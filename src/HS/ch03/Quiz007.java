package HS.ch03;

import java.util.Arrays;
import java.util.Scanner;

// 백준 1940 주몽의 명령
// 투 포인터
// 정답보고함
public class Quiz007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);
        int count = 0;

        int i = 0;
        int j = N - 1;

        while (i < j) {
            if (A[i] + A[j] < M) {
                i ++;
            } else if (A[i] + A[j] > M) {
                j --;
            } else {
                count ++;
                i ++;
                j --;
            }
        }

        System.out.println(count);


    }
}
