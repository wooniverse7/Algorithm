package BOJ.Season5.P20056;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class Fireball {
        int r, c, m, s, d; // (r, c), 질량 m, 속도 s, 방향 d

        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static int N, M, K; // 크기 N, 개수 M, K번 명령
    static ArrayList<Fireball>[][] map;
    static ArrayList<Fireball> list = new ArrayList<>();
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<Fireball>();
            }
        }

        int r, c, m, s, d;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            list.add(new Fireball(r,c,m,s,d));
        }

        for (int i = 0; i < K; i++) {
            move();
            checkFireBall();
        }

        int result = 0;
        for(Fireball cur : list) {
            result += cur.m;
        }

        System.out.println(result);
    }

    private static void checkFireBall() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j].size() == 1)
                    map[i][j].clear(); // 해당 map 초기화. fireball은 list에 그대로 있음

                if(map[i][j].size() < 2)
                    continue;

                int mSum = 0, sSum= 0;

                boolean even = map[i][j].get(0).d % 2 == 0;
                boolean odd = map[i][j].get(0).d % 2 == 1;

                for(Fireball cur : map[i][j]) {
                    mSum += cur.m;
                    sSum += cur.s;
                    even = even & cur.d % 2 == 0;
                    odd = odd & cur.d % 2 == 1;
                    list.remove(cur);
                }

                // 4개의 파이어볼로 나누어짐
                int newMass = mSum / 5;
                int size = map[i][j].size();
                map[i][j].clear();

                if(newMass == 0) continue;

                int newS = sSum /size;
                if(even | odd) { // 모두 짝수 or 홀수
                    for (int k = 0; k < 8; k += 2) { // 방향 : 0, 2, 4, 6
                        list.add(new Fireball(i, j, newMass, newS, k));
                    }
                }else { // (false, false)
                    for (int k = 1; k < 8; k += 2) { // 방향 : 1, 3, 5, 7
                        list.add(new Fireball(i, j, newMass, newS, k));
                    }
                }
            }
        }
    }

    // fireball 이동
    private static void move() {
        for(Fireball ball : list) {
            int nr = (ball.r + N + dr[ball.d] * (ball.s % N)) % N; // 범위 넘어가면 다음 칸 하면 됨
            int nc = (ball.c + N + dc[ball.d] * (ball.s % N)) % N;

            ball.r = nr;
            ball.c = nc;
            map[nr][nc].add(ball);
        }
    }

}
