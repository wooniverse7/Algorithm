package Programmers.P03;

//import java.util.Arrays;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] park = {"SOO","OOO","OOO"};
        String[] routes = {"E 2","S 2","W 1"};
        System.out.println(Arrays.toString(new Solution().solution(park, routes)));

        String[] park2 = {"OSO","OOO","OXO","OOO"};
        String[] routes2 = {"E 2","S 3","W 1"};
        System.out.println(Arrays.toString(new Solution().solution(park2, routes2))); // [0,0]
    }

    static char[][] map;
    static int[] sPos = new int[2];

    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        int height = park.length;
        int width = park[0].length();

        map = new char[height][width];
        // 맵 만들기
        for (int i = 0; i < park.length; i++) {
            map[i] = park[i].toCharArray();

            // 시작 위치 저장
            if(park[i].contains("S")){
                sPos[0] = i; // x좌표, 높이
                sPos[1] = park[i].indexOf("S"); // y좌표, 길이
            }
        }


        for (String st : routes) {
            String mv = st.split(" ")[0];
            int len = Integer.parseInt(st.split(" ")[1]);

            int nx = sPos[0];
            int ny = sPos[1];

            // 이동하기
            for (int i = 0; i < len; i++) {
                if(mv.equals("E")){
                    ny++;
                }
                if(mv.equals("W")){
                    ny--;
                }
                if(mv.equals("S")){
                    nx++;
                }
                if(mv.equals("N")){
                    nx--;
                }
                if (nx >= 0 && ny >= 0 && ny < width && nx < height){
                    // 장애물
                    if(map[nx][ny] == 'X'){
                        break;
                    }
                    // 명령만큼 이동했으면
                    if(i == len - 1){
                        sPos[0] = nx;
                        sPos[1] = ny;
                    }
                }
            }
        }

        answer = new int[]{sPos[0], sPos[1]};

        return answer;
    }
}
