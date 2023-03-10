package SWEA.CodingTest;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{

    static int[][] map;
    static int N;
    static int M;
    static boolean[] alpahbet = new boolean[26]; // 썼던 알파벳인지
    static int[] dx = {-1, 1, 0, 0}; // x방향배열 - 상하
    static int[] dy = {0, 0, -1, 1}; // y방향배열 - 좌우
    static int ans = 0;

    public static void dfs(int x, int y, int cnt){
        if(alpahbet[map[x][y]]) // 0,0에 저장된 알파벳이 이미 한번 방문한 알파벳이라면
        {
            ans = Math.max(ans, cnt); // ans 갱신
            return; // 조건에 만족하면 리턴
        }else{
            alpahbet[map[x][y]] = true; // 현재 위치 방문 처리
            for(int i = 0; i < 4; i++){ // 다음칸 이동
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                    dfs(nx, ny, cnt+1); // count++ 하면 안됨
                }
            }
            alpahbet[map[x][y]] = false;
        }
   }

    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = s.charAt(j) - 'A';
                }
            }

            dfs(0,0,0); // (0,0)에서 시작, 이동한 위치 0회
            sb.append("#" + t + " ").append(ans).append('\n');

        }
        System.out.println(sb);
    }

}
