package HS.ch03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 백준 11003 최솟값 찾기
// 슬라이딩 윈도우
public class Quiz010 {
    // 책보고 한 것
    // 슬라이딩 윈도우를 덱으로 구현하여 정렬효과를 본다.
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int L = Integer.valueOf(st.nextToken());
        st = new StringTokenizer(br.readLine());

        Deque<Node> mydeque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            // 새로운 값이 들어올 때마다 정렬 대신
            // 현재 수보다 큰 값을 덱에서 제거해 시간 복잡도를 줄임

            while (!mydeque.isEmpty() && mydeque.getLast().value > now) {
                mydeque.removeLast();
            }

            mydeque.addLast(new Node(now, i));

            if (mydeque.getFirst().index <= i - L) {
                mydeque.removeFirst();
            }

            bw.write(mydeque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node {
        public int value;
        public int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    // 오답
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int total = Integer.valueOf(st.nextToken());
//        int window = Integer.valueOf(st.nextToken());
//
//        int[] arr = new int[total];
//
//        st = new StringTokenizer(br.readLine());
//
//        int[] result = new int[total];
//        int minNum = 110;
//        int secondMinNumIndex = 0;
//
//        for (int i = 0; i < total; i++) {
//            arr[i] = Integer.valueOf(st.nextToken());
//
//            if (arr[i] < minNum) {
//                minNum = arr[i];
//            }
//
//        }
//
//        // 12 3
//        // 1 5 2 3 6 2 3 7 3 5 2 6
//        System.out.println(Arrays.toString(result));
//
//
//    }
}
