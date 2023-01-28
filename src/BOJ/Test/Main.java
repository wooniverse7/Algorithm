package BOJ.Test;

import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());

            int H = Integer.parseInt(st.nextToken()); // 층수
            int W = Integer.parseInt(st.nextToken()); // 층의 방 수
            int N = Integer.parseInt(st.nextToken()); // 몇 번째 손님

            int[][] hotel = new int[H+1][W+1];
            int cnt = 1;
            int roomH = 0;
            int roomW = 0;
            for (int i = 1; i <= W; i++) {
                for (int j = 1; j <= H; j++) {
                    // 높이부터 채우고 다음칸으로 넘어가야 하는데
                    hotel[j][i] = cnt;
                    if(cnt == N){
                        roomH = j;
                        roomW = i;
                    }
                    cnt += 1;

                }
            }

            sb.append(roomH).append("0").append(roomW).append('\n');
//            System.out.printf("%d0%d\n", roomH, roomW);
        }
        System.out.println(sb);

    }
}

