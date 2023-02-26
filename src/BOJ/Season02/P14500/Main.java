package BOJ.Season02.P14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visit;
    // ㅗ 탐색(ㅏ, ㅜ, ㅓ), 주둥이를 기준으로 대각선 2개, 바로 앞 1개
    static int[][][] oh= {
            {{1,-1}, {1, 0}, {1, 1}}
            ,{{-1, -1}, {0, -1}, {1, -1}}
            ,{{-1, -1}, {-1, 0}, {-1, 1}}
            ,{{-1, 0}, {0, -1}, {1, 0}}
    };
    static int rst;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 맵 만들기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // ㅗ를 제외한 나머지 도형은 뭉쳐서 탐색, 4칸까지만 탐색한다
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = true;
                dfs(i, j, 0, 0);
                visit[i][j] = false; // 리셋 필요

                // 'ㅗ' 탐색
                oh(i, j);
            }
        }



        System.out.println(rst);
    }

    static void dfs(int x, int y, int cnt, int sum){
        // 4칸 검색하면 cnt=3인데, 여기서 dfs 들어가면 cnt가 4가 되니까, 4일 때 탈출
        if(cnt == 4) {
            rst = Math.max(rst, sum);
            return;
        }

        // 어디서 더해줘야 중복없이 더할까. 맞네
        sum += map[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                if(!visit[nx][ny]){
                    // 한 칸씩 더해준다
                    //map[nx][ny] += map[x][y];
                    visit[nx][ny] = true;
                    dfs(nx, ny, cnt+1, sum);
                    visit[nx][ny] = false;
                }
            }
        }


    }

    static void oh(int x, int y){
        // ㅗ의 4가지 모양 다 탐색
        for (int i = 0; i < 4; i++) {
            int[][] tmp = oh[i]; // ㅗ 모양 하나씩 꺼내옴
            int sum = map[x][y]; // 가운데 블록

            // 현재 위치기준 3칸씩 검색
            // tmp  : {{1,-1}, {1, 0}, {1, 1}}
            for (int j = 0; j < 3; j++) {
                int nx = x + tmp[j][0];
                int ny = y + tmp[j][1];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                    sum += map[nx][ny];
                }

                rst = Math.max(sum, rst);
            }
        }
    }
}
