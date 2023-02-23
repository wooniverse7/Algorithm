package BOJ.Season02.P7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[][] heavy = new int[N][2];
        for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                heavy[i][0] = Integer.parseInt(st.nextToken());
                heavy[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int a = heavy[i][0];
            int b = heavy[i][1];

            int cnt = 1;
            for (int j = 0; j < N; j++) {
                int c = heavy[j][0];
                int d = heavy[j][1];

                if(a < c && b < d) cnt++;
            }
            sb.append(cnt + " ");
        }

        sb.delete(sb.length()-1, sb.length());

        System.out.println(sb);
    }
}
