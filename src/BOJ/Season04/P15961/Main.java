package BOJ.Season04.P15961;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int ans = 0;
        int left = 0;
        int right = 0;
        int cnt = 0;
        int[] arr = new int[n];
        int[] eat = new int[d+1];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < k; i++) {
            ++eat[arr[right]];
            if(eat[arr[right]] == 1) {
                ++cnt;
            }
            ++right;
        }
        ans = cnt;

        while(left != n) {
            --eat[arr[left]];
            if(eat[arr[left]] == 0) {
                --cnt;
            }
            ++left;

            ++eat[arr[right]];
            if(eat[arr[right]] == 1) {
                ++cnt;
            }
        }
    }
}
