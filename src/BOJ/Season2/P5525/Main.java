package BOJ.Season2.P5525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        char[] arr = S.toCharArray();
        int[] memo = new int[M]; // 연속된 oi 수를 저장할 배열

        int cnt = 0;
        for (int i = 1; i < M - 1; i++) {
            // oi가 연속으로 반복되는 수만큼 memo배열에 저장한다.
            if(arr[i] == 'O' && arr[i+1] == 'I'){
                memo[i+1] = memo[i-1] + 1;
            }

            // 연속된 oi의 개수가 주어진 Pn만큼 되고 연속된 oi의 맨 앞이 i이면
            if(memo[i+1] >= N && arr[i - 2*N + 1] == 'I'){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
// 매 인덱스마다 스트링을 비교하면 시간초과
// 인덱스 크기 M, 매번 새로운 String배열 선언 시간 O(n2)?

// dp를 적용하면 O(n) time에 성공
