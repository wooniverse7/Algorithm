package BOJ.P11726;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[] dp = new long[1003];

        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= 1000; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 10007;
        }
        // 더해줄 때 마다 나머지 연산하는데 왜 제대로 된 값이 나오지

        System.out.println(dp[n]);
    }
}
