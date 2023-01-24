package BOJ.P1388;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 맵, visited, Queue, 방향, 입력 변수, 출력값
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    static Queue<int[]> queue = new LinkedList<>();
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];
        // String을 char 기호 배열로 변환하는 방법
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }

        // bfs()
        // bfs()가 몇 번 돌았는지 세야하니 이중 for문으로 bfs를 호출?
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bfs(i, j);
                cnt++;
            }
        }


    }

    static void bfs(int x, int y){
        queue.offer(new int[]{x, y});
        visited[x][y] = true; // 방문 처리

        // 큐가 다 빌 때 까지 순회 반복
        while(!queue.isEmpty()){
            int cur[] = queue.poll();
            int xid = cur[0]; // x 좌표
            int yid = cur[1]; // y 좌표
            char ch = map[xid][yid]; // 현재 좌표의 판자 모양
            // 4방향 순회
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                // 범위 검사
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // - 일 경우 -만 큐에 넣고 다 돌때까지 순회. 다 돌면 cnt+1
                if(map[nx][ny] == ch && !visited[nx][ny]){
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
                // | 일 경우 |만 큐에 넣고 다 돌때까지 순회. 다 돌면 cnt+1
                if(map[nx][ny] == ch && !visited[nx][ny]){
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
