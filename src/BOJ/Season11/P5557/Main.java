package BOJ.Season11.P5557;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        long[][] dp = new long[n][21];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][arr[0]] = 1;

        for (int i = 1; i < n-1; i++) { // 마지막은 결과값
            for (int num = 0; num <= 20; num++) {
                int plus = num + arr[i];
                int minus = num - arr[i];

//                if(plus <= 20) dp[i][num] += dp[i-1][plus];
//                if(minus >= 0) dp[i][num] += dp[i-1][minus];
                if(plus <= 20) dp[i][plus] += dp[i-1][num];
                if(minus >= 0) dp[i][minus] += dp[i-1][num];
            }
        }

        System.out.println(dp[n-2][arr[n-1]]);
    }
}

