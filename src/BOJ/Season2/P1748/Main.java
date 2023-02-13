package BOJ.Season2.P1748;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 실패

        int N = Integer.parseInt(br.readLine());

//        int cnt = 0;
//        for (int i = 1; i <= N; i++) {
//            int size = String.valueOf(i).length();
//            cnt += size;
//        }
        // for문을 쓰면 안될듯하다

        int cnt = 0;
        int length = 10;
        int plus = 1;
        for (int i = 1; i <= N; i++) {

            if(i % length == 0){
                plus++;
                length *= 10;
            }
            cnt += plus;
        }
        System.out.println(cnt);

    }
}
