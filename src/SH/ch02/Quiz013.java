package SH.ch02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Quiz013 {
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> myQueue = new LinkedList<>();
        int N = sc.nextInt();
        for(int i = 1; i <= N; i++) {
            myQueue.add(i);
        }
        // 기본적으로 생각한 구조는 똑같지만 한번의 반복문 안에서 삭제와 뒤로이동을 한번에 처리해서
        // 나보다 훨씬 성능이 좋다..
        // 문제 자체가 시간제한이 2초고 N의 값이 50만까지라 내가 푼 풀이도 통과된거지 좀 빡빡했으면 틀렸을듯?
        while(myQueue.size() > 1) {
            myQueue.poll();
            myQueue.add(myQueue.poll());
        }
        System.out.println(myQueue.poll());
    }
    public static void main(String[] args) {
        // 백준-2164-카드게임
        // 선입선출로 이루어지는 큐를 사용해야하는 문제인거 같음.
        // 시간 제한은 2초 N의 크기는 50만까지 허용 N의 2제곱은 시간초과이므로 NlogN이하의 속도를 가진 시간복잡도로 풀어야할거같음.
        // 정답!
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            queue.add(i);
        }

        boolean result = true;

        while(queue.size() > 1) {
            if(result) {
                queue.poll();
                result = false;
            } else {
                queue.add(queue.poll());
                result = true;
            }
        }

        System.out.println(queue.peek());
    }
}
