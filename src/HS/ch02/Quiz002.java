package HS.ch02;

import java.util.Scanner;

// 백준 1546 평균 구하기
// 배열과 리스트
public class Quiz002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] intArr = new int[N];

        for(int i = 0; i < N; i++) {
            intArr[i] = sc.nextInt();
        }

        double max = 0;
        double sum = 0;

        for (int i = 0; i < N; i ++) {
            if (intArr[i] > max) {
                max = intArr[i];
            }
            sum += intArr[i];
        }

        System.out.println((sum / max * 100) / N);
    }
}
