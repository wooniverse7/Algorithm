package Programmers.S141;

import java.util.Arrays;

/**
 * 숫자 게임
 * 최대 승점 구하기
 */
public class Solution {
    public static void main(String[] args) {
        int[] A = {5, 1, 3, 7};
        int[] B = {2, 2, 6, 8};
        System.out.println(new Solution().solution(A, B)); // 3


    }

    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int aIdx = 0;
        int bIdx = 0;

        while((aIdx != A.length) && (bIdx != B.length)) {
            if(A[aIdx] < B[bIdx]) {
                answer++;
                aIdx++;
            }
            bIdx++;
        }

        return answer;
    }
}
