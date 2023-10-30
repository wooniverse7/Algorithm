package BOJ.Season10.P2285;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static long[] X, A;
    static int n, v; // 마을 수, 마을 위치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        Node[] arr = new Node[n];

        long sum = 0;
        long cnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++) {
            long x = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            arr[i] = new Node(x, a);

            cnt += arr[i].a; // 사람 수 가운데
        }

        Arrays.sort(arr, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return 0;
            }
        });

    }

    public static class Node{
        long x;
        long a;

        public Node(long x2, long a2) {
            super();
            this.x = x2;
            this.a = a2;
        }
    }
}
