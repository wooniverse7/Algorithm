package Programmers.P08;

import java.util.HashMap;
import java.util.Map;

/**
 * 할인 행사
 * 5월 10일 1차
 */
public class Solution {
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(new Solution().solution(want, number, discount));
        // result = 3

    }

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> wantMap = new HashMap<>();
        int wantLength = want.length;
        for(int i = 0; i < wantLength; i++) {
            wantMap.put(want[i], number[i]);
        }

        int discountLength = discount.length;
        for(int i = 0; i <= discountLength - 10; i++) {
            Map<String, Integer> discountMap = new HashMap<>();
            for(int j = 0; j < 10; j++) {
                String item = discount[i + j];
                int count = discountMap.getOrDefault(item, 0);
                // 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환하는 메서드
                count++;
                discountMap.put(item, count);
            }

            boolean isSignup = true;
            for (String wantItem : wantMap.keySet()) {
                int wantCount = wantMap.get(wantItem);
                int discountCount = discountMap.getOrDefault(wantItem, 0);
                if(wantCount > discountCount) {
                    isSignup = false;
                    break;
                }
            }
            if(isSignup) {
                answer++;
            }
        }

        return answer;
    }
}

