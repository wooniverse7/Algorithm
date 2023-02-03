package BOJ.Season01.P1929;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 100만까지 소수 미리 구하기
        boolean[] prime = new boolean[1000001]; // 소수 판별 배열
        prime[0] = prime[1] = false; // 소수가 아님
        for (int i = 2; i < 1000000; i++) {
            prime[i] = true;
        }
        // 에라토스테네스의 체
        for (int i = 2; i*i < 1000000; i++) { // i 부터 i제곱이 N을 넘지 않을 때까지
            if(prime[i] == false) continue; // 소수가 아니면 패스
            // 범위 2*i -> i*i로 크게 줄임
            for (int j = i*i; j < 1000000; j += i) {
                prime[j] = false; // 소수의 배수들은 false처리
            }
        }

        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            if(prime[i]) al.add(i);
        }

        //StringBuilder로 출력시간 크게 감소
        StringBuilder sb = new StringBuilder();

        Iterator<Integer> it = al.iterator();
        while(it.hasNext()){
            int rst = it.next();
            if(rst >= N && rst <= M) sb.append(rst).append('\n');
        }
        System.out.println(sb);


    }
}
