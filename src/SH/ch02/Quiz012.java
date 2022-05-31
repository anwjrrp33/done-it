package SH.ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Quiz012 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] A = new int[N];
        int[] S = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        StringBuffer sb = new StringBuffer();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i = 1; i < N; i++) {
            // 해당 조건에 맞지않는다면 다음 N값으로 넘어가고
            // 다음 N값에 해당하면 조건에 맞는 스택의 index값들을 while문으로 일괄적으로 변경하는 로직
            // 이 로직을 통해서 시간복잡도 O(NlogN)값이 수립된다.
            while(stack.empty() == false && A[stack.peek()] < A[i]) {
                S[stack.pop()] = A[i];
            }
            stack.push(i);
        }
        while(stack.empty() == false) {
            S[stack.pop()] = -1;
        }

        for(int i = 0; i < N; i++) {
            sb.append(S[i] + " ");
        }

        System.out.println(sb.toString());
    }
    /*
    // 제한 시간은 1초
    // 수열의 크기는 1 ~ 1,000,000
    // 시간복잡도는 O(NlogN)까지 사용가능
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        StringBuffer sb = new StringBuffer();

        // 단순히 2중 for문 사용 시 시간 초과 날 확률이 존재
        // 어떻게 하면 시간초과가 없이 출력이 가능하지?
        // 2중 폴문은 N제곱..당연히 안될거같긴한데 일단 동작
        for(int i = 0; i < N; i++) {
            boolean result = true;
            for(int j = i + 1; j < N; j++) {
                if(A[i] < A[j]) {
                    result = false;
                    sb.append(A[j] + " ");
                    break;
                }
            }
            if(result) {
                sb.append("-1 ");
            }
        }

        System.out.println(sb.toString());
    }
    */
}
