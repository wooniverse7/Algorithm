package BOJ.Season03.P3085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        char[][] board = new char[N][N];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            board[i] = tmp.toCharArray();
        }

        // 가로방향 바꾸기
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {

                char tmp = board[i][j-1];
                board[i][j-1] = board[i][j];
                board[i][j] = tmp;

                dfs(board);

                tmp = board[i][j-1];
                board[i][j-1] = board[i][j];
                board[i][j] = tmp;
            }
        }

        // 세로방향 바꾸기
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
//                copy = board;

                char tmp = board[j-1][i];
                board[j-1][i] = board[j][i];
                board[j][i] = tmp;

                dfs(board);

                // 원상복구
                tmp = board[j-1][i];
                board[j-1][i] = board[j][i];
                board[j][i] = tmp;
            }
        }

        System.out.println(max);
    }

    static void dfs(char[][] arr){

        // 가로 최대 길이 계산
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 1; j < N; j++) {
                if(arr[i][j] == arr[i][j-1]) {
                    cnt++;
                }else{
                    cnt = 1;
                }

                max = Math.max(max, cnt);
            }
        }

        // 세로 최대 길이 계산
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 1; j < N; j++) {
                if(arr[j][i] == arr[j-1][i]) {
                    cnt++;
                }else{
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }
    }
}