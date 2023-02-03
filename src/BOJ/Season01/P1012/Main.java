package BOJ.Season01.P1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0}; // 상하
    static int[] dy = {0, 0, -1, 1}; // 좌우
    static int[][] map; // 맵
    static boolean[][] visited; // 방문 처리 (몇개해야되지, K개?)
    static Queue<int[]> queue = new LinkedList<>();
    static int T, M, N, K; // 변수
    static int cnt;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while(T-- > 0){

            // 맵 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[M][N]; // N:세로길이(x개수)
            visited = new boolean[M][N];
            //System.out.println(Arrays.deepToString(visited));
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
                queue.offer(new int[]{x, y});
            }
            //System.out.println(Arrays.deepToString(map));

            // bfs
            cnt = 0;
            // bfs를 돌린 횟수만큼 cnt해야 하므로 bfs 반복
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    // 배추가 있고 방문하지 않은 곳일 때
                    if(map[i][j] == 1 && !visited[i][j]){
                        bfs(i, j);
                        cnt++; // bfs 한 번 돌았을 때 마다 지렁이 한 마리
                    }

                }
            }

            System.out.println(cnt);
        }

    }

    // bfs()
    static void bfs(int x, int y){
        // 현재 위치
        visited[x][y] = true; // 방문 처리

        // bfs에서 queue의 역할은 다음 탐색할 좌표를 미리 저장해 놓는 것
        // bfs 1번 실행될때마다 인접한 곳을 모두 탐색하고 종료되니 bfs안에 queue를 선언
        queue = new LinkedList<>();
        queue.offer(new int[] {x, y}); // 현재 좌표 삽입

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            // 4방향으로 한칸씩
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                // 범위 검사
                if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;

                // 다음 좌표에 배추가 있고 방문하지 않았을 때 큐 삽입
                if(map[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true; // 방문 체크
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }

    // 똑같이 한 큐가 다 돌면 cnt+1
    // 몇 개의 큐가 돌았는지만 검사

    // 그런데 여러 개의 큐를 어떻게 돌릴 수 있을까
    // 이미 돌았던 곳은 visited 처리
    // 그래서 여러 개의 큐 탐색
}
