package BOJ.Season11.P1958;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();

        int na = a.length();
        int nb = b.length();
        int nc = c.length();
        int[][][] dp = new int[na+1][nb+1][nc+1];

        for (int i = 1; i <= na; i++) {
            for (int j = 1; j <= nb; j++) {
                for (int k = 1; k <= nc; k++) {
                    if(a.charAt(i-1) == b.charAt(j-1) && b.charAt(j-1) == c.charAt(k-1)){
                        dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
                    }else{
                        dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
                    }
                }
            }
        }

        System.out.println(dp[na][nb][nc]);
    }
}
