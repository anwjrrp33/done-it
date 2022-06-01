package HS.ch02;

import java.util.Scanner;

// 백준 12891
public class Quiz009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dnaStrLen = sc.nextInt();
        int partStrLen = sc.nextInt();
        sc.nextLine();
        String dnaStr = sc.nextLine();
        int aCnt = sc.nextInt();
        int cCnt = sc.nextInt();
        int gCnt = sc.nextInt();
        int tCnt = sc.nextInt();

        int start = 0;
        int end = start + partStrLen;

        int result = 0;
        while (end <= dnaStrLen) {
            String partStr = dnaStr.substring(start, end);
            if (partStr.chars().filter(c -> c == 'A').count() >= aCnt
                &&
                    partStr.chars().filter(c -> c == 'C').count() >= cCnt
                &&
                    partStr.chars().filter(c -> c == 'G').count() >= gCnt
                &&
                    partStr.chars().filter(c -> c == 'T').count() >= tCnt) {
                result ++;
            }
            start ++;
            end ++;
        }
        System.out.println(result);
    }
}
