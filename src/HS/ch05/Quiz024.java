package HS.ch05;

import java.util.Scanner;

// 백준 2023 신기한 소수찾기
// 이해하는중
public class Quiz024 {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        DFS(2,1);
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);


    }

    static void DFS(int number, int jarisu) {
        if (jarisu == N) {
            if (isPrime(number)) {
                System.out.println(number);
            }
        }
        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) {
                // 짝수라면 더 이상 탐색할 필요가 없음
                continue;
            }
            if (isPrime(number * 10 + i)) {
                // 소수라면 재귀 함수로 자릿수를 늘림
                DFS(number * 10 + i, jarisu + 1);
            }
        }
    }
    static boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//
//        int min = (int) Math.pow(10, N-1);
//        int max = (int) Math.pow(10, N);
//        for(int i = min; i < max; i++) {
//            boolean isStrangePrimeNumber = true;
//            String str = String.valueOf(i);
//            for(int j = 1; j <= str.length(); j++) {
//                int part = Integer.valueOf(str.substring(0, j));
//                if (!isPrimeNumber(part))
//                    isStrangePrimeNumber = false;
//            }
//            if (isStrangePrimeNumber)
//                System.out.println(str);
//        }
//    }
//
//    public static boolean isPrimeNumber(int num) {
//
//        if (num <= 3) return true;
//
//        for (int i = 2; i <= num/2; i++) {
//            if (num % i == 0) {
//                return false;
//            }
//        }
//
//        return true;
//    }
}
