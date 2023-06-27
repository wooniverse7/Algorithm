package Programmers.S131;

public class Solution {
    public static void main(String[] args) {
        int[] budgets = {120, 110, 140, 150};
        int M = 485;
        System.out.println(new Solution().solution(budgets, M));
    }

    public int solution(int[] budgets, int M) {
        int answer = 0;

        int lf = 0;
        int rt = 0;

        for (int budget : budgets) {
            if(budget > rt) {
                rt = budget;
            }
        }

        int mid = 0;
        while(lf <= rt) {
            long sum = 0;
            mid = (lf + rt) / 2;

            for(int budget : budgets) {
                if(budget >= mid) {
                    sum += mid;
                } else {
                    sum += budget;
                }
            }

            if(sum > M) {
                rt = mid - 1;
            } else {
                answer = mid;
                lf = mid + 1;
            }
        }

        return answer;
    }
}
