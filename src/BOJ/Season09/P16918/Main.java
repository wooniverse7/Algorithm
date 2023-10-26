package BOJ.Season09.P16918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, c, n;
    static char[][] map;
    static int[][] bombTime;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        bombTime = new int[r][c];

        for (int i = 0; i < r; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = tmp.charAt(j);
                if(map[i][j] == 'O'){
                    bombTime[i][j] = 3; // 0 + 3초후 터짐
                }
            }
        }

        int time = 0;

        while(time++ < n){

            // 짝수 초는 폭탄 놓음
            if(time%2 == 0) {
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if(map[i][j] == '.') {
                            map[i][j] = 'O';
                            bombTime[i][j] = time + 3;
                        }
                    }
                }
            }else if(time % 2 == 1) {  // 3초 경과된 폭탄 터뜨리기
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        // 폭탄에서 3초 지난 시간과 현재 시간이 같으면
                        if(bombTime[i][j] == time) {
                            map[i][j] = '.';
                            for (int k = 0; k < 4; k++) {
                                int nx = i + dx[k];
                                int ny = j + dy[k];

                                if(nx < 0 || ny < 0 || nx >= r || ny >= c)
                                    continue;

                                // 폭탄을 동시에 터뜨리기
                                // 하나씩 터뜨리면서 끝부분에 폭탄이 미리 터져서 연쇄반응이 사라짐
                                // 터진 폭탄 근처 폭탄의 bombTime이 다르면 연쇄로 터지는 폭탄이다
                                if(map[nx][ny] == 'O' && bombTime[nx][ny] != time) {
                                    map[nx][ny] = '.';
                                    bombTime[nx][ny] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < r; i++) {
            System.out.println(map[i]);
        }
    }
}

// 0초 - 초기 상태
// 1초 - 그대로
// 2초 - 폭탄 놓음
// 3초 - 폭탄 터짐(0초거)
// 4초 - 폭탄 놓음
// 5초 - 폭탄 터짐(2초거)
// 6초 - 폭탄 놓음
// ...
