package HS.ch02;

import java.util.Arrays;
import java.util.Scanner;

// 백준 1253
public class Quiz008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);

        int count = 0;

        for (int k = 0; k < N; k++) {
            int i = 0;
            int j = N - 1;

            while(i < j) {
                int sum = A[i] + A[j];
                if (sum == A[k]) {

                    // 서로 다른 두 수의 합이어야 함을 체크함
                    if (i != k && j != k) {
                        count ++;
                        break;
                    } else if (i == k) {
                        i ++;
                    } else {
                        j --;
                    }


                } else if (sum > A[k]) {
                    j --;
                } else { // sum < A[k]
                    i ++;
                }
            }

        }
        System.out.println(count);

    }
}
