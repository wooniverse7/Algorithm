package BOJ.Season03.P2667;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int N;
    static int[][] Map;
    static int cnt;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static ArrayList<Integer> rst;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        Map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            String input = sc.next();
            for (int j = 0; j < N; j++) {
                Map[i][j] = input.charAt(j) - '0';
            }
        }

        cnt = 0;
        rst = new ArrayList<>();
    }
}
