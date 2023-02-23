package BOJ.Season2.P3085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        char[][] board = new char[N][N];
//        char[][] copy = new char[N][N];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            board[i] = tmp.toCharArray();
        }
//        System.out.println(Arrays.deepToString(board));

        // 그냥 처음부터 범위 내에 한칸씩 바꾸면서 그 때 마다 dfs로 최대길이 구하기
        // 가로로 N-1번, 세로로 N-1번 바꿈
        // 한 번 바꿀 때마다 같은 행, 열에 같은 문자가 있으면 카운트, 그 중에서 최댓값 구하기

        // 가로방향 바꾸기
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
//                copy = board; // 이렇게 복사하면 copy값을 바꿔도 board값도 변경된다. 얕은 복사인듯

                char tmp = board[i][j-1];
                board[i][j-1] = board[i][j];
                board[i][j] = tmp;
//                System.out.println(Arrays.deepToString(board));
//                System.out.println(Arrays.deepToString(copy));

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
