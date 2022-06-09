package HS.ch02;

// 백준 11286 절댓값 힙 구현하기
// 정답보고함
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Quiz014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> myQue = new PriorityQueue<>((o1, o2) -> {
           int firstAbs = Math.abs(o1);
           int secondAbs = Math.abs(o2);
           if (firstAbs == secondAbs)
               return o1 > o2 ? 1: -1;
           else
               return firstAbs - secondAbs;
        });
        for (int i = 0; i < N; i++) {
            int request = Integer.parseInt(br.readLine());
            if (request == 0) {
                if (myQue.isEmpty())
                    System.out.println("0");
                else
                    System.out.println(myQue.poll());
            } else {
                myQue.add(request);
            }
        }
    }
    // 오답!
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//
//        Deque<Integer> que = new LinkedList<>();
//        StringBuffer sb = new StringBuffer();
//
//        for (int i = 0; i < n; i++) {
//            int x = sc.nextInt();
//            if (x == 0) {
//
//                // 제일작은값찾기.
//                // 그 값을 배열에서 제거한다.
//                // add할때 정렬할거니깐 첫번째값
//                Integer poll = que.poll();
//                sb.append((poll == null ? 0 : poll)+"\n");
//            } else {
//                que.add(x);
//                // 정렬이안됨 ㅜㅜㅜ
////                que.stream().sorted().collect();
//                System.out.println(que);
//            }
//        }
//
//        System.out.println(sb);
//
//    }
}
