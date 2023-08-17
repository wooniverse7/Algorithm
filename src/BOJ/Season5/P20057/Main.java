package BOJ.Season5.P20057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1}; // 서, 남, 동, 북
    static int[] dy = {-1, 0, 1, 0};
    static int[] dc = {1, 1, 2, 2};
    static int[][] spreadDx = {  // 모래가 퍼지는 x방향
            {-1, 1, -2, -1, 1, 2, -1, 1, 0},
            {-1, -1, 0, 0, 0, 0, 1, 1, 2},
            {1, -1, 2, 1, -1, -2, 1, -1, 0},
            {1, 1, 0, 0, 0, 0, -1, -1, -2},
    };
    static int[][] spreadDy = { // 모래가 퍼지는 y 방향
            {1, 1, 0, 0, 0, 0, -1, -1, -2},
            {-1, 1, -2, -1, 1, 2, -1, 1, 0},
            {-1, -1, 0, 0, 0, 0, 1, 1, 2},
            {1, -1, 2, 1, -1, -2, 1, -1, 0}
    };
    static int[] percent = {1, 1, 2, 7, 7, 2, 10, 10, 5};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine().trim());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = tornado(N/2, N/2);
        System.out.println(result);

    }


    // 현위치에서 이동
    static int tornado(int x, int y) {
        int outSand = 0;

        int curX = x;
        int curY = y;

        while(true) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < dc[i]; j++) {
                    // 현재위치에서 이동
                    int nx = curX + dx[i];
                    int ny = curY + dy[i];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) {
                        return outSand;
                    }

                    // 모래 뿌리기
                    int sand = map[nx][ny];
                    map[nx][ny] = 0;
                    int spreadTotal = 0;

                    // 중심점부터 퍼져나간 9칸 분포
                    for (int k = 0; k < 9; k++) {
                        int sandX = nx + spreadDx[i][k];
                        int sandY = ny + spreadDy[i][k];
                        int spreadAmount = (sand * percent[k]) / 100;

                        if(sandX < 0 || sandX >= N || sandY < 0 || sandY >= N) {
                            outSand += spreadAmount;
                        } else{
                            map[sandX][sandY] += spreadAmount;
                        }

                        spreadTotal += spreadAmount;
                    }

                    // 알파값
                    int alphaX = nx + dx[i];
                    int alphaY = ny + dy[i];
                    int alphaAmount = sand - spreadTotal;
                    if(alphaX < 0 || alphaY < 0 || alphaX >= N || alphaY >= N) {
                        outSand += alphaAmount;
                    }else {
                        map[alphaX][alphaY] += alphaAmount;
                    }

                    // 위치 업데이트
                    curX = nx;
                    curY = ny;
                    
                }
            }

            // 이동 1 - 1 - 2 - 2 - 3 - 3 - 4 - 4 ...
            // 횟수 업데이트
            for (int i = 0; i < 4; i++) {
                dc[i] += 2;
            }
        }
    }
}
