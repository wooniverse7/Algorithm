package Programmers.P1;


import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String[] wall1 = {"3 1 1 2", "2 3 2", "1 1 2 3"};
        System.out.println(Arrays.deepToString(solution(wall1))); // {1, 1}

        String[] wall2 = {"1 1", "1 1"};
        System.out.println(Arrays.deepToString(solution(wall2))); // [[0, 0], [0, 1], [1, 0], [1, 1]]

        String[] wall3 = {"1 1 1", "3"};
        System.out.println(Arrays.deepToString(solution(wall3))); // [[0, 1], [1, 0]]
    }

    int[][] map;
    public static int[][] solution(String[] wall) {
        int[][] answer = {};

        String[] tmp = wall[0].split(" ");
        int[] num1 = new int[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            num1[i] = Integer.parseInt(tmp[i]);
        }

        int length = 0;
        for (int i = 0; i < num1.length; i++) {
            length += num1[i];
        }
        int height = wall.length;

        int[][] map = new int[height][length];
        for (int i = 0; i < height; i++) {
            String[] str = wall[i].split(" ");
            int[] num = new int[str.length];
//            System.out.println(Arrays.toString(num));
            // 한 줄씩 정수화
            int cnt = 0;

            for (int j = 0; j < str.length; j++) { // 4번
                int fst = Integer.parseInt(str[j]);

                // 3 1 1 2
                for (int k = 0; k < fst; k++) {
                    System.out.println(cnt);
                    map[i][k] = cnt;
                }
                cnt++;
            }

        }

        System.out.println(Arrays.deepToString(map));

        return answer;
    }
}
