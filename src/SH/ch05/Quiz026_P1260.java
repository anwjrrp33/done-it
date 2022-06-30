package SH.ch05;

import java.util.*;

public class Quiz026_P1260 {

    static boolean visited[];

    static ArrayList<Integer>[] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 노드 개수
        int M = sc.nextInt(); // 에지 개수
        int Start = sc.nextInt(); // 시작점

        A = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            A[S].add(E);
            A[E].add(S);
        }
        // 번호가 작은 것을 먼저 방문하기 위해 정렬하기
        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }

        visited = new boolean[N + 1]; // 방문 배열 초기화하기
        DFS(Start);
        System.out.println();

        visited = new boolean[N + 1]; // 방문 배열 초기화하기
        BFS(Start);
        System.out.println();
    }

    public static void DFS(int Node) { // DFS 구현하기
        System.out.print(Node + " ");

        visited[Node] = true;

        for (int i : A[Node]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    private static void BFS(int Node) { // DFS 구현하기
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(Node);

        visited[Node] = true;

        while (!queue.isEmpty()) {
            int now_Node = queue.poll();

            System.out.print(now_Node + " ");

            for (int i : A[now_Node]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
