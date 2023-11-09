package BOJ.Season11.P4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;
    static int[][] fire; // 불의 이동 시간
    static int[][] man; // 사람의 이동 시간
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0,-1};
    static Queue<Pair> fireQ = new LinkedList<>();
    static Queue<Pair> manQ = new LinkedList<>();
    static int r, c;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];
        fire = new int[r][c];
        man = new int[r][c];

        for (int i = 0; i < r; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                fire[i][j] = -1;
                man[i][j] = -1;

                if(board[i][j] == 'F') {
                    fireQ.offer(new Pair(i, j));
                    fire[i][j] = 0;
                }else if(board[i][j] == 'J') {
                    manQ.offer(new Pair(i, j));
                    man[i][j] = 0;
                }
            }
        }

        // 불 BFS
        fireBFS();
        boolean flag = manBFS(); // 탈출 = true;

        if(!flag) {
            System.out.println("IMPOSSIBLE");
        }

    }

    static void fireBFS() {
        while(!fireQ.isEmpty()){
            Pair cur = fireQ.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if(fire[nx][ny] >= 0 || board[nx][ny] == '#') continue;

                fire[nx][ny] = fire[cur.x][cur.y] + 1;
                fireQ.offer(new Pair(nx, ny));
            }
        }
    }

    static boolean manBFS() {
        while (!manQ.isEmpty()) {
            Pair cur = manQ.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                // 범위를 벗어나면 탈출
                if(nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    System.out.println(man[cur.x][cur.y] + 1); // 범위를 벗어난 곳은 현재 지점 +1로 계산
                    return true;
                }

                if(man[nx][ny] >= 0 || board[nx][ny] == '#') continue;
                // 불의 전파 시간보다 적을 때 이동가능
                if(fire[nx][ny] <= man[cur.x][cur.y] + 1) continue;

                man[nx][ny] = man[cur.x][cur.y] + 1;
                manQ.offer(new Pair(nx, ny));
            }
        }

        return false;
    }
}

class Pair {

    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

//5 5
//#####
//#F#J#
//###.#
//###.#
//###.#
//
//3 5
//#####
//...J#
//#####