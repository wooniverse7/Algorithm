package Programmers.S111;

public class Solution {

    public static void main(String[] args) {
        int n = 11;
        int[] stations = {4, 11};
        int w = 1; // answer = 3;
        System.out.println(new Solution().solution(n, stations, w));

        int n2 = 16;
        int[] stations2 = {9};
        int w2 = 2; // answer = 3;
        System.out.println(new Solution().solution(n2, stations2, w2));
    }

    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int leftStart = 1;
        for(int station : stations){
            if(station - w > leftStart) {
                int leftEnd = station - w;
                int length = leftEnd - leftStart;

                int cnt = length / (w * 2 + 1);
                if(length % (w * 2 + 1) != 0) {
                    cnt++;
                }

                answer += cnt;

            }

            leftStart = station + w + 1;
        }

        if(stations[stations.length - 1] + w + 1 <= n) {
            leftStart = stations[stations.length - 1] + w + 1;
            int leftEnd = n + 1;
            int length = leftEnd - leftStart;

            int cnt = length / (w * 2 + 1);
            if(length % (w * 2 + 1) != 0) {
                cnt++;
            }

            answer += cnt;
        }

        return answer;
    }
}
