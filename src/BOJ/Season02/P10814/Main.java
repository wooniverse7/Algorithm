package BOJ.Season02.P10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        StringBuilder[] p = new StringBuilder[201]; // 최대 사람수

        // 각 배열에 stringBuilder 객체 만들기
        for (int i = 0; i < p.length; i++) {
            p[i] = new StringBuilder();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            // 카운팅 정렬 : 나이를 index로 하여 해당 인덱스에 나이와 이름을 append함
            // 같은 나이일 때 이름은 먼저온 순
            p[age].append(age).append(' ').append(name).append('\n');
        }

        StringBuilder sb = new StringBuilder();
        for(StringBuilder val : p){
            sb.append(val); // 원소가 없는 것은 패스
        }

        System.out.println(sb);
    }
}
