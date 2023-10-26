package BOJ.Season09.P21608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int map[][];
    static HashMap<Integer, Integer[]> hashMap = new HashMap<>();
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n * n; i++) {
            st = new StringTokenizer(br.readLine());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());
            int s3 = Integer.parseInt(st.nextToken());
            int s4 = Integer.parseInt(st.nextToken());
            int s5 = Integer.parseInt(st.nextToken());
            // 해시맵에 좋아하는 친구 저장
            hashMap.put(s1, new Integer[]{s2, s3, s4, s5});
            //현재 학생의 자리 지정
            putStudent(s1);
        }

        // 만족도 조사



    }

    public static void putStudent(int student) {

        Integer friends[] = hashMap.get(student);
        int f1 = friends[0];
        int f2 = friends[1];
        int f3 = friends[2];
        int f4 = friends[3];

        // 좋아하는 친구 많은 순, 빈 공간 많은 순, 행 작은 순, 열 작은 순
        ArrayList<Integer[]> list=new ArrayList<>();

        for (int i = 0; i < map.length ; i++) {
            for (int j = 0; j < map.length; j++) {

            }
        }
    }
}