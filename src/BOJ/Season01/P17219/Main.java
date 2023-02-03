package BOJ.Season01.P17219;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> site = new HashMap<>(); // key, value

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            site.put(st.nextToken(), st.nextToken());
        }

        // 해당 Key에 해당하는 value 출력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            bw.write(site.get(st.nextToken()) + '\n');
        }

        bw.flush();
        bw.close();
    }
}
