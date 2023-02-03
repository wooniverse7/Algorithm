package BOJ.Season2.P14425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<String> S = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            S.add(br.readLine());
        }

        ArrayList<String> check = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            check.add(br.readLine());
        }

        int cnt = 0;
        for (String ch: check) {
            if(S.contains(ch)) cnt++;
        }

        System.out.println(cnt);
    }
}
