package HS.ch02;

import java.util.Scanner;
// 백준 2018 연속된 자연수의 합 구하기
// 투 포인터
// 정답보고함
public class Quiz006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 15 -> 4
        // 15, 7+8 , 4+5+6, 1+2+3+4+5

        // 10 -> 2
        // 10, 1+2+3+4

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }


        int count = 1;

        int startIndex = 1;
        int endIndex = 1;

        int sum = 1;
        while(endIndex != N) {
            if (sum == N) {
                count++;
                endIndex++;
                sum = sum + endIndex;
            } else if (sum > N) {
                sum = sum - startIndex;
                startIndex++;
            } else {
                endIndex++;
                sum = sum + endIndex;
            }
        }

        System.out.println(count);

    }
}
