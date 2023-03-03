package BOJ.Season02.P14235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int input = Integer.parseInt(st.nextToken());

            if(input != 0) {
                for (int j = 0; j < input; j++) {
                    int tmp = Integer.parseInt(st.nextToken());

                    pq.offer(tmp);
                }
            }

            if(input == 0){
                if(pq.isEmpty()) sb.append(-1).append('\n');
                else sb.append(pq.poll()).append('\n');
            }
        }

        System.out.println(sb);
    }
}
