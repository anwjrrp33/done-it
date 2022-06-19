package HS.ch03;

import java.util.Scanner;

// 백준 11720 숫자의 합 구하기
// 배열과 리스트
public class Quiz001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine());
        String[] arr = sc.nextLine().split("");
        System.out.println(sum(arr));
    }

    public static int sum(String[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += Integer.valueOf(arr[i]);
        }
        return sum;
    }
}
