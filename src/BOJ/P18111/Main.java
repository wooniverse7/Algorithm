package BOJ.P18111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int maxv = Integer.MIN_VALUE;
    static int minv = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;

                maxv = Math.max(maxv, num);
                minv = Math.min(minv, num);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int height = 0;
        // 최하층부터 최고층까지 한칸씩 채우면서 최소 시간 구하기
        for (int i = minv; i <= maxv; i++) { // 같은 높이일수도 있으니 == 필요
            int item = B;
            int time = 0;

            // 각 칸마다 소요되는 시간 구하기
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    // 평평하게 만들려는 층보다 높으면 파낸다
                    if(map[j][k] > i){
                        time += (map[j][k] - i) * 2; // 시간 소요
                        item += (map[j][k]- i); // 파낸만큼 증가
                    }else if(map[j][k] < i){
                        // 층보다 낮게 있으면 쌓는다
                        time += (i - map[j][k]);
                        item -= (i - map[j][k]);
                    }
                }
            }
            // item이 남아있고, 지금까지의 최단 시간과 같거나 적으면 갱신
            // 같은 시간일 경우 더 높은 높이를 선택하기 위해 == 필요
            if(item >= 0 && minTime >= time){
                minTime = time;
                height = i; // 해당층의 높이. 순회할수록 높아지니 다른 변수 필요 X
            }
        }

        System.out.println(minTime + " " + height);
    }
}
