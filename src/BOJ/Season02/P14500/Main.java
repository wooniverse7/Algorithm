package BOJ.Season02.P14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, answer;
    static int[][] map;
    static boolean[][] visited;

    // 꼬다리 기준
    static int[][][] oh = {
            {{0,0}, {1,-1}, {1,0}, {1,1}}, // ㅗ
            {{0,0}, {-1,-1},{0,-1}, {1,-1}}, // ㅏ
            {{0,0}, {-1,1}, {0,1}, {1,1}}, // ㅓ
            {{0,0}, {-1,-1}, {-1,0}, {-1,1}} // ㅜ
    };

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 'ㅗ'를 제외한 도형을 시작점을 기준으로 겹쳤을 때 4칸 내의 범위가 모두 겹치므로
        // 시작점 기준 4칸을 탐색했을 때 가장 큰 값을 도출하면 된다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 4칸씩 DFS
                visited[i][j] = true; // 시작점 체크
                dfs(i, j, 0, 0);
                visited[i][j] = false; // 리셋

                // 'ㅗ' 체크
                checOh(i,j);
            }
        }

        System.out.println(answer);

    }

    static void dfs(int x, int y, int depth, int cnt){
        // 4칸 탐색하면 값 리턴
        if(depth == 4) {
            answer = Math.max(answer, cnt);
            return;
        }

        // 점수 카운트
        cnt += map[x][y];

        // 4칸씩 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(boundary(nx, ny)) continue;
            if(visited[nx][ny]) continue;

            visited[nx][ny] = true;
            dfs(nx, ny, depth + 1, cnt);
            visited[nx][ny] = false;
        }

    }

    static boolean boundary(int x, int y){
        return (x < 0 || y < 0 || x >= N || y >= M);
    }

    static void checOh(int x, int y){
        for (int i = 0; i < 4; i++) {
            // 'ㅗ' 한개 꺼내옴
            int[][] tmp = oh[i];
            int cnt = 0;

            // {0,0}, {1,-1}, {1,0}, {1,1}
            for (int j = 0; j < 4; j++) {
                int nx = x + tmp[j][0];
                int ny = y + tmp[j][1];
                if(boundary(nx, ny)) break;

                cnt += map[nx][ny];
            }

            answer = Math.max(cnt, answer);
        }
    }
}
