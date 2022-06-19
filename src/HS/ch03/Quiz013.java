package HS.ch03;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

// 백준 2164 카드게임
// 맞았다 ㅠㅠ
public class Quiz013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Deque<Integer> que = new LinkedList<>();

        for (int i = 1; i <= n; i++) que.add(i);

        while(que.size() != 1) {
            que.poll();
            que.add(que.poll());
        }

        System.out.println(que.peek());
    }
}
