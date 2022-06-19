package HS.ch04;

import java.util.Scanner;

// 백준 1427 내림차순으로 자릿수 정렬하기
// 맞음!!
public class Quiz017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split("");

        for (int i = 0; i < arr.length; i++) {
            int maxIndex = findMaxIndex(arr, i);
            int temp = Integer.parseInt(arr[i]);
            arr[i] = arr[maxIndex];
            arr[maxIndex] = String.valueOf(temp);
        }

        System.out.println(String.join("", arr));
    }

    public static int findMaxIndex(String[] arr, int i) {
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (; i < arr.length; i++) {
            if (max < Integer.parseInt(arr[i])) {
                max = Integer.parseInt(arr[i]);
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
