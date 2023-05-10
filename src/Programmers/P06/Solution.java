package Programmers.P06;

public class Solution {
    private static final int MOD = 10000019;

    public static void main(String[] args) {
        // case 1
        int width = 2;
        int height = 2;
        int[][] diagonals = {{1,1}, {2,2}};
        System.out.println(new Solution().solution(width, height, diagonals)); // expected result = 12

        // case 2
        int width2 = 51;
        int height2 = 37;
        int[][] diagonals2 = {{17,19}};
        System.out.println(new Solution().solution(width2, height2, diagonals2)); // expected result = 3225685
    }

    public int solution(int width, int height, int[][] diagonals) {
        int[][] board = new int[width + 1][height + 1];
        for (int[] diagonal : diagonals) {
            board[diagonal[0]][diagonal[1]] = 1;
        }

        int[][][] dp = new int[width + 1][height + 1][2];
        dp[1][1][0] = 1;
        for (int x = 1; x <= width; x++) {
            for (int y = 1; y <= height; y++) {
                if (x == 1 && y == 1) continue;
                if (board[x][y] == 1) {
                    dp[x][y][1] = (dp[x - 1][y][0] + dp[x][y - 1][0]) % MOD;
                } else {
                    dp[x][y][0] = (dp[x - 1][y][0] + dp[x][y - 1][0]) % MOD;
                    dp[x][y][1] = (dp[x - 1][y][1] + dp[x][y - 1][1]) % MOD;
                }
            }
        }

        return dp[width][height][1] % MOD;
    }
}
