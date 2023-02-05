package BOJ.Season2.P2866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int cnt = 0;
    static String[] original;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] original = new char[R][C];
        char[][] rotate = new char[C][R-1]; // original 배열에서 첫째줄을 제외하고 90도 회전한 배열

        for (int i = 0; i < R; i++) {
            original[i] = br.readLine().toCharArray();
        }

        // 첫째 줄 빼고 90도 회전
        for (int i = 0; i < C; i++) {
            for (int j = 1; j < R; j++) {
                rotate[i][j-1] = original[j][i];
            }
        }
//        System.out.println(Arrays.deepToString(rotate));

        // 해쉬맵으로 중복검사
        int cnt = 0;
        R--; // 첫째 줄 삭제했으니
        for (int i = 0; i < R; i++) {
            HashMap<String, String> map = new HashMap<>();
            for (int j = 0; j < C; j++) {
                String tmp = String.valueOf(rotate[j], i, R-i); // String.valueof( 원본 배열, 시작 인덱스, 개수);
//                System.out.println(tmp);
                map.put(tmp, "");
            }
            if(map.size() == C){
                cnt++;
            }else{
                break;
            }
        }

        System.out.println(cnt);
    }

    // 첫번 째 시도 - 배열 만드는데 3중 for문이라 시간 초과
//    static void main2(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int R = Integer.parseInt(st.nextToken());
//        int C = Integer.parseInt(st.nextToken());
//
//        String[] str = new String[R];
//        for (int i = 0; i < R; i++) {
//            str[i] = br.readLine();
//        }
//
//        // 세로 배열 만들기
//        original = new String[C];
//        // 이걸 이분탐색으로 만들어야 할 듯 -> 배열 만드는 것을 2중 for문으로 줄이자
//        for (int idx = 1; idx < R; idx++) {
//            for (int i = 0; i < C; i++) {
//                String tmp = "";
//                for (int j = idx; j < R; j++) {
//                    tmp += str[j].charAt(i);
//                }
//                original[i] = tmp;
//            }
//
//            // 중복 검사
//            HashMap<String, Integer> hm = new HashMap<>();
//            for (int i = 0; i < C; i++) {
//                hm.put(original[i], i);
//            }
//            // 크기 비교
//            if(hm.size() == C) cnt++;
//            else break;
//        }
//        System.out.println(cnt);
//
//    }
}
