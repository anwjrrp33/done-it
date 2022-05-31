package HS.ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quiz005 {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        long[] S = new long[N];
        long[] C = new long[M];
        st = new StringTokenizer(br.readLine());




// 아래는 오답(시간초과)
//        int[] arr = new int[N];
//
//        for (int i = 0; i < N; i++) {
//            arr[i] = Integer.valueOf(st.nextToken());
//        }
//
//        int result = 0;


//
//        for (int i = 0; i < N; i++) {
//            int sum = 0;
//            for (int j = i; j < N; j++) {
//                sum += arr[j];
//                if (sum % M == 0) {
//                    result ++;
//                }
//            }
//        }

//        System.out.println(result);
    }
}
