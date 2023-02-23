package BOJ.Season02.P14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int r, c, dir;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0}; // 북동남서(반시계)
    static int[] dy = {0, 1, 0, -1};
    static int cnt = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(r, c, dir);
        System.out.println(cnt);

    }

    public static void dfs(int x, int y, int dir) {

        map[x][y] = -1; // 현재 위치 청소

        for (int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
                cnt++;
                dfs(nx, ny, dir);

                return;
            }
        }


        // 주변에 청소할 곳이 없을 때
        int back = (dir + 2) % 4; // 반대 방햐ㅑㅇ
        int bx = x + dx[back];
        int by = y + dy[back];
        if (bx >= 0 && bx < N && by >= 0 && by < M && map[bx][by] != 1) {
            dfs(bx, by, dir); // 후진할 때 방향 유지
        }
    }
}
