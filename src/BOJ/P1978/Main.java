package BOJ.P1978;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if(arr[i] == 1) continue;

            if(isPrime(arr[i])) cnt++;
        }

        System.out.println(cnt);
    }

    public static boolean isPrime(int num){
        boolean flag = true;

        for (int i = 2; i*i <= num; i++) { // 범위 설정 조심
            // num 9, i = 2, 4 <= 9 / i = 3, 3*3 <= 9
            if(num % i == 0) {
                flag = false; // 소수가 아니면 false
                break;
            }
        }
        //if(flag) System.out.println("소수 : " + num);

        return flag;
    }
}