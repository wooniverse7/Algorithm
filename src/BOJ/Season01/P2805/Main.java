package BOJ.Season01.P2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M; // 개수, 필요한 양
    static long sum;
    public static void main(String[] args) throws IOException {

        // 브루트 포스로 나무 제일 높은 곳에서 1씩 떨어지면서 계속 탐색?

        // 나무가 100만개라서 높이 100m만 떨어져도 1억번 탐색해야됨. 나무 높이는 최대 2백만
        // 이분 탐색으로 높이를 찾는데 필요한 양의 나무를 주는 최고 높이를 찾아야 됨.
        // mid에서 나오는 나무양보다 많으면 위로 가는데 적어지는 순간까지 탐색해야 한다.
        // 특정 지점을 찾는게 아닌 최고-최저 높이의 범위를 찾는 것.

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] tree = new int[N];
        int top = 0;
        int bot = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());

            if(tree[i] > top){
                top = tree[i];
            }
        }

        System.out.println(bs(top, bot, tree));
    }

    // BinarySearch
    static long bs(int top, int bot, int[] forest){
        // while문 순회
        // 범위 최저 높이 ~ 최고 높이

        while(top > bot){
            int mid = (top + bot) / 2; // 자르는 높이

            sum = 0;
            for (int tree : forest) {

                // 잘린 부분 위의 총합
                if (tree > mid) {
                    sum += tree - mid;
                }
            }

            // 목표치보다 적을 때(자르는 높이를 낮춰야 함)
            if(sum < M){
                // lowerBound를 가운데로 높임
                top = mid;
            }
            else{
                // 목표치보다 많을 때 자르는 높이를 높여서 줄임
                bot = mid + 1;
            }
        }

        // bot을 mid+1로 설정해서 출력은 -1다시 해줌
        return bot-1;
    }
}
