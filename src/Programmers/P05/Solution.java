package Programmers.P05;

import java.util.Arrays;

class Solution {
    public int solution(int[] boxes, int m, int k) {
        int answer = m;

        for (int i = 0; i < k; i++) {
            int maxMoney = 0;
            int maxBox = -1;
            for (int j = 0; j < boxes.length; j++) {
                int earnedMoney = (answer / 10000) * boxes[j];
                if (earnedMoney <= 100000 && earnedMoney > maxMoney) {
                    maxMoney = earnedMoney;
                    maxBox = j;
                }
            }
            if (maxBox != -1) {
                answer += maxMoney;
            } else {
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        // case 1
        int[] boxes = {1000, 800, 900};
        int m = 1000000;
        int k = 3;
        System.out.println(new Solution().solution(boxes, m, k)); // 1294200

        // case 2
        int[] boxes2 = {9000, 10000, 8520, 9500};
        int m2 = 110000;
        int k2 = 3;
        System.out.println(new Solution().solution(boxes2, m2, k2)); // 209000
    }
}
