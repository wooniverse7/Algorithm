package SWEA.CT01;



import java.util.Scanner;

class Solution
{

    static int[][] map;
    static int r;
    static int c;
    static boolean[] alpahbet = new boolean[26]; // 썼던 알파벳인지
    static int[] dx = {-1, 1, 0, 0}; // x방향배열 - 상하
    static int[] dy = {0, 0, -1, 1}; // y방향배열 - 좌우
    static int ans = 0;

    public static void dfs(int x, int y, int cnt){
        if(alpahbet[map[x][y]] == true) // 0,0에 저장된 알파벳이 이미 한번 방문한 알파벳이라면
        {
            ans = Math.max(ans, cnt); // ans 갱신
            return; // 조건에 만족하면 리턴
        }else{
            alpahbet[map[x][y]] = true; // 현재 위치 방문 처리
            for(int i = 0; i < 4; i++){ // 다음칸 이동
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < r && ny < c){
                    dfs(nx, ny, cnt+1); // count++ 하면 안됨
                }
            }
            alpahbet[map[x][y]] = false;
        }
    }

    public static void main(String args[])
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {

            r = sc.nextInt();
            c = sc.nextInt();

            map = new int[r][c];
            for (int i = 0; i < r; i++) {
                String s = sc.next();
                for (int j = 0; j < c; j++) {
                    map[i][j] = s.charAt(j) - 'A';
                }
            }

            dfs(0,0,0); // (0,0)에서 시작, 이동한 위치 0회
            sb.append("#" + t + " ").append(ans).append('\n');
        }
        System.out.println(sb);
    }
}
