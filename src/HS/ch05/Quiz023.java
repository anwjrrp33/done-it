package HS.ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 백준 11724 연결 요소의 개수 구하기
// 이해하는 중
public class Quiz023 {
    public static void main(String[] args) throws IOException {

        // 6 5 // 노드 개수, 에지 개수
        // 1 2
        // 2 5
        // 5 1
        // 3 4
        // 4 6

        // 1 - 2, 5
        // 2 - 1, 5
        // 3 - 4
        // 4 - 3, 6
        // 5 - 1, 2
        // 6 - 4

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken()); // 노드 개수
        int m = Integer.valueOf(st.nextToken()); // 에지 개수

        visited = new boolean[n + 1];
//        int[][] arr = new int[m][2];
        A = new ArrayList[n + 1];

        for (int i = 1; i < n + 1; i++) {
            // 인접 리스트 초기화
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
//            arr[i][0] = Integer.valueOf(st.nextToken());
//            arr[i][1] = Integer.valueOf(st.nextToken());
            int s = Integer.valueOf(st.nextToken());
            int e = Integer.valueOf(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }
        int count = 0;
        for (int i = 0; i < n + 1; i++) {
            if (!visited[i]) {
                // 방문을 안했으면 카운트 올리기.
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }
    static ArrayList<Integer>[] A;
    static boolean visited[];

    static void DFS(int v) {
        if (visited[v]) {
            return; // 방문을 했으면 종료
        }
        visited[v] = true;
        for (int i : A[v]) {
            if (visited[i] == false) {
                // 연결 노드 중 방문하지 않았던 노드만 탐색하기기
               DFS(i);
            }
        }
    }

}
