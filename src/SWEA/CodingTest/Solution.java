package SWEA.CodingTest;

/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;
// double b = 1.0;
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{

    static char[][] map;
    static int n;
    static int m;
    static int maxVal = Integer.MIN_VALUE;
    static boolean[][] visited; // 탐색한 자리인지
    static boolean[] alphbet = new boolean[27]; // 썼던 알파벳인지
    static int[] dx = {-1, 1, 0, 0}; // x방향배열 - 상하
    static int[] dy = {0, 0, -1, 1}; // y방향배열 - 좌우

    public static void main(String args[]) throws Exception
    {
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
        //System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        //Scanner sc = new Scanner(System.in);
//        int T;
//        T=sc.nextInt();
//		/*
//		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
//		*/
//
//        for(int test_case = 1; test_case <= T; test_case++)
//        {
//
//            /////////////////////////////////////////////////////////////////////////////////////////////
//			/*
//				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
//			 */
//            /////////////////////////////////////////////////////////////////////////////////////////////
//
        // maxVal, n, m 초기화 필요
        // 배열
//        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        visited = new boolean[n][m];
        visited[0][0] = true;
        dfs(0,0,1);
        System.out.println(maxVal);

    }

    public static void dfs(int x, int y, int count) {
        System.out.printf("x %d, y %d, count %d\n", x, y, count);
        // 이 종료조건을 알파벳을 모두 탐색했을 때로 바꿔야 한다.
        if(x == n-1 && y == m-1) { // (n-1, m-1)에 도착했을 때 종료
            maxVal = Math.max(maxVal, count);
            System.out.println(maxVal);
            return;
        }

            if(count < maxVal) {
            System.out.printf("cnt : %d, maxVal : %d\n", count, maxVal);
            return; //가지치기 - 이미 count가 minVal보다 커졌다면 return;
        }

        //방향배열 사용하지 않고 조건문으로 4가지를 나누어 보았다.
        //map의 조건을 알파벳으로 바꿔야함
        if(x > 0 && !visited[x-1][y] && map[x-1][y] == 1) { //상
            visited[x-1][y] = true;
            dfs(x-1, y, count + 1);
            visited[x-1][y] = false;
        }
        if(x < n-1 && !visited[x+1][y] && map[x+1][y] == 1) { //하
            visited[x+1][y] = true;
            dfs(x+1, y, count + 1);
            visited[x+1][y] = false;
        }
        if(y > 0 && !visited[x][y-1] && map[x][y-1] == 1) { //좌
            visited[x][y-1] = true;
            dfs(x, y-1, count + 1);
            visited[x][y-1] = false;
        }
        if(y < m-1 && !visited[x][y+1] && map[x][y+1] == 1) { //우
            visited[x][y+1] = true;
            dfs(x, y+1, count + 1);
            visited[x][y+1] = false;
        }
    }
}
