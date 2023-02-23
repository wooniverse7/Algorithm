package SKP2023.p3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String[][] board1 = {{"00011", "01111", "21001", "11001", "01111"},
                {"00011", "00011", "11111", "12101", "11111"}};
        String[][] board2 = {{"1111", "1121", "1001", "1111"},
                {"0000", "0000", "0000", "0002"},
                {"0000", "0100", "0000", "0002"},
                {"0000", "0010", "0121", "0010"}};

        System.out.println(solution(board1)); // (1, 1)
        System.out.println(solution(board2)); // (1,1,0,0)
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static int[] solution(String[][] boards) {
        int[] answer = {};
        answer = new int[boards.length];

        // 1개씩 판을 만듬
        for (int t = 0; t < boards.length; t++) {
            String[] tmpMap = boards[t];

            // int형 변환
            int n = tmpMap.length; // 세로 길이
            int m = tmpMap[0].length(); // 가로 길이
            int[][] map = new int[n][m];
            int x = 0, y = 0; // 캐릭터 좌표

            for (int i = 0; i < n; i++) {
                char[] chArr = tmpMap[i].toCharArray();
                for (int j = 0; j < m; j++) {
                    map[i][j] = Character.getNumericValue(chArr[j]);
                    if(map[i][j] == 2){
                        x = i;
                        y = j;
                    }
                }
            }
            // 방문 배열, 방향 변수
            boolean[][] visited = new boolean[n][m];

            // 거기서 dfs 돌림림
            answer[t] = dfs(map, visited, x, y);
        }

        return answer;
    }

    static int dfs(int[][] map, boolean[][] visited, int x, int y){
        // 이걸 메인이라고 생각하고 dfs를 더 구현해보자
        visited[x][y] = true;
        int N = map.length;
        int M = map[0].length;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                if(map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(map, visited, nx, ny);
                }
            }
        }

        // 성공, 실패
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && map[i][j] == 1){
                    return 0;
                }
            }
        }

        return 1;
    }


}
