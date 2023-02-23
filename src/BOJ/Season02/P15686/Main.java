package BOJ.Season02.P15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static ArrayList<Node> chicken = new ArrayList<>(); // 치킨집 좌표
    static ArrayList<Node> home = new ArrayList<>();
    static boolean[] visited; // 백트래킹을 위해 방문 체크
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 맵 정보 입력
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) home.add(new Node(i, j));
                if(map[i][j] == 2) chicken.add(new Node(i, j));
            }
        }

        visited = new boolean[chicken.size()]; // 1대 1 매핑
        backTracking(0, 0);

        System.out.println(min);

    }

    // 백 트래킹
    static void backTracking(int idx, int cnt){
        // 치킨집 M개를 뽑은 후 도시 치킨 거리를 만듬
        if(cnt == M){
            int city = 0; // 도시 치킨 거리
            for (int i = 0; i < home.size(); i++) {
                int sum = Integer.MAX_VALUE; // 각 집에서 치킨 거리 변수
                for (int j = 0; j < chicken.size(); j++) {
                    if(visited[j]){
                        // 각 집 별로 치킨 거리 구하기 : i개의 집마다 j개의 치킨집 비교
                        int dist = Math.abs(home.get(i).x - chicken.get(j).x) + Math.abs(home.get(i).y - chicken.get(j).y);
                        sum = Math.min(dist, sum);
                    }
                }
                // 합산(각 집에서의 치킨 거리 합산)
                city += sum;
            }
            // 비교

            min = Math.min(city, min);
            return;
        }

        // 백트래킹 : 다시 M개를 뽑아 비교
        // idx와 i의 차이를 조심할 것. i는 단순히 치킨집 개수만큼 반복한다는 의미가 크고
        // idx는 어떤 치킨집인지 인덱스를 알려주는 의미가 크다
        // M=3일 때 : ㅁㅁㅁㅇㅇ, ㅁㅁㅇㅁㅇ, ㅁㅁㅇㅇㅁ
        for (int i = idx; i < chicken.size(); i++) {
            if(!visited[i]){ // 방문하지 않았으면
                visited[i] = true; // 방문 체크
                backTracking(i+1, cnt + 1); // 카운트가 M이 될때까지 중첩. M이 되면 비교 후 탈출
                // 나왔으면 해제. 다음 인덱스의 치킨집으로 다시 비교
                visited[i] = false;
            }
        }
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
