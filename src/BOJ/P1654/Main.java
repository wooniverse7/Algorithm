package BOJ.P1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] line = new int[K];
        long end = 0;
        long srt = 0;
        for (int i = 0; i < K; i++) {
            line[i] = Integer.parseInt(br.readLine());
            if(line[i] > end){
                end = line[i];
            }
        }
        end++;


        while(srt < end){
            long mid = (srt + end) / 2;
            long cnt = 0;

            for (int i = 0; i < line.length; i++) {
                cnt += line[i] / mid;
            }
            //System.out.println("cnt : " + cnt);
            // 적으면 최대 길이를 mid로 바꿔서 자르는 길이를 짧게 해서 개수를 늘린다.
            if(cnt < N){
                end = mid;
            }else{ // 개수가 같거나 많으면 이제 길이의 upper bound를 찾기 위해 길이를 1cm씩 늘린다.
                srt = mid + 1;
            }
        }

        System.out.println(srt - 1);

    }

}

