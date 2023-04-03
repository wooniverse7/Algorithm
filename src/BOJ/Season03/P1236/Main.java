package BOJ.Season03.P1236;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] oneLine = new String[N];
        char[][] map = new char[N][M];
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            oneLine[i] = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = oneLine[i].charAt(j);
//                if(map[i][j] == '.') visited[i][j] = false;
//                if(map[i][j] == 'X') visited[i][j] = true;
            }
        }

        int colCnt = 0;
        int rowCnt = 0;

        // 행에 필요한 경비원 수
        for (int i = 0; i < N; i++) {
            boolean flag = true;
            // 한 행씩 검사하면서 X가 있으면 false 처리 후 탈출.
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 'X'){
                    flag = false;
                    break;
                }
            }
            if(flag) rowCnt++;
        }

        // 열에 필요한 경비원 수. 각 열의 모든 원소(행)을 검사
        for (int i = 0; i < M; i++) {
            boolean flag = true;
            // 한 행씩 검사하면서 X가 있으면 false 처리 후 탈출.
            for (int j = 0; j < N; j++) {
                if(map[j][i] == 'X'){
                    flag = false;
                    break;
                }
            }
            if(flag) colCnt++;
        }

//        // 자기 열, 자기 행 다 검사하면서 X 없으면 X 표시
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                if(map[i][j] != 'X'){
//                    boolean colFlag = false;
//                    boolean rowFlag = false;
//                    // 행 검사
//                    for (int k = 0; k < M; k++) {
//                        if(map[i][k] == 'X'){
//                            colFlag = true;
//                            break;
//                        }
//                    }
//                    // 한 행에 아무것도 없으면 X 추가하고 cnt++
//                    if(!colFlag) {
//                        map[i][j] = 'X';
//                        colCnt++;
//                    }
//
//                    // 열 검사
//                    for (int k = 0; k < N; k++) {
//                        if(map[k][j] == 'X'){
//                            rowFlag = true;
//                            break;
//                        }
//                    }
//                    // 한 열에 아무것도 없으면 X 추가하고 cnt++
//                    if(!rowFlag) {
//                        map[i][j] = 'X';
//                        rowCnt++;
//                    }
//
//                }
//            }
//        }

        int rst = Math.max(rowCnt, colCnt);
        System.out.println(rst);
    }
}