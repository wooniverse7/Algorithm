package BOJ.Season01.P7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M; // 입력

    static int[] dx = {-1, 1, 0 , 0}; // 상하
    static int[] dy = {0, 0, -1 , 1}; // 좌우
    static int[][] map; // 토마토 맵
    static Queue<int[]> tomato = new LinkedList<>(); // 큐

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M]; // N행 M열
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 익은 토마토(1)이면 큐에 좌표를 넣어 BFS를 돌릴 준비
                if(map[i][j] == 1)
                    tomato.offer(new int []{i, j}); //
            }
        }

        System.out.println(bfs());
    }

    static int bfs(){
        // 큐가 빌때까지 bfs 재귀를 돌린다
        while(!tomato.isEmpty()){

            // 큐에서 첫번째 익은 토마토를 poll
            int[] cur = tomato.poll();

            // 다음 좌료를 구한다
            int x = cur[0];
            int y = cur[1];

            // 4방향으로 한칸 씩 검사
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 예외 처리
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                // 다음 칸이 0이면 다음칸을 현재칸+1을 하고 큐에 add
                if(map[nx][ny] == 0){
                    map[nx][ny] = map[x][y] + 1;
                    tomato.offer(new int[]{nx, ny});
                }
            }
        }
        //System.out.println(Arrays.deepToString(map));

        // 빈칸이 있는지 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0) return -1;
            }
        }

        // 완료하면 map에서 최댓값을 구한다
        int max = -1;
        //System.out.println(max);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(max < map[i][j]) max = map[i][j];
            }
        }

        // map의 초기값이 1이기 때문에 max에 1을 빼준게 최소 일수
        return max - 1;
    }
}
