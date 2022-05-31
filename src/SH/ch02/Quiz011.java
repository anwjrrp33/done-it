package SH.ch02;

import java.util.Scanner;
import java.util.Stack;

public class Quiz011 {
    // NO인 경우를 제대로 생각하지않았음.
    // 새로운 숫자가 들어가는게 아닌 자연수는 1씩 증가함!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];

        for(int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();

        StringBuffer bf = new StringBuffer();
        int num = 1;
        boolean result = true;

        for(int i = 0; i < A.length; i++) {
            int su = A[i];
            if(su >= num) {
                while(su >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            } else {
                int n = stack.pop();
                // 스택은 후입선출이기때문에 n값이 su보다 크다면 다음에 나올 n값을 뽑아내지 못함!
                // 그렇기때문에 이룰수없음.
                if(n > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    bf.append("-\n");
                }
            }
        }
        if(result) {
            System.out.println(bf.toString());
        }
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int N = sc.nextInt();
//
//        for(int i = 0; i < N; i++) {
//            int M = sc.nextInt();
//            again(M);
//        }
//    }
//
//    public static Stack<Integer> stack = new Stack<Integer>();
//
//    public static void again(int M) {
//        if(stack.empty()) {
//            stack.push(1);
//            System.out.println("+");
//            again(M);
//        } else if(stack.peek() < M) {
//            stack.push(stack.size() + 1);
//            System.out.println("+");
//            again(M);
//        } else if(stack.peek() > M) {
//            stack.pop();
//            System.out.println("+");
//            again(M);
//        } else if(stack.peek() == M) {
//            stack.pop();
//            System.out.println("-");
//        }
//    }
}
