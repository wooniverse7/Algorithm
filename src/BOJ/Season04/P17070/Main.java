package BOJ.Season04.P17070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, cnt;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        cnt = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,1,0);

        System.out.println(cnt);
    }

    // state : 0 - 가로, 1 - 세로, 2 - 대각선
    static void dfs(int x, int y, int state) {
        if(x == n - 1 && y == n - 1) {
            cnt++;
            return;
        }

        if(state == 0) {
            if (y + 1 < n && map[x][y + 1] == 0) {
                dfs(x, y + 1, 0);
            }
        }
        else if(state == 1) {
            if(x+1 < n && map[x+1][y] == 0) {
                dfs(x+1, y, 1);
            }
        }
        else if(state == 2) {
            if(y+1 < n && map[x][y+1] == 0) {
                dfs(x, y + 1, 0);
            }
            if(x+1 < n&& map[x+1][y] == 0) {
                dfs(x+1, y, 1);
            }
        }

        if(x+1 < n && y + 1 < n && map[x][y+1] == 0 && map[x+1][y] == 0 && map[x+1][y+1] == 0){
            dfs(x+1, y+1, 2);
        }

    }
}
