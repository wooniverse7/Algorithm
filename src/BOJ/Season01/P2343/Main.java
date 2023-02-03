package BOJ.Season01.P2343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] blue;
    static int lf, rt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        blue = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            blue[i] = Integer.parseInt(st.nextToken());
            lf = Math.max(lf, blue[i]);
            rt += blue[i];
        }

        // 블루레이 개수로 이분 탐색
        while(lf <= rt){
            int sum = 0; // 한 블루레이에 담은 강의 길이
            int cnt = 0; // blueray 개수
            int mid = (lf + rt) / 2;

            // for문을 이용해 모든 레슨들을 하나씩 담아 본다.
            for (int i = 0; i < N; i++) {
                // 그 합이 mid 값보다 커진다면 필요한 블루레이 갯수를 한개 증가
                if(sum + blue[i] > mid){
                    cnt++;
                    sum = 0;
                }
                sum += blue[i]; // 크지 않다면
            }
            // 블루레이 크기보다 작아서 증가시키지 못했을 경우
            if(sum > 0) cnt++;

            // M개보다 개수가 적다면 rt값을 mid로 바꿔(크기를 줄임) 개수를 늘린다
            if(cnt <= M){
                rt = mid - 1;
            }else{  // 개수가 많다면 블루레이 크기를 늘려서 개수를 줄임
                lf = mid + 1;
            }
        }

        // 블루레이 최소 크기 = lf
        System.out.println(lf);
    }
}
