package HS.ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 12891
// 정답보고함(이해안감)
public class Quiz009 {
    static int checkArr[];
    static int myArr[];
    static int checkSecret;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int Result = 0;
        char A[] = new char[S];
        checkArr = new int[4];
        myArr = new int[4];
        checkSecret = 0;
        A = bf.readLine().toCharArray();
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0)
                checkSecret++;
        }
        for (int i = 0; i < P; i++) {
            Add(A[i]);
        }
        if (checkSecret == 4)
            Result ++;
        // 슬라이딩 윈도우 처리 부분
        for (int i = P; i < S; i++) {
            int j = i - P;
            Add(A[i]);
            Remove(A[j]);
            if (checkSecret == 4)
                Result++;
        }
        System.out.println(Result);
        bf.close();
    }

    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0])
                    checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1])
                    checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2])
                    checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3])
                    checkSecret++;
                break;
        }
    }

    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0])
                    checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1])
                    checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2])
                    checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3])
                    checkSecret--;
                myArr[3]--;
                break;
        }
    }

    // 오답 시간초과
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int dnaStrLen = sc.nextInt();
//        int partStrLen = sc.nextInt();
//        sc.nextLine();
//        String dnaStr = sc.nextLine();
//        int aCnt = sc.nextInt();
//        int cCnt = sc.nextInt();
//        int gCnt = sc.nextInt();
//        int tCnt = sc.nextInt();
//
//        int start = 0;
//        int end = start + partStrLen;
//
//        int result = 0;
//        while (end <= dnaStrLen) {
//            String partStr = dnaStr.substring(start, end);
//            if (partStr.chars().filter(c -> c == 'A').count() >= aCnt
//                &&
//                    partStr.chars().filter(c -> c == 'C').count() >= cCnt
//                &&
//                    partStr.chars().filter(c -> c == 'G').count() >= gCnt
//                &&
//                    partStr.chars().filter(c -> c == 'T').count() >= tCnt) {
//                result ++;
//            }
//            start ++;
//            end ++;
//        }
//        System.out.println(result);
//    }
}
