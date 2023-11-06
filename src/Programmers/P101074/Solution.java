package Programmers.P101074;

// 더 맵게
// 우선순위큐

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {

    }

    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            que.add(scoville[i]);
        }
        while(que.peek() < K) {
            if(que.size() == 1) return -1;
            que.add(que.poll() + que.poll() * 2);
            answer++;
        }

        return answer;
    }
}
