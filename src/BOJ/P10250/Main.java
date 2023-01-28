package BOJ.P10250;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0){
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();

            System.out.println(yanolja(H, W, N));

        }

    }
    static int yanolja(int H, int W, int N){
//        int[][] hotel = new int[H+1][W+1];
        int cnt = 1;

        for (int i = 1; i <= W; i++) {
            for (int j = 1; j <= H; j++) {
                if(cnt == N) {
                    return j * 100 + i;
                }
                cnt++;
            }
        }

        return 0;
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0){
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();

            int roomH = 0;
            int roomW = 0;

            // 층수는 N 나머지 높이를 한 값과 같다.
            // 가로 방 번호는 몫과 같다.
            // 4층 6개방일 때
            // 4 8 12 16 20
            // 3 7 11 15 19
            // 2 6 10 14 18
            // 1 5 9  13 17
            if(N % H == 0){
                // 맨 위층에 배정될 때
                roomH = H * 100; // 나머지가 0일 때는 층 높이와 같음
                roomW = N / H; // 몫을 그대로
            }else{
                roomH = (N % H) * 100;
                roomW = (N / H) + 1; // 나눈 몫의 + 1
            }

            int rst = roomH + roomW;
            System.out.println(rst);
        }
    }
}
