package BOJ.Season03.P3566;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int rh = Integer.parseInt(st.nextToken());
        int rv = Integer.parseInt(st.nextToken());
        int sh = Integer.parseInt(st.nextToken());
        int sv = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int rhi = Integer.parseInt(st.nextToken());
            int rvi = Integer.parseInt(st.nextToken());
            int shi = Integer.parseInt(st.nextToken());
            int svi = Integer.parseInt(st.nextToken());
            int pi = Integer.parseInt(st.nextToken());

            for (int j = 0; j < 2; j++) {
                int numH = (rh + rhi - 1) / rhi;
                int numV = (rv + rvi - 1) / rvi;

                int cost = (numH * numV) * pi;

                if (numH * shi >= sh && numV * svi >= sv) {
                    minCost = Math.min(minCost, cost);
                }

                int temp = rhi;
                rhi = rvi;
                rvi = temp;

                temp = shi;
                shi = svi;
                svi = temp;
            }
        }

        System.out.println(minCost);
    }
}