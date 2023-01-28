package BOJ.P10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0}; // 상하
    static int[] dy = {0, 0, -1, 1}; // 좌우
    static boolean[][] visited;
    static Queue<int[]> Q = new LinkedList<>();
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int rst1 = 0;
        // 일반인
        // map을 돌면서 같은 원소만 돌게. 몇 번 bfs를 돌았는지
        // bfs(해당 좌표의 char, 해당 좌표)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]){
                    bfs(map[i][j], new int[]{i,j});
                    rst1++;
                }
            }
        }

        // visited 초기화 밑 색 변동
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = false;
                if(map[i][j] == 'G') map[i][j] = 'R';
            }
        }

        // 적녹색약
        int rst2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 색을 같게 만듬

                if(!visited[i][j]){
                    bfs(map[i][j], new int[]{i,j});
                    rst2++;
                }
            }
        }

        System.out.printf("%d %d\n", rst1, rst2);

    }

    static void bfs(char color, int[] xy) {
        Q.offer(xy);
        visited[xy[0]][xy[1]] = true;

        while(!Q.isEmpty()){
            int[] cur = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                if(!visited[nx][ny] && map[nx][ny] == color){
                    visited[nx][ny] = true;
                    Q.offer(new int[] {nx, ny});
                }
            }
        }

    }

}
