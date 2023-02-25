package BOJ.Season02.P14719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] block = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            block[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        // 인덱스 범위는
        for (int i = 1; i < W; i++) {
            int lfMax = 0;
            int rtMax = 0;

            // i를 기점으로 왼쪽 중 가장 높은 블록
            for (int j = i-1; j >= 0; j--) {
                if(block[j] > lfMax)
                    lfMax = block[j];
            }

            // i를 기점으로 오른쪽에서 가장 높은 블록
            for (int j = i+1; j < W; j++) {
                if(block[j] > rtMax)
                    rtMax = block[j];
            }

            // 양쪽에서 가장 낮은 높이의 블록이 현재의 블록보다 높으면 양쪽에 벽이 가로막혀 있다는 뜻이므로
            // 현재 위치에서 고이는 빗물의 양은 양쪽 중에서 낮은 높이만큼은 보장된다
            // 낮은 높이 - 나의 높이
            int minH = Math.min(lfMax, rtMax);
            if(minH > block[i]){
                cnt += minH - block[i];
            }

        }

        System.out.println(cnt);


    }
}
