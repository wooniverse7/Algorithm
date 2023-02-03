package BOJ.P2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int white, blue;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rec(N, 0, 0);

        System.out.println(white);
        System.out.println(blue);
    }

    static void rec(int size, int row, int col){

        boolean one = true;
        int color = map[row][col]; // 첫번 째 원소

        // 같은 색인지
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if(map[i][j] != color) one = false;
            }
        }

        // 0은 하양, 1은 파랑
        if(one){ // 같은 색이면
            if(map[row][col] == 0) white++;
            else blue++;

            return;
        }

        // 색이 다르면
        size /= 2;

        // 4분할
        // 2|1
        // 3|4
        rec(size, row, col); // 2사분면
        rec(size, row, col + size); // 1사분면
        rec(size, row + size, col); // 3사분면
        rec(size, row + size, col + size); // 4사분면(처음과 제일 먼)

    }
}
