package HS.ch03;

import java.util.Scanner;

// 백준 11659 구간 합 구하기
// 구간 합
// BufferedReader, StringTokenizer를 쓰는게 더 좋겠다.
// 입력받음과 동시에 합배열을 만드는게 좋겠다.
public class Quiz003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = sc.nextInt();
        int[] arr = new int[n];

        for (int k = 0; k < n; k++) {
            arr[k] = sc.nextInt();
        }

        int[] sumArr = new int[n + 1];
        int sum = 0;
        sumArr[0] = 0;
        for (int k = 1; k < n + 1; k++) {
            sum += arr[k - 1];
            sumArr[k] = sum;
        }

        int[] result = new int[count];

        for (int k = 0; k < count; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            result[k] = sumArr[j] - sumArr[i-1];
        }

        for (int k = 0; k < count; k++) {
            System.out.println(result[k]);
        }
    }
}
