package Programmers.S121;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        System.out.println(new Solution().solution(numbers)); // 6210

        int[] numbers2 = {3, 30, 34, 5, 9};
        System.out.println(new Solution().solution(numbers2)); // 9534330
    }

    public String solution(int[] numbers) {
        String answer = "";

        String[] str = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str, (a,b) -> (b + a).compareTo(a + b));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }

        answer = sb.toString();
        if(answer.charAt(0) == '0') return "0";

        return answer;
    }
}
