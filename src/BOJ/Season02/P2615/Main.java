package BOJ.Season02.P2615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board = new int[19][19];

    // 북동 - 동 - 남동 - 남
//    static int[] dx = {0, 1, 1, -1};
//    static int[] dy = {1, 0, 1, 1};
    // 북 - 북동 - 동 - 남동
    static int[] dx = {-1, -1, 0, 1};
    static int[] dy = {0, 1, 1, 1};
    // 남 - 남서 - 서 - 북서
//    static int[] dx = {1, 1, 0, -1};
//    static int[] dy = {0, -1, -1, -1};
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 탐색을 왼쪽부터 하려면 탐색 순서를 위에서 아래로, 왼쪽에서 오른쪽으로
        for (int y = 0; y < 19; y++) {
            for (int x = 0; x < 19; x++) {
                if (board[x][y] != 0) {
                    // DFS
                    for (int k = 0; k < 4; k++) {
                        cnt = 1;
                        // 같은 방향으로 깊이 탐색하기 위해
                        int nx = x;
                        int ny = y;

                        // 증가하는 방향
                        while (true) {
                            nx += dx[k];
                            ny += dy[k];
                            if (nx >= 0 && nx < 19 && ny >= 0 && ny < 19) {
                                if (board[x][y] == board[nx][ny]) cnt++;
                                else {
                                    break;
                                }
                            } else break;
                        }
                        nx = x;
                        ny = y;
                        // 증가하는 반대방향 탐색
                        while (true) {
                            nx -= dx[k];
                            ny -= dy[k];
                            if (nx >= 0 && nx < 19 && ny >= 0 && ny < 19) {
                                if (board[x][y] == board[nx][ny]) cnt++;
                                else break;
                            } else break;
                        }

                        // 5개 체크
                        if (cnt == 5) {
                            // cnt가 5일 때 가장 왼쪽에서 시작하려면
                            System.out.println(board[x][y]);
                            System.out.println((x + 1) + " " + (y + 1)); // 가장 위의 좌표가 출력됨
                            return;
                        }
                    }
                }
            }
        }
        // 아무도 이기지 않았을 때
        System.out.println(0);
    }
}

