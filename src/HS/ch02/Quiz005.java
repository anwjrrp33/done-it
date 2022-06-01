package HS.ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 10986
// 정답보고함
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

        long answer = 0;
        st = new StringTokenizer(br.readLine());
        S[0] = Integer.valueOf(st.nextToken());

        for (int i = 1; i < N; i++) {
            S[i] = S[i-1] + Integer.valueOf(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            // 합 배열의 모든 값에 % 연산 수행하기
            int remainder = (int) (S[i] % M);
            // 0 ~ i 까지의 구간 합 자체가 0일 때 정답에 더하기
            if (remainder == 0) answer++;
            // 나머지가 같은 인덱스의 갯수 카운팅하기
            C[remainder] ++;
        }

        for (int i = 0; i < M; i++) {
            if (C[i] > 1) {
                answer = answer + (C[i] * (C[i] - 1) / 2);
            }
        }
        System.out.println(answer);

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
