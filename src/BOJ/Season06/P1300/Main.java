package BOJ.Season06.P1300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static long K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Long.parseLong(br.readLine());

        // Point 3가지
        // upper bound를 출력할지, lower bound를 출력할지
        // 탐색 범위를 어디까지로 해야할지
        // 어떻게 B[K] = x에서 x의 값을 구할지
        // i / k를 했을 때, 몫의 누적합

        // lo <= x <= hi
        long lo = 1;
        long hi = K;


        while(lo < hi) {
            long mid = (lo + hi) / 2;
            long count = 0;

            // 임의의 x에 대해 i번째 항을 나눔으로써 x보다 작거나 같은 원소의 개수 누적 합을 구함
            // 열의 개수 N을 초과하지 않는 선에서 구함
            for (int i = 1; i <= N; i++) {
//                count += mid / i;
                count += Math.min(mid/i, N);
            }

            // count가 더 크다는 것은 x보다 작은 수가 더 많다는 뜻
            // 범위를 왼쪽으로 좁혀야 한다.
            if(count >= K) {
                hi = mid;
            }else {
                lo = mid + 1;
            }
        }

        System.out.println(lo);
    }
}

