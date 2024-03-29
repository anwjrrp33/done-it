package SH.ch08;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Quiz058_1854 {
    static final int INF = 100000000;
    public static void main(String[] args) throws IOException {
        int N, M, K;
        int[][] W = new int[1001][1001];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer>[] distQueue = new PriorityQueue[N + 1];
        Comparator<Integer> cp = new Comparator<Integer>() { // 오름차순으로 정렬 기준 설정
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1 : -1;
            }
        };
        for (int i = 0; i < N + 1; i++) {
            distQueue[i] = new PriorityQueue<Integer>(K, cp);
        }
        for (int i = 0; i < M; i++) { // 인접행렬에 그래프 데이터 저장

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            W[a][b] = c;
        }
        PriorityQueue<Node_1854> pq = new PriorityQueue<>();
        pq.add(new Node_1854(1, 0));
        distQueue[1].add(0);
        while (!pq.isEmpty()) {
            Node_1854 u = pq.poll();
            for (int adjNode_1854 = 1; adjNode_1854 <= N; adjNode_1854++) {
                // 연결된 모든 노드에 대하여 검색하기 (시간복잡토 측면에서 인접행렬이 불리한이유)
                if (W[u.Node_1854][adjNode_1854] != 0) {
                    // 저장된 경로가 K개가 안될 경우 그냥 추가한다.
                    if (distQueue[adjNode_1854].size() < K) {
                        distQueue[adjNode_1854].add(u.cost + W[u.Node_1854][adjNode_1854]);
                        pq.add(new Node_1854(adjNode_1854, u.cost + W[u.Node_1854][adjNode_1854]));
                    }
                    // 저장된 경로가 K개이고, 현재 가장 큰 값보다 작을때만 추가한다.
                    else if (distQueue[adjNode_1854].peek() > u.cost + W[u.Node_1854][adjNode_1854]) {
                        distQueue[adjNode_1854].poll(); // 기존 큐에서 Max값 삭제먼저 해주어야함
                        distQueue[adjNode_1854].add(u.cost + W[u.Node_1854][adjNode_1854]);
                        pq.add(new Node_1854(adjNode_1854, u.cost + W[u.Node_1854][adjNode_1854]));
                    }
                }
            }
        }
        for (int i = 1; i <= N; i++) { // K번째 경로 출력
            if (distQueue[i].size() == K) {
                bw.write(distQueue[i].peek() + "\n");
            } else {
                bw.write(-1 + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
//노드 클래스 작성
class Node_1854 implements Comparable<Node_1854> {
    int Node_1854;
    int cost;
    Node_1854(int Node_1854, int cost) {
        this.Node_1854 = Node_1854;
        this.cost = cost;
    }
    @Override
    public int compareTo(Node_1854 o) {
        return this.cost < o.cost ? -1 : 1;
    }
}