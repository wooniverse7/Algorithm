package BOJ.Season09.P11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                // 누적합
                dp[i][j] = dp[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= m; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 2 2 3 4
            for (int j = x1; j <= x2; j++) {
                // 해당 행 마지막 누적합 - 앞의 누적합
                sum = sum + (dp[j][y2] - dp[j][y1 - 1]);
//                System.out.println("dp[i][y2] : " + dp[i][y2]);
//                System.out.println("dp[i][y1 - 1] : " + dp[i][y1 - 1]);
//                System.out.println("sum : " + sum);
//                System.out.println();
            }
            sb.append(sum + "\n");
        }

        System.out.println(sb);
    }
}
//1 2 3 4
//2 3 4 5
//3 4 5 6
//4 5 6 7

// 1 3 6 10
// 2 5 9 14
// 3 7 12 18
// 4 9 15 22

// 2 2 3 4