package BOJ.P2869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

//        Scanner sc = new Scanner(System.in);
//
//        int up = sc.nextInt();
//        int down = sc.nextInt();
//        int top = sc.nextInt();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 정리

        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        int top = Integer.parseInt(st.nextToken());

        // 저녁에 down만큼 내려오는 것을 빼줘서 최소값을 구한다.
        // 이때 나눈 수에 나머지가 있으면 저녁에 내려오고 올라가야 하므로 +1을 해줘야 한다.
        // 그렇게 주워들었는데 완전히 이해되지는 않는다.
        int rst = (top - down) / (up - down);

        if((top-down) % (up-down) == 0) System.out.println(rst); // 낮에 정확히 도착했을 때
        else System.out.println(rst+1); // 낮에 up보다 작은 칸이 남았을 때

    }
}
