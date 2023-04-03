package Programmers.P02;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}}; // [8, 10, 25]

        System.out.println(Arrays.toString(solution(rows, columns, queries)));
    }


    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int[][] map = makeMap(rows, columns);
//        System.out.println(Arrays.deepToString(map));
        int rstIdx = 0; // 결과값 인덱스

        // 쿼리 수 만큼 반복
        for(int[] query : queries){

            // (x1, y1)  (x1, y2)
            //
            // (x2, y1)  (x2, y2)
            int x1 = query[0];
            int y1 = query[1];
            int x2 = query[2];
            int y2 = query[3];

            // 시작하는 곳 복사
            int start = map[x1][y2];
            int min = start;

            // 한칸씩 시계방향 회전
            // 맨 위 테두리. 오른쪽 이동(맨 오른쪽에서 하나씩)
            for (int i = y2-1; i >= y1; i--) {
                min = Math.min(min, map[x1][i]);
                map[x1][i+1] = map[x1][i];
            }

            // 서쪽 테두리. 위로 위동
            for (int i = x1+1; i <= x2; i++) {
                min = Math.min(min, map[i][y1]);
                map[i-1][y1] = map[i][y1];
            }

            // 남쪽 테두리. 왼쪽으로 이동
            for (int i = y1 + 1; i <= y2 ; i++) {
                min = Math.min(min, map[x2][i]);
                map[x2][i-1] = map[x2][i];
            }

            // 오른쪽 테두리. 아래로 이동
            for (int i = x2-1; i >= x1 ; i--) {
                min = Math.min(min, map[i][y2]);
                map[i+1][y2] = map[i][y2];
            }

            // 처음 덮인 부분 복구
            map[x1+1][y2] = start;
            answer[rstIdx] = min; // 테두리 최솟값 저장
            rstIdx++;
        }

        return answer;
    }

    public static int[][] makeMap(int rows, int columns){
        // 첫번 째 줄을 공백으로 만들어 인덱스와 값이 일치하게 만
        int[][] map = new int[rows+1][columns+1];
        int cnt = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                map[i][j] = cnt++;
            }
        }
        System.out.println(Arrays.deepToString(map));

        return map;
    }
}
