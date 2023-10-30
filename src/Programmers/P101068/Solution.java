package Programmers.P101068;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {

        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        System.out.println(new Solution().solution(participant, completion)); // "mislav"

        String[] participant2 = {"leo", "kiki", "eden"};
        String[] completion2 = {"eden", "kiki"};
        System.out.println(new Solution().solution(participant2, completion2)); // "leo"
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();
        for(String player : participant) {
            map.put(player, map.getOrDefault(player, 0) + 1);
        }

        for(String player : completion) {
//            map.remove(player); // 값 자체를 지움
            map.put(player, map.get(player) - 1); // 해당 key에 연결된 value의 값을 조정함
        }

        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();

        while(iter.hasNext()){
            Map.Entry<String, Integer> entry = iter.next();

            if(entry.getValue() != 0) {
                answer = entry.getKey();
                break;
            }
        }

        return answer;
    }
}

// 참고
// https://coding-grandpa.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%99%84%EC%A3%BC%ED%95%98%EC%A7%80-%EB%AA%BB%ED%95%9C-%EC%84%A0%EC%88%98-%ED%95%B4%EC%8B%9C-Lv-1
