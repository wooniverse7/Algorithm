package BOJ.Season04.P3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static Queue<int[]> hedgehog = new LinkedList<>();
    static Queue<int[]> water = new LinkedList<>();
    static int[][] move = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                char tmp = input.charAt(j);
                map[i][j] = tmp;

                if(tmp == 'S') {
                    hedgehog.add(new int[] {i, j});
                    map[i][j] = '.';
                    visited[i][j] = true;
                } else if (tmp == '*') {
                    water.add(new int[] {i, j});
                }
            }
        }

        int cnt = 0;

        while(!hedgehog.isEmpty()) {
            cnt++;

            // 물 범람
            int size = water.size();
            while(size-- > 0) {
                int[] w = water.poll();

                for (int i = 0; i < 4; i++) {
                    int wr = w[0] + move[i][0];
                    int wc = w[1] + move[i][1];

                    if(wr < 0 || wr >= R || wc < 0 || wc >= C || map[wr][wc] != '.')
                        continue;

                    map[wr][wc] = '*';
                    water.add(new int[] {wr, wc});
                }
            }

            // 고슴도치 이동
            size = hedgehog.size();
            while(size-- > 0) {
                int[] h = hedgehog.poll();

                for (int i = 0; i < 4; i++) {
                    int hr = h[0] + move[i][0];
                    int hc = h[1] + move[i][1];

                    if(hr < 0 || hr >= R || hc < 0 || hc >= C || visited[hr][hc]
                            || map[hr][hc] == '*' || map[hr][hc] == 'X')
                        continue;

                    if(map[hr][hc] == 'D') {
                        System.out.println(cnt);
                        return;
                    }

                    visited[hr][hc] = true;
                    hedgehog.add(new int[] { hr, hc });
                }
            }
        }

        System.out.println("KAKTUS");
    }
}
