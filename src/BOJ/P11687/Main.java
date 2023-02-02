package BOJ.P11687;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();

        int lf = 1;
        int rt = 5 * M;

        boolean flag = false;

        while(lf <= rt){
            int mid = (lf + rt) / 2;

            // 5의 배수가 몇개 들어있는지
            int cnt = 0;
            for (int i = 5; i <= mid; i *= 5) { // 등호 중요
                cnt += mid/i;
            }

            if(cnt > M){
                rt = mid - 1;
            }else if(cnt == M){
                rt = mid - 1;
                flag = true; // 정확히 맞아 떨어졌을 때
            } else{
                lf = mid + 1;
            }

        }

        if(flag){
            System.out.println(lf);
        }else
            System.out.println(-1);

    }
}
