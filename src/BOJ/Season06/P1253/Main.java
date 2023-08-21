package BOJ.Season06.P1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int result = 0;
        // for문으로 타겟 순회
        for (int i = 0; i < N; i++) {
            int target = arr[i];
            int lf = 0, rt  = N - 1;

            // 투 포인터
            while(lf < rt) {
                int sum = arr[lf] + arr[rt];

                if(sum == target) {
                    // 자기 자신을 더하면 안된다는 조건
                    if(lf != i && rt != i) {
                        result++;
                        break;
                    } else if(lf == i) {
                        ++lf;
                    } else{
                        --rt;
                    }
                } else if(sum < target) {
                    lf++;
                }else {
                    rt--;
                }
            }
        }

        System.out.println(result);
    }
}

// 어떻게 범위를 줄일 것인가
// 타겟 2000번
// 왼쪽 수 2000번, 오른쪽 수 2000번(투 포인터)