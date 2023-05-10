package Programmers.P07;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {

        // case 1
        int n = 6;
        int[][] network = {{1, 2}, {3, 5}, {4, 2}, {5, 6}};
        int[][] repair = {{3, 2, 10}, {5, 4, 15}};
        System.out.println(new Solution().solution(n, network, repair));
        // expected result = 10

        // case 1
        int n2 = 4;
        int[][] network2 = {{1, 2}};
        int[][] repair2 = {{2, 3, 10}, {3, 1, 12}};
        System.out.println(new Solution().solution(n2, network2, repair2));
        // expected result = -1

    }

    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    int[] parent;

    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return false;

        parent[y] = x;
        return true;
    }

    public int solution(int n, int[][] network, int[][] repair) {
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        ArrayList<Edge> edges = new ArrayList<>();
        for (int[] pair : network) {
            edges.add(new Edge(pair[0], pair[1], 0));
        }

        for (int[] pair : repair) {
            edges.add(new Edge(pair[0], pair[1], pair[2]));
        }

        Collections.sort(edges);

        int cnt = 0;
        int answer = 0;
        for (Edge edge : edges) {
            if (union(edge.src, edge.dest)) {
                answer += edge.weight;
                cnt++;
            }
        }

        return cnt == n - 1 ? answer : -1;
    }
}
