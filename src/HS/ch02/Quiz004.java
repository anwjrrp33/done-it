package HS.ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 11660
public class Quiz004 {
    // 오답
//    public static void main(String[] args) throws IOException {
//        BufferedReader br =
//                new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st =
//                new StringTokenizer(br.readLine());
//
//        int size = Integer.valueOf(st.nextToken());
//
//        int[][] sumArr = new int[size][size + 1];
//
//        int quizCount = Integer.valueOf(st.nextToken());
//
//        // 4 3
//        // 1 2 3 4
//        // 2 3 4 5
//        // 3 4 5 6
//        // 4 5 6 7
//        // 2 2 3 4
//        // 3 4 3 4
//        // 1 1 4 4
//        //
//        for (int i = 0; i < size; i++) {
//            st = new StringTokenizer(br.readLine());
//            int sum = 0;
//            sumArr[i][0] = 0;
//            for (int j = 1; j <= size; j++) {
//                sum += Integer.valueOf(st.nextToken());
//                sumArr[i][j] = sum;
//            }
//        }
//
//        int[] result = new int[quizCount];
//
//        for (int i = 0; i < quizCount; i++) {
//            st = new StringTokenizer(br.readLine());
//
//            int x1 = Integer.valueOf(st.nextToken());
//            int y1 = Integer.valueOf(st.nextToken()) -1;
//
//            int x2 = Integer.valueOf(st.nextToken());
//            int y2 = Integer.valueOf(st.nextToken()) -1;
//
//            for (; y1 <= y2; y1++) {
//                result[i] += (sumArr[y1][x2] - sumArr[y1][x1-1]);
//            }
//        }
//
//        for (int i = 0; i < quizCount; i++) {
//            System.out.println(result[i]);
//        }
//    }
    // 책 정답
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A[][] = new int[N + 1][N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int D[][] = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j];
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.valueOf(st.nextToken());
            int y1 = Integer.valueOf(st.nextToken());
            int x2 = Integer.valueOf(st.nextToken());
            int y2 = Integer.valueOf(st.nextToken());

            int result = D[x2][y2] - D[x1-1][y2]
                    - D[x2][y1-1] + D[x1-1][y1-1];
            System.out.println(result);
        }
    }
}
