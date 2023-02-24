package BOJ.Season02.P21610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // ←, ↖, ↑, ↗, →, ↘, ↓, ↙
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int N, M;
    static int[][] map;
    static boolean[][] visit;

    static Queue<Cloud> clouds = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //  (N, 1), (N, 2), (N-1, 1), (N-1, 2)
        clouds.add(new Cloud(N-1, 0));
        clouds.add(new Cloud(N-1, 1));
        clouds.add(new Cloud(N-2, 0));
        clouds.add(new Cloud(N-2, 1));

        // 구름 인덱스를
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());

            move(d, s);
            magic();
            makeCloud();
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += map[i][j];
            }
        }

        System.out.println(sum);
    }

    static void move(int d, int s){
        for(Cloud cloud : clouds){
            // 현재 구름의 위치에서 di방향으로 si칸만큼 이동
            cloud.x = (N + cloud.x + dx[d] * (s % N)) % N;
            cloud.y = (N + cloud.y + dy[d] * (s % N)) % N;
            /**
             *  구름 이동 로직 :
             *
             *  n번 이상 이동할 경우 n으로 나머지 연산한 결과와 동일함으로 s%n
             *  dx[d]는 si(s%n)만큼 이동 = dx[d]*(s%n)
             *  행과 열의 0번째 칸이 n-1번째 칸과 이어져있기 때문에 이 경우를 처리해줘야하는데
             *  n을 앞에 더해주고 마지막에 n으로 나머지 연산하여 이어져있도록 하였다.
             */

            // 비 : 구름있는 칸 +1
            map[cloud.x][cloud.y]++;
        }
    }

    static void magic() {
        while(!clouds.isEmpty()){
            // 구름이 모두 사라질 때까지 하나씩 뻄
            Cloud cloud = clouds.poll();

            // 3에서 사라지지 않은 칸 체크하기 위해
            visit[cloud.x][cloud.y] = true;
            int cnt = 0;

            // 대각선 칸 검사
            for (int i = 1; i <= 7; i += 2) {
                int dix = cloud.x + dx[i];
                int diy = cloud.y + dy[i];

                // 경계 검사
                if(dix < 0 || dix >= N || diy < 0 || diy >= N) continue;

                // 대각선 방향에 물이 있으면 복사
                if(map[dix][diy] > 0) cnt++;
            }

            map[cloud.x][cloud.y] += cnt;
        }
    }

    static void makeCloud(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] >= 2 && !visit[i][j]){
                    map[i][j] -= 2;
                    clouds.add(new Cloud(i, j));
                }
            }
        }

        visit = new boolean[N][N];
    }

    public static class Cloud {
        int x;
        int y;

        public Cloud(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
