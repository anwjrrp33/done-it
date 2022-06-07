package SH.ch02;

import java.util.Scanner;

public class Quiz015 {
    public static void main(String[] args) {
        // 백준 2750번 - 수 정렬하기 1
        // 책에서 버블 정렬 사용 권장
        // 시간복잡도 O(N의 2제곱)
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];

        for(int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for(int i = 0; i < N - 1; i++) {
            for(int j = 0; j < N - 1 - i; j++) {
                int a = A[j];
                int b = A[j + 1];
                if(a > b) {
                    A[j] = b;
                    A[j + 1] = a;
                }
            }
        }

        for(int n: A) {
            System.out.println(n);
        }
    }
}
