package HS.ch03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// 백준 17298 오큰수 구하기
// 스택과 힙
// 정답보고함
// 이해안감
public class Quiz012 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] A = new int[n]; // 수열 배열 생성
        int[] ANS = new int[n]; // 정답 배열 생성
        String[] str = bf.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(str[i]);
        }

        // A배열의 인덱스가 쌓이는 스택임
        Stack<Integer> myStack = new Stack<>();
        myStack.push(0); // 비어있으므로 최초값 초기화

        for (int i = 0; i < n; i++) {
            // 스택이 비어있지 않고, 현재 수열이
            // 스택 top 인덱스가 가리키는 수열보다 큰 경우
            while(!myStack.isEmpty() && A[myStack.peek()] < A[i]) {
                ANS[myStack.pop()] = A[i];
            }
            myStack.push(i);
        }

        while (!myStack.empty()) {
            // 반복문을 다 돌고 나왔는데 스택이 비어있지 않다면 빌 때까지
            ANS[myStack.pop()] = -1;
            // 스택에 쌓인 index에 -1을 넣고
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            bw.write(ANS[i] + " ");
        }
        bw.write("\n");
        bw.flush();
        
    }

//    public static void main(String[] args) throws Exception, EmptyStackException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int size = Integer.parseInt(br.readLine());
//        // int[] arr = new int[size];
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        Stack<Integer> stack = new Stack<>();
//        stack.push(0);
//        for (int i = 0; i < size; i++) {
//            // arr[i] = Integer.parseInt(st.nextToken());
//            int n = Integer.parseInt(st.nextToken());
//            stack.push(n);
//            if (stack.peek() < n) {
//                System.out.println(stack.pop());
//            } else {
//                System.out.println("-1");
//            }
//        }
//    }
}
