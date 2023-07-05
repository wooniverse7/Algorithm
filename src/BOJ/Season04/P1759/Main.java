package BOJ.Season04.P1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int l, c;
    static String pw[], abc[];
    static String vowels[] = {"a", "e", "i", "o", "u"};
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        abc = br.readLine().split(" ");
        pw = new String[l];

        sb = new StringBuilder();

        Arrays.sort(abc);

        reculsion(0,0);

        System.out.println(sb);
    }

    public static void reculsion(int depth, int start) {

        // l개 선택
        if(depth == l) {
            if(check()) {
                for(String value : pw) {
                    sb.append(value);
                }
                sb.append("\n");
            }

            return;
        }

        for (int i = start; i < abc.length; i++) {
            pw[depth] = abc[i];
            reculsion(depth+1, i+1);
        }
        // a t c i s w
        // a t c i
        // a t c s
        // a t c w
        // a t i s
    }

    public static boolean check() {
        int vow = 0; // 모음 개수
        int cons = 0; // 자음 개수

        for(String value : pw) {
            boolean isVowel = false;
            // 모음이면 vow++
            for (int i = 0; i < vowels.length; i++) {
                if(value.equals(vowels[i])) {
                    isVowel = true;
                    vow++;
                }
                if(isVowel) {
                    break;
                }
            }
            // 자음이면 cons++;
            if(!isVowel) cons++;

            // 암호 조건 체크
            if(vow >= 1 & cons >= 2) {
                return true;
            }
        }

        return false;
    }
}
