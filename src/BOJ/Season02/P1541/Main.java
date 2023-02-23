package BOJ.Season02.P1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        // +면 뭉쳐서 합치고 - 면 뺀다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int sum = Integer.MAX_VALUE;
        // 뺄셈 기준으로 나눔
        String[] sub = br.readLine().split("-");

        for (int i = 0; i < sub.length; i++) {
            int tmp = 0;

            // 뺄셈 사이를 더하기 위해 수 추출
            String[] add = sub[i].split("\\+");

            for (int j = 0; j < add.length; j++) {
                tmp += Integer.parseInt(add[j]);
            }

            // 첫번 째 토큰
            if(sum == Integer.MAX_VALUE){
                sum = tmp;
            }else{
                sum -= tmp;
            }
        }

        System.out.println(sum);
    }
}
