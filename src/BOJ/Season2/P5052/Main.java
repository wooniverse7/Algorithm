package BOJ.Season2.P5052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());
            String[] number = new String[N];
            for (int i = 0; i < N; i++) {
                number[i] = br.readLine();
            }
            Arrays.sort(number);

            boolean flag = true;
            for (int i = 1; i < number.length; i++) {
                if(number[i].startsWith(number[i-1])){
                    flag = false;
                    break;
                }
            }

            if(!flag){
                sb.append("NO").append('\n');
            }else{
                sb.append("YES").append('\n');
            }
        }

        System.out.println(sb);
    }
}