package BOJ.Season04.P20529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] person = new String[N];
            for (int i = 0; i < N; i++) {
                person[i] = st.nextToken();
            }
            if(N > 32) {
                System.out.println(0);
            } else{
                int minDist = 100;

                for (int i = 0; i < N; i++) {
                    for (int j = i + 1; j < N; j++) {
                        for (int k = j + 1; k < N; k++) {
                            minDist = Math.min(minDist, calDist(person[i], person[j], person[k]));

                        }
                    }
                }
                System.out.println(minDist);
            }
        }
    }

    private static int calDist(String p1, String p2, String p3) {
        int dist = 0;
        for (int i = 0; i < 4; i++) {
            dist += (p1.charAt(i) != p2.charAt(i) ? 1 : 0);
            dist += (p2.charAt(i) != p3.charAt(i) ? 1 : 0);
            dist += (p3.charAt(i) != p1.charAt(i) ? 1 : 0);
        }
        return dist;
    }
}
