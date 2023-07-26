package BOJ.Season5.P14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class virus {
    int x;
    int y;

    public virus(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, m, rst;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(rst);

    }

    // 벽 세우기
    static void dfs(int depth) {
        // 벽 3개를 만들었으면
        if(depth == 3) {
            // 바이러스를 채우고 0 개수 구하기
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(depth+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    // 바이러스 퍼뜨리기
    public static void bfs(){
        Queue<virus> q = new LinkedList<>(); // 큐 구현시 LinkedList보다 ArrayDeque가 성능이 더 좋다고 한다.

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 2) {
                    q.add(new virus(i, j));
                }
            }
        }

        // 원본 연구소를 유지하기 위해 깊은 복사
        int[][] virusMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                virusMap[i][j] = map[i][j];
            }
        }

        while(!q.isEmpty()){
            virus now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    // 바이러스에서 퍼질 때 한칸 씩 퍼져 벽을 통과할 수 없기 때문에 벽 내외부는 검사 필요 없다
                    if(virusMap[nx][ny] == 0) {
                        virusMap[nx][ny] = 2;
                        q.add(new virus(nx, ny));
                    }
                }
            }
        }
        count(virusMap);
    }

    public static void count(int[][] virusMap) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(virusMap[i][j] == 0) cnt++;
            }
        }
        rst = Math.max(rst, cnt);
    }
}
