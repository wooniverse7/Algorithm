package BOJ.P1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
//    static int num0;
//    static int num1;
    static Integer[][] dp = new Integer[42][2]; // NULL 초기화를 위해 Integer 사용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 피보나치 규칙성 찾기위한 함수
//        for (int i = 0; i < 15; i++) {
//            fibo(i);
//            System.out.printf("%d의 0개수 : %d, 1개수 : %d\n", i, num0, num1);
//            num0 = num1 = 0;
//        }

        // 해당 피보나치의 0, 1개수 구하기, DP

        // 초기화
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        StringBuilder sb = new StringBuilder();
        while(N-- > 0){
            int M = Integer.parseInt(br.readLine());
            fibonacci(M);
            sb.append(dp[M][0] + " " + dp[M][1]).append('\n');
        }

        System.out.println(sb);
    }

    // 0,1개수의 규칙성을 찾기 위한 fibo함수
//    static int fibo(int n){
//        if(n == 0) {
//            num0 += 1;
//            return 0;
//        }
//        else if(n == 1) {
//            num1 += 1;
//            return 1;
//        }
//        else return fibo(n-1) + fibo(n-2);
//    }

    // 규칙 : fibo(n)의 0의 개수 = fibo(n-1)의 1의 개수 or fibo(n-2)의 0개수 + fibo(n-1)의 0개수
    //  fibo(n)의 1의 개수 = fibo(n-1)의 0의 개수 + 1의 개수
    static Integer[] fibonacci(int m){
        // m에 대한 0, 1의 호출 횟수값이 없을 때
        if(dp[m][0] == null || dp[m][1] == null){
            // 각 m에 대한 0과 1의 개수를 dp에 채우기 위해 재귀 호출
            dp[m][0] = fibonacci(m-1)[0] + fibonacci(m-2)[0];
            dp[m][1] = fibonacci(m-1)[1] + fibonacci(m-2)[1];
        }
        // m에 대한 0과 1의 개수, [m][0], [m][1]을 담고있는 [m]을 반환
        return dp[m];
    }
}
