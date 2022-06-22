package SH.ch04;

import java.util.Scanner;

// 백준 - 1427
// 선택 정렬 사용
public class Quiz017 {
    // 선택정렬 사용
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int[] A = new int[str.length()];
        for(int i = 0; i < str.length(); i++) {
            A[i] = Integer.parseInt(str.substring(i, i + 1));
        }

        for(int i = 0; i < A.length - 1; i++) {
            int index = i;
            for(int j = i; j < A.length; j++) {
                if(A[index] < A[j]) {
                    index = j;
                }
            }
            int a = A[i];
            int b = A[index];
            A[i] = b;
            A[index] = a;
        }

        for(int n: A) {
            System.out.print(n);
        }
    }
}
