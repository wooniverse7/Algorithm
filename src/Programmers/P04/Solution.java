package Programmers.P04;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}}; // [19, 15, 6]
        System.out.println(Arrays.toString(new Solution().solution(name, yearning, photo)));
    }

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        int time = photo.length;

        for(int i = 0; i < time; i++){
            String[] onePhoto = photo[i];
            int rst = 0;

            int length = photo[i].length;
            for(int j = 0; j < length; j++){
                String tmp = onePhoto[j];

                for(int k = 0; k < name.length; k++){
                    if(tmp.equals(name[k])){
                        rst += yearning[k];
                    }
                }
            }
            answer[i] = rst;
        }

        return answer;
    }
}