package BOJ.Season11.P4095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0) break;

            int[][] map = new int[n+1][m+1];
            int[][] dp = new int[n+1][m+1];
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= m; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            // 현재점에서 왼쪽, 왼상단, 위쪽 검사해서 1일 경우 크기 증가
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if(map[i][j] == 1) {
                        if(dp[i-1][j-1] > 0 && dp[i-1][j] > 0 && dp[i][j-1] > 0) {
                            dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                        } else {
                            dp[i][j] = 1;
                        }
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }
            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0) break;

            int[][] dp = new int[n+1][m+1];

            int max = 0;
            // 현재점에서 왼쪽, 왼상단, 위쪽 검사해서 1일 경우 크기 증가
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= m; j++) {
                    dp[i][j] = Integer.parseInt(st.nextToken());
                    if(dp[i][j] == 1)
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;

                    max = Math.max(max, dp[i][j]);
                }
            }
            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }
}
