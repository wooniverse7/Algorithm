package BOJ.Season5.P10282;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {

    int idx; // 의존하는 컴퓨터 idx
    int time;

    public Node(int idx, int time) {
        this.idx = idx;
        this.time = time;
    }

    @Override
    public int compareTo(Node o){
        return this.time - o.time;
    }
}

public class Main {
    static int T, n, d, c;
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int[] dist;

    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 노드 수
            d = Integer.parseInt(st.nextToken()); // 간선 수
            c = Integer.parseInt(st.nextToken()); // 바이러스 위치

            list = new ArrayList[n + 1];
            dist = new int[n+1];
            visited = new boolean[n+1];

            for(int i = 1; i <= n; i++) {
                dist[i] = INF;
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                // a가 b를 의존한다고 할 때, b에서 a로 연결
                list[b].add(new Node(a, s));
            }

            dijk(c);

            int cnt = 0; // 감염된 컴퓨터 수
            int totalTime = 0; // 총 걸린 시간

            for (int i = 1; i < n+1; i++) {
                if(dist[i] != INF) {
                    cnt++;
                    totalTime = Math.max(totalTime, dist[i]);
                }
            }

            System.out.println(cnt + " " + totalTime);
        }
    }

    public static void dijk(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            int now = pq.poll().idx;

            if(!visited[now]) {
                visited[now] = true;

                for(Node next : list[now]){

                    if(dist[next.idx] > dist[now] + next.time) {
                        dist[next.idx] = dist[now] + next.time;
                        pq.add(new Node(next.idx, dist[next.idx]));
                    }
                }
            }
        }
    }
}
