package BOJ.Season5.P2458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//public class Main {
//    static int N, M;
//    static boolean[][] map, reverseMap;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        map = new boolean[N + 1][N + 1];
//        reverseMap = new boolean[N + 1][N + 1];
//
//        // 입력
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//
//            map[a][b] = true;
//            // a -> b or b -> a 하나만 연결되면 된다.
//            reverseMap[b][a] = true;
//        }
//
//        // 플로이드 와샬 : 모든 정점에 대해 도달 가능한 정점들을 구함
//        for (int k = 1; k <= N; k++) {
//            for (int i = 1; i <= N; i++) {
//                for (int j = 1; j <= N; j++) {
//                    if (map[i][k] && map[k][j]) {
//                        map[i][j] = true; // 연결
//                    }
//                }
//            }
//        }
//
//        // 역방향
//        for (int k = 1; k <= N; k++) {
//            for (int i = 1; i <= N; i++) {
//                for (int j = 1; j <= N; j++) {
//                    if (reverseMap[i][k] && reverseMap[k][j]) {
//                        reverseMap[i][j] = true; // 연결
//                    }
//                }
//            }
//        }
//
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                map[i][j] |= reverseMap[i][j];
//            }
//        }
//
//        int rst = 0;
//        for (int i = 1; i <= N; i++) {
//            boolean flag = true;
//            for (int j = 1; j <= N; j++) {
//                if(i == j) continue;
//
//                // 키 비교를 할 수 없는 쌍은 continue;
//                if(!map[i][j]) {
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag) rst++;
//        }
//
//        System.out.println(rst);
//    }
//}

public class Main {
    static int N, M, rst;
    static boolean[][] map;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N + 1][N + 1];
        count = new int[N+1];

        // 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = true;
        }

        floydWarshall();

        countValidOrders();

        outcome();

    }

    // 플로이드 와샬 알고리즘을 적용하여 모든 정점에 대해 도달 가능한 정점들을 구함
    static void floydWarshall() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][k] && map[k][j]) {
                        map[i][j] = true;
                    }
                }
            }
        }
    }

    // 키 순서를 확인하여 유효한 순서 쌍의 개수를 반환
    static void countValidOrders() {
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (map[i][j] || map[j][i]) {
                    count[i]++;
                }
            }
        }
    }

    static void outcome() {
        rst = 0;
        for(int num : count) {
            if(num == N - 1) rst++;
        }
        System.out.println(rst);
    }
}