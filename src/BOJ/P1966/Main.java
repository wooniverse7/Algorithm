package BOJ.P1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        // Test Case 반복
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            // 큐 개수와 뽑고자 하는 데이터 위치
            int size = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 큐 입력. 우선순위와 index를 같이
            Queue<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine()); // 줄이 넘어가면 다시 해줘야한다?

            for (int i = 0; i < size; i++) {
                queue.add(new int[]{i, Integer.parseInt(st.nextToken())}); // idx, 중요도
            }

            int cnt = 1; // 인쇄된 순서
            // 큐가 빌 때 까지 혹은 찾을 때 까지

            while (!queue.isEmpty()) {
                int[] front = queue.remove(); // poll을 하면 null 반환을 해서 에러
                Boolean flag = true; // 가장 큰 원소인지

                for(int[] q : queue){
                    if(q[1] > front[1]){
                        flag = false;
                        break;
                    }
                }

                //가장 큰 우선순위일 경우
                if (flag) {
                    // 원하는 data인지 확인, 아니면 다음 인쇄
                    if (front[0] == M) break; // index 비교...
                    cnt++;
                } else {
                    // 가장 큰 우선순위가 아닐경우 뒤로 보냄
                    queue.offer(front);
                }
            }
            //카운트 저장
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);

    }
}
