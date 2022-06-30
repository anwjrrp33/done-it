package SH.ch05;

import java.util.ArrayList;
import java.util.Scanner;

public class Quiz025_P13023 {

    static ArrayList<Integer>[] A;

    static boolean[] visited;

    static boolean arrive;

    public static void main(String[] args) {
        int N; // 노드 개수
        int M; // 에지 개수
        arrive = false;

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        A = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            A[S].add(E);
            A[E].add(S);
        }

        for (int i = 0; i < N; i++) {
            DFS(i, 1); // depth 1부터 시작

            if (arrive) {
                break;
            }
        }

        if (arrive) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    public static void DFS(int now, int depth) { // DFS 구현하기
        if (depth == 5 || arrive) { // depth가 5가 되면 프로그램 종료
            arrive = true;
            return;
        }

        visited[now] = true;

        for (int i : A[now]) {
            if (!visited[i]) {
                DFS(i, depth + 1); // 재귀함수가 호출이 될 때마다 depth를 1씩 증가
            }
        }

        visited[now] = false;
    }
}
