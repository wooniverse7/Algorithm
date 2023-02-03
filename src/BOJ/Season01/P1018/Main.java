package BOJ.Season01.P1018;

import java.util.Scanner;

public class Main {

    static int min = 64; //최솟값 설정

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        String[][] board = new String[M][N];

        //체스판 입력
        for (int i = 0; i < M; i++) {
            String s = sc.next(); // 한 줄 전체가 입력받아진 다음
            for (int j = 0; j < N; j++) {
                if(s.charAt(j) == 'W') // 한 줄에서 W와 B를 구분해줌
                    board[i][j] = "W";
                else
                    board[i][j] = "B";
            }
        }

        // 검흰판 먼저 생성
        String[][] White = new String[M][N];
        String[][] Black = new String[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if((i % 2 == 0 && j % 2 == 1) || (i % 2 == 1 && j % 2 == 0)){
                    White[i][j] = "B";
                    Black[i][j] = "W";
                }
                else {
                    White[i][j] = "W";
                    Black[i][j] = "B";
                }
            }
        }

        // 프린트

        // 8*8크기를 만들어야 하므로 모든 구간의 8*8구간에서 개수를 구한다..?
        for (int x = 0; x < M-7; x++) {
            for (int y = 0; y < N-7; y++) {
                int cntW = 0;
                //int cntB = 0;
                int answer = 0;

                //검흰판에서 board의 색과 다른 부분 개수 구하기
                for (int i = x; i < x+8; i++) {
                    for (int j = y; j < y+8; j++) {
                        if(!board[i][j].equals(White[i][j])){
                            cntW++;
                        }
                    }
                }
                // 8*8에서 흰검중 작은 경우의 수
                answer = Math.min(cntW, 64-cntW);
                // 모든 8*8에서 가장 작은 수
                min = Math.min(min, answer);
            }
        }

        System.out.println(min);

    }
}
