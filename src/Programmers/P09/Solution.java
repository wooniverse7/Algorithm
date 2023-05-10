package Programmers.P09;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int n = 3;
        long left = 2;
        long right = 5;
        System.out.println(Arrays.toString(new Solution().solution(n, left, right))); // 3 2 2 3

        int n2 = 4;
        long left2 = 7;
        long right2 = 14;
        System.out.println(Arrays.toString(new Solution().solution(n2, left2, right2))); // 3 2 2 3
    }

    public int[] solution(int n, long left, long right) {
        int[] answer = {};

        // n제곱 배열 만들기는 시간 초과로 패스
//        int[][] board = new int[n+1][n+1];
//        int cnt = 1;
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                if(i == cnt || j == cnt){
//                    board[i][j] = cnt;
//                }
//            }
//            cnt++;
//        }
//        System.out.println(Arrays.deepToString(board));

        // Todo : 원하는 길이 만큼만 배열 선언해서 구하기
        int size = (int) (right - left + 1);
        answer = new int[size];

        for (int i = 0; i < size; i++) {
            //n X n 배열일 때, ( i / n ) + 1 은 행의 값이 되고 ( i % n ) + 1 은 열의 값이 된다
            int row = (int)((i + left) / n) + 1; // 행
            int col = (int)((i + left) % n) + 1; // 열

            // 원소의 값은 해당 원소의 행과 열 값중 큰 값을 따라감
            answer[i] = Math.max(row, col);
        }

        return answer;
    }
}
