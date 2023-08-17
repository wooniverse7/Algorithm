package BOJ.Season06.P1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node>{
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o){
        return weight - o.weight;
    }
}

public class Main {
    static int V, E, K;
    static int MAX = 123456789;
    static List<Node>[] list;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        list = new ArrayList[V+1];
        dist = new int[V+1];

        Arrays.fill(dist, MAX);

        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, weight));
        }

        StringBuilder sb = new StringBuilder();
        dijkstra(K);

        for(int i = 1; i <= V; i++){
            if(dist[i] == MAX) sb.append("INF\n");
            else sb.append(dist[i] + "\n");
        }

        System.out.println(sb);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] visited = new boolean[V + 1];
        q.add(new Node(start, 0));
        dist[start] = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();
            int point = cur.end;

            if(visited[point] == true) continue;
            visited[point] = true;

            for(Node node : list[point]) {
                if(dist[node.end] > dist[point] + node.weight){
                    dist[node.end] = dist[point] + node.weight;
                    q.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }

}

