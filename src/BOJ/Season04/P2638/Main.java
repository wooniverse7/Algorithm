package BOJ.Season04.P2638;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[][] outside;
    static int N, M, cnt, time;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
                if(tmp == 1) cnt++;
            }
        }

        while(cnt != 0) {
            BFS();
        }

        System.out.println(time);
    }

    public static void BFS() {
        // 외부를 BFS
        outside = new int[N][M];

        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[] {0,0});
        outside[0][0] = -1; // 모서리칸은 없다

        while(!que.isEmpty()){
            int[] node = que.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node[0] + dx[i];
                int ny = node[1] + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                if(map[nx][ny] == 1) // 다음칸에 치즈가 있으면
                    outside[nx][ny]++;
                if(map[nx][ny] == 0 && outside[nx][ny] == 0)
                {
                    outside[nx][ny] = -1; // 방문 체크
                    que.add(new int[]{nx, ny});
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(outside[i][j] >= 2) {
                    cnt--;
                    map[i][j] = 0;
                }
            }
        }
        time++;
    }
}
