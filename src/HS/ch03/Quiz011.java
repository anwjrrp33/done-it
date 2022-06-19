package HS.ch03;

import java.util.Scanner;
import java.util.Stack;

// 백준 1874 스택으로 오름차순 수열 만들기
// 스택과 큐
public class Quiz011 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();
        int num = 1;
        boolean result = true;
        for (int i = 0; i < N; i++) {
            int su = A[i];
            if (su >= num) {
                while (su >= num) { // 딱 su == num이 될때까지 push후 pop
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            } else {
                int n = stack.pop();
                if (n > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    // n == su라면 이게 맞지만
                    // n < su인 경우는 어떻게 되는거지??
                    bf.append("-\n");
                }
            }
        }
        if (result) System.out.println(bf.toString());
    }

    // 오답 (출력초과)
//    public static void main(String[] args) throws IOException, EmptyStackException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//
//        int count = Integer.parseInt(br.readLine());
//
//        int[] arr = new int[count];
//
//        for (int i = 0; i < count; i++) {
//            arr[i] = Integer.valueOf(br.readLine());
//        }
//
//        Stack stack = new Stack();
//        int j = 1;
//        stack.push(j);
//        bw.write("+\n");
//
//        for (int i = 0; i < count; i++) {
//            while(true) {
//                if (!stack.isEmpty()
//                        && (Integer) (stack.peek()) < arr[i]) {
//                    j++;
//                    stack.push(j);
//                    bw.write("+\n");
//                } else if (!stack.isEmpty()
//                        && (Integer) (stack.peek()) == arr[i]) {
//                    stack.pop();
//                    bw.write("-\n");
//                    break;
//                } else if (!stack.isEmpty()
//                        && (Integer) (stack.peek()) > arr[i]) {
//                    bw = new BufferedWriter(new OutputStreamWriter(System.out));
//                    bw.write("NO");
//                    i = count;
//                    break;
//                } else if (stack.isEmpty()) {
//                    j++;
//                    stack.push(j);
//                    bw.write("+\n");
//                } else {
//                    bw = new BufferedWriter(new OutputStreamWriter(System.out));
//                    bw.write("NO");
//                    i = count;
//                    break;
//                }
//            }
//        }
//
//        bw.flush();
//        bw.close();
//        // 8
//        // 4
//        // 3
//        // 6
//        // 8
//        // 7
//        // 5
//        // 2
//        // 1
//
//        // 5
//        // 1
//        // 2
//        // 5
//        // 3
//        // 4
//
//        // 5
//        // 3
//        // 2
//        // 1
//        // 4
//        // 5
//    }

}
